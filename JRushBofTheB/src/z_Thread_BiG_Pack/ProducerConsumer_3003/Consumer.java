package z_Thread_BiG_Pack.ProducerConsumer_3003;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
    private final TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        // реализуй метод run так, чтобы вызов метода interrupt прерывал работу consumer и producer трэдов
        try {
            Thread.sleep(450);
            while (!thread.isInterrupted()) {
                System.out.format("Processing %s%n", queue.take().toString());
            }
        } catch (InterruptedException ignored) {
        }
    }

}
