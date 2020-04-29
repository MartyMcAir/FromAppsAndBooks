package com.javarush.task.task29.task2912;

/* 
Рефакторинг паттерна Chain of Responsibility
*/
// https://javarush.ru/tasks/com.javarush.task.task29.task2912#discussion
// В программе реализован паттерн "цепочка ответственности". Изучи его внимательно. В классах FileLogger,
// ConsoleLogger, SmsLogger, PhoneLogger есть много повторяющегося кода. Подними весь повторяющийся код
// в абстрактный класс AbstractLogger.
// Подъемом в рефакторинге называется перенос полей, методов, конструкторов из всех наследников в одного
// общего предка. Из наследников, при этом, удаляется код, который перенесен в класс предка.
//
// Логика работы программы не должна измениться.
public class Solution {
    public static void main(String[] args) {
        Logger logger3 = new PhoneLogger(Level.FATAL); // 400
        Logger logger2 = new SmsLogger(Level.ERROR); // 300
        Logger logger1 = new ConsoleLogger(Level.WARN); // 200
        Logger logger0 = new FileLogger(Level.INFO); // 100

        logger3.setNext(logger2); // 400 - set 200
        logger2.setNext(logger1); // 300 - set 200
        logger1.setNext(logger0); // 200 - set 100

        // покажет сообщение _ 400 <= 100
        //      и запустит след сообщение
        logger3.inform("Everything is OK", Level.INFO); // 400 _ in 100
        /// покажет сообщение _ 400 <= 200
        logger3.inform("We found a bug", Level.WARN); // 400 _ in 200
        /// покажет сообщение _ 400 <= 300
        logger3.inform("Database connection error", Level.ERROR); // 400 _ in 300
        /// покажет сообщение _ 400 <= 400
        logger3.inform("System shut down", Level.FATAL); // 400 _ in 400
    }
}