package br.com.exactalabs.bicycleshop;


import br.com.exactalabs.bicycleshop.service.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication
public class BicycleShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(BicycleShopApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ApplicationContext appContext) {
        return args -> {
            // como construtor
            ProductService productService = appContext.getBean(ProductService.class);
//            ProductCategoryService productCategoryService = appContext.getBean(ProductCategoryService.class);

//            var productCategory = new ProductCategory("garrafa");
//
//            productCategoryService.saveProductCategory(productCategory);

//            var product = new Product("squeeze", BigDecimal.valueOf(50.00), 3, productCategoryService.findProductByIdProductCategory(9L));
//
//            productService.saveProduct(product);

            System.out.println(productService.findProductByNameAsc("%luv%", 0).getContent());

//            System.out.println(productService.findAllProductByPriceAsc(0).getContent());

//

//            productService.deleteProductById(14L);

//            System.out.println(productService.findProductByNameAsc("%cap%", 0).getContent());
        };
    }
}

