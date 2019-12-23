package a_SingleMathSimpleLogicAlgo;

/* 
Сумма цифр трехзначного числа
*/
// https://javarush.ru/tasks/com.javarush.task.task01.task0132
// Напиши код метода sumDigitsInNumber(int number). Метод на вход принимает целое трехзначное число. Нужно посчитать сумму цифр этого числа, и вернуть эту сумму.
//
//Пример:
//Метод sumDigitsInNumber вызывается с параметром 546.
//
//Пример вывода:
//15
//
//Требования:
//•	Программа не должна считывать данные с клавиатуры.
//•	Метод sumDigitsInNumber(int) должен быть публичным и статическим.
//•	Метод sumDigitsInNumber должен возвращать значение типа int.
//•	Метод sumDigitsInNumber не должен ничего выводить на экран.
//•	Метод sumDigitsInNumber должен правильно возвращать сумму всех цифр в числе number.
public class LogicSumThreeDigits_0132 {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        String str = String.valueOf(number);
        char[] chArr = str.toCharArray();
        int res=0, tmp;
        for(int i=0;i<chArr.length;i++){
            tmp = Integer.parseInt(String.valueOf(chArr[i]));
            res +=tmp;
        }
        return res;
    }
}