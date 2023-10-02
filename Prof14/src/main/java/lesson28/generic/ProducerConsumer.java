package lesson28.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProducerConsumer {
    public static void main(String[] args) {
        List<Number> numberList = new ArrayList<>(Arrays.asList(3.15, 3));
        numberList.add(13.33); // ok так как Double является производным от Number
        numberList.add(-1); // ok так как Integer является производным от Number

        // Double d = numberList.get(1); // not ok - так как в numberList хранятся Number
        // printListOfNumbers(numberList); // ok

        List<Integer> integerList = new ArrayList<>(Arrays.asList(1,2,3));

        // printListOfNumbers(integerList); // not ok - нарушение условий контракта
        Number n = integerList.get(0);
        printListOfNumbers(integerList);

        addNumber(numberList);
    } // main

    // Consumer
    // ? extends Number - мы обязуемся только считывать оттуда Number
    // но не записывать его
    public static void printListOfNumbers(List<? extends Number> numberList){
        numberList.forEach(n -> System.out.println("number is: " + n));
        // numberList.add(33); // not ok - нарушение контракта - обязались ничего не записывать
    }

    // Producer
    // контракт
    // мы только записываем в контейнер и обязуемся ничего не считывать
    public static void addNumber(List<? super Integer> integerList)
    {
        integerList.add(new Random().nextInt());
        // Integer i = integerList.get(0); // not ok - нарушение контракта - обязались ничего не считывать
    }
}