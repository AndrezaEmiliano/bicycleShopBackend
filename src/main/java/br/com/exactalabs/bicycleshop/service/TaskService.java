package br.com.exactalabs.bicycleshop.service;

import br.com.exactalabs.bicycleshop.entity.Subtask;
import br.com.exactalabs.bicycleshop.entity.Task;
import br.com.exactalabs.bicycleshop.repository.SubtaskRepository;
import br.com.exactalabs.bicycleshop.repository.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class TaskService {

    private TaskRepository taskRepository;
    private SubtaskRepository subtaskRepository;

    public TaskService(TaskRepository taskRepository,
                       SubtaskRepository subtaskRepository) {
        this.taskRepository = taskRepository;
        this.subtaskRepository = subtaskRepository;
    }

    public Task createTask(String name) {
        var task = new Task(name);
        return taskRepository.save(task);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public Page<Task> findTasks(Integer pageNumber) {
        var pageRequest =
                PageRequest.of(pageNumber, 30);

        return taskRepository.findAll(pageRequest);
    }

    public Long countDoneTasks() {
        return taskRepository.countByDone(true);
    }

    public Long countPendingTasks() {
        return taskRepository.countByDone(false);
    }

    public Task completeTask(Long id) {
        Task task = taskRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Task não encontrada"));

        task.setDone(true);

        return this.updateTask(task);
    }

    @Transactional
    public void completeSubTask(Long id) {
        Subtask subtask = subtaskRepository
                .findById(id)
                .orElseThrow(() -> new RuntimeException("Subtask não encontrada"));

        subtask.setDone(true);
        this.subtaskRepository.save(subtask);

        boolean hasPendingSubtask = false;

        Task parentTask = subtask.getParentTask();

        Collection<Subtask> subtasks = parentTask.getSubtasks();

        for (Subtask sub : subtasks) {
            if (!sub.isDone()) {
                hasPendingSubtask = true;
                break;
            }
        }

        if (!hasPendingSubtask) {
            parentTask.setDone(true);
            this.updateTask(parentTask);
        }
    }

}
