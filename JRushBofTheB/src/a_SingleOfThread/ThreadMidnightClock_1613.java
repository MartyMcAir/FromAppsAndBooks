package a_SingleOfThread;

/* 
Big Ben clock
*/

import java.time.LocalTime;
// https://javarush.ru/tasks/com.javarush.task.task16.task1613
//1. Разберись, что делает программа.
//        2. Реализуй логику метода printTime так, чтобы каждую секунду выдавалось время начиная с установленного в конструкторе.
//
//        Пример:
//        В г. Лондон сейчас 23:59:58!
//        В г. Лондон сейчас 23:59:59!
//        В г. Лондон сейчас полночь!
//        В г. Лондон сейчас 0:0:1!
//
//        Требования:
//        •	Метод printTime должен работать примерно секунду.
//        •	Метод printTime должен увеличивать (инкрементировать) количество секунд, хранимое в переменной seconds.
//        •	Секунд, после икрементирования времени, не может быть больше 59. Должно увеличиться количество минут.
//        •	Минут, после икрементирования времени, не может быть больше 59. Должно увеличиться количество часов.
//        •	Часов, после икрементирования времени, не может быть больше 23.
public class ThreadMidnightClock_1613 {
    public static volatile boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock("Лондон", 23, 59, 57);
        Thread.sleep(4000);
        isStopped = true;
        System.out.println("___isStopped!___"); // code
        Thread.sleep(1000);
    }

    public static class Clock extends Thread {
        private String cityName;
        private int hours;
        private int minutes;
        private int seconds;
//        public static int i = 0; // code

        public Clock(String cityName, int hours, int minutes, int seconds) {
            this.cityName = cityName;
            this.hours = hours;
            this.minutes = minutes;
            this.seconds = seconds;
            start();
        }

        public void run() {
            try {
                while (!isStopped) {
                    printTime();
                }
            } catch (InterruptedException e) {
            }
        }

        private void printTime() throws InterruptedException {
            //add your code here - добавь код тут
            Thread.sleep(1000);
            int h = hours, m = minutes, s = seconds;
//            if (s == 59) {
//                i = 0;
//            } else {
//                i++;
//            }
//            this.i++;
            LocalTime lt = LocalTime.of(h, m, s).plusSeconds(1);
            this.hours = lt.getHour();
            this.minutes = lt.getMinute();
            this.seconds = lt.getSecond();

            ///
            if (hours == 0 && minutes == 0 && seconds == 0) {
                System.out.println(String.format("В г. %s сейчас полночь!", cityName));
            } else {
                System.out.println(String.format("В г. %s сейчас %d:%d:%d!", cityName, hours, minutes, seconds));
            }
        }
    }
}
