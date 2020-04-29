package com.javarush.task.task30.task3003;

import java.util.concurrent.TransferQueue;

public class Producer implements Runnable {
    private final TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        try {
            for (int i = 1; i < 10; i++) {
                if (!Thread.currentThread().isInterrupted()) {
                    System.out.format("Элемент 'ShareItem-%d' добавлен%n", i);
                    queue.offer(new ShareItem("ShareItem-" + i, i));
                    Thread.sleep(100);

                    // т.е. видеть сколько успело внестись в очередь элеметов
                    // _ до первого вылета запроса от Consumer
                    if (queue.hasWaitingConsumer()) {
                        System.out.format("Consumer в ожидании!%n");
                    }
                } else {
                    break;
                }
            }
        } catch (InterruptedException ignored) {
        }
    }

}
