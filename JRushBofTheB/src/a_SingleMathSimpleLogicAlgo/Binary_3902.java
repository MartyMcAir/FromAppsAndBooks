package a_SingleMathSimpleLogicAlgo;

import java.io.IOException;

/* 
Биты были биты
*/
// https://javarush.ru/tasks/com.javarush.task.task39.task3902#discussion
// В процессе разработки сложного алгоритма кодирования возникла задача определить четное ли количество единиц в двоичной записи числа.
//Реализуй метод boolean isWeightEven(long number), который будет возвращать true или false в зависимости от того, является ли количество единиц в двоичном представлении числа number четным или нечетным.
//P.S. Постарайся использовать только побитовые операции, а также минимизировать время выполнения программы.
// https://habr.com/ru/post/276957/
public class Binary_3902 {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        System.out.println("Please enter a number: ");
//
//        long l = Long.parseLong(reader.readLine());
//        String result = isWeightEven(l) ? "even" : "odd";
//        System.out.println("The entered number has " + result + "ones");

        System.out.println(isWeightEven(333));
    }

    // from https://github.com/msamichev/javarush/blob/c1b53a589cf8c509fd7f6beab5fe5ff2e049d3e9/JavaRushTasks/4.JavaCollections/src/com/javarush/task/task39/task3902/Solution.java
    public static boolean isWeightEven(long number) {
        int lo = (int) number;
        lo -= ((lo >> 1) & 0x55555555);
        lo = (lo & 0x33333333) + ((lo >> 2) & 0x33333333);
        int hi = (int) (number >> 32);
        hi -= ((hi >> 1) & 0x55555555);
        hi = (hi & 0x33333333) + ((hi >> 2) & 0x33333333);
        hi += lo;
        hi = (hi & 0x0F0F0F0F) + ((hi >> 4) & 0x0F0F0F0F);
        hi += (hi >> 16);
        return ((hi + (hi >> 8)) & 0x000000FF) % 2 == 0;
    }

    // работает
    public static boolean isWeightEvenMyV2(long number) {
        return (Long.bitCount(number) % 2 == 0) ? true : false;
    }

    // работает
    public static boolean isWeightEvenMy(long number) {
        String s = Long.toBinaryString(number);
        System.out.println(s);

        char[] chars = s.toCharArray();

        int counter = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') counter++;
        }

        if (counter % 2 == 0) return true;
        return false;
    }
}
