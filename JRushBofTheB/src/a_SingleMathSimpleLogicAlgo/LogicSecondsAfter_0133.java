package a_SingleMathSimpleLogicAlgo;

/* 
Не думать о секундах…
*/
// https://javarush.ru/tasks/com.javarush.task.task01.task0133
// Напиши код, который считает сколько секунд прошло с 15:00, если на часах 15:30. Выведи результат на экран.
//
//Требования:
//•	Программа должна выводить текст.
//•	Выведенный текст должен быть целым положительным числом.
//•	Выведенное число должно быть кратно 60.
//•	Выводимое число должно соответствовать заданию.
public class LogicSecondsAfter_0133 {
    public static void main(String[] args) {
        int min = 30;
        //int secondsAfter15 = 30*60; // 1800
        int secondsAfter15 = getSecondFromMinute(15, 15.30);
        System.out.println(secondsAfter15);
    }

     public static int getSecondFromMinute(double hSt, double hEn){
        double m = hEn- hSt;
        double sec = (m*100)*60;
        return (int) sec;
     }
}