package br.com.exactalabs.bicycleshop.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "É necessário selecionar uma produto.")
    @JoinColumn (name = "product_id")
    @OneToOne
    private Product product;

    @Min(value = 0, message = "A quatidade de produto comprada não pode ser negativa.")
    @Column (name = "quantity")
    private Integer quantity;

    @Min(value = 0, message = "O preço do produto não pode ser negativo.")
    private BigDecimal price;

    public OrderItem (){
    }

    public OrderItem(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
        setPrice(product);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(Product product) {
        this.price = product.getPrice();
    }

    public void decreaseQuantity() {
        this.product.setQuantityProduct(this.product.getQuantityProduct()-this.quantity);
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "id=" + id +
                ", product=" + product +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}

