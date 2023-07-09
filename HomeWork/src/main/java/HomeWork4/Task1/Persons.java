package HomeWork4.Task1;

public class Persons {
    private String name;
    final private Address address;

    public Persons(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }
}
