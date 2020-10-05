package br.com.exactalabs.bicycleshop.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import java.math.BigDecimal;

@Entity
@Table (name = "product")
public class Product {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "A descrição do produto não pode ser nula!")
    @Column (name = "description")
    private String description;

    @Min(value = 0, message = "O preço do produto não pode ser negativo!")
    @NotNull(message = "O preço do produto não pode ser nulo!")
    private BigDecimal price;

    @NotNull (message = "O produto precisa ser cadastrado em uma categoria válida!")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id")
    private ProductCategory productCategory;

    @Min(value = 0, message = "A quantidade do produto não pode ser negativa!")
    @Column (name = "quantity_product")
    private Integer quantityProduct;



    public Product() {
    }

    public Product(String description, BigDecimal price, Integer quantityProduct, ProductCategory productCategory) {
        this.description = description;
        this.price = price;
        this.quantityProduct = quantityProduct;
        this.productCategory = productCategory;
    }


    private void setPrice (BigDecimal price) {
       this.price = price;
    }

    public String getDescription() {
        return this.description;
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


    public void setDescription(String description) {
        this.description = description;
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

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", productCategory=" + productCategory +
                ", quantityProduct=" + quantityProduct +
                '}';
    }
}
