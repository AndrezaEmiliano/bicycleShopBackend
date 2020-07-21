import java.math.BigDecimal;
import java.time.LocalDate;

public class Invoice extends PaymentMethod {

    private long barcode;
    private Client client;
    private LocalDate deadline;


    public Invoice(BigDecimal flexPaymentNumber) {
        super(flexPaymentNumber);
    }

    public Invoice(long barcode, Client client, LocalDate deadline, BigDecimal flexPaymentNumber) {
        super(flexPaymentNumber);
        this.barcode = barcode;
        this.client = client;
        this.deadline = LocalDate.now().plusDays(2);
    }


    public long getBarcode() {
        return barcode;
    }

    public Client getClient() {
        return client;
    }

    public LocalDate getDeadline() {
        return deadline;
    }


    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

}
