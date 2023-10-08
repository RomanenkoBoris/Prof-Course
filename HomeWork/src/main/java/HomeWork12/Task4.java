package HomeWork12;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

//4. Создайте функцию, ожидающую рандомное время от 0 до 1000 мс и возвращающую это время в качестве результата
//   Запустите эту функцию в двух потоках, в их методе run сохраните результат выполнения этой функции в статические переменные класса.
//   В main запустите потоки и распечатайте сумму значений этих статических переменных.
public class Task4 {
    public static int a;
    public static int b;

    public static void main(String[] args) {
        Thread one = new Thread(()-> a = waitFor());
        Thread two = new Thread(()-> b = waitFor());
        one.start();
        two.start();
        try {
            one.join();
            two.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(a+b);

    }

    public static int waitFor() {
        return new Random().nextInt(1000);
    }
}
