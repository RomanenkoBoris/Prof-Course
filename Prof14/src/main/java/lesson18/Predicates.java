package lesson18;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Predicates {
    public static void main(String[] args) {
        // Predicate - функциональный интерфейс который принимает значение любого типа и возвращает boolean
        // тест на соответствие значения какому-нибудь условию
        // можно объединять между собой с помощью and(), negate(), or().
        List<String> names = Arrays.asList("John", "Max", "Alexander", "Vasilisa");

        // предикат который возвратит true только если строка s длинее 5 символов
        Predicate<String> moreThan5Letters = s -> s.length() > 5;

        // предикат который вернет true если в строке есть буква x
        Predicate<String> containsX = s -> s.contains("x");

        // Предикат используется в методе фильтр
        System.out.println(
                names.stream() // создаем поток из коллекции
                        .filter(containsX) // пропускает только соответствующие предикату элементы
                        .collect(Collectors.toList()) // собирает дошедшие элементы в коллекцию (лист).
        );

        // "сложный" предикат, который пропускает как элементы длинее 5 символов так и элементы содержащие x
        // посмотри еще методы and() и negate() - пропиши логику
        Predicate<String> complexPredicate = moreThan5Letters.or(containsX);

        System.out.println(
                names.stream().filter(complexPredicate)
                        .collect(Collectors.toList())
        );

    }
}
