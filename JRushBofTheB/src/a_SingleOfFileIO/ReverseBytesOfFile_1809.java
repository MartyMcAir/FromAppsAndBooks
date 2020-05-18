package a_SingleOfFileIO;

/* 
Реверс файла
*/

import java.io.*;
// https://javarush.ru/tasks/com.javarush.task.task18.task1809
//Считать с консоли 2 имени файла: файл1, файл2.
//        Записать в файл2 все байты из файл1, но в обратном порядке.
//        Закрыть потоки.
//
//        Требования:
//        •	Программа должна два раза считать имена файлов с консоли.
//        •	Для чтения из файла используй поток FileInputStream, для записи в файл - FileOutputStream
//        •	Во второй файл нужно записать все байты из первого в обратном порядке.
//        •	Потоки FileInputStream и FileOutputStream должны быть закрыты.
public class ReverseBytesOfFile_1809 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String filePath1 = bf.readLine(), filePath2 = bf.readLine();
//        String filePath1 = "C:\\z_n\\new_test_folder\\data.txt";
//        String filePath2 = "C:\\z_n\\new_test_folder\\result.txt";
        BufferedInputStream bfIn = new BufferedInputStream(new FileInputStream(filePath1));
        BufferedOutputStream bfOut = new BufferedOutputStream(new FileOutputStream(filePath2));

        // Ошибка в файле com/javarush/task/task18/task1809/Solution_3105.java в строке : 19
        // Не найден метод "readAllBytes()" в переменной "bfIn"
//        byte[] arrByte = bfIn.readAllBytes();   // WTF!?
//
////        System.out.println(Arrays.toString(arrByte));
//        byte current;   // reverse array
//        for (int i = 0, j = arrByte.length - 1; i < j; i++, j--) {
//            current = arrByte[i]; // сохран текущее значение
//            arrByte[i] = arrByte[j]; // текущему индексу значение последнего элемента
//            arrByte[j] = current; // текущ значение присваиваем к последнему индексу
//        }
//        System.out.println(Arrays.toString(arrByte));

//        for (int i = 0; i < arrByte.length; i++) {
//            bfOut.write(arrByte[i]);
//        }

        // скопипастил с коммента
        byte[] buffer = new byte[bfIn.available()];
        bfIn.read(buffer);

        for (int i = 0; i < buffer.length / 2; i++) {
            byte temp = buffer[i];
            buffer[i] = buffer[buffer.length - 1 - i];
            buffer[buffer.length - 1 - i] = temp;
        }

        bfOut.write(buffer);

        bf.close();
        bfIn.close();
        bfOut.close();
    }
}
