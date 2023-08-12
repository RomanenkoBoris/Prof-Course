package lesson14;

import java.util.*;

public class Lesson14 {
    public static void main(String[] args) {
        List<Fruit> fruits = new ArrayList<>(Arrays.asList(
                new Fruit("Apple", 52),
                new Fruit("Bananas", 89),
                new Fruit("Grapes", 67),
                new Fruit("Plums", 67),
                new Fruit("Lemon", 29)
        ));
        System.out.println(fruits);
        Collections.sort(fruits);
        System.out.println(fruits);

        // сортировка вначале по убыванию калорий и потом по убыванию имен
        fruits.sort(
                Comparator.comparingInt(Fruit::getCalories).reversed()
                        .thenComparing(Comparator.comparing(Fruit::getName).reversed())
        );
        System.out.println(fruits);

        // элемент с максимальной калорийностью
        Fruit max = Collections.max(fruits, (o1, o2) -> o1.getCalories() - o2.getCalories());
        Fruit max2 = Collections.max(fruits, Comparator.comparingInt(Fruit::getCalories));
        System.out.println(max);
        System.out.println(max2);

        Fruit lemon = new Fruit("Lemon", 29);
        fruits.sort(Comparator.comparing(Fruit::getName));
        System.out.println(fruits);
        System.out.println(
                Collections.binarySearch(fruits, lemon, Comparator.comparing(Fruit::getName)) // 3 - место в коллекции
        );

        // фрукты по возрастанию калорийности
//        TreeSet<Fruit> fset = new TreeSet<>();
//        fset.addAll(fruits);
//        System.out.println(fruits);

        TreeSet <Fruit> fset = new TreeSet<>(Comparator.comparing(Fruit::getCalories));
        fset.addAll(fruits);
        System.out.println(fset);
        // найти подсет элементов, которые находятся между заданными параметрами
        System.out.println(
                fset.subSet(
                        new Fruit("Kiwi", 30),
                        new Fruit("Pomelo", 70)
                )
        );
        // fset.tailSet() // набор тех кто больше
        // fset.headSet() // набор тех кто меньше
    }
}
