package lesson33.homework;

public class BankAccount {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public synchronized int increaseBalance(int value)
    {
        balance += value;
        return balance;
    }

}
