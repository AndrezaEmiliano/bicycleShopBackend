import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Customer {

    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String cpf;
    private String email;
    private String mainPhone;
    private String secondPhone;
    private Address address;
    private static int total;


    public Customer() {
    }

    public Customer(String name, String surname, LocalDate dateOfBirth, String cpf, String email, String mainPhone, String secondPhone, Address address){
        Customer.total++;
        this.name = name;
        this.surname = surname;
        setDateOfBirth(dateOfBirth);
        this.cpf = cpf;
        this.email = email;
        this.mainPhone = mainPhone;
        this.secondPhone = secondPhone;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getDateOfBirth () {
        return dateOfBirth;
    }

    public String getDateOfBirthFormatted () {
        if (dateOfBirth != null){
        return dateOfBirth.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        }
        else{
            System.out.println("Data de nascimento não cadatrada");
            return null;
        }
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }

    public String getMainPhone() {
        return mainPhone;
    }

    public String getSecondPhone() {
        return secondPhone;
    }

    public Address getAddress() {
        return address;
    }

    public static int getTotal() {
        return total;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) throws DateException {
        if (dateOfBirth != null && dateOfBirth.isAfter(LocalDate.now())) {
            throw new DateException("A data de nascimento nao é válida");
        }
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfBirthFormatted(String dateOfBirth){
        this.dateOfBirth = LocalDate.parse(dateOfBirth, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMainPhone(String mainPhone) {
        this.mainPhone = mainPhone;
    }

    public void setSecondPhone(String secondPhone) {
        this.secondPhone = secondPhone;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
