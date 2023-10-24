package lesson34;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

public class G_Exceptions {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> "234");

        CompletableFuture<String> result = cf
                .thenApply(s -> Integer.parseInt(s))
                .thenApply(i -> i*i)
                .thenApply(i -> "Result is: " + i)
                .exceptionally(
                        // t -> "Problem: " + t.getMessage();
                        new Function<Throwable, String>() {
                            @Override
                            public String apply(Throwable throwable) {
                                return "Problem: " + throwable.getMessage();
                            }
                        }
                );


        System.out.println(result.get());


    }
}
