package b_BigTusks.Apteka_1715;

import java.util.ArrayList;
import java.util.List;

/* 
Аптека
*/

public class Solution {
    public static DrugsController drugsController = new DrugsController();
    public static boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Thread apteka = new Thread(new Apteka());
        Thread man = new Thread(new Person(), "Мужчина");
        Thread woman = new Thread(new Person(), "Женщина");

        apteka.start();
        man.start();
        woman.start();

        Thread.sleep(1000);
        isStopped = true;
    }

    // code >>>
    public static class Apteka implements Runnable {
        @Override
        public void run() {
            while (!isStopped) {
                drugsController.buy(getRandomDrug(), getRandomCount());
                waitAMoment();
                waitAMoment();
                waitAMoment();
            }
        }
    }

    public static class Person implements Runnable {
        @Override
        public void run() {
//            synchronized (Person.class) {
//            synchronized (this.getClass()) {
            while (!isStopped) {
                drugsController.sell(getRandomDrug(), getRandomCount());
                waitAMoment();
            }
//            }
        }
    }

    // <<< code
    public static int getRandomCount() {  // произвольное кол-во
        return (int) (Math.random() * 3) + 1;
    }

    public static Drug getRandomDrug() {  // произвольный препарат
        int index = (int) ((Math.random() * 1000) % (drugsController.allDrugs.size()));
        List<Drug> drugs = new ArrayList<>(drugsController.allDrugs.keySet()); // сюда отправляют Set<Drug>
        return drugs.get(index);
    }

    private static void waitAMoment() { // пауза в 100 мс
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}
