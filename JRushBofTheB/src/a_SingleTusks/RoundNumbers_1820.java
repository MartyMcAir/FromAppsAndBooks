package a_SingleTusks;

/* 
Округление чисел
*/

import java.io.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
// https://javarush.ru/tasks/com.javarush.task.task18.task1820
//Считать с консоли 2 имени файла.
//        Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
//        Округлить числа до целых и записать через пробел во второй файл.
//        Закрыть потоки.
//
//        Принцип округления:
//        3.49 => 3
//        3.50 => 4
//        3.51 => 4
//        -3.49 => -3
//        -3.50 => -3
//        -3.51 => -4
//
//        Требования:
//        •	Программа должна два раза считать имена файлов с консоли.
//        •	Для первого файла создай поток для чтения. Для второго - поток для записи.
//        •	Считать числа из первого файла, округлить их и записать через пробел во второй.
//        •	Должны соблюдаться принципы округления, указанные в задании.
//        •	Созданные для файлов потоки должны быть закрыты.
public class RoundNumbers_1820 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String file1 = bf.readLine(), file2 = bf.readLine();
        String pathDir = "C:\\z_n\\new_test_folder\\";
        String file1 = pathDir + "data1.txt", file2 = pathDir + "data2.txt", file3 = pathDir + "result.txt";
        bf.close();

        BufferedInputStream bfIn = new BufferedInputStream(new FileInputStream(file1));
//        BufferedOutputStream bfOut = new BufferedOutputStream(new FileOutputStream(file2));
        DataOutputStream bfOut = new DataOutputStream(new FileOutputStream(file2));

        DecimalFormat df = new DecimalFormat("#");
        String number = "";

        byte[] reserve = new byte[bfIn.available()];
        bfIn.read(reserve, 0, bfIn.available()); // сохраняем прочитанное в массив байтов
        for (byte item : reserve) {
//            System.out.println((char) item);
            number += (char) item;
        }
        bfIn.close();
//        System.out.println(number); // еще один вариант получить строку 3.49 3.50 3.51 -3.49 -3.50 -3.51
        String[] arr = number.split(" "); // разделяем строку на отедельные элементы

        /////////////////////////////////////// withOut DataOutputStream
        for (String item : arr) { // обрабатываем в результ
//            byte[] bb = (item + " ").getBytes();
            RoundingMode mode = Double.parseDouble(item) > 0 ? RoundingMode.HALF_UP : RoundingMode.HALF_DOWN;
            df.setRoundingMode(mode);
            byte[] bb = (df.format(Double.parseDouble(item)) + " ").getBytes();
//            bfOut.write(Integer.parseInt(df.format(Double.parseDouble(item)))); // ээь
//            bfOut.write(Byte.parseByte(df.format(Double.parseDouble(item)))); // ээь
//            bfOut.write((int) Math.round(Double.parseDouble(item))); // ээь
//            bfOut.writeLong(Math.round(Double.parseDouble(item))); // wrong
            bfOut.write(bb); // good
        }

        bfOut.close();
        ///////////////////////////////////////// with DataOutputStream
//        for (String item : arr) { // обрабатываем в результ
//            RoundingMode mode = Double.parseDouble(item) > 0 ? RoundingMode.HALF_UP : RoundingMode.HALF_DOWN;
//            df.setRoundingMode(mode);
//            byte[] bb = (df.format(Double.parseDouble(item)) + " ").getBytes();
//            bfOut.writeChars(df.format(Double.parseDouble(item)) + " "); //  3   4   4   - 3   - 3   - 4
//        }

        // второй вариат чтение и обработака по присутствию пробела
//        StringBuilder sb = new StringBuilder();   // тоже вариант но более затратный
//        ArrayList<String> list = new ArrayList<String>();
//        int tmp;
//        while (bfIn.available() > 0) {
//            tmp = bfIn.read();
//            if (tmp == 32) {
////                list.add(String.valueOf(sb));
////                sb.delete(0, sb.length());
//                list.add(number);
//                number = "";
//                continue;
//            }
//            number += (char) tmp;
//            if (bfIn.available() == 0 && tmp != 32) { // что бы записывало последнюю цифру
//                list.add(number);
//            }
////                sb.append((char) tmp);
////            System.out.println((char) bfIn.read());
//        }
//        list.forEach(v -> System.out.print(v + " _ "));
//
//        for (String item : list) {
//            if (Double.parseDouble(item) > 0) {
//                df.setRoundingMode(RoundingMode.HALF_UP);
//                System.out.println(df.format(Double.parseDouble(item)));
//            } else {
//                df.setRoundingMode(RoundingMode.HALF_DOWN);
//                System.out.println(df.format(Double.parseDouble(item)));
//            }
//        }


    }
}
