package Restaurant_1712;

public class Waiter implements Runnable {
    public boolean continueWorking = true;

    @Override
    public void run() {
        Manager manager = Manager.getInstance();

        while (continueWorking || !manager.getDishesQueue().isEmpty()) {
            if (!manager.getDishesQueue().isEmpty()) {       //относим готовый заказ
                Dishes dishes = manager.getDishesQueue().poll(); // poll() удаляет первый элемент и возвращает его
                System.out.println("Официант отнес заказ для стола №" + dishes.getTableNumber());
            } else {                                         //берем новый заказ
                Table table = manager.getNextTable(); // получает объект Table() из коллекции от столика №1 до 10
                Order order = table.getOrder(); // возвращает новый объект Order() класса _ там же инкрементируется номер столика
                System.out.println("Получен заказ от стола №" + order.getTableNumber());
                manager.getOrderQueue().add(order); // добавляет заказ в коллекцию
            }
            try {
                Thread.sleep(100);  //walking to the next table
            } catch (InterruptedException e) {
            }
        }
    }
}
