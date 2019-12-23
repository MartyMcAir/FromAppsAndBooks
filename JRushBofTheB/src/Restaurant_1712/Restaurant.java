package Restaurant_1712;

import java.util.ArrayList;
import java.util.List;

/* 
Ресторан
*/

public class Restaurant {
    public static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Waiter waiterTarget = new Waiter();
        Thread waiter = new Thread(waiterTarget); // создание потока из ожидаемого
        threads.add(waiter); // добавление в список потоков

        Cook cookTarget = new Cook();
        Thread cook = new Thread(cookTarget); // создание потока готовки
        threads.add(cook);

        waiter.start(); // запуск потоков
        cook.start();

        Thread.sleep(2000);
        cookTarget.continueWorking = false;
        Thread.sleep(500);
        waiterTarget.continueWorking = false;
    }
}
