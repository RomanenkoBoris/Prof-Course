package lesson33;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinTester {
    public static void main(String[] args) throws InterruptedException {
        // можно воспользоваться встроенным в ява пулом потоков
        // недостатки/достоинства
        //      не нужно ждать
        //      не нужно настраивать
        ExecutorService service = ForkJoinPool.commonPool();
        service.submit(new Runnable() {
                           @Override
                           public void run() {
                               try {
                                   Thread.sleep(500);
                                   System.out.println("Time is: " + System.currentTimeMillis()
                                           + " thread " + Thread.currentThread().getId()
                                   );
                               } catch (InterruptedException e) {
                                   //
                               }
                           }
                       });
        Thread.sleep(1_000);
    }
}