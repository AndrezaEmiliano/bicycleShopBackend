package br.com.exactalabs.bicycleshop.entity;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "customer")
public class Customer {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank (message = "Nome não pode ser nulo.")
    @Column (name = "first_name")
    private String name;

    @NotBlank (message = "O soberenome não pode ser nulo.")
    @Column (name = "last_name")
    private String surname;

    @NotNull (message = "A data não pode ser nula")
    @Past (message = "A data não é válida. Ela deve ser anterior a data de hoje.")
    @Column (name = "birthday")
    private LocalDate dateOfBirth;

    @NotBlank (message = "O CPF não pode ser nulo.")
    private String cpf;

    @NotBlank (message = "O email não pode ser nulo.")
    private String email;

    @NotBlank (message = "O telefone não pode ser nulo")
    @Column (name = "phone1")
    private String mainPhone;

    @Column (name = "phone2")
    private String secondPhone;

    @NotEmpty (message = "O endereço não pode ser nulo")
    @JoinColumn(name = "customer_id")
    @OneToMany (cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Address> address = new ArrayList<>();

    public Customer() {
    }

    public Customer(String name, String surname, LocalDate dateOfBirth, String cpf, String email, String mainPhone, String secondPhone, Address address){
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.cpf = cpf;
        this.email = email;
        this.mainPhone = mainPhone;
        this.secondPhone = secondPhone;
        this.addAddress(address);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public LocalDate getDateOfBirth () {
        return dateOfBirth;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMainPhone() {
        return mainPhone;
    }

    public void setMainPhone(String mainPhone) {
        this.mainPhone = mainPhone;
    }

    public String getSecondPhone() {
        return secondPhone;
    }

    public void setSecondPhone(String secondPhone) {
        this.secondPhone = secondPhone;
    }


    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public void addAddress(Address address) {
        if (address != null) {
            this.address.add(address);
        }
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", mainPhone='" + mainPhone + '\'' +
                ", secondPhone='" + secondPhone + '\'' +
                ", address=" + address +
                '}';
    }
}
