package lesson28.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class GenericTester {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Misha");
        // names.add(4); - нельзя добавить числовой тип

        List something = new ArrayList(); // Object
        something.add("Misha");
        something.add(123);
        String name = (String) something.get(0);
        // String anotherName = (String) something.get(1);

        debug(name);
        debug(123);
        log(name); // It's a String, value is: Misha
        log(123); // It's a Integer, value is: 123

        String[] countries = {"Cuba", "Venezuela", "Salvador", "Albania"};
        System.out.println(firstElement(countries));

        System.out.println(Arrays.toString(countries));
        swap(countries, 1, 2);
        System.out.println(Arrays.toString(countries));

        Pair<String, Integer> masha = new PairImpl<>("Masha", 24);
        Pair<String, Integer> masha2 = new PairImpl<>("Masha", 24);
        System.out.println(firstAndLast(countries)); // P{f=Cuba, s=Albania}

        System.out.println(fromArrayToList(countries));

        System.out.println(fromArrayToList(countries, s -> s.contains("l"), s -> s.toUpperCase()));
        // [SALVADOR, VENEZUELA, ALBANIA]

        System.out.println(equals(masha, masha2)); // true

        System.out.println(filter(Arrays.asList(countries), c -> c.length() > 5));
        // [Salvador, Venezuela, Albania]
    } // main

//    Напишите в классе GenericTester функцию equals, которая сравнит две пары.
//    Пары равны если равны оба их элемента

    public static boolean equals(Pair p1, Pair p2) {
        if (p1 == null || p2 == null) {
            return false;
        }
        if (p1.first().getClass() != p2.first().getClass() || p1.second().getClass() != p2.second().getClass()) {
            return false;
        }
        return p1.first().equals(p1.first()) && p1.second().equals(p2.second());
    }

//    Напишите в классе GenericTester функцию filter, которая принимает список любого типа
//    и предикат и возвращает список только из тех элементов, которые предикату соотвутствуют.

    public static <T> List<T> filter(List<T> t, Predicate<T> p) {
        return t.stream()
                .filter(p)
                .collect(Collectors.toList());
    }

    public static <T, R> List<R> fromArrayToList(T[] a, Predicate<T> predicate, Function<T, R> mapper) {
        return Arrays.stream(a)
                .filter(predicate)
                .map(mapper)
                .collect(Collectors.toList());
    }

    // напишите шаблоную функцию которая преобразует массив чего угодно в список
    public static <T> List<T> fromArrayToList(T[] a) {
        return Arrays.stream(a)
                .collect(Collectors.toList());
    }

    // напишите функцию которая принимает на вход массив чего угодно и возвращает
    // пару из первого и последнего элемента
    public static <T> Pair<T, T> firstAndLast(T[] a) {

        return new PairImpl<>(a[0], a[a.length - 1]);
    }

    // напишите функцию swap которая принимает на вход массив чего угодно и два номера
    // внутри массива обменивает элементы по этим номерам
    public static <R> void swap(R[] array, int i, int j) {
        R tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    // напишите шаблонную функцию которая принимает на вход массив чего угодно
    // и возвращает первый элемент этого массива
    public static <T> T firstElement(T[] array) {
        return array[0];
    }

    // Generic == Шаблон
    // T - типовой параметр
    public static <T> void log(T t) {    // t - значение, T - тип
        System.out.println("It's a " + t.getClass().getSimpleName() + ", value is: " + t);
    }

    public static void debug(int i) {
        System.out.println("It's a int, value is: " + i);
    }

    public static void debug(String s) {
        System.out.println("It's a String, value is: " + s);
    }
}