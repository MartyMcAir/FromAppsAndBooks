package a_SingleMathSimpleLogicAlgo;

/* 
Максимум четырех чисел
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
// https://javarush.ru/tasks/com.javarush.task.task04.task0419
// Ввести с клавиатуры четыре числа, и вывести максимальное из них.
//Если числа равны между собой, необходимо вывести любое.
//
//Требования:
//•	Программа должна считывать числа c клавиатуры.
//•	Программа должна выводить число на экран.
//•	Программа должна выводить на экран максимальное из четырёх чисел.
//•	Если максимальных чисел несколько, необходимо вывести любое из них.
public class LogicMaxFourNumbers_0419 {
    public static void main(String[] args) throws Exception {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n1, n2, n3, n4, res = 0;
        n1 = Integer.parseInt(bf.readLine());
        n2 = Integer.parseInt(bf.readLine());
        n3 = Integer.parseInt(bf.readLine());
        n4 = Integer.parseInt(bf.readLine());

        if (n1 >= n2 && n1 >= n3 && n1 >= n4) {
            res = n1;
            System.out.println(res);
        } else if (n2 >= n1 && n2 >= n3 && n1 >= n4) {
            res = n2;
            System.out.println(res);
        } else if (n3 >= n1 && n3 >= n2 && n3 >= n4) {
            res = n3;
            System.out.println(res);
        } else if (n4 >= n1 && n4 >= n2 && n4 >= n3) {
            res = n4;
            System.out.println(res);
        } else if (n1 == n2 && n1 == n3 && n1 == n4) {
            res = n3;
            System.out.println(res);
        }
        //System.out.println(res);
    }
}
