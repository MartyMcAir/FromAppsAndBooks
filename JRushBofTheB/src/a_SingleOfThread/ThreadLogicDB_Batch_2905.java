package a_SingleOfThread;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

/* 
Странные ошибки О_о
*/
// Исправь 2 ошибки:
//1) возникновение исключения
//2) подвисание
//Сделай минимальные изменения.
// https://javarush.ru/tasks/com.javarush.task.task29.task2905#discussion
public class ThreadLogicDB_Batch_2905 {
    final int NUMBER_OF_THREADS = 3; // 3 треда будет обрабатывать нашу очередь
    final int MAX_BATCH_SIZE = 100; // Будем вытаскивать по 100 сообщений

    private Logger logger = Logger.getLogger(ThreadLogicDB_Batch_2905.class.getName());
    private BlockingQueue messageQueue = new LinkedBlockingQueue(); // Тут будут храниться все сообщения

    private BlockingQueue fakeDatabase = new LinkedBlockingQueue();

    public static void main(String[] args) throws InterruptedException {
        // Статики во многих местах неуместны, поэтому помещаем все данные в поля класса,
        // затем создаем объект и вызываем его метод
        ThreadLogicDB_Batch_2905 solution = new ThreadLogicDB_Batch_2905();

        solution.startCreatingMessages(); // в нити цикл add(i..100_000 в messageQueue .start()
        solution.startPersistingMessages(); // цикл создает 3 нити,
        // каждая нить setDaemon(true), создает список batch size 100,
        // в цикле какая-то.. добавляет из messageQueue в неё же и удаляет от туда не более MAX_BATCH_SIZE т.е. 100
        // потом persistData кидает список batch в fakeDatabase _ потом список очищается

        Thread.sleep(100);
        solution.printResults();

        Thread.sleep(100);
        solution.printResults();

        Thread.sleep(100);
        solution.printResults();

        Thread.sleep(500);
        solution.printResults();
    }

    public void startCreatingMessages() {
        new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 100_000; i++) {
                    messageQueue.add(i);
//                    messageQueue.add(String.valueOf(i--));
                }
            }
        }.start();
    }

    public void startPersistingMessages() {
        for (int i = 0; i < NUMBER_OF_THREADS; i++) {
            new Thread() {
                private final Collection batch = new ArrayList(MAX_BATCH_SIZE);

                {
                    setDaemon(true);
                }

                @Override
                public void run() {
                    while (true) {
                        try {
                            // Удаляет не более заданного количества доступных элементов из этой очереди
                            // и добавляет их в заданную коллекцию.
//                            messageQueue.drainTo(messageQueue, MAX_BATCH_SIZE);
                            messageQueue.drainTo(batch, MAX_BATCH_SIZE);
                            persistData(batch);
                            batch.clear();
                            Thread.sleep(1);
                        } catch (Throwable e) {
                            logger.log(Level.SEVERE, "impossible to persist a batch", e);
                        }
                    }
                }
            }.start();
        }
    }

    private void persistData(Collection batch) {
        // Представим, что тут мы коннектимся к базе данных, и сохраняем данные в нее
        // Сохранение данных по 1 записи тратит много ресурсов, поэтому делают батчем (группой по несколько)
        fakeDatabase.addAll(batch);
    }

    private void printResults() {
        System.out.println();
        System.out.println("messageQueue size is " + messageQueue.size());
        System.out.println("fakeDatabase size is " + fakeDatabase.size());
    }
}
