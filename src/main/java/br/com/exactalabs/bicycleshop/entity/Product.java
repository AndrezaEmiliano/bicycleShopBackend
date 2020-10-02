package br.com.exactalabs.bicycleshop.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


import java.math.BigDecimal;

@Entity
@Table (name = "product")
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "A descrição do produto não pode ser nula!")
    @Column (name = "description")
    private String name;

    @Min(value = 0, message = "O preço do produto não pode ser negativo!")
    @NotEmpty (message = "O preço do produto não pode ser nulo!")
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id")
    @Column (name = "category")
    private ProductCategory productCategory;

    @Column (name = "quantity_product")
    private Integer quantityProduct;



    public Product() {
    }

    public Product(String name, BigDecimal price, ProductCategory productCategory, Integer quantityProduct) {
        this.name = name;
        this.price = price;
        this.productCategory = productCategory;
        this.quantityProduct = quantityProduct;
    }


    private void setPrice (BigDecimal price) {
       this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public ProductCategory getProductCategory() {
        return productCategory;
    }

    public Integer getQuantityProduct() {
        return quantityProduct;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setProductCategory(ProductCategory productCategory) {
        this.productCategory = productCategory;
    }

    public void setQuantityProduct(Integer quantityProduct) {
        this.quantityProduct = quantityProduct;
    }

    public void setDiscount (BigDecimal percentDiscount) {
        this.price = (price.subtract ((price.multiply(percentDiscount)).divide(BigDecimal.valueOf(100))));
    }
}
