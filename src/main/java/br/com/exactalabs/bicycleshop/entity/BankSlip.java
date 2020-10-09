package br.com.exactalabs.bicycleshop.entity;
import java.time.LocalDate;

public class BankSlip extends PaymentMethod {

    private String barcode;
    private Customer customer;
    private LocalDate deadline;


    public BankSlip() {
    }

    public BankSlip(String barcode, Customer customer, LocalDate deadline) {
        this.barcode = barcode;
        this.customer = customer;
        this.deadline = LocalDate.now().plusDays(2);
    }


    public String getBarcode() {
        return barcode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getDeadline() {
        return deadline;
    }


    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public void setClient(Customer customer) {
        this.customer = customer;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

}
