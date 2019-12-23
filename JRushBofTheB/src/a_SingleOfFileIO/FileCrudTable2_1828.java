package a_SingleOfFileIO;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
// https://javarush.ru/tasks/com.javarush.task.task18.task1828
//CrUD для таблицы внутри файла
//        Считать с консоли имя файла для операций CrUD
//
//        Программа запускается с одним из следующих наборов параметров:
//        -u id productName price quantity
//        -d id
//
//        Значения параметров:
//        где id - 8 символов
//        productName - название товара, 30 символов
//        price - цена, 8 символов
//        quantity - количество, 4 символа
//        -u - обновляет данные товара с заданным id
//        -d - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)
//
//        В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
//        id productName price quantity
//        Данные дополнены пробелами до их длины
//
//        Пример:
//        19847   Шорты пляжные синие           159.00  12
//        198479  Шорты пляжные черные с рисунко173.00  17
//        19847983Куртка для сноубордистов, разм10173.991234
//
//        Требования:
//        •	Программа должна считать имя файла для операций CrUD с консоли.
//        •	При запуске программы без параметров список товаров должен остаться неизменным.
//        •	При запуске программы с параметрами "-u id productName price quantity" должна обновится информация о товаре в файле.
//        •	При запуске программы с параметрами "-d id" строка товара с заданным id должна быть удалена из файла.
//        •	Созданные для файлов потоки должны быть закрыты.
public class FileCrudTable2_1828 {
    public static void main(String[] args) throws IOException {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        String[] arrPath = new String[]{dir + "data.txt", dir + "dataRes.txt",
                dir + "dataEncrypt.txt", "end"};
//        String fileName = arrPath[0], fileNameOut = arrPath[1];

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String fileName = bf.readLine();
        bf.close();

        if (args.length != 0) {
            String idNeed = args[1], args0 = args[0], tmpLine = null;
//            String idNeed = "19847983", args0 = args[0], tmpLine = null;

            // Читаем файл и сохраняем содержимое в список _ и сразу же при чтении
            // исщем искомую строку с нужным id и сохраняем номер этой строки
            BufferedReader bfR = new BufferedReader(new InputStreamReader(
                    new FileInputStream(fileName)
//                    , Charset.forName("cp1251")
            ));
            ArrayList<String> list = new ArrayList<>();

            int indexIs = 0;
            for (int i = 0; (tmpLine = bfR.readLine()) != null; i++) {
                if (tmpLine.substring(0, 8).trim().equals(idNeed)) {
                    indexIs = i; // искомый индекс для удаляния или обновления
                }
                list.add(tmpLine);
            }
            bfR.close();

//            list.forEach(v -> System.out.print(v));
            // перебираем вариантивность в зависимости от поступившей команды -c или -u
            if (args[0].trim().equals("-u")) { // -u 12345678 Шортыпляжныесиние 150.00 1235
                String id = spaceCounter(args[1], 8);
                String product = spaceCounter(args[2], 30);
                String price = spaceCounter(args[3], 8);
                String quantity = spaceCounter(args[4], 4);
                String element = id + product + price + quantity;
//                String element = idNeed + args[2] + args[3] + args[4];
                list.set(indexIs, element);
            } else if (args[0].trim().equals("-d")) {
                list.remove(indexIs);
            }
//            System.out.println("\n____\n");
//            list.forEach(v -> System.out.print(v));

            // Записываем измененный список (после операции -u или -d _ false т.е. перезапишем файл
            BufferedWriter bfWr = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(fileName, true)
//                    , Charset.forName("cp1251")
            ));
            for (String item : list) {
                bfWr.write(item);
                bfWr.newLine();
            }
            bfWr.close();
        }
    }

    public static String spaceCounter(String original, int number) {
        while (original.length() < number) {
            original += " ";
        }
        return original;
    }
}
