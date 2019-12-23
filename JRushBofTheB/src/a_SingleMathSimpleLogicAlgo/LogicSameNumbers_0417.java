package a_SingleMathSimpleLogicAlgo;

/* 
Существует ли пара?
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
// https://javarush.ru/tasks/com.javarush.task.task04.task0417
// Ввести с клавиатуры три целых числа. Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
//Если такая пара существует, вывести на экран числа через пробел.
//Если все три числа равны между собой, то вывести все три.
//
//Примеры:
//а) при вводе чисел
//1
//2
//2
//получим вывод
//2 2
//
//б) при вводе чисел
//2
//2
//2
//получим вывод
//2 2 2
//Требования:
//•	Программа должна считывать числа c клавиатуры.
//•	Программа должна содержать System.out.println() или System.out.print()
//•	Если два числа равны между собой, необходимо вывести числа на экран.
//•	Если все три числа равны между собой, необходимо вывести все три.
//•	Если нет равных чисел, ничего не выводить.
public class LogicSameNumbers_0417 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n1, n2, n3;
        n1 = Integer.parseInt(bf.readLine());
        n2 = Integer.parseInt(bf.readLine());
        n3 = Integer.parseInt(bf.readLine());

        String res = null;
        if (n1 == n2 && n1 != n3) {
            res = n1 + " " + n2;
        } else if (n1 == n3 && n1 != n2) {
            res = n1 + " " + n3;
        } else if (n2 == n3 && n2 != n1) {
            res = n2 + " " + n3;
        } else if (n1 == n2 && n1 == n3) {
            res = n1 + " " + n2 + " " + n3;
        }
        if(res!=null) {
            System.out.println(res);
        }
    }
}