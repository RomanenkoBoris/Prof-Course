package lesson17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Lesson17 {

    // https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html

    public static void main(String[] args) {
        NoArgsReturnDouble returns10 = new NoArgsReturnDouble() {
            @Override
            public double produce() {
                return 10;
            }
        };

        NoArgsReturnDouble lambdaReturns5 = () -> 5;
        NoArgsReturnDouble lambdaReturns15 = () -> {
            return 15;
        };

        // напишите в виде лямбды реализацию NoArgsReturnDouble которая возвращает рандомное
        // значение double
        NoArgsReturnDouble randomDouble = () -> new Random().nextDouble();

//        NoArgsReturnDouble randomDouble = new NoArgsReturnDouble() {
//            @Override
//            public double produce() {
//                return new Random().nextDouble();
//            }
//        };
        System.out.println("рандомное значение: " + randomDouble.produce());

        // Supplier - безаргументный функциональный интерфейс который
        // просто возвращает значение

        // Predicate - функциональный интерфейс который принимает на вход значение
        // и вщзвращает boolean

        TwoIntsReturnsBoolean equality = (i, j) -> i == j;
        TwoIntsReturnsBoolean isDividedBy = (i, j) -> i % j == 0;

        System.out.println(process(2, 3, equality)); // false
        System.out.println(process(12, 3, isDividedBy)); // true

        List<Integer> digits = Arrays.asList(1, 2, 3, 4, 8, 10, 12, 0, 2);
        System.out.println(filter(digits, i -> i % 2 == 1));
        System.out.println(filter(digits, i -> i >= 10));

        List<String> names = Arrays.asList("Max", "Masha", "Alexander", "Dima");
        System.out.println(map(names, s -> s.length()));

        System.out.println(
                names.stream()
                        .filter(s -> s.length() > 4)
                        .map(s -> s.length())
                        .collect(Collectors.toList())
        );
        // функциональный интерфейс который принимает один тип и возвращает другой
        // кроме boolean называется Function

    } // main

    static List<Integer> map(List<String> string, StringReturnInt p) {
        List<Integer> result = new ArrayList<>();
        for (String s : string)
            result.add(p.process(s));
        return result;
    }


    static List<Integer> filter(List<Integer> list, IntReturnsBoolean p) {
        List<Integer> result = new ArrayList<>();
        for (Integer temp : list) {
            if (p.check(temp)) {
                result.add(temp);
            }
        }
        return result;
    }


    // напишите реализацию - вызывать функцию из интерфейса для i и j
    static boolean process(int i, int j, TwoIntsReturnsBoolean c) {
        return c.check(i, j);
    }

    // отфильтруйте список
    // добавляйте в выходной список только те элементы из входного
    // которые соотвутствуют предикату IntReturnsBoolean

}
