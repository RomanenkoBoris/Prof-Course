package lesson10;

/*
    если планируем использовать для наших собственных классов
    хэшированные контейнеры (HashSet, HashMap etc) то нужно:
    0. заимплементить в классе equals() и hashCode()
    у Object.hasCode() есть контракт
    1. На протяжении жизни объекта hashCode() должен выдавать одно и то-же целое
    2. если два объекта эквивалентны, то их хэш-коды должны быть одинаковы

 */


import java.util.HashSet;
import java.util.Set;

public class HashSetTester {
    public static void main(String[] args) {
        Set<Point> points = new HashSet<>();
        Point p1 = new Point(10, 20);
        Point p2 = new Point(10, 20);
        points.add(p1);
        points.add(p2);
        System.out.println(points.size()); // дефолтно 2, а после переопределения equals уже 1

        Set<Point> newPoints = new HashSet<>();
        Point newPoint = new Point(100, 200);
        newPoints.add(newPoint);
        newPoint.setY(10_000);
        newPoints.add(newPoint);
        // hashCode разный и equals тоже разный
        System.out.println(newPoints.size()); // 2
        // Чтобы этого не произошло (см. правила исп. хэшей) нужно сделать экземпляры нашего класса не изменяемыми,
        // иначе теряется смысл - объекты могут меняться, хэш меняется - бардак. Поэтому у свойств private b никаких set
    }


}