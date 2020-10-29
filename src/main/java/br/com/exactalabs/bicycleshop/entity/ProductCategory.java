package br.com.exactalabs.bicycleshop.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product_category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "A descrição da categoria não pode ser nula!")
    @Column (name = "description")
    private String description;

    @OneToMany(mappedBy = "productCategory",
            cascade = CascadeType.REMOVE)
    private List<Product> productList = new ArrayList<>();


    public ProductCategory() {
    }

    public ProductCategory(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "ProductCategory{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
