import java.math.BigDecimal;

public abstract class PaymentMethod {

    private BigDecimal value;
    private BigDecimal flexPaymentNumber;

    public PaymentMethod(BigDecimal flexPayment) {
        this.flexPaymentNumber = flexPayment;
    }

        public BigDecimal getValue() {
        return value;
    }

    public BigDecimal getFlexPaymentNumber() {
        return flexPaymentNumber;
    }

    public void setFlexPaymentNumber(BigDecimal flexPayment) {
        this.flexPaymentNumber = flexPayment;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
