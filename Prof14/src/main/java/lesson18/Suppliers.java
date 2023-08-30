package lesson18;

import java.util.Random;
import java.util.function.IntSupplier;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class Suppliers {
    public static void main(String[] args) {
        // Supplier
        // функция не принимает параметров но возвращает значение
        Supplier<String> supplierString = (/* входные параметры */) -> "123";
        Supplier<Double> randomDoubleSupplier = () -> new Random().nextDouble();
        System.out.println("random double: " + randomDoubleSupplier.get());

        // числа фибоначчи с использованием Supplier
        IntSupplier fib = new IntSupplier() {
            private int previous = 1;
            private int current = 2;
            @Override
            public int getAsInt() {
                int next = previous + current;
                previous = current;
                current = next;
                return previous;
            }
        };

        IntStream.generate(fib).limit(10).forEach(
                i -> System.out.println("Next fib number is: " + i)
        );
    }
}
