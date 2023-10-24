package lesson32.counter;

public class CounterSync implements Counter{
    Object lock = new Object();
    private int counter = 0;

    @Override
    public int getValue() {
        return counter;
    }
    @Override
    public /* synchronized */ void run() {
        synchronized (lock) {
            for (int i = 1; i <= 1000_000; i++) {
                counter++;
            }
        }
    }
}

