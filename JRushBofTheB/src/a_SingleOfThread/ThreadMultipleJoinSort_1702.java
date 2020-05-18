package a_SingleOfThread;

import java.util.ArrayList;
import java.util.List;

/* 
Вместе быстрее? Ща проверим :)
*/
// https://javarush.ru/tasks/com.javarush.task.task17.task1702
//1. Разберись, что и как работает.
//        2. Создай public static нить SortThread, которая в методе run отсортирует статический массив testArray используя метод sort.
//
//        Требования:
//        •	Класс Solution_3105 должен содержать public static класс SortThread.
//        •	Класс SortThread должен быть нитью.
//        •	В методе run класса SortThread должен вызывать метод sort() с параметром testArray.
//        •	Программа должна выводить текст на экран.
public class ThreadMultipleJoinSort_1702 {
    public static int threadCount = 10;
    public static int[] testArray = new int[1000];

    static {   // int массив наполняется от 0 до 999
        for (int i = 0; i < ThreadMultipleJoinSort_1702.testArray.length; i++) {
            testArray[i] = i;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        StringBuffer expectedResult = new StringBuffer();
        for (int i = 1000 - 1; i >= 0; i--) { // наполняется от 999 до 0
            expectedResult.append(i).append(" ");
        }

        initThreads();

        StringBuffer result = new StringBuffer();
        for (int i = 0; i < testArray.length; i++) {
            result.append(testArray[i]).append(" ");
        }
        System.out.println(result);
        System.out.println((result.toString()).equals(expectedResult.toString()));
    }

    // создается 10 (перем threadCount) new SortThread потоков и join'ятся
    public static void initThreads() throws InterruptedException {
        List<Thread> threads = new ArrayList<Thread>(threadCount);
        for (int i = 0; i < threadCount; i++) threads.add(new SortThread());
        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join();
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int k = array[i];
                    array[i] = array[j];
                    array[j] = k;
                }
            }
        }
    }

    // code
    public static class SortThread extends Thread{
        @Override
        public void run(){
            ThreadMultipleJoinSort_1702.sort(testArray);
        }
    }

    // В общем, сравнивая строку с ожидаемым результатом, получаем false, так как все 10 потоков
    // наполняют (append) строку одновременно. Если поставить один поток в threadCount, то все
    // встает на свои места и получаем при сравнении true. Если же синхронизировать sort
    // (public static synchronized void sort) и запустить 10 потоков, то тоже получаем true.
    // и с synchronized время создания всех действий в цикле меньше т.е. с synchronized быстрее
}

