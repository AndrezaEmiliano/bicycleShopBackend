import java.math.BigDecimal;

public class Ordered {

    private Customer purchaser;
    private PaymentMethod paymentMethod;
    private Products product;
    private Integer quantity;
    private BigDecimal estimatedTotal;
    private BigDecimal subtotalDiscount;


    public Ordered() {
    }

    public Ordered(Customer purchaser, Products product, Integer quantity, PaymentMethod paymentMethod) {
        this.purchaser = purchaser;
        this.product = product;
        this.quantity = quantity;
        this.paymentMethod = paymentMethod;
    }


    public Customer getPurchaser() {
        return this.purchaser;
    }

    public PaymentMethod getPaymentMethod() {
        return this.paymentMethod;
    }

    public Products getProduct() {
        return this.product;
    }

    public Integer getQuantity() {
        return quantity;
    }


    public void setPurchaser(Customer purchaser) {
        this.purchaser = purchaser;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setProduct(Products product) {
        this.product = product;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public boolean decreaseQuantity(){
        if (this.product.getQuantityProduct() >= this.quantity){
            this.product.setQuantityProduct(this.product.getQuantityProduct()-this.quantity);
            return true;
        }
        else {
            return false;
        }
    }

    public BigDecimal getEstimatedTotal () {
        if (this.decreaseQuantity()) {
            this.estimatedTotal = (this.getProduct().getPrice().multiply(new BigDecimal(this.getQuantity())));
            this.paymentMethod.setValue(this.estimatedTotal);
        }
        else {
            System.out.println("A quantidade de produto é insuficiênte para esta compra!");
        }
        return this.estimatedTotal;
    }

    public void setSubtotalDiscount (Integer percentDiscount) {
        this.subtotalDiscount = (getEstimatedTotal().subtract((getEstimatedTotal().multiply(BigDecimal.valueOf(percentDiscount))).divide(BigDecimal.valueOf(100))));
        System.out.println("O novo valor do produto com o desconto de " + percentDiscount + "% concedido é: R$" + this.subtotalDiscount);
    }

    public BigDecimal getSubtotalDiscount() {
        return subtotalDiscount;
    }
}