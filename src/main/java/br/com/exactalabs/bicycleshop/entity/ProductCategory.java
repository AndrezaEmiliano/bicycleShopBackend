package br.com.exactalabs.bicycleshop.entity;

public class ProductCategory {

    private String name;


    public ProductCategory() {
    }

    public ProductCategory(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
