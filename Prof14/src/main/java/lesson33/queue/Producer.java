package lesson33.queue;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {
    private final BlockingQueue<Message> queue;
    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        long before = System.currentTimeMillis();
        for (int i = 0; i < 30; i++) {
            Message message = new Message("index: " + i);
            try {
                // подождите время i*100, положите сообщение в очередь
                // распечататйте временной интервал между текущим времением и сохраненным временем
                Thread.sleep(i*100);
                queue.put(message);
                System.out.println(System.currentTimeMillis() - before);
            }catch ( Exception e) {}
        }
        // положите в очередь сообщение "exit"
        try {queue.put(new Message("exit"));
        }catch (InterruptedException e) {throw new RuntimeException(e);}
    }
}