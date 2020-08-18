package br.com.exactalabs.bicycleshop;

import br.com.exactalabs.bicycleshop.entity.ProductCategory;
import br.com.exactalabs.bicycleshop.repository.ProductCategoryRepository;

import java.util.ArrayList;
import java.util.List;

public class BicycleShopApplication {

    public static void main(String[] args) {

//        var categories = List.of(
//                new ProductCategory("categoria X"),
//                new ProductCategory("cateogira Y"),
//                new ProductCategory("categoria Z"));

        var productCategoryRepository = new ProductCategoryRepository();

        var categoriaA = productCategoryRepository.findById(1L);
        System.out.println("ID Categoria: " +categoriaA.getId());
        System.out.println("Nome categoria: " + categoriaA.getName());

        //productCategoryRepository.batchInsert(categories);


    }

}
