package br.com.exactalabs.bicycleshop;

import br.com.exactalabs.bicycleshop.entity.Task;
import br.com.exactalabs.bicycleshop.repository.TaskRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

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

            PageRequest page = PageRequest.of(0, 2);

            PageRequest pageWithSort = PageRequest.of(0, 2,
                    Sort.by("name")
                            .and(Sort.by("done"))
                            .ascending());

            Page<Task> tasksPaginadas = taskRepository.findByDone(false, pageWithSort);

            int numeroPagina = tasksPaginadas.getNumber() + 1;

            System.out.println("Total de tasks: " + tasksPaginadas.getTotalElements());
            System.out.println("Total de paginas: " + tasksPaginadas.getTotalPages());
            System.out.println("Numero da pagina: " + numeroPagina);
            System.out.println("Tasks: " + tasksPaginadas.getContent());

            System.out.println(tasksPaginadas);

            List<Task> tasksOrdenadasPorNome =
                    taskRepository.findAll(Sort.by("name"));

            System.out.println(tasksOrdenadasPorNome);

            List<Task> tasksPendentesOrdenadas =
                    taskRepository.findByDone(false, Sort.by("name"));

            System.out.println(tasksPendentesOrdenadas);

        };
    }

}
