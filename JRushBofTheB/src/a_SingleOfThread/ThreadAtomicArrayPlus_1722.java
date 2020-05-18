package a_SingleOfThread;

/* 
Посчитаем
*/
// https://javarush.ru/tasks/com.javarush.task.task17.task1722
//1. Сделай так, чтобы результат успел посчитаться для всех элементов массива values НЕ используя Thread.sleep
//  в методе main(String[] args)
//        2. Исправь synchronized блок так, чтобы массив values заполнился значением 1
//
//        Требования:
//        •	Класс Solution_3105 должен содержать класс Counter.
//        •	Класс Counter должен быть нитью.
//        •	Метод run() класса Counter должен содержать synchronized блок.
//        •	Synchronized блок метода run() не должен блокировать мьютекс this.
//        •	Метод main(String[] args) класса Solution_3105 не должен использовать Thread.sleep().
//        •	Для каждой нити, в методе main(String[] args) класса Solution_3105 используй метод, который ожидает завершение нити.
public class ThreadAtomicArrayPlus_1722 {
    public static void main(String[] args) throws InterruptedException {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();
        Counter counter4 = new Counter();

        counter1.start();
        counter2.start();
        counter3.start();
        counter4.start();

        // code _ wair() Переводит поток в режим ожидания для получения доступа к ресурсу.
//        counter1.wait(); // IllegalMonitorStateException
        counter1.join();
        counter2.join();
        counter3.join();
        counter4.join();

        for (int i = 1; i <= 100; i++) { // 0-ой элемент не учитывает
            if (values[i] != 1) {
                System.out.println("Массив values содержит элементы неравные 1");
                break;
            }
        }

//        System.out.println(Arrays.toString(values)); // 0 1 1 1

//        System.out.println(getCount()); // 0
//        System.out.println(values[getCount()]++); // 0
//        System.out.println(values[getCount()]++); // 1
//        System.out.println(values[getCount()]++); // 2
//        System.out.println(getCount()); // 0
//        incrementCount();
//        System.out.println(getCount()); // 1
    }

    public static Integer count = 0;
    public static int[] values = new int[105];

    static {
        for (int i = 0; i < 105; i++) {
            values[i] = 0;
        }
    }

    public static void incrementCount() {
        count++;
    }

    public static int getCount() {
        return count;
    }

    public static class Counter extends Thread {
        @Override
        public void run() {
            do { // цикл сначала выполняется, а потом проверяет условия
//                synchronized (this) { // мьютекс блокировка на уровне текущего объекта _ 0 1 2
                synchronized (values) { // work _ 0 1 1 1
//                synchronized (Solution_3105.class) { // work _ 0 1 1 1
                    incrementCount();   // атомарная операция 0, 1, 2, ..

                    // [getCount()]++ - т.е. инкрементирует полученный элемент
                    values[getCount()]++; // массив из 105 элементов _ 0, 1, 2, ..
                }

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {   // срабатывает при прерывании
                }
            } while (getCount() < 100);
        }
    }
}
