import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CreditCard extends PaymentMethod {

    private String numberCard;
    private LocalDate expDate;
    private int cvv;
    private String nameCard;


    public CreditCard(BigDecimal flexPaymentNumber) {
        super(flexPaymentNumber);
    }

    public CreditCard(String numberCard, LocalDate expDate, int cvv, String nameCard, BigDecimal flexPaymentNumber) {
        super(flexPaymentNumber);
        this.numberCard = numberCard;
        this.expDate = expDate;
        this.cvv = cvv;
        this.nameCard = nameCard;

    }

    public String getNumberCard() {
        return numberCard;
    }

    public LocalDate getExpDate() {
        if (expDate.isAfter(LocalDate.now())){
        return expDate;
        }
        else {
        System.out.println("A data de válidade do cartão esta expirada, favor cadastre outro cartão");
        return expDate = null;
        }
    }

    public String getExpDateFormatted() {
        return expDate.format(DateTimeFormatter.ofPattern("MM/yyyy"));
    }

    public int getCvv() {
        return cvv;
    }

    public String getNameCard() {
        return nameCard;
    }


    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public void setExpDateFormatted(String expDate) {
        this.expDate = LocalDate.parse(expDate, DateTimeFormatter.ofPattern("/MM/yyyy"));
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setNameCard(String nameCard) {
        this.nameCard = nameCard;
    }

    public BigDecimal getFlexPayment() {
        return super.getValue().divide(getFlexPaymentNumber());
    }
}