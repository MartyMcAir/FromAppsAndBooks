package a_SingleMathSimpleLogicAlgo;


/* 
Треугольник из восьмерок
*/
// https://javarush.ru/tasks/com.javarush.task.task04.task0437
// Используя цикл for вывести на экран прямоугольный треугольник из восьмёрок со сторонами 10 и 10.
//
//Пример вывода на экран:
//8
//88
//888
//8888
//88888
//888888
//8888888
//88888888
//888888888
//8888888888
//
//Требования:
//•	Программа не должна считывать числа c клавиатуры.
//•	Программа должна выводить числа на экран.
//•	Программа должна выводить прямоугольный треугольник из восьмёрок со сторонами 10 и 10.
//•	В программе должен использоваться цикл for.
public class MathTriangle_0437 {
    public static void main(String[] args) throws Exception {
        //System.out.println("fff");
        for (int i = 1; i < 11; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(8);
            }
            System.out.println();
        }
    }
}
