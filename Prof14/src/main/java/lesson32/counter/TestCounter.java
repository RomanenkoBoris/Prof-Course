package lesson32.counter;

public class TestCounter {
    public static void main(String[] args) throws InterruptedException {
        // Counter counter = new CounterClassic();
        // Counter counter = new CounterSync();
        Counter counter = new CounterAtomic();

        Thread t1 = new Thread(counter);
        Thread t2 = new Thread(counter);
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(counter.getValue()); // 2000000
    }
}
