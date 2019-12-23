package a_SingleMathSimpleLogicAlgo;

/* 
Таблица умножения
*/
// https://javarush.ru/tasks/com.javarush.task.task03.task0314
// Выведи на экран таблицу умножения 10 на 10 в следующем виде:
//1 2 3 4 ...
//2 4 6 8 ...
//3 6 9 12 ...
//4 8 12 16 ...
//...
//
//Требования:
//•	Программа должна выводить текст.
//•	Выведенный текст должен содержать 10 строк.
//•	Каждая выведенная строка должна содержать 10 чисел, разделенных пробелом.
//•	Выведенные числа должны быть таблицей умножения.
public class MathMultiplicationTbl2_0314 {
    public static void main(String[] args) {
        int n1 = 1;
        for(int i=0; i<10; i++){
            for(int j=1; j<11; j++){
                System.out.print((n1*j)+" ");
            }
            System.out.println();
            n1++;
        }
    }
}
