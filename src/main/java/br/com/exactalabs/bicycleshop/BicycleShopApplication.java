package br.com.exactalabs.bicycleshop;

import br.com.exactalabs.bicycleshop.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BicycleShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(BicycleShopApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ApplicationContext appContext) {
        return args -> {
            //Encarem como um construtor
            TaskRepository taskRepository = appContext.getBean(TaskRepository.class);

            System.out.println("Tasks que possuam subtasks pendentes:");
            System.out.println(taskRepository.findBySubtasksDone(false));

        };
    }

}
