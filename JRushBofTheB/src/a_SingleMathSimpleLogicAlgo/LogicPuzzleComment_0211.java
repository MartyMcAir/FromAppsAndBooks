package a_SingleMathSimpleLogicAlgo;

/* 
Самое нужное число
*/
// https://javarush.ru/tasks/com.javarush.task.task02.task0211
// Закомментируй максимальное количество строк, чтобы на экран вывелось число 19
//
//Требования:
//•	Программа должна выводить на экран число 19.
//•	Нельзя изменять строки с объявлением переменных.
//•	Нельзя изменять строку отвечающую за вывод в консоль.
//•	Нужно закомментировать некоторые строки и не менять остальные.
public class LogicPuzzleComment_0211 {
    public static void main(String[] args) {
        int x = 1;
        int y = 0;

        y = y + 3 * x;
        //x = x * 2;
        x = x * 16;
        //y = y + 2 * x;
        y = y + x;

        System.out.println(y);
    }
}
