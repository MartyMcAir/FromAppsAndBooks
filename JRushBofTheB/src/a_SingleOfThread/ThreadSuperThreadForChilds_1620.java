package a_SingleOfThread;

import java.util.ArrayList;
import java.util.List;

/* 
Один для всех, все - для одного
*/
// https://javarush.ru/tasks/com.javarush.task.task16.task1620
//1. Разберись, как работает программа.
//        1.1. Обрати внимание, что объект Water - один для всех нитей.
//        2. Реализуй метод ourInterruptMethod, чтобы он прерывал все нити из threads.
//        3. В методе run исправь значения переменных:
//        3.1. isCurrentThreadInterrupted - должна равняться значению метода isInterrupted у текущей нити.
//        3.2. threadName - должна равняться значению метода getName (реализовано в классе Thread) у текущей нити.
//
//        Требования:
//        •	Метод ourInterruptMethod должен прервать все нити из списка threads.
//        •	Метод run должен получать текущую нить с помощью Thread.currentThread.
//        •	Метод run должен использовать метод isInterrupted текущей нити.
//        •	Метод run должен использовать метод getName текущей нити.
//        •	Метод main должен работать примерно 3 сек.
public class ThreadSuperThreadForChilds_1620 {
    public static byte threadCount = 3;
    static List<Thread> threads = new ArrayList<Thread>(threadCount);

    public static void main(String[] args) throws InterruptedException {
        initThreadsAndStart(); // Метод заполняет список потоками и запускает их
        Thread.sleep(3000);
        ourInterruptMethod();
    }

    public static void ourInterruptMethod() {
        //add your code here - добавь код тут
        // прерываем потоки
        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).interrupt();
        }
    }

    private static void initThreadsAndStart() {
        Water water = new Water("water");
        // добавление потоков в ArrayList
        for (int i = 0; i < threadCount; i++) {
            threads.add(new Thread(water, "#" + i)); // объект, имя потока
        }
        // запуск потоков c ArrayList
        for (int i = 0; i < threadCount; i++) {
            threads.get(i).start();
        }
    }

    public static class Water implements Runnable {
        private String sharedResource;

        public Water(String sharedResource) {
            this.sharedResource = sharedResource;
        }

        public void run() {
            //fix 2 variables - исправь 2 переменных
            boolean isCurrentThreadInterrupted = Thread.currentThread().isInterrupted();
            String threadName = Thread.currentThread().getName();

            try {
                while (!isCurrentThreadInterrupted) {

                    System.out.println("Объект " + sharedResource + ", нить " + threadName);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
            }
        }
    }
}
