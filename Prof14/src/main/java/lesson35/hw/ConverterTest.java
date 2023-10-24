package lesson35.hw;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/*
И вызовите последовательно перевод 10 евро ("EUR") в фунты ("GBP")
и потом для полученной суммы вызовите перевод из фунтов в доллары ("USD")
воспользовавшись CompletableFuture
Распечатайте результат.
 */
public class ConverterTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> converter = CompletableFuture.supplyAsync(
                        // суфикс Async значит что этот CF будет выполнятся
                        // на пуле потоков
                        // если не указать то это будет ForkJoin
                        () -> Converter.convert(10.0, "EUR", "GBP"))
                .thenApply(
                        // все методы без Async запускаются в потоке в котором
                        // выполняется .get()
                        money -> Converter.convert(money, "GBP", "USD"))
                .handle(
                        (result, error) -> error != null ? error.getMessage() : "" + result);
        // цепочка запускается только после вызова get
        System.out.println(converter.get());
        System.exit(0);
    }
}
