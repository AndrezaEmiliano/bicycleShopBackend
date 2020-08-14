public class Address {

    private String zipCode;
    private String streetName;
    private String number;
    private String neighborhood;
    private String state;
    private String city;
    private String complement;

    public Address() {
    }

    public Address(String zipCode, String streetName, String number, String neighborhood, String state, String city, String complement) {
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.number = number;
        this.neighborhood = neighborhood;
        this.state = state;
        this.city = city;
        this.complement = complement;
    }


    public String getZipCode() {
        return zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getNumber() {
        return number;
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


    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setNumber(String number) {
        this.number = number;
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
}
