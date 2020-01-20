package a_SingleOfThread;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* 
Трудолюбие - душа всякого дела и залог благосостояния
*/
// https://javarush.ru/tasks/com.javarush.task.task26.task2605#discussion
// Трудолюбие - душа всякого дела и залог благосостояния
// Расставь volatile там, где необходимо.
public class ThreadVolatile_2605 {
    private static ScheduledExecutorService interruptScheduledExecutor;
    private static Thread taskThread;
    private static RethrowableTask task;

    public static void main(String[] args) throws Exception {
        runTaskBySchedule(new Runnable() {
                              @Override
                              public void run() {
                                  System.out.println("A");
                                  throw new RuntimeException("it's test");
                              }
                          }, 1_000, TimeUnit.MILLISECONDS
        );

        interruptScheduledExecutor.shutdown(); // вырубаем шедулер задач
    }

    public static void runTaskBySchedule(final Runnable runnable, long timeout, TimeUnit unit) throws Exception {
        task = new RethrowableTask(runnable);
        taskThread = new Thread(task);
        taskThread.start(); // запуск нити

        interruptScheduledExecutor = Executors.newScheduledThreadPool(1);
        interruptScheduledExecutor.schedule(new Runnable() {
            public void run() {
                taskThread.interrupt();
            }
        }, timeout, unit); // юзает шедулер задач с таймеров по запуску потоков
        Thread.sleep(unit.toMillis(timeout));
        try {
            // а искл. будет 100%, будет т.к. кидается из main(.. cообщение "it's test"
            task.rethrow(); // при исключении пишет B и кидает искл.
        } catch (Throwable throwable) {
            System.out.println(throwable.getMessage());  // печатает выкинутое искл.. с rethrow()
        }
    }

    public static class RethrowableTask implements Runnable {
        private volatile Throwable throwable;   // volatile most be here!
        private Runnable runnable;

        public RethrowableTask(Runnable runnable) {
            this.runnable = runnable;
        }

        public void run() {
            try {
                runnable.run();
            } catch (Throwable throwable) {
                this.throwable = throwable;
            }
        }

        public void rethrow() throws Exception {
            if (throwable != null) {
                System.out.println("B"); // пишет B при любой ошибке при run()
                throw new Exception(throwable);
            }
        }
    }
}
