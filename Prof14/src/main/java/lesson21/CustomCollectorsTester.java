package lesson21;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CustomCollectorsTester {
    public static void main(String[] args) {
        // Collector<T,A,R>
        // T - тип из входного потока
        // A - тип аккумулятора - контейнер в котором накапливаются результаты обработки элементов из входного потока
        // R - тип возвращаемого значения
        // supplier - метод который возвращает пустой аккумулятор
        // accumulator - сохраняет в A (аккумулятор) данные из каждого входного элемента
        // combiner - объединяет A (аккумуляторы) в один
        // finisher - преобразует A в результат

        List<Student> students = Arrays.asList(
                new Student("Michael", "Svetlov", 24),
                new Student("Alexander", "Svetlov", 28),
                new Student("Daria", "Petrovskaya", 19),
                new Student("Maria", "Drobysheva", 19),
                new Student("Max", "Pavlov", 24)
        );

        // напишем коллектор который суммирует возраста студентов
        Collector<Student, List<Integer>, Integer> studentAgeSumCollector = new Collector<Student, List<Integer>, Integer>() {

            // supplier() создает аккумулятор в котором будут накапливаться промеуточные результаты
            @Override
            public Supplier<List<Integer>> supplier() {
                // return () -> new ArrayList<Integer>();
                return ArrayList::new;
            }

            // accumulator() должна как-то обработать и зафиксировать данные каждого входного элемента в аккумуляторе
            @Override
            public BiConsumer<List<Integer>, Student> accumulator() {
                return (list, student) -> list.add(student.getAge());
            }

            // объединяет аккумуляторы между собой при параллельной работе в разнах потоках выполнения
            // по окончании обработки всех входных элементов
            @Override
            public BinaryOperator<List<Integer>> combiner() {
                return (list, list2) -> {
                    list.addAll(list2);
                    return list;
                };
            }
            // преобразование данных в аккумуляторе в возвращаемое значение
            // (сложить все числа в списке между собой и вернуть сумму)
            @Override
            public Function<List<Integer>, Integer> finisher() {
                return list -> list.stream().mapToInt(i -> i).sum();
            }


            @Override
            public Set<Characteristics> characteristics() {
                // Characteristics.IDENTITY_FINISH - не нужно запускать finisher()
                // Characteristics.CONCURRENT - входные элементы можно аккумулировать в
                //      нескольких параллельных потоках выполнения
                // Characteristics.UNORDERED - данные могут обрабатываться в произвольном порядке
                return new HashSet<>(Arrays.asList(Characteristics.UNORDERED));
            }
        }; // дописали свой коллектор и запускаем

        // запустите Collector для потока студентов и распечатайте результат
        System.out.println(students.stream().collect(studentAgeSumCollector));


    } // main
}
