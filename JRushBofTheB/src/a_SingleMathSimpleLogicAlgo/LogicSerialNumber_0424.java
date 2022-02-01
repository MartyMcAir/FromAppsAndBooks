package a_SingleMathSimpleLogicAlgo;

/* 
Три числа
*/

import java.util.Scanner;
// https://javarush.ru/tasks/com.javarush.task.task04.task0424
// Ввести с клавиатуры три целых числа. Одно из чисел отлично от двух других, равных между собой.
// Вывести на экран порядковый номер числа, отличного от остальных.
//
//Пример для чисел 4 6 6:
//1
//
//Пример для чисел 6 6 3:
//3
//
//Требования:
//•	Программа должна считывать числа c клавиатуры.
//•	Программа должна использовать команды System.out.println() или System.out.print().
//•	Программа должна выводить на экран порядковый номер числа, отличного от остальных.
//•	Если все числа разные, ничего не выводить.
public class LogicSerialNumber_0424 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n1, n2, n3, res=0;
        n1 = sc.nextInt();
        n2 = sc.nextInt();
        n3 = sc.nextInt();

        if(n1==n2 && n1!=n3){
            res=3;
        } else if(n2==n3 && n2!=n1){
            res = 1;
        } else if(n3==n1 && n3!=n2){
            res = 2;
        }
        if(res!=0){
            System.out.println(res);
        }
    }
}
