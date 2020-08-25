package br.com.exactalabs.bicycleshop;

import br.com.exactalabs.bicycleshop.entity.Task;
import br.com.exactalabs.bicycleshop.repository.TaskRepository;

public class BicycleShopApplication {

    public static void main(String[] args) {
        var taskRepository = new TaskRepository();

        var taskAprenderJPA = taskRepository.findById(1L);

        taskAprenderJPA.getSubtasks();


        System.out.println(taskAprenderJPA);

    }

}
