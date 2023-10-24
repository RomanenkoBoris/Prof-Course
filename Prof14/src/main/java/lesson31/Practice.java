package lesson31;

import java.sql.CallableStatement;
import java.util.Random;

public class Practice {
    public static void main(String[] args) {
        // создайте и запустите поток,
        // который выполнит function1 и распечатает результат
        Thread t1 = new Thread(() -> System.out.println(function1()));
        t1.start(); // 12:1696445559171

        Thread t2 = new MyThread("hello");
        t2.start();

        // создайте Thread который в run выполняет function1 и потом запускает MyThread передав
        // в качестве параметра результат function1

        Thread t3 = new Thread(() -> new MyThread(function1()).start());
        t3.start(); // 14:1696446942882|16:1696446943882

//        Thread t3 = new Thread() {
//            @Override
//            public void run() {
//                String result = function1();
//                Thread t4 = new MyThread(result);
//                t4.start();
//            }
//        };

    }
    // напишите статический класс который расширяет Thread и в конструкторе принимает на вход строку
    // принимаемую строку испольует в run для того чтобы вызвать с ней function2, результат нужно распечатать
    // до 21:02
    public static class MyThread extends Thread {
        private String text;
        public MyThread(String text) {
            this.text = text;
        }
        @Override
        public void run() {
            System.out.println(
                    function2(text)
            );
        }
    }
    public static String function2(String text) {
        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return text + "|" + Thread.currentThread().getId() + ":" + System.currentTimeMillis();
    }

    public static String function1()
    {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "" + Thread.currentThread().getId() + ":" + System.currentTimeMillis();
    }
}
