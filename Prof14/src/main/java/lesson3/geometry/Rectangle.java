package lesson3.geometry;

public class Rectangle extends Figure {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double area() {
        return width*height;
    }

    @Override
    double perimeter() {
        return (width+height)*2;
    }
}