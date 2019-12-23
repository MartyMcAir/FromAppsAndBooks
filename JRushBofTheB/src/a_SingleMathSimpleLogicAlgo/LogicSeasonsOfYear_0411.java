package a_SingleMathSimpleLogicAlgo;

/* 
Времена года на Терре
*/
// https://javarush.ru/tasks/com.javarush.task.task04.task0411
// Напишите метод checkSeason. По номеру месяца, метод должен определить время года (зима, весна, лето, осень) и вывести на экран.
//
//Пример для номера месяца 2:
//зима
//
//Пример для номера месяца 5:
//весна
//
//Требования:
//•	Программа должна выводить текст на экран.
//•	Метод main не должен вызывать функцию System.out.println или System.out.print.
//•	Метод main должен вызывать метод checkSeason.
//•	Метод checkSeason должен быть static void, и иметь только один параметр int.
//•	Метод checkSeason должен выводить текст на экран согласно заданию.
public class LogicSeasonsOfYear_0411 {
    public static void main(String[] args) {
        checkSeason(12);
        checkSeason(4);
        checkSeason(7);
        checkSeason(10);
    }

    public static void checkSeason(int month) {
        String res = "";
        if (month == 12 || month <= 2) { // 12 1 2
            res = "зима";
        } else if (month > 2 && month < 6) { // 3 4 5
            res = "весна";
        } else if (month > 5 && month < 9) { // 6 7 8
            res = "лето";
        } else if (month > 8 && month < 12) { // 9 10 11
            res = "осень";
        }
        System.out.println(res);
    }
}