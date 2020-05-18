package a_SingleOfThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
// https://javarush.ru/tasks/com.javarush.task.task16.task1632
//1. Создай 5 различных своих нитей c отличным от Thread типом:
//        1.1. Нить 1 должна бесконечно выполняться;
//        1.2. Нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
//        1.3. Нить 3 должна каждые полсекунды выводить "Ура";
//        1.4. Нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
//        1.5. Нить 5 должна читать с консоли числа пока не введено слово "N",
//        а потом вывести в консоль сумму введенных чисел.
//        2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
//        3. Нити не должны стартовать автоматически.
//
//        Подсказка:
//        Нить 4 можно проверить методом isAlive()
//
//        Требования:
//        •	Статический блок класса Solution_3105 должен создавать и добавлять 5 нитей в список threads.
//        •	Нити из списка threads не должны стартовать автоматически.
//        •	Нить 1 из списка threads должна бесконечно выполняться.
//        •	Нить 2 из списка threads должна выводить "InterruptedException" при возникновении исключения InterruptedException.
//        •	Нить 3 из списка threads должна каждые полсекунды выводить "Ура".
//        •	Нить 4 из списка threads должна реализовать интерфейс Message,
//        при вызове метода showWarning нить должна останавливаться.
//        •	Нить 5 из списка threads должна читать с консоли числа пока не введено слово "N",
//        а потом вывести в консоль сумму введенных чисел.
public class ThreadMessage_1632 {
    public static List<Thread> threads = new ArrayList<>(5);

    // code
    static {
        threads.add(new Thread(new TestThread1()));
        // Нить 2 из списка threads должна выводить "InterruptedException"
        // при возникновении исключения InterruptedException.
        threads.add(new Thread(new TestThread2()));
        // Нить 3 из списка threads должна каждые полсекунды выводить "Ура".
        threads.add(new Thread(new TestThread3()));
//        threads.add(new Thread(new TestThread4())); // ---
        threads.add(new TestThread4()); // ---
        threads.add(new Thread(new TestThread5()));
    }

//    В run нити №4 не нужно использовать isAlive(). В задаче говорится, что "Нить 4 можно
//    проверить методом isAlive()". Это говорит о том, что можно использовать его для тестирования,
//    чтобы убедиться, что после вызова showWarning() нить действительно останавливается. Например:
//            - я в main для теста запустил эту нить,
//- затем подождал секунду,
//            - затем вызвал showWarning(),
//- затем подождал еще секунду,
//- затем вывел на экран значение isAlive(), чтобы убедиться что этот метод возвращает
// false и нить действительно остановлена.

    public static void main(String[] args) throws InterruptedException {
//        for (Thread item : threads) {
//            item.start();
////            item.interrupt();
////            item.join();
//        }

//        Thread ttt = new Thread(new TestThread4());
//        ttt.start();
//        ttt.showWarning(); // не могу вызвать метод

        // Правильно - тип Thread. Т.е. в листе threads лежат экземпляры классов - наследников от Thread.
        //  В том числе и MessageThread, который еще реализует интерфейс Message. Но их тип - Thread,
        //  а у Thread нет метода showWarning().  Я думаю вам нужно повторить темы про
        //  сужение/расширение типов и тогда все встанет на свои места.
//        MessageThread mt = ((MessageThread)threads.get(3));
//        mt.showWarning();
    }

    // code
    public static class TestThread1 implements Runnable {
        @Override
        public void run() { // Нить 1 должна бесконечно выполняться;
            while (true) {
//                System.out.println("INFINITY_!");
            }
        }
    }

    public static class TestThread2 implements Runnable {
        @Override
        public void run() { // Нить2 выводить "InterruptedException" при возникнов искл InterruptedException;
//            if (Thread.currentThread().isInterrupted()) {
//                new InterruptedException().printStackTrace(); //исключ красное,а то что ниже инфа о классе
////                System.out.println(new InterruptedException());
//            }
            try {
                Thread.currentThread().sleep(0);
            } catch (InterruptedException e) {
//                new InterruptedException();
                System.out.println("InterruptedException");
            }
        }
    }

    public static class TestThread3 implements Runnable {
        @Override
        public void run() { // Нить 3 должна каждые полсекунды выводить "Ура";
//            while (!Thread.currentThread().isInterrupted()) { // по умолчанию false
            while (true) {
            try {
                System.out.println("Ура");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        }
    }

    public static class TestThread4 extends Thread implements Message {
        public boolean tmp = false;

        @Override
        public void run() {
//            while (!Thread.currentThread().isInterrupted()) { // по умолчанию false
//            }
//            try {
//                Thread.sleep(3000);
//                showWarning();  // метод реально прекращает жизнь потока
////                new InterruptedException().printStackTrace();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            // Нить 4 можно проверить методом isAlive() - _ но зачем не понял!?
//            if (!Thread.currentThread().isAlive()) { // по умолчанию true
//                Thread.currentThread().interrupt();
//            }
            while (!tmp) {

            }
        }

        // Нить4 реализовать интерфейс Message,при вызове метода showWarning нить должна останавливаться;
        @Override
        public void showWarning() {
//            Thread.currentThread().interrupt();
//            this.stop(); // - пишут что принимает
            tmp = true;
        }
    }

    public static class TestThread5 implements Runnable {
        public int result = 0;

        @Override
        public void run() {
            // Нить5 читать с консоли числа пока не введено слово"N",
            // а потом вывести в консоль сумму введенных чисел.
            String tmp = "";
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                while (!Thread.currentThread().isInterrupted()) { // по умолчанию false
                    tmp = reader.readLine();
                    if (tmp.equals("N")) {
                        System.out.println(result);
                        return;
                    }
                    result += Integer.parseInt(tmp);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //////////////////////
    public interface Message {
        void showWarning();
    }
}