package com.javarush.task.task30.task3004;

import java.util.concurrent.ForkJoinPool;

/* 
Fork/Join
*/
// https://javarush.ru/tasks/com.javarush.task.task30.task3004#discussion
// решил почти сам _ все понятно - в сравнении с битовыми сдвигами..
// 1. Создай класс BinaryRepresentationTask. Для этого в IntelliJ IDEA на красном имени класса нажми Alt+Enter -> Create Class ...
//(класс должен наследоваться от RecursiveTask<String>). Параметр конструктора - int x.
//2. Реализуй логику метода compute - число должно переводиться в двоичное представление.
//3. Используй методы fork и join.
//4. Пример функциональной реализации - метод binaryRepresentationMethod.
public class Solution {
    private String binaryRepresentationMethod(int x) {
        int a = x % 2;
        int b = x / 2;
        String result = String.valueOf(a);
        if (b > 0) {
            return binaryRepresentationMethod(b) + result;
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String result1 = solution.binaryRepresentationMethod(6);
        System.out.println(result1);

        System.out.println();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        String result2 = forkJoinPool.invoke(new BinaryRepresentationTask(6));
        System.out.println(result2);
    }

}
