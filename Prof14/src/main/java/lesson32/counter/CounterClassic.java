package lesson32.counter;

public class CounterClassic implements Counter {
    private int counter = 0;

    @Override
    public int getValue() {
        return counter;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 1000_000; i++) {
            counter++;
        }

    }
}
