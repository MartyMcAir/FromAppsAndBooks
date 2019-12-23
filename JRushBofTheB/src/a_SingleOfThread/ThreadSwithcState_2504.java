package a_SingleOfThread;

/* 
Switch для нитей
*/
// https://javarush.ru/tasks/com.javarush.task.task25.task2504#discussion
// Switch для нитей
//Обработай список нитей в зависимости от состояния:
//1. Если нить еще не запущена, то запусти ее.
//2. Если нить в ожидании, то прерви ее.
//3. Если нить работает, то проверь маркер isInterrupted.
//4. Если нить прекратила работу, то выведи в консоль ее приоритет.
//Используй switch.
//
//
//Требования:
//1. Метод processThreads принимает аргументом массив нитей.
//2. Если переданная нить не запущена, нужно ее запустить.
//3. Если переданная нить находится в ожидании, нужно ее прервать.
//4. Если переданная нить работает, то нужно проверить маркер isInterrupted.
//5. Если переданная нить завершила работу, нужно вывести в консоль ее приоритет.
//6. Метод processThreads должен использовать оператор switch.
public class ThreadSwithcState_2504 {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (Thread thred : threads) {
            switch (thred.getState()) {
                case NEW:
//                    System.out.println("case NEW: " + thred.getState());
                    thred.start();
                    break;
                case BLOCKED:
                case WAITING:
                case TIMED_WAITING:
//                    System.out.println("case TIMED_WAITING: " + item.getState());
                    thred.interrupt();
//                    System.out.println(thred.getPriority());
                    break;
                case RUNNABLE:
//                    System.out.println("case RUNNABLE: " + item.getState());
                    thred.isInterrupted();
//                    if (thred.isInterrupted()) {
//                        System.out.println(thred.getPriority());
//                    }
                    break;
                case TERMINATED:
//                    System.out.println("case TERMINATED: " + item.getState());
                    System.out.println(thred.getPriority());
                    break;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Runnable r1 = new Runnable() {
            public void run() {
                Thread thrCurrent = Thread.currentThread();
                System.out.println(thrCurrent.getName() + ", condition: " + thrCurrent.getState());
            }
        };
        Thread[] tArr = new Thread[10];
        for (int i = 0; i < tArr.length; i++) {
            tArr[i] = new Thread(r1);
        }


//        for (int i = 0; i < tArr.length; i++) {
//            tArr[i].start();
////            Thread.currentThread().sleep(1000);
//            tArr[i].join();
//        }
        processThreads(tArr);

    }
}
