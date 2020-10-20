package br.com.exactalabs.bicycleshop.entity;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "when_made")
    private LocalDate whenMade;

    @NotNull (message = "O cliente não pode ser nulo")
    @JoinColumn (name = "customer_id")
    @OneToOne
    private Customer customer;

    @Min(value = 0, message = "O valor da compra não pode ser negativo!")
    @Column (name = "estimated_total")
    private BigDecimal estimatedTotal;

    @Column (name = "subtotal_discount")
    private BigDecimal subtotalDiscount;

    @NotEmpty(message = "Não se pode realizar um pedido sem itens")
    @JoinColumn(name = "order_id")
    @OneToMany(cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<OrderItem> orderItems = new ArrayList<>();


    public Order() {
        this.whenMade = LocalDate.now();
        this.subtotalDiscount = BigDecimal.valueOf(0);
    }

    public Order(Customer customer, OrderItem orderItem) {
        this();
        this.customer = customer;
        this.addOrderedItem(orderItem);
        this.getEstimatedTotal (orderItem);
    }


    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getWhenMade() {
        return whenMade;
    }

    public void setWhenMade(LocalDate whenMade) {
        this.whenMade = whenMade;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    private BigDecimal getEstimatedTotal (OrderItem orderItem) {
        orderItem.decreaseQuantity();
        this.estimatedTotal = (orderItem.getProduct().getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity())));
        return this.estimatedTotal;
    }

    public BigDecimal getEstimatedTotalValue (){
        return this.estimatedTotal;
    }

    public void setEstimatedTotal(BigDecimal estimatedTotal) {
        this.estimatedTotal = estimatedTotal;
    }

    public void setSubtotalDiscount (Integer percentDiscount) {
        this.subtotalDiscount = (this.estimatedTotal.subtract((this.estimatedTotal.multiply(BigDecimal.valueOf(percentDiscount))).
                divide(BigDecimal.valueOf(100))));
        setEstimatedTotal(this.subtotalDiscount);
    }

    public BigDecimal getSubtotalDiscount() {
        return subtotalDiscount;
    }

    public void addOrderedItem(OrderItem orderItem) {
        if (orderItem != null) {
            this.orderItems.add(orderItem);
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", whenMade=" + whenMade +
                ", customer=" + customer +
                ", estimatedTotal=" + estimatedTotal +
                ", subtotalDiscount=" + subtotalDiscount +
                ", orderItems=" + orderItems +
                '}';
    }
}