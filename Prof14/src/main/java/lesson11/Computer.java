package lesson11;

public class Computer {
    private String serialNumber;
    private String model;
    private double price;

    public Computer(String serialNumber, String model, double price) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.price = price;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getModel() {
        return model;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Computer computer = (Computer) o;

        return serialNumber.equals(computer.serialNumber);
    }

    @Override
    public int hashCode() {
        return serialNumber.hashCode();
    }

    @Override
    public String toString() {
        return "Computer{" +
                "serialNumber='" + serialNumber + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                '}';
    }
}
