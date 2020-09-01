package br.com.exactalabs.bicycleshop;

import br.com.exactalabs.bicycleshop.entity.Subtask;
import br.com.exactalabs.bicycleshop.entity.Task;
import br.com.exactalabs.bicycleshop.repository.TaskRepository;

public class BicycleShopApplication {

    public static void main(String[] args) {

        var taskRepository = new TaskRepository();

        var task = new Task("Aprender Mapeamento JPA");

        var subtask = new Subtask();
        subtask.setName("Aprender insert com cascade");

        task.addSubtask(subtask);

        taskRepository.insert(task);

        var task15 = taskRepository.findById(16L);


        System.out.println(task15);

        taskRepository.remove(task15);


    }

}
