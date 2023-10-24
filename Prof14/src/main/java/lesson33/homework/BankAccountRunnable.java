package lesson33.homework;

import java.util.Random;


public class BankAccountRunnable implements Runnable {
    private BankAccount account;

    public BankAccountRunnable(BankAccount account) {
        this.account = account;
    }

    @Override
    public void run() {
        Random r = new Random();
        for(int i = 0; i < 10; i++)
        {
            try {
                Thread.sleep(r.nextInt(100));
            } catch (InterruptedException ignored) {}
            account.increaseBalance(10);
        }
    }
}
