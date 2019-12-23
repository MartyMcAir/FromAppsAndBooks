package a_SingleOfFileIO;

import java.io.*;
import java.util.TreeMap;

/* 
Собираем файл
*/
// https://javarush.ru/tasks/com.javarush.task.task18.task1825
//Собираем файл из кусочков.
//        Считывать с консоли имена файлов.
//        Каждый файл имеет имя: [someName].partN.
//
//        Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
//
//        Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
//        В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].
//
//        Например, Lion.avi.
//
//        В него переписать все байты из файлов-частей используя буфер.
//        Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
//        Закрыть потоки.
//
//        Требования:
//        •	Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
//        •	Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
//        •	В новый файл перепиши все байты из файлов-частей *.partN.
//        •	Чтение и запись должны происходить с использованием буфера.
//        •	Созданные для файлов потоки должны быть закрыты.
//        •	Не используй статические переменные.
public class FilePartsIs_1825 {
    public static void main(String[] args) throws IOException {
        String Direct = "C:\\z_n\\new_test_folder\\1\\";
        String[] arrPath = new String[]{Direct + "some3.txt.part3", Direct + "some1.txt.part1",
                Direct + "some2.txt.part2", "end"};

        // ___ наполняем список путями к файлам, и массивами байтов
        TreeMap<String, byte[]> map = new TreeMap<>();
        String tmp, finalFile = null;

        BufferedReader bfR = new BufferedReader(new InputStreamReader(System.in));
        BufferedInputStream bfIn = null;   // C:\z_n\new_test_folder\1\some1.txt.part1
//        while (!(tmp = bfR.readLine()).equals("end")) {
        for (int i = 0; i < arrPath.length & !arrPath[i].equals("end"); i++) {
            tmp = arrPath[i];
            if (finalFile == null) {
                finalFile = tmp.split(".part")[0];
            }
            bfIn = new BufferedInputStream(new FileInputStream(tmp));
            byte[] buffer = new byte[bfIn.available()];   // сохраняем путь и массив байтов файла
            bfIn.read(buffer);
            map.put(tmp, buffer);
            bfIn.close();
        }
        bfR.close();

        // обрабатываем путь, создаем имя файла и записываем в него весь буфер
        BufferedOutputStream bfOut = new BufferedOutputStream(new FileOutputStream(finalFile));
        for (byte[] item : map.values()) {
            bfOut.write(item);
        }
        bfOut.close();
    }
}
