import java.math.BigDecimal;
import java.time.LocalDate;

public class CreditCard extends PaymentMethod {

    private String cardNumber;
    private LocalDate expDate;
    private int cvv;
    private String cardName;
    private Integer flexPaymentNumber;


    public CreditCard() {
    }

    public CreditCard(String cardNumber, LocalDate expDate, int cvv, String cardName, Integer flexPaymentNumber) {
        this.cardNumber = cardNumber;
        this.expDate = expDate;
        this.cvv = cvv;
        this.cardName = cardName;
        this.flexPaymentNumber = flexPaymentNumber;
    }


    public String getCardNumber() {
        return cardNumber;
    }

    public LocalDate getExpDate() throws ExpDateException{
        if (expDate == null){
            throw new ExpDateException("O cartão não pode ter a data de validade nula.");
        }
        if (expDate.isBefore(LocalDate.now())){
            throw new ExpDateException("O cartão está com a validade expirada");
        }
        return expDate;
    }

    public int getCvv() {
        return cvv;
    }

    public String getCardName() {
        return cardName;
    }

    public Integer getFlexPaymentNumber() {
        return flexPaymentNumber;
    }


    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setExpDate(LocalDate expDate) {
        this.expDate = expDate;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public void setFlexPaymentNumber(Integer flexPaymentNumber) {
        this.flexPaymentNumber = flexPaymentNumber;
    }
}