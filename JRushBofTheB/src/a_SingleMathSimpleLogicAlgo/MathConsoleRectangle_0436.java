package a_SingleMathSimpleLogicAlgo;


import java.util.Scanner;
/*
Рисуем прямоугольник
*/
// https://javarush.ru/tasks/com.javarush.task.task04.task0436
// Ввести с клавиатуры два числа m и n.
//Используя цикл for вывести на экран прямоугольник размером m на n из восьмёрок.
//
//Пример: m=2, n=4
//8888
//8888
//
//Требования:
//•	Программа должна считывать два числа c клавиатуры.
//•	Программа должна выводить текст на экран.
//•	Программа должна выводить прямоугольник размером m на n из восьмёрок.
//•	В программе должен использоваться цикл for.
public class MathConsoleRectangle_0436 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int ln = sc.nextInt();
        int wide = sc.nextInt();

        for(int i=0; i<ln; i++){
            for(int j=0; j<wide; j++){
                System.out.print(8);
            }
            System.out.println();
        }
    }
}
