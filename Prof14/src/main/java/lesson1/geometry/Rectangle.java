package lesson1.geometry;

public class Rectangle {
    final private Point sw;
    final private Point ne;

    public Rectangle(Point sw, Point ne) {
        this.sw = sw;
        this.ne = ne;
    }

    public Point getSw() {
        return sw;
    }

    public Point getNe() {
        return ne;
    }

    public double area (){
        return (ne.getX()-sw.getX())*(ne.getY()-sw.getY());
    }
}
