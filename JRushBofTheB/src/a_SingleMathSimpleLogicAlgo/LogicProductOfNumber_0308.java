package a_SingleMathSimpleLogicAlgo;

/* 
Произведение 10 чисел
*/
// https://javarush.ru/tasks/com.javarush.task.task03.task0308
// Вывести на экран произведение 10 чисел от 1 до 10.
//Результат - это 1 число.
//
//Подсказка:
//будет три миллиона с хвостиком.
//
//Требования:
//•	Программа должна выводить целое число на экран.
//•	Метод main должен вызывать функцию System.out.println.
//•	Выведенное число должно быть больше трех миллионов.
//•	Выведенное число должно соответствовать заданию.
public class LogicProductOfNumber_0308 {
    public static void main(String[] args) {
        System.out.println(getMultiply(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
    }

    public static int getMultiply(int... a) {
        int result = 0, res = 0;
        for (int item : a) {
            res = item;

            result *= res;
        }
        return result;
    }

    //        тоже работает
    public static int getFactorial(int n) {
        int result = 1;
        for (int i = 1; i <= n; i++) {
            //result=result * i;
            result *= i;
        }
        return result;
    }

    //        а вот мой пример нет
    public static int getMultiplyMy(int... a) {
        int result = 0, tmp1, tmp2;
        for (int item : a) {
            tmp1 = item;
            result = item * tmp1; // 9
            result *= result; // 81
            //result = result*item; //27
            // result *= item; // 0

        }
        return result;
    }

    public static void oth() {
        System.out.println(1 * 2 * 3 * 4 * 5 * 6 * 7 * 8 * 9 * 10); // 3628800
    }

}
