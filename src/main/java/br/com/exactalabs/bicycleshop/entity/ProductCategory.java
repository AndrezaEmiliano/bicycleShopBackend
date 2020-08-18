package br.com.exactalabs.bicycleshop.entity;

import java.time.LocalDateTime;

public class ProductCategory {

    private Long id;
    private String name;
    private LocalDateTime createdAt;

    public ProductCategory() {
    }

    public ProductCategory(Long id, String name, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

}
