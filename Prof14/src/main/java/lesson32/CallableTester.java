package lesson32;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTester {
    public static void main(String[] args) {
        // Runnable не возвращает результат
        new Thread(new MyRunnable()).start();

        Callable<String> callable = new MyCallable();
        // Future - будущий результат
        FutureTask<String> task = new FutureTask<>(callable);
        new Thread(task).start();
        try {
            // если результат не готов, то get блокирует поток, в котором вызвается (в данном случае 0 поток)
            // до готовности результата
            System.out.println(task.get());
        } catch (Exception e) { /* */ }
    }
}
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Hello " + System.currentTimeMillis());
    }
}
class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        return "Hello " + System.currentTimeMillis();
    }
}
