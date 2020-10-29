package br.com.exactalabs.bicycleshop;

import br.com.exactalabs.bicycleshop.entity.Product;
import br.com.exactalabs.bicycleshop.entity.ProductCategory;
import br.com.exactalabs.bicycleshop.service.ProductCategoryService;
import br.com.exactalabs.bicycleshop.service.ProductService;
import br.com.exactalabs.bicycleshop.entity.Address;
import br.com.exactalabs.bicycleshop.entity.Customer;
import br.com.exactalabs.bicycleshop.service.CustomerService;
import br.com.exactalabs.bicycleshop.entity.*;
import br.com.exactalabs.bicycleshop.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class BicycleShopApplication {

    public static void main(String[] args) {
     SpringApplication.run(BicycleShopApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ApplicationContext appContext) {
        return args -> {

            //===================================Customer and Adress===================================

            //como um construtor
            CustomerService customerService = appContext.getBean(CustomerService.class);

            //cadastro de endereço
//            var address = new Address("14800000", "Rua fulana", "222",
//                    "Centro", "SP", "Araraquara", "nao tem");

            //cadastro de cliente
//            var customer = new Customer ("Sophie", "Emiliano", LocalDate.of(2020, 9, 5), "30000106829",
//                    "sophie.clinicageral@gmail.com", "16 900999090", " 16 999990000", address);

            //salva cliente
//            customerService.saveCustomer(customer);

            //busca cliente por id
//            System.out.println(customerService.findCustomerById(6L));

            //busca todos os clientes
//            System.out.println(customerService.findAllCustomer(0).getContent());

            //deleta clientes por id
//            customerService.deleteCustomerById(1L);

            //update cliente
//            var customerUpdate = customerService.findCustomerById(7L);
//            customerUpdate.setName("Amorinha");
//            customerService.saveCustomer(customerUpdate);

            //update endereço
//            var adressUpdate = customerUpdate.getAddress().get(0);
//            adressUpdate.setAddressNumber("22");
//            customerService.saveCustomer(customerUpdate);

            //===================================Product and ProductCategory===================================

            // como construtor
            ProductService productService = appContext.getBean(ProductService.class);
            ProductCategoryService productCategoryService = appContext.getBean(ProductCategoryService.class);

            //cadastro de categoria
//            var productCategory = new ProductCategory("bicicleta");
//            productCategoryService.saveProductCategory(productCategory);

            //cadastro de produto
//            var product = new Product("chianatown classic bike", BigDecimal.valueOf(799.00), 3,
//            productCategoryService.findProductByIdProductCategory(11L));
//            productService.saveProduct(product);

            //busca de produto por nome
//            System.out.println(productService.findProductByNameAsc("%sque%", 0).getContent());
//            System.out.println(productService.findProductByNameAsc("%bike%", 0).getContent());

            //busca de produto por id
//            System.out.println(productService.findProductByIdProduct(10L));

            //busca de todos os produtos
//            System.out.println(productService.findAllProduct(0).getContent());

            //busca de produto por menor preço
//            System.out.println(productService.findAllProductByPriceAsc(0).getContent());

            //busca de produto por maior preço
//            System.out.println(productService.findAllProductByPriceDesc(0).getContent());

            //deleta produto por id
//            productService.deleteProductById(13L);


            //busca de categoria de produto por nome
//            System.out.println(productCategoryService.findProductCategoryByNameAsc("%garr%", 0).getContent());

            //busca de categoria de produto por id
//            System.out.println(productCategoryService.findProductByIdProductCategory(10L));

            //busca de todas as categorias de produto
//            System.out.println(productCategoryService.findAllProductCategory(0).getContent());

            //deleta categoria de produto por id
//            productCategoryService.deleteProductCategoryById(10L);


            //busca produto (em ordem alfabética) por nome de categoria de produto
//            System.out.println(productService.findAllProductByProductCategoryDescription
//                    ("bicicleta", 0).getContent());


            //===================================Order and OrderItem===================================

            //como um construtor
            OrderService orderService = appContext.getBean(OrderService.class);
//            OrderItemService orderItemService = appContext.getBean(OrderItemService.class);

            //cadastro de Order e OrderItem
//            var order = new Order(customerService.findCustomerById(7L), new OrderItem(productService.findProductByIdProduct(11L), 2));


            //salva Order e OrderItem
//            orderService.saveOrder(order);

            //busca Order por id
//            System.out.println(orderService.findOrderById(9L));

            //busca todos as Orders
//            System.out.println(orderService.findAllOrder(0).getContent());

            //deleta Order por id
//            orderService.deleteOrderById(8L);

        };
    };
}
