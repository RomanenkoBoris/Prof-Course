package HomeWork4.Task1;

public class Address {
    private String street;
    private int houseNumber;

    public Address(String street, int houseNumber) {
        this.street = street;
        if (houseNumber > 0 && houseNumber < 1000) {
            this.houseNumber = houseNumber;
        }
    }

    public String getStreet() {
        return street;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    @Override
    public String toString() {
        return "Street: " + street  +
                ", house number: " + houseNumber;
    }
}
