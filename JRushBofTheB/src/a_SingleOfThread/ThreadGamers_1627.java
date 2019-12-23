package a_SingleOfThread;

import java.util.ArrayList;
import java.util.List;
// https://javarush.ru/tasks/com.javarush.task.task16.task1627
//Три человека играют в игру. Каждый игрок(Gamer) характеризуется двумя параметрами: фамилией(name) и количеством действий в секунду (rating).
//        Нужно вывести в консоль ход игры и определить победителя и проигравших.
//        Итак...
//        1. Разберись, что делает программа.
//        1.1. List<String> steps хранит последовательность действий, которое каждый игрок выполняет от 0 до последнего.
//        1.2. isWinnerFound показывает, найден победитель или нет.
//        1.3. Метод sleep выбрасывает InterruptedException и принимает параметр типа long.
//        1.4. Игроки играют независимо друг от друга.
//        2. Реализуй логику метода run так, чтобы для каждого игрока:
//        2.1. Через равные интервалы времени (1000ms / rating) выводились в консоль действия, описанные в steps.
//        2.2. Любой текст должен начинаться с фамилии игрока (метод getName()), потом следовать двоеточие, а затем сам текст.
//
//        Пример:
//        Ivanov:Начало игры
//
//        2.3. Когда игрок выполнит все действия из steps, то он считается победителем. Выведите getName() + ":победитель!"
//        2.4. Когда найден победитель, то игра останавливается, и остальные игроки считаются побежденными. Выведите для них getName() + ":проиграл"
//
//        Требования:
//        •	Метод run класса Gamer через равные интервалы времени (1000ms / rating) должен выводить в консоль фамилию игрока (метод getName()), потом двоеточие, а затем текст из OnlineGame.steps. Пример: Ivanov:Начало игры
//        •	Когда все игровые шаги будут выполнены, а победитель еще не найден, метод run должен установить флаг OnlineGame.isWinnerFound в true (сообщить остальным, что он победитель).
//        •	Если игрок стал победителем, его метод run должен вывести надпись getName() + ":победитель!". Например: Sidorov:победитель!
//        •	Методы run всех игроков которые не стали победителями (были прерваны), должны вывести надписи getName() + ":проиграл". Например: Petrov:проиграл
//        •	Метод run не должен кидать исключение при прерывании.
public class ThreadGamers_1627 {
    public static void main(String[] args) throws InterruptedException {
        OnlineGame onlineGame = new OnlineGame();
        onlineGame.start();
    }

    public static class OnlineGame extends Thread {
        public static volatile boolean isWinnerFound = false;   // volatile _ одна переменная на все потоки

        public static List<String> steps = new ArrayList<String>();

        static {   // статик блок инициализации _ наполение коллекции
            steps.add("Начало игры");
            steps.add("Сбор ресурсов");
            steps.add("Рост экономики");
            steps.add("Убийство врагов");
        }

        protected Gamer gamer1 = new Gamer("Ivanov", 3);
        protected Gamer gamer2 = new Gamer("Petrov", 1);
        protected Gamer gamer3 = new Gamer("Sidorov", 5);

        public void run() { // Внутри потока OnlineGame запускаем потоки Gamer
            gamer1.start();
            gamer2.start();
            gamer3.start();

            while (!isWinnerFound) { // если false, то потоки работают пока не найдется победитель
            }
            // прерываем потоки
            gamer1.interrupt();
            gamer2.interrupt();
            gamer3.interrupt();
        }
    }

    public static class Gamer extends Thread {
        private int rating;

        public Gamer(String name, int rating) {
            super(name);   // имя потока
            this.rating = rating;
        }

        @Override
        public void run() {
            //Add your code here - добавь код тут
            int i = 0;
            try {
                while (i < OnlineGame.steps.size()) {
                    Thread.sleep(1000 / rating);

                    System.out.println(getName() + ":" + OnlineGame.steps.get(i));
                    i++;
                    // если это последний шаг текущего потока, то данный поток победитель
                }

                // можно его не создавать, а просто в условии елзе вывести сообщения
                // проигравших в блок кэч оставить пустым
                if (!OnlineGame.isWinnerFound) {
                    OnlineGame.isWinnerFound = true;
                    System.out.println(getName() + ":победитель!");
                } else throw new InterruptedException();

//                if (!OnlineGame.isWinnerFound) {
//                    Thread.sleep(1000 / rating);
//                    System.out.println(getName() + ":победитель!");
//                }
//
//                if (i == OnlineGame.steps.size()) {
//                    // Игрок не должен выводить сообщение о победе, если переменная isWinnerFound
//                    // уже установлена в true (победитель уже найден)
//
//                    // Метод run должен засыпать на (1000ms / rating) четыре раза.
////                        Thread.sleep(1000 / rating);
////                        System.out.println(getName() + ":победитель!");
//                    OnlineGame.isWinnerFound = true;
//                }

            } catch (InterruptedException e) {
                System.out.println(getName() + ":проиграл!");
            }
        }
    }
}
