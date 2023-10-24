package lesson33.homework;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class BankTester {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        BankAccountRunnable runnable = new BankAccountRunnable(account);

        ExecutorService service = Executors.newFixedThreadPool(3);
        for(int i = 0 ; i < 5; i++)
            service.submit(runnable);
        service.shutdown();
        try {
            service.awaitTermination(10, TimeUnit.SECONDS);
        } catch (InterruptedException ignored) {}
        System.out.println("Balance: " + account.getBalance());
    }
}