package lesson4;

import java.util.ArrayList;

public class Box {
    public static void main(String[] args) {
        // int     boolean float byte double ...
        // Integer Boolean Float Byte Double ...
        int i = 10;
        Integer i1 = new Integer(i);

        Integer i2 = i; // boxing - упаковка

        if(i2 < 100) // unboxing - распаковка
            System.out.println("hello");

        int a = 10;
        int b = 10;
        // примитивные типы сравниваются по значению
        System.out.println(a == b); // true

        Integer i3 = new Integer(10);
        Integer i4 = new Integer(10);
        System.out.println(i3 == i4); // false
        // == - эквивалентность
        // для ссылочных типов эквивалентность означает
        // совпадение адреса в памяти

        // ссылочные типы нужно сравнивать на равенство только с помощью equals
        // для всех объектов библиотеки джава (только!!!) equals переопределен
        // и отрабатывает грамотно - сравнивает по значению
        System.out.println(i3.equals(i4)); // true

        // если мы хотим сравнивать между собой экземпляры наших
        // собственных классов, нужно переопредить в классе метод equals
        // т.к. по умолчанию он срванивает объекты по адресу

        // всы ссылочные типы в ява это потомки класса Object

        // контейнеры стандартной библиотеки работают
        // только со ссылочными типами
        ArrayList<Integer> list = new ArrayList<>();
        list.add(123);
        list.add(456);

        String j1 = "JAVA"; // нет new
        String j2 = "JAVA"; // нет new
        // из-за особенностей реализации String
        System.out.println(j1 == j2); // true

    }
}