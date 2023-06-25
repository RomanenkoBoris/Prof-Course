package lesson3.geometry;

public class DailyWork {
    public static void main(String[] args) {
        Figure [] work = {
                new Rectangle(2, 3),
                new Rectangle(4, 5),
                new Circle(2),
                new Circle(5),
        };
        double area = 0;
        double perimeter = 0;
        for (int i = 0; i<work.length; i++){
            area += work[i].area();
            perimeter += work[i].perimeter();
        }
        System.out.println("area: " + area + ", perimeter: " + perimeter);
        
    }
}
