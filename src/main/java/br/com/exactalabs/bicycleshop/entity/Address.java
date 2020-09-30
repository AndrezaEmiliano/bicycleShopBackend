package br.com.exactalabs.bicycleshop.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "zip_code")
    private String zipCode;

    @Column (name = "street_name")
    @NotBlank (message = "O endereço não pode ser nulo")
    private String streetName;

    @Column (name = "address_number")
    @NotBlank (message = "O número não pode ser nulo")
    private String addressNumber;

    @NotBlank (message = "O bairro não pode ser nulo")
    private String neighborhood;

    @NotBlank (message = "O estado não pode ser nulo")
    private String state;

    @NotBlank (message = "A cidade não pode ser nula")
    private String city;

    private String complement;

    public Address() {
    }

    public Address(String zipCode, String streetName, String addressNumber, String neighborhood, String state, String city, String complement) {
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.addressNumber = addressNumber;
        this.neighborhood = neighborhood;
        this.state = state;
        this.city = city;
        this.complement = complement;
    }

    public Long getId() {
        return id;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getAddressNumber() {
        return addressNumber;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getComplement() {
        return complement;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setAddressNumber(String addressNumber) {
        this.addressNumber = addressNumber;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setNumber(String number) {
        this.addressNumber = number;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", zipCode='" + zipCode + '\'' +
                ", streetName='" + streetName + '\'' +
                ", addressNumber='" + addressNumber + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", complement='" + complement + '\'' +
                '}';
    }
}
