package a_SingleMathSimpleLogicAlgo;

import org.apache.logging.log4j.core.util.JsonUtils;

import java.io.IOException;
// Неравноценный обмен
//Продолжая разработку алгоритма, нам очень бы пригодился метод который бы менял указанные биты
//в двоичном представлении числа типа long.
//
//Реализуй метод long swapBits(long number, int i, int j), который будет в двоичном представлении числа number менять местами биты с индексами i и j и возвращать результат.
//
//Наименее значимый бит имеет индекс 0.
//
//
//Требования:
//1. Метод swapBits должен быть реализован в соответствии с условием задачи.
//2. Метод swapBits должен быть публичным.
//3. Метод swapBits должен быть статическим.
//4. Метод swapBits должен возвращать число типа long.

// https://javarush.ru/tasks/com.javarush.task.task39.task3903#discussion

//  означает что результ внутри метода свапаем 1ый и второй индекс значит: 1 1 0 0 0 ___ и на выходе это 24
// Ноо ответ верный другой..
//  ___ т.е. индексы подразумевается что они справа на лево выходит так!?
public class BinaryToDecimal_3903 {
    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        System.out.println("Please enter a number: ");
//
//        long number = Long.parseLong(reader.readLine());
//        System.out.println("Please enter the first index: ");
//        int i = Integer.parseInt(reader.readLine());
//        System.out.println("Please enter the second index: ");
//        int j = Integer.parseInt(reader.readLine());
//
//        System.out.println("The result of swapping bits is " + swapBits(number, i, j));

        // число 20  - (представление в битах) 1 0 1 0 0
        // после перестановы должно быть _1 1 0 0 0  _ ?
        int number = 333;
        System.out.println(swapBits(number, 1, 2));
        System.out.println(swapBitsMy(number, 1, 2));
    }

    public static long swapBits(long number, int i, int j) {
        System.out.println("swapBits на входе в двоичном: " + Long.toBinaryString(number));

        if (i == j) return number;
        if (i > 63 || i < 0 || j > 63 || j < 0) throw new IllegalArgumentException();

        long firstBit = number & (1l << i);
        long secondBit = number & (1l << j);

        if (firstBit != 0) number |= 1l << j;
        else number &= ~(1l << j);

        if (secondBit != 0) number |= 1l << i;
        else number &= ~(1l << i);

        System.out.println("swapBits на выходе в двоичном: " + Long.toBinaryString(number));
        return number;
    }

    // вроде как верно работает _ но сути задачи не понял у меня из 20тки на выходе 24 _ а  должно 18
    public static long swapBitsMy(long number, int i, int j) {
//        BitSet bitSet = new BitSet(); // подобие коллекции но для битов..
        String s = Long.toBinaryString(number);   // двоичное представление числа
        System.out.println("swapBitsMy на входе в двоичном: " + s);

        char[] chars = s.toCharArray();
        // переставляем индексы
        char char1 = chars[i];
        char char2 = chars[j];
        chars[i] = char2;
        chars[j] = char1;
        // возвращаем обратно в десятичной системе
        String s1 = new String(chars);

        System.out.println("swapBitsMy на выходе в двоичном: " + s1);
        return Long.parseUnsignedLong(s1, 2);  // 1100
    }
}
