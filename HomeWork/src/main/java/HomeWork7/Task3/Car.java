package HomeWork7.Task3;

public class Car implements Comparable<Car> {
    private String brand;
    private String model;
    private double prise;

    public Car(String brand, String model, double prise) {
        this.brand = brand;
        this.model = model;
        this.prise = prise;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getPrise() {
        return prise;
    }

    @Override
    public String toString() {
        return '[' + model + ": "+ prise + ']';
    }

    @Override
    public int compareTo(Car o) {
        return this.brand.compareTo(o.brand);
    }
}
