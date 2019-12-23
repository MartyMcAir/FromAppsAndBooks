package Restaurant_1712;

public class Cook implements Runnable {
    public boolean continueWorking = true;

    @Override
    public void run() {
        boolean needToWait;
        while (continueWorking || needToCookOrders()) { // * или *
            try {
                synchronized (this) { // блокировка ведь повар один
                    needToWait = !needToCookOrders(); // если заказ есть
                    if (!needToWait) {
                        cook();
                    }
                }
                if (continueWorking && needToWait) { // после того как сделал работу отдыхает 100мс
                    System.out.println("Повар отдыхает");
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
            }
        }
    }

    private boolean needToCookOrders() {
        return !Manager.getInstance().getOrderQueue().isEmpty(); // если не пуст список заказов из коллекции
    }

    private void cook() throws InterruptedException {
        Manager manager = Manager.getInstance(); // получаем объект Menedger() -он один singleton
        Order order = manager.getOrderQueue().poll();      // повар берет заказ из очереди
        // random время готовки и № стола генерится при создании Order(tableNumber) объекта т.е. при заказе
        System.out.println(String.format("Заказ будет готовиться %d мс для стола №%d", order.getTime(), order.getTableNumber()));
        Thread.sleep(order.getTime());     // готовим блюдо
        // dishes и order плодят одно и теже get set _ но при Order() генерится а dishes просто это же возвращает
        Dishes dishes = new Dishes(order.getTableNumber());       //  это готовое блюдо _ просто # стола

        // --- просто после этого готовое блюдо не добалвяли в список очередь готовых блюд
        manager.getDishesQueue().add(dishes);
        // --- потому и waiter т.е. официант не относил то чего нет

        System.out.println(String.format("Заказ для стола №%d готов", dishes.getTableNumber()));
    }
}
