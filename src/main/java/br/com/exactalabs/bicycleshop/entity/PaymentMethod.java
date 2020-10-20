package br.com.exactalabs.bicycleshop.entity;
import java.math.BigDecimal;

public abstract class PaymentMethod {

    private BigDecimal value;

    public PaymentMethod() {
    }

    public BigDecimal getValue() {
        return value;
    }


    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
