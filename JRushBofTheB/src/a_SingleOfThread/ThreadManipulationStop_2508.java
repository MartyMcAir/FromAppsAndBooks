package a_SingleOfThread;

/* 
Не валять дурака
*/
public class ThreadManipulationStop_2508 {
    /*
     Output:
     first
     first
     second
     second
     second
     third
     fifth
     */
    // https://javarush.ru/tasks/com.javarush.task.task25.task2508#discussion
    // подтупал слегка в решении..
    // Восстанови логику класса TaskManipulator.
    //
    //Требования:
    //1. Класс TaskManipulator должен реализовывать интерфейсы Runnable и CustomThreadManipulator.
    //2. Метод run должен каждые 100 миллисекунд выводить имя исполняемой нити в консоль.
    //3. Класс TaskManipulator должен иметь внутреннее поле типа Thread.
    //4. Метод start должен создавать, сохранять во внутреннее поле и запускать нить с именем, которое передано через аргумент метода.
    //5. Метод stop должен прерывать последнюю созданную классом TaskManipulator нить.
    public static void main(String[] args) throws InterruptedException {
        CustomThreadManipulator manipulator = new TaskManipulator();

        manipulator.start("first");
        Thread.sleep(150);
        manipulator.stop();

        manipulator.start("second");
        Thread.sleep(250);
        manipulator.stop();

        manipulator.start("third");
        Thread.sleep(50);
        manipulator.stop();

        manipulator.start("forth");
        manipulator.stop();

        manipulator.start("fifth");
        Thread.sleep(1);
        manipulator.stop();
    }

    public interface CustomThreadManipulator {
        public void start(String threadName);

        public void stop();
    }

    public static class TaskManipulator implements Runnable, CustomThreadManipulator {
        private Thread thread;

        @Override
        public void run() {
//        Thread current = Thread.currentThread();
//        System.out.println(thread.isInterrupted());
//        while (!thread.isInterrupted()) {
            while (true) {
                try {
                    //  каждые 100 миллисекунд выводить имя исполняемой нити в консоль
                    System.out.println(thread.getName());
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    break;
//                e.printStackTrace();
                }
            }
        }

        @Override
        public void start(String threadName) {
            // создавать, сохранять во внутреннее поле и запускать нить с именем,
            // которое передано через аргумент метода.
//        System.out.println(threadName);

            // V2
            thread = new Thread(this, threadName);
//        thread.setName(threadName);
            thread.start();

            // получив полный стек всех нитей, запускаем требуюмую _ Version1
//        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
//        for (Map.Entry<Thread, StackTraceElement[]> item : allStackTraces.entrySet()) {
//            Thread keyThread = item.getKey();
//            if (keyThread.getName().equals(threadName)) {
//                this.thread = keyThread;
//                keyThread.start();
//            }
//        }
        }

        @Override
        public void stop() {
            // прерывать последнюю созданную классом TaskManipulator нить.
//        if (thread != null) {
//            System.out.println("ffffffffffffff");
            // this _ т.е. текущая значит последняя
            thread.interrupt();
//        }
        }
    }
}