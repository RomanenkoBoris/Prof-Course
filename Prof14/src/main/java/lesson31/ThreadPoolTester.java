package lesson31;


import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
    пул потоков - набор потоков, thread pool
        набор из потоков выполнения + очередь задач для выполнения
        задания в очереди это либо Runnable либо Callable
 */
public class ThreadPoolTester {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2); // 2 потока выполнения в пуле
        Runnable r = new Work();
        service.submit(r); // Thread with id: 12
        service.submit(r); // Thread with id: 12
        service.submit(r); // Thread with id: 12
        service.submit(r); // Thread with id: 13
        service.submit(r); // Thread with id: 12
        service.submit(r); // Thread with id: 13

        // Создаем экземпляр Callable
        Job callable = new Job();

        // Future - будущий результат
        Future<String> result = service.submit(callable);

//        try {
//            System.out.println(result.get()); //  Future<>.get() блокирует поток в котором выполняется
//        } catch (Exception e) {
//            System.out.println("Exception: " + e.getMessage());
//        }
        if(result.isDone()) {
            // можем результат запросить, он готов
            System.out.println("Future result is ready");
        } else {
            System.out.println("Future result is not ready, can do something else");
        }
        service.shutdown(); // дожидается выполнения всех задач в очереди
        // service.shutdownNow(); // не дожидается выполнения всех заданий в очереди
    }
    // Callable - задача, которая возвращает результат
    public static class Job implements Callable<String> {

        @Override
        public String call() throws Exception {
            Thread.sleep(500);
            return "" + System.currentTimeMillis();
        }
    }

    public static class Work implements Runnable {
        @Override
        public void run() {
            Random r = new Random();
            try {
                Thread.sleep(r.nextInt(500));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread with id: " + Thread.currentThread().getId());
        }
    }


}
