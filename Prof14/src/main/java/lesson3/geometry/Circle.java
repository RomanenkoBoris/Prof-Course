package lesson3.geometry;

public class Circle extends Figure {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    double area(){
        return 2*Math.PI*Math.pow(radius, 2);

    }

    @Override
    double perimeter() {
        return 2*Math.PI*radius;
    }
}
