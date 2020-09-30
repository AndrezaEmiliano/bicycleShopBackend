package br.com.exactalabs.bicycleshop;

import br.com.exactalabs.bicycleshop.entity.Address;
import br.com.exactalabs.bicycleshop.entity.Customer;
import br.com.exactalabs.bicycleshop.service.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class BicycleShopApplication {

    public static void main(String[] args) {
     SpringApplication.run(BicycleShopApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ApplicationContext appContext) {
        return args -> {
            //Encarem como um construtor
            CustomerService customerService = appContext.getBean(CustomerService.class);
            //System.out.println(customerService.findCustomerById(6L));

            var address = new Address("14800000", "Rua fulana", "222",
                    "Centro", "SP", "Araraquara", "nao tem");
            var customer = new Customer ("Sophie", "Emiliano", LocalDate.of(2020, 9, 5), "30000106829",
                    "sophie.clinicageral@gmail.com", "16 900999090", " 16 999990000", address);

           //customerService.saveCustomer(customer);

            System.out.println(customerService.findAllCustomer(0).getContent());

           // customerService.deleteCustomerById(1L);

            //update
//            var customerUpdate = customerService.findCustomerById(7L);
////            customerUpdate.setName("Amorinha");
////            customerService.saveCustomer(customerUpdate);
//
//
//            var adressUpdate = customerUpdate.getAddress().get(0);
//            adressUpdate.setAddressNumber("22");
//            customerService.saveCustomer(customerUpdate);
        };
    }

}
