package lesson3.geometry;

public abstract class Figure {
    abstract double area();
    abstract double perimeter();

    // абстрактные классы могут иметь поля
    private String name = "FIGURE";

    // не абстрактные методы наследуюся
    // производными классами
    // производные классы не обязаны переопределять
    // не абстрактные методы
    public void hello()
    {
        System.out.println("Hello");
    }
}