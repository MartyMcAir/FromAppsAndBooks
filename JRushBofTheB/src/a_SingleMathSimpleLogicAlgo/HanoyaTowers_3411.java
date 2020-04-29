package com.javarush.task.task34.task3411;

/* 
Ханойские башни
*/
// https://javarush.ru/tasks/com.javarush.task.task34.task3411#discussion
// сам бы не допер до такой двойной рекурсии..  (нашел рекомендации читать Кнут'а)
public class Solution {
    public static void main(String[] args) {
        int numRings = 3;
        moveRing('A', 'B', 'C', numRings);
    }

    public static void moveRing(char a, char b, char c, int numRings) {
        //напишите тут ваш код
        if (numRings > 0) {
            moveRing(a, c, b, numRings - 1); // перенести башню из n−1 диска на 2-й штырь
            System.out.println(String.format("from %c to %c", a, b));
            moveRing(c, b, a, numRings - 1); // перенеси башню из n−1 диска на 3-й штырь
        }
    }
}