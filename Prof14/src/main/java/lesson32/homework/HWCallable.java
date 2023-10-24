package lesson32.homework;

import java.util.Random;
import java.util.concurrent.*;

public class HWCallable {
    /*
Переделайте предыдущее задание про потоки выполнения (класс lesson31.hw.HWThreads)
на Callable
Создайте Callable, из метода call которой возвращайте результат выполнения
функции waitSomeTime.
В main создайте и запустите два потока, выполняющие этот Callable и
распечатайте сумму результатов.
В классе CallableTester можно посмотреть пример запуска Callable
на потоке выполнения и получения из Callable результата.
     */


    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        /*
        FutureTask<Integer> ft1 = new FutureTask<>(new MyCallable());
        FutureTask<Integer> ft2 = new FutureTask<>(new MyCallable());
        new Thread(ft1).start();
        new Thread(ft2).start();
        System.out.println(ft1.get() + ft2.get());
         */
        ExecutorService service = Executors.newFixedThreadPool(2);
        // TODO - запустим Callable на ExecutorService  и сложим результат

        // запустите на пуле потоков два Callable
        // получите Future<Integer>
        // сложите результаты двух Future
        Future<Integer> f1 = service.submit(new MyCallable());
        Future<Integer> f2 = service.submit(new MyCallable());
        System.out.println(f1.get() + f2.get(10, TimeUnit.SECONDS));
        service.shutdown(); // ожидает завершения выполнения всех заданий
        // service.shutdownNow(); // НЕ ожидает завершения всех заданий

        // дожидаемся либо остановки пула потоков либо выбрасывания исключения
        service.awaitTermination(15, TimeUnit.SECONDS);



    }

    // Создайте функцию, ожидающую рандомное время от 0 до 1000 мс и возвращающую
    // это время в качестве результата
    public static int waitSomeTime() {
        Random r = new Random();
        int pause = r.nextInt(1000);
        try {
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            //
        }
        return pause;
    }
    public static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            return waitSomeTime();
        }
    }
}
