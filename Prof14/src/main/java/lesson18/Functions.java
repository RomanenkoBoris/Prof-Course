package lesson18;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Functions {
    public static void main(String[] args) {
        // Function
        // принимает на вход элемент одного типа а отдает элемент другого типа (или того же)
        // https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html
        // могут объединяться andThen() и compose() - посмотри на Oracle
        // вернуть длину строки
        //тип на входе    выходе
        Function<String, Integer> stringIntegerFunction = s -> s.length();
        List<String> names = Arrays.asList("John", "Max", "Alexander", "Vasilisa");

        // Функции применяются при вызове map() метода
        System.out.println(
                names.stream()
                        .map(stringIntegerFunction) // логику можно прописать сразу в параметрах в виде Lambda
                        .collect(Collectors.toList()) // [4, 3, 9, 8]
        );

        // напишите Function который добавит к строке одинарные кавычки - alex -> 'alex'
        Function<String, String> quote = s -> "'" + s + "'";

        Function<Double, String> formatDouble = d -> "double: " + d;

        // Прямая последовательность объединения 2х функций
        System.out.println(
                formatDouble.andThen(quote).apply(3.14) // 'double: 3.14'
        );

        // Обратная последовательность, но результат у обоих единый
        System.out.println(
                quote.compose(formatDouble).apply(3.14) // 'double: 3.14'
        );

        // Identity - возвращает то что и принимает на вход
        Function<Long, Long> longIdentity = Function.identity();
        System.out.println(longIdentity.apply(3L)); // 3

        // BiFunction - функция которая принимает на вход два аргумента разных типов
        // и возвращает значение другого типа
        //          вход    вход    выход
        BiFunction<String, Double, Integer> formatter = (s, d) -> (s + " " + d).length();
        System.out.println(formatter.apply("hello", 3.14)); // 10

        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("John", 15_000);
        salaries.put("Masha", 25_000);
        salaries.put("Alex", 17_000);
        salaries.put("Samuel", 33_000);

        salaries.computeIfAbsent("Max", s -> 4000 * s.length());
        System.out.println(salaries); // {Alex=17000, Samuel=33000, Masha=25000, Max=12000, John=15000}

        // увеличьте зарплату каждого на 1200
        salaries.replaceAll((name, salary) -> salary + 1200);
        System.out.println(salaries); // {Alex=18200, Samuel=34200, Masha=26200, Max=13200, John=16200}

        // Увеличить зарплату Макса в 2 раза, остальных оставить без изменения
        salaries.replaceAll((name, salary) -> name.equals("Max") ? salary * 2 : salary);
        System.out.println(salaries); // {Alex=18200, Samuel=34200, Masha=26200, Max=26400, John=16200}
    }
}
