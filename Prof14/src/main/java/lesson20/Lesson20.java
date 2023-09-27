package lesson20;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lesson20 {
    public static void main(String[] args) {
        // Java Streams: Flat map.
        // filter n -> 0..n

        // map n -> n
        // flatMap n -> m

        Integer [] [] twoDimensionalArray = {
                {1,2,3},
                {5,6,8,10},
                {11},
                {14,12}
        };
        Arrays.stream(twoDimensionalArray)
                .forEach(array -> System.out.println(Arrays.toString(array)));

        Arrays.stream(twoDimensionalArray)
//                .flatMap(new Function<Integer[], Stream<Integer>>() {
//
//                    @Override
//                    public Stream<Integer> apply(Integer[] integers) {
//                        return Arrays.stream(integers);
//                    }
                .flatMap((Function<Integer[], Stream<Integer>>) integers -> Arrays.stream(integers))
                .forEach(System.out::println);

        List<List<String>> names = Arrays.asList(
                Arrays.asList("Masha", "Alexander"),
                Arrays.asList("Semen", "Vlad", "Alice", "Xenia")
        );
        // преобразуйте в поток имен и распечатайте
        names.stream()
                //.flatMap((Function<List<String>, Stream<String>>) strings-> strings.stream())
                .flatMap(list -> list.stream())
                .forEach(System.out::println);

        // преобразовать names в поток длин имен, желательно за одну операцию flatMap
        names.stream()
                .flatMap(list -> list.stream().map(w -> w.length()))
                .forEach(System.out::println);

        names.stream()
                .flatMap(list -> list.stream())
                //.flatMap(chars -> Arrays.stream(chars)) - Stream char не поддерживается
                .flatMap(name -> Arrays.stream(name.split("")))
                .forEach(System.out::println);

        Order grocery = new Order(
                new OrderItem("mango", 2, 1.66),
                new OrderItem("apples", 3, 0.99),
                new OrderItem("corona", 2, 1.35)
        );

        Order utility = new Order(
                new OrderItem("water", 104, 0.30),
                new OrderItem("electicity", 201, 0.38)
        );

        List<Order> orders = Arrays.asList(grocery, utility);

        // Посчитать сумму всех затрат (по всем счетам и позициям)
        System.out.println(orders.stream()
                .flatMap(order -> order.getItems().stream())
                .map(orderItem -> orderItem.getQuantity()*orderItem.getUnitPrice())
                .reduce(0.0, (total, price) -> total + price));

        List<Book> library = Arrays.asList(
                new Book("War and Peace", "Max", "Sveta", "Dima"),
                new Book("Movable feast", "Ernest", "George"),
                new Book("Hello to Spartans", "Dima", "Alexander", "Galina")
        );

        // распечатайте всех авторов
        library.stream()
                .flatMap(books -> books.getAuthors().stream())
                .forEach(System.out::println);

        // распечатать авторов без повторов и в алфавитном порядке
        library.stream()
                .flatMap(books -> books.getAuthors().stream())
                .distinct()
                .sorted()
                // или заколектить в TreeSet, тогда избежим и повторов и отсортируемся сразу
                .forEach(System.out::println);

        // При работе с примитивами, нужно использовать свои вариации flatMapToInt, --ToDouble и т.д.
        int [] [] ints = {
                {1,2,3},
                {4}
        };
        System.out.println(
                Arrays.toString(
                        Arrays.stream(ints).flatMapToInt(array -> Arrays.stream(array)).toArray()
                )
        );

        // создайте на базе names Map<Integer, List<String>>, ключом которой была бы длина имени
        Map<Integer, List<String>> namesMap = new HashMap<>(names.stream()
                .flatMap(list -> list.stream())
                .collect(Collectors.groupingBy(name -> name.length())));
        System.out.println(namesMap); // {9=[Alexander], 4=[Vlad], 5=[Masha, Semen, Alice, Xenia]}

        // Map<Integer, List<String>> -> Map<Integer, Integer> т.е. из одной Мар делаем другую
        namesMap.entrySet().stream()
                .map(pair -> new AbstractMap.SimpleEntry(pair.getKey(), pair.getValue().size()))
                .collect(Collectors.toMap(
                pair -> pair.getKey(),      // не пугаться что при сборе в Мар Java тупит и не понимает.
                pair -> pair.getValue()));  // прописываем все Funktion до конца и она разберется что требуется



    }
}
