package a_SingleOfThread;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
// https://javarush.ru/tasks/com.javarush.task.task28.task2802#discussion
// сам не допер _ задача простая, но не понятно что значит на уровне класса или уровне..
// В классе Solution_3105 создай публичный статический класс AmigoThreadFactory, реализующий интерфейс ThreadFactory.
//1. Реализация интерфейсного метода - создайте и верните трэд, который должен:
//1.1. не быть демоном,
//1.2. иметь нормальный приоритет,
//1.3. имя трэда должно иметь шаблон "GN-pool-A-thread-B",
//где GN - это имя группы,
//A - это номер фабрики инкрементируется в пределах класса начиная с 1, используйте AtomicInteger,
//B - номер треда инкрементируется в пределах конкретной фабрики начиная с 1, используйте AtomicInteger.
//2. Каждая фабрика должна иметь ту группу тредов (ThreadGroup), в которой она была создана.
public class ThreadFactoryAtomic_2802 {

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    // AmigoThreadFactory_NotMy
    public static class AmigoThreadFactory implements ThreadFactory {
        //  номер треда инкрементируется в пределах конкретной фабрики начиная с 1
        private AtomicInteger threadCount = new AtomicInteger(0);
        private static AtomicInteger factoryCount = new AtomicInteger(0);
        //  номер фабрики инкрементируется в пределах класса начиная с 1
        private int factoryNumber;

        public AmigoThreadFactory() {
            // создается фабрика инкрементится
            factoryNumber = factoryCount.incrementAndGet();
        }

        @Override
        public Thread newThread(Runnable r) {
            ThreadGroup group = Thread.currentThread().getThreadGroup();
            String threadName = String.format("%s-pool-%d-thread-%s", group.getName(),
                    factoryNumber, threadCount.incrementAndGet());
            Thread t = new Thread(group, r, threadName);
            t.setPriority(Thread.NORM_PRIORITY);
            t.setDaemon(false);

            return t;
        }
    }

    public static class AmigoThreadFactory_NotMy2 implements ThreadFactory {
        static final AtomicInteger poolNumber = new AtomicInteger(1);
        final ThreadGroup group;
        final AtomicInteger threadNumber = new AtomicInteger(1);
        final String namePrefix;

        AmigoThreadFactory_NotMy2() {
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
            namePrefix = group.getName() + "-pool-" + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(), 0);
            if (t.isDaemon()) t.setDaemon(false);
            if (t.getPriority() != Thread.NORM_PRIORITY) t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }

    // My ____
    public static class AmigoThreadFactory_ implements ThreadFactory {
        //  инкрементируется в пределах класса
        private static AtomicInteger atomicIntegerA = new AtomicInteger(1);
        // инкрементируется в пределах конкретной фабрики
        private final AtomicInteger atomicIntegerB = new AtomicInteger(1);

        // костыль какой-то вышел
        private int factoryNumber;

        public AmigoThreadFactory_() {
            factoryNumber = atomicIntegerA.getAndIncrement();
        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r);
            t.setPriority(Thread.NORM_PRIORITY); // 5
            t.setDaemon(false);
            ThreadGroup GN = Thread.currentThread().getThreadGroup();
            t.setName(GN.getName() + "-pool-" + atomicIntegerA
                    + "-thread-" + atomicIntegerB.getAndIncrement());
            return t;
        }
    }
}
