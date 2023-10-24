package lesson34;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class E_CompletableFutureCompose {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // thenCompose
        // Если есть библиотечные функции, возвращающие CompletableFuture
        // то чтобы вызвать их последовательно удобно использовать
        // thenCompose

        CompletableFuture<CompletableFuture<UserRating>> rating =
                getUserInfo(122)
                        // так как getUserRating возвращает CompletableFuture<UserRating>
                        // то thenApplyAsync возвратит CompletableFuture<CompletableFuture<UserRating>>
                        .thenApplyAsync(
                                info -> getUserRating(info)
                        );

        // вопрос - как получить CompletableFuture<UserRating>?
        CompletableFuture<UserRating> realRating =
                getUserInfo(122)
                        .thenCompose(
                                info -> getUserRating(info)
                        );


        // запустите и rating и realRating и распечатайте результат
        // добейтесь путем использования get() чтобы и в 1 и во 2 случае
        // распечаталось UserRating
        // до 21:34
        System.out.println(rating.get());
        System.out.println(realRating.get());

    }

    static CompletableFuture<UserInfo> getUserInfo(int id) {
        return CompletableFuture.supplyAsync(
                // () -> new UserInfo(id)
                new Supplier<UserInfo>() {
                    @Override
                    public UserInfo get() {
                        return new UserInfo(id);
                    }
                }
        );
    }

    static CompletableFuture<UserRating> getUserRating(UserInfo info) {
        return CompletableFuture.supplyAsync(
                // () -> new UserRating(info)
                new Supplier<UserRating>() {
                    @Override
                    public UserRating get() {
                        return new UserRating(info);
                    }
                }
        );
    }

}

class UserInfo {
    private int userId;

    public UserInfo(int userId) {
        this.userId = userId;
    }
}

class UserRating {
    private UserInfo info;

    public UserRating(UserInfo info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "UserRating";
    }
}