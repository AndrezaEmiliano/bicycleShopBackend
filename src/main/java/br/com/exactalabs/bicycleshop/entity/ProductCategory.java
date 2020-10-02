package br.com.exactalabs.bicycleshop.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "description")
    private String name;

    @OneToMany(mappedBy = "productCategory",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Product> productList = new ArrayList<>();


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
