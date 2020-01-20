package a_SingleOfThread;

/* 
Приоритеты в Threads
*/
// https://javarush.ru/tasks/com.javarush.task.task28.task2805#discussion
// В отдельном файле создай класс MyThread унаследовавшись от Thread.
//MyThread должен:
//1. Иметь возможность быть созданным используя любой конструктор супер-класса (Alt+Insert).
//2. Приоритет у трэдов должен проставляться циклично от минимального значения до максимального значения.
//3. если у трэда установлена трэд-группа(ThreadGroup), то приоритет трэда
// не может быть больше максимального приоритета его трэд-группы.

import java.util.concurrent.atomic.AtomicInteger;

// очч.. простая задача мог исам догодаться но нет.(
public class ThreadCounterSimple_2805 {

    public static void main(String[] args) {
        for (int i = 0; i < 12; i++) {
            System.out.print(new MyThread().getPriority() + " ");
        }
        //output
        //1 2 3 4 5 6 7 8 9 10 1 2

        System.out.println();
        ThreadGroup group = new ThreadGroup("someName");
        group.setMaxPriority(7);
        for (int i = 0; i < 12; i++) {
            System.out.print(new MyThread(group, "name" + i).getPriority() + " ");
        }
        //output
        //3 4 5 6 7 7 7 7 1 2 3 4
    }

    // если делать в одну строчку(коменты ниже),  то можно и без тернарных операторов :
    // count++ % 10 + 1

    // Смущала вторая строка, почему с 3-ки начинается, потом дошло что единица и двойка находятся
    // в предыдущем цикле, т.е. в первой строке, последние две цифры. Получается что значение приоритета,
    // которое объявляется в классе MyThread в static счётчике приоритетов сохраняется до тех пор, пока
    // существует основной поток main, который вызывает классы MyThread. Соответственно до уничтожения
    // потока main в памяти лежит класс MyThread со своим static счётчиком.
    //А 7-ка автоматом проставляется для всех потоков-участников группы, и превысить это значение,
    // без дополнительных манипуляций, нельзя.

    public static class MyThread extends Thread {
        // My __-- неверное решение
        private static volatile int i = 0;

        // Иметь возможность быть созданным используя любой конструктор супер-класса
        // т.е. их 2 по умолчанию и с параметрами
//         НЕТ надо создать ВСЕ конструкторы класса Thread!
        public MyThread() {
            // Приоритет у трэдов должен проставляться циклично
            // от минимального значения до максимального значения.
            i++;
            if (i > 0 & i < 10) {
                i = i;
            }
            if (i == 10) {
                i = 1;
            }
            setPriority(i);
        }

        public MyThread(ThreadGroup group, String s) {
            // если у трэда установлена трэд-группа(ThreadGroup), то приоритет трэда
            // не может быть больше максимального приоритета его трэд-группы.
            ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
            i++;
            if (threadGroup.getMaxPriority() < i) {
                i = threadGroup.getMaxPriority();
            }
            setPriority(i);
        }
    }

    // NOt MY
    public static class MyThreadNotMy extends Thread {
//        private static AtomicInteger currentPriority = new AtomicInteger(0);
//
//        public MyThreadNotMy() {
//            initialize();
//        }
//
//        private void initialize() {
//            currentPriority.incrementAndGet();
//            currentPriority.compareAndSet(11, 1);
//
//            int newPriority = currentPriority.get();
//            if (getThreadGroup() != null) {
//                if (newPriority > getThreadGroup().getMaxPriority()) {
//                    newPriority = getThreadGroup().getMaxPriority();
//                }
//            }
//            setPriority(newPriority);
//        }


        private int countOfThread = 1;
        private static int priority = 1;
        private ThreadGroup currentThGroup = getThreadGroup();

//    private static void customSetPriority(Thread currentThread, ThreadGroup currentThGroup) {
//        if (priority == currentThGroup.getMaxPriority()) {
//            currentThread.setPriority(currentThGroup.getMaxPriority());
//            priority = 1;
//            return;
//        }
//
//        currentThread.setPriority(priority++);
//    }

        {
            setPriority(priority++);
            if (priority > 10) {
                priority = 1;
            }
        }

        public MyThreadNotMy() {
//        customSetPriority(this, this.getThreadGroup());
        }

        public MyThreadNotMy(Runnable target) {
            super(target);
//        customSetPriority(this, this.getThreadGroup());
        }

        public MyThreadNotMy(ThreadGroup group, Runnable target) {
            super(group, target);
//        customSetPriority(this, group);
        }

        public MyThreadNotMy(String name) {
            super(name);
//        customSetPriority(this, this.getThreadGroup());
        }

        public MyThreadNotMy(ThreadGroup group, String name) {
            super(group, name);
//        customSetPriority(this, group);
        }

        public MyThreadNotMy(Runnable target, String name) {
            super(target, name);
//        customSetPriority(this, this.getThreadGroup());
        }

        public MyThreadNotMy(ThreadGroup group, Runnable target, String name) {
            super(group, target, name);
//        customSetPriority(this, group);
        }

        public MyThreadNotMy(ThreadGroup group, Runnable target, String name, long stackSize) {
            super(group, target, name, stackSize);
        }

    }
}
