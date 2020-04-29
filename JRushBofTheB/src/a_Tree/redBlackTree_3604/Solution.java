package com.javarush.task.task36.task3604;

/* 
Разбираемся в красно-черном дереве
*/
// https://javarush.ru/tasks/com.javarush.task.task36.task3604#discussion
public class Solution {
    public static void main(String[] args) {
        RedBlackTree red = new RedBlackTree();
        red.insert(1);
        red.insert(2);
        red.insert(3);
        red.insert(4);

//        red.displayAllTree(red.current); // StackOverflowError
        // Why!???
    }
}
