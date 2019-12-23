package a_SingleMathSimpleLogicAlgo;

/* 
Сумма 5 чисел
*/
// https://javarush.ru/tasks/com.javarush.task.task03.task0309
// Вывести на экран сумму чисел от 1 до 5 построчно (должно быть 5 строк):
//1
//1+2=3
//1+2+3=6
//...
//
//Пример вывода:
//1
//3
//6
//...
//
//Требования:
//•	Программа должна выводить текст.
//•	Выведенный текст должен содержать 5 строк.
//•	Число в каждой новой строке должно быть больше предыдущего.
//•	Выводимый текст должен соответствовать заданию.
public class MathSumFiveDigits_0309 {
    public static void main(String[] args) {
        sumProgress(1, 5);
    }

    public static void sumProgress(int st, int end) {
        int tmp, res, tmp2 = 0;
        for (int i = st; i <= end; i++) {
            tmp = st;
            tmp2 += st; // 15
            res = st + tmp; // 10
            System.out.println(tmp2);
            st++;
        }
    }

}
