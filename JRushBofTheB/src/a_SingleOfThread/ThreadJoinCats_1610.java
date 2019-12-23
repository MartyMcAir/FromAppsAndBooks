package a_SingleOfThread;

/* 
Расставь вызовы методов join()
*/
// https://javarush.ru/tasks/com.javarush.task.task16.task1610
//1. Разберись, что делает программа.
//        2. Расставь вызовы методов join() так, чтобы для каждой кошки выполнялось следующее:
//        2.1. Сначала кошка рожает котят.
//        2.2. Потом все котята вылазят из корзинки в произвольном порядке.
//        2.3. В конце кошка собирает их назад в корзинку.
//        2.4. Все события для одной кошки могут быть перемешаны с событиями для другой кошки.
//        2.5. Добавить сон котят (200 мс) в investigateWorld.
//
//        Требования:
//        •	У каждого котенка (объекта типа Kitten) должен быть вызван метод join.
//        •	Метод investigateWorld должен обеспечивать сон котенка на 200 мс. Используй метод Thread.sleep(200).
//        •	Программа должна создавать две кошки и четыре котенка.
//        •	Методы, которые отвечают за вывод в консоль, не изменять.
//        •	Вывод программы должен отображать выполнение требований условия.
public class ThreadJoinCats_1610 {
    public static void main(String[] args) throws InterruptedException {
        Cat cat1 = new Cat("Мурка");
        Cat cat2 = new Cat("Пушинка");
        cat2.join();
    }

    private static void investigateWorld() {
        try {
            Thread.sleep(200);
//            Thread.currentThread().sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static class Cat extends Thread {
        protected Kitten kitten1;
        protected Kitten kitten2;

        public Cat(String name) throws InterruptedException {
            super(name);
            kitten1 = new Kitten("Котенок 1, мама - " + getName());
            kitten2 = new Kitten("Котенок 2, мама - " + getName());
            start(); // Запуск потока
        }

        public void run() {
            System.out.println(getName() + " родила 2 котенка");
            try {
                initAllKittens(); // запуск кошек _ инициализация
            } catch (InterruptedException e) {
            }
            System.out.println(getName() + ": Все котята в корзинке. " + getName() + " собрала их назад");
        }

        private void initAllKittens() throws InterruptedException {
            kitten1.start();
            kitten2.start();
            // Сначала котята пушинки должны вылезти из корзины, после этого она сможет их собрать.
            // Особо ничего не понял
            kitten1.join();
            kitten2.join();
        }
    }

    public static class Kitten extends Thread {
        public Kitten(String name) {
            super(name);
        }

        public void run() {
//            if(Thread.currentThread().getName().equalsIgnoreCase("Пушинка")){
//                try {
//                    Thread.currentThread().join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
            System.out.println(getName() + ", вылез из корзинки");
            investigateWorld();
        }
    }
}
