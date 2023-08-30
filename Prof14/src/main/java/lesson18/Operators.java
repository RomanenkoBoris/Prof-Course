package lesson18;

import java.util.Arrays;
import java.util.Random;
import java.util.function.IntUnaryOperator;
import java.util.function.LongBinaryOperator;

public class Operators {
    public static void main(String[] args) {
        // Operator -это Function у которой одинаковы входной и возвращаемый тип
        // IntUnaryOperator - оператор принимающий и возвращающий int

        int [] numbers  = new int[] {1,3,5,2,4,11};
        int sum =
        Arrays.stream(numbers)
                .reduce(0, (number1, number2) -> number1+number2); // reduce() механизм производящий подсчет
//         .reduce(0, new IntBinaryOperator() {
//            @Override
//            public int applyAsInt(int total, int value) {
//                return total + value;
//            }
        System.out.println(sum);
    }
    public static IntUnaryOperator boundedRandomIntSupplier() {
        return (number) -> new Random().nextInt(number);
    }
    public static LongBinaryOperator longSumOperation() {
        return (l1, l2) -> l1 + l2;
    }
}
