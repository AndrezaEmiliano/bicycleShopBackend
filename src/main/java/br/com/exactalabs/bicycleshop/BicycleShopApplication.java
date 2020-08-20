package br.com.exactalabs.bicycleshop;

import br.com.exactalabs.bicycleshop.entity.ProductCategory;
import br.com.exactalabs.bicycleshop.repository.ProductCategoryRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BicycleShopApplication {

    public static void main(String[] args) {

        var productCategoryRepository = new ProductCategoryRepository();
        var pageResult = productCategoryRepository.findAllPaged(2, 5);

        pageResult.getResults().forEach(productCategory -> {
            System.out.println(productCategory.getName());
        });



    }

}
