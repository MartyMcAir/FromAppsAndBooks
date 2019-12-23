package a_SingleOfThread;

/* 
Отсчет на гонках
*/
// https://javarush.ru/tasks/com.javarush.task.task16.task1617
//1. Разберись, что делает программа.
//        2. Реализуй логику метода run так, чтобы каждую секунду через пробел
//        выдавался отсчет начиная с numSeconds до 1, а потом слово [Марш!] (см примеры).
//        3. Если нить работает 3.5 секунды или более, прерви ее методом interrupt и внутри нити выведи в консоль слово [Прервано!].
//
//        Пример для numSeconds=4 :
//        "4 3 2 1 Прервано!"
//
//        4. Если нить работает менее 3.5 секунд, она должна завершиться сама.
//        Пример для numSeconds=3 :
//        "3 2 1 Марш!"
//
//        PS: метод sleep выбрасывает InterruptedException.
//
//        Требования:
//        •	Метод run класса RacingClock должен содержать цикл.
//        •	Объект класса RacingClock должен каждую секунду уменьшать значение переменной numSeconds на единицу.
//        •	Метод main должен вызывать Thread.sleep(3500).
//        •	Метод main должен вызывать метод interrupt у объекта clock.
//        •	Если numSeconds равно 3, то программа должна вывести "3 2 1 Марш!".
//        •	Если numSeconds равно 4, то программа должна вывести "4 3 2 1 Прервано!".
public class ThreadRacing_1617 {
    public static volatile int numSeconds = 4;

    public static void main(String[] args) throws InterruptedException {
        RacingClock clock = new RacingClock();
        //add your code here - добавь код тут
        Thread.sleep(3500);
        clock.interrupt();
//        Thread current = Thread.currentThread();
    }

    public static class RacingClock extends Thread {

        public RacingClock() {
            start();
        }

        public void run() {
            //add your code here - добавь код тут
            int i = numSeconds;
            while (numSeconds>=1) {
                try {
                    Thread.sleep(1000);
                    System.out.print((numSeconds--) + " ");
                } catch (InterruptedException e) {
//                    e.printStackTrace();
                    System.out.print((numSeconds--) + " ");
                    System.out.println("Прервано!");
                }
            }
            if (i == 3) {
                System.out.println("Марш!");
            }
        }
    }
}
