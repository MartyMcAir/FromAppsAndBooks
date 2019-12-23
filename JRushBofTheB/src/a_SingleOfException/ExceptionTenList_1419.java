package a_SingleOfException;

import java.util.ArrayList;
import java.util.List;

/* 
Нашествие исключений
*/
// https://javarush.ru/tasks/com.javarush.task.task14.task1419
//Заполни список exceptions десятью(10) различными исключениями.
//        Первое исключение уже реализовано в методе initExceptions.
//
//        Требования:
//        •	Список exceptions должен содержать 10 элементов.
//        •	Все элементы списка exceptions должны быть исключениями(потомками класса Throwable).
//        •	Все элементы списка exceptions должны быть уникальны.
//        •	Метод initExceptions должен быть статическим.
public class ExceptionTenList_1419 {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        }
        //напишите тут ваш код
        catch (Exception e) { // 1
            exceptions.add(e);
            exceptions.add(new ArrayIndexOutOfBoundsException());
            exceptions.add(new ArrayStoreException());
            exceptions.add(new ClassCastException());
            exceptions.add(new IllegalArgumentException());
            exceptions.add(new IllegalMonitorStateException());
            exceptions.add(new IllegalStateException());
            exceptions.add(new IllegalThreadStateException());
            exceptions.add(new IndexOutOfBoundsException());
            exceptions.add(new NegativeArraySizeException());
        }
    }
}
