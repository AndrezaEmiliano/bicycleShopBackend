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
        getEstimatedTotal();
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


    public void setDecreaseQuantity() throws QuantityException {
        if (this.product.getQuantityProduct() < this.quantity || this.product.getQuantityProduct() == null){
            throw new QuantityException("A quantidade de produto é insuficiênte para esta compra!");
        }
        this.product.setQuantityProduct(this.product.getQuantityProduct()-this.quantity);
    }

    private BigDecimal getEstimatedTotal () {
        this.setDecreaseQuantity();
        this.estimatedTotal = (this.getProduct().getPrice().multiply(BigDecimal.valueOf(this.getQuantity())));
        this.paymentMethod.setValue(this.estimatedTotal);
        return this.estimatedTotal;
    }

    public BigDecimal getEstimatedTotalValue (){
        return this.estimatedTotal;
    }

    public void setEstimatedTotal(BigDecimal estimatedTotal) {
        this.estimatedTotal = estimatedTotal;
        this.paymentMethod.setValue(this.estimatedTotal);
    }

    public void setSubtotalDiscount (Integer percentDiscount) {
        this.subtotalDiscount = (getEstimatedTotalValue().subtract((getEstimatedTotalValue().multiply(BigDecimal.valueOf(percentDiscount))).divide(BigDecimal.valueOf(100))));
        setEstimatedTotal(getSubtotalDiscount());
    }

    public BigDecimal getSubtotalDiscount() {
        return subtotalDiscount;
    }
}