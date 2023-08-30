package Lesson19;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lesson19 {
    public static void main(String[] args) {
        List<Integer> years = Arrays.asList(2000, 2022, 2021, 2027);

        // поток не запустится, пока к нему не присоединена терминальная операция
        Stream<Integer> yearsStream = years.stream()
                .filter(y -> y % 2 == 0) // промежуточная операция
                .filter(y -> y > 2010); // промежуточная операция

        // разрывая каскад, мы можем использовать множество терминальных операций опираясь
        // на данные интремедиальных операций, получыя различный результат (в зависимости от задачи)
        yearsStream.forEach(i -> System.out.println(i));
        // yearsStream.reduce(....) и т.д.

        String[] names = {"Alexander", "Max", "Xenia", "Maria"};

        // отфильтруйте только те что содержать x или X, переведите имена в верхний регистр, распечатайте
        Arrays.stream(names)
                .filter(s -> s.toLowerCase().contains("x"))
                .map(s -> s.toUpperCase())
                .forEach(s -> System.out.println(s));

        // Генерация потока примитивов

        // IntStream.range(1,5) // 1,2,3,4
        // IntStream.rangeClosed(1,5) // 1,2,3,4,5

        // сгеренируйте рандомный double
        DoubleStream
                .generate(() -> new Random().nextDouble())
                .limit(10)
                .forEach(System.out::println);

        // создать поток интов до 10 и распечатать 3,4 и 5
        IntStream.rangeClosed(1, 10)
                .skip(2)
                .limit(3)
                .forEach(System.out::println);

        // names - преобразуйте "имя" -> "имя:3" - и распечатайте
        Arrays.stream(names)
                .map(s -> s + ":" + s.length())
                .forEach(System.out::println);

        System.out.println(
                Arrays.stream(names)
                        .map(s -> s + ":" + s.length())
                        .count() // количество элементов в потоке
        );

        Arrays.stream(names)
                .map(s -> s + ":" + s.length())
                .sorted() // sort
                .forEach(System.out::println);

        Stream.of(1, 10, 20, 20, 0, 10)
                .distinct() // пропустит только не повторяющиеся элементы 1 10 20 0
                .forEach(System.out::println);

        // peek - позволяет заглянуть в поток, без изменения его элементов
        Arrays.stream(names)
                .peek(s -> System.out.println(s.length()))
                .forEach(System.out::println);

        // функции которые проверяют все элементы потока целиком
        // anyMatch(Predicate<T>) - хотя бы один элемент удовлетворяет
        // allMatch(Predicate<T>) - все элементы удовлетворяют
        // noneMatch(Predicate<T>) - ни один из элементов не удовлетворяет

        // убедитесь что ни один из names не содержит "y"
        Arrays.stream(names)
                .noneMatch(s -> s.toLowerCase().contains("y"));

        Arrays.stream(names)
                .allMatch(s -> s.toLowerCase().contains("a"));

        int[] numbers = {2, 4, 5, 8, 3};

        System.out.println(
                Arrays.stream(numbers)
                        .reduce(0, (prev, current) -> prev + current)
        );

        // найдите произведение элементов numbers
        System.out.println(
                Arrays.stream(numbers)
                        .reduce(1, (prev, current) -> prev * current)
        );

        // Optional<T> - может быть значение, но может и не быть значения
        // превратите names в "Alexander, Max, Xenia, Maria"
        System.out.println(Arrays.stream(names)
                .reduce((total, element) -> total + ", " + element) // нет начального значения
                //Optional[Alexander, Max, Xenia, Maria]
                .orElse(" ")); // .orElseGet, .orElseThrow
        // Alexander, Max, Xenia, Maria

        System.out.println(
                years.stream()
                        .filter(y -> y > 10_000)
                        .findFirst() // возвратить первый элемент
        );


        // min / max
        System.out.println(
                Arrays.stream(names)
                        .max(Comparator.naturalOrder()) // Optional[Xenia] -компаратор построенный на Comparable
        );
        System.out.println(
                Arrays.stream(names)
                        .max(Comparator.comparingInt(String::length)) // Optional[Alexander]
                        .orElse("") // Alexander
        );

        // Collect
        Set<String> namesSet =
                Arrays.stream(names)
                        .collect(Collectors.toSet());

        Arrays.stream(names)
                .collect(
                        Collectors.toCollection(ArrayList::new)
                );

        String namesCombined =
                Arrays.stream(names)
                        .collect(Collectors.joining(", "));

        // groupingBy - возможность сгруппировать элементы в Map
        // с помощью функции вычисления ключа

        // Alexander  Max  Xenia  Maria
        System.out.println(
                Arrays.stream(names)
                        .collect(Collectors.groupingBy(s -> s.length())) // вычисление ключа
                // {3=[Max], 5=[Xenia, Maria], 9=[Alexander]} - создает ключ = лист типа элементов потока
        );

        // Collectors toMap
        // длина
        System.out.println(
                Arrays.stream(names)
                .collect(Collectors.toMap(s -> s, s -> s.length())) // одна Ф. для ключа, вторая для значения
                //{Alexander=9, Max=3, Maria=5, Xenia=5}
        );


    }
}
