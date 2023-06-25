package lesson2;

public class Account {

    private String id;
    private String owner;
    private int balance;

    public Account(String id, String owner, int balance) {
        this.id = id;
        this.owner = owner;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public int getBalance() {
        return balance;
    }

    public int addMoney(int money) {
        if (money < 0) {
            System.out.println("Сумма отрицательна");
        } else {
            balance += money;
        }
        return balance;
    }

    public int subtractMoney(int money) {
        if (money > balance) {
            System.out.println("Сумма на счету недостаточна для совершения оплаты");
        } else {
            balance -= money;

        }
        return balance;
    }

    public int transaction(Account account, int amount) {
        int amountTOTransfer = (balance - subtractMoney(amount));
        account.addMoney(amountTOTransfer);
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", owner='" + owner + '\'' +
                ", balance=" + balance +
                '}';
    }

    public static void main(String[] args) {
        Account a1 = new Account("123", "Misha Semenov", 30);
        Account a2 = new Account("456", "Dima Petrov", 60);
        a1.transaction(a2, 15);
        System.out.println(a1);
        System.out.println(a2);

        a1.transaction(a2, 100);
        System.out.println(a1);
        System.out.println(a2);
    }
}
