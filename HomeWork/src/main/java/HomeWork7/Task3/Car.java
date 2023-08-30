package HomeWork7.Task3;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (Double.compare(car.prise, prise) != 0) return false;
        if (!Objects.equals(brand, car.brand)) return false;
        return Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = brand != null ? brand.hashCode() : 0;
        result = 31 * result + (model != null ? model.hashCode() : 0);
        temp = Double.doubleToLongBits(prise);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}


