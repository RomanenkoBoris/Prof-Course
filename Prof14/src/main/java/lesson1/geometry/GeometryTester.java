package lesson1.geometry;

public class GeometryTester {
    public static void main (String[]args){
        Point p1 = new Point(1, 2);
        Point p2 = new Point(15, 44);
        Rectangle abcd = new Rectangle(p1, p2);
        double area = abcd.area();
        System.out.println("Your area is " + area);
    }
}
