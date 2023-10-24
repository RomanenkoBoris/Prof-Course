package lesson34;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CC_Practice {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // напишите CompletableFuture из нескольких стадий
        // 1 стадия - создать и вернуть рандомное число от 0 до 200
        //       и потом его результат распечатать через cf.get()
        //      до 20:25
        CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(
                () -> new Random().nextInt(200)
        ).thenApplyAsync(i -> i*i);

        System.out.println(cf.get());

    }
}