package lesson33;

import lesson22.Match;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class PiCalculator {

    // количество точек внутри четверти окружности
    private static AtomicInteger inside = new AtomicInteger();

    // количество точек всего
    private static AtomicInteger all = new AtomicInteger();

    // для инициализации счетчиков
    public static void init()
    {
        inside = new AtomicInteger(0);
        all = new AtomicInteger(0);
    }

    public static void main(String[] args) {
        runner(1);
        runner(2);
        runner(5);
        runner(10);
        runner(20);
        runner(40);
        runner(100);
        // сколько всего ядер на конкретной машине
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
    static void runner (int numberOfThreads ) {
        long before = System.currentTimeMillis();
        ExecutorService service = Executors.newFixedThreadPool(numberOfThreads);
        Runnable p = new PiRunnable();
        for(int i = 0; i < 10_000_000; i++)
        {
            service.submit(p);
        }
        service.shutdown();
        try {
            service.awaitTermination(10, TimeUnit.SECONDS);
        } catch (Exception e) {}
        long after = System.currentTimeMillis();
        System.out.printf(
                "threads: %d, t: %d, i: %d, a: %d, pi: %f\n",
                numberOfThreads,
                (after - before),
                inside.get(),
                all.get(),
                4.0*inside.get()/all.get()
        );
    }
    private static Random r = new Random();
    // рандомно геренировать x и y для точки
    // вычислять внутри или вне окружности
    // добавляет это в inside и в all
    static class PiRunnable  implements Runnable {
        @Override
        public void run() {
            all.incrementAndGet();
            double x = new Random().nextDouble();
            double y = new Random().nextDouble();
            double gip = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
            if (gip <= 1){
                inside.incrementAndGet();
            }
            // сгенерируйте используя Random
            // double x и double y
            // вычислите расстояние до центра окружности по теореме Пифагора
            // если это расстояние меньше или равно 1 добавьте 1 в inside
            // добавьте 1 в all
            // до 20:02
        }
    }
}
