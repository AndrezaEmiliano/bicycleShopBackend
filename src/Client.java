import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {

    private String name;
    private String surname;
    private LocalDate dateBirth;
    private String cpf;
    private String email;
    private String mainPhone;
    private String secondPhone;
    private Address address;
    private static int total;


    public Client() {
    }

    public Client (String name, String surname, LocalDate dateBirth, String cpf, String email, String mainPhone, String secondPhone, Address address){
        Client.total++;
        this.name = name;
        this.surname = surname;
        if (dateBirth.isBefore(LocalDate.now())){
            this.dateBirth = dateBirth;
        }
        else {
            System.out.println("A data de nascimento não é válida, favor edita-la");
        }
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

    public LocalDate getDateBirth () {
        return dateBirth;
    }

    public String getDateBirthFormatted () {
        if (dateBirth != null){
        return dateBirth.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public void setDateBirthFormatted(String dateBirth){
        this.dateBirth = LocalDate.parse(dateBirth, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
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
