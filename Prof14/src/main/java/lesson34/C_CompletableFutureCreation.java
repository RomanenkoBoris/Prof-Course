package lesson34;

// https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/CompletableFuture.html

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class C_CompletableFutureCreation {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // runAsync запускает на встроенном ExecutorService - ForkJoinPool
        // runAsync не может возвратить значение
        // аналог создания и запуска Thread-а через Runnable
        CompletableFuture<Void> future = CompletableFuture.runAsync(
                () -> {
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {}
                    System.out.println("Current thread is: " + Thread.currentThread().getId());
                }
        );

        // CompletableFuture не запускается пока не вызван его метод get
        future.get();

        // supplyAsync принимает на вход Supplier<T>
        // supplyAsync выполняется в порожденном потоке
        // предназначен для возвращения значения
        CompletableFuture<Void> cf = CompletableFuture.supplyAsync(
                        () -> "" + System.currentTimeMillis()
                )
                // thenApplyAsync принимает на вход Function<T,R>
                // и может возвращать значение
                .thenApplyAsync(
                        s -> "Hello, " + s
                )
                // thenAccept если результат не нужен, а важны сами действия
                .thenAccept(
                        s -> System.out.println(s.length())
                );

        //System.out.println(
        cf.get();
        //);


    }
}