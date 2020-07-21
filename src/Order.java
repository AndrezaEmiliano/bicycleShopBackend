import java.math.BigDecimal;

public class Order {

    private Client purchaser;
    private PaymentMethod paymentMethod;
    private Products product;
    private Integer quantity;
    private BigDecimal estimatedTotal;


    public Order() {
    }

    public Order(Client purchaser, Products product, Integer quantity, PaymentMethod paymentMethod) {
        this.purchaser = purchaser;
        this.product = product;
        this.quantity = quantity;
        this.paymentMethod = paymentMethod;
    }


    public Client getPurchaser() {
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

    public BigDecimal getEstimatedTotal() {
            return estimatedTotal;
    }


    public void setPurchaser(Client purchaser) {
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

    public void setEstimatedTotal () {
        try{
        if (this.decreaseQuantity()) {
            this.estimatedTotal = this.getProduct().getPrice().multiply(new BigDecimal(this.getQuantity()));
            this.paymentMethod.setValue(this.estimatedTotal);
        }
        else {
            System.out.println("quantidade de produto insuficiênte");
        }
        }
        catch(NullPointerException exception){
            System.out.println("O preço do produto não está cadastrado");
        }
    }

    public void discountEstimatedTotal (BigDecimal percentDiscount) {
        try{
        BigDecimal subtotalDiscount = (getEstimatedTotal().subtract((getEstimatedTotal().multiply(percentDiscount)).divide(new BigDecimal(100))));
        System.out.println("O novo valor do produto com o desconto de " + percentDiscount + "% concedido é: R$" + subtotalDiscount);
        }
        catch(NullPointerException exception){
            System.out.println("O preço do produto não está cadastrado");
        }
    }

}