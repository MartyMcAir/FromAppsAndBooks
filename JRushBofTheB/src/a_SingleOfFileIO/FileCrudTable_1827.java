package a_SingleOfFileIO;

/* 
Прайсы
*/

import java.io.*;
// https://javarush.ru/tasks/com.javarush.task.task18.task1827
//CrUD для таблицы внутри файла.
//        Считать с консоли имя файла для операций CrUD.
//
//        Программа запускается со следующим набором параметров:
//        -c productName price quantity
//
//        Значения параметров:
//        где id - 8 символов.
//        productName - название товара, 30 символов.
//        price - цена, 8 символов.
//        quantity - количество, 4 символа.
//        -c - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле.
//
//        В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
//        id productName price quantity
//
//        Данные дополнены пробелами до их длины.
//
//        Пример:
//        19846   Шорты пляжные синие           159.00  12
//        198478  Шорты пляжные черные с рисунко173.00  17
//        19847983Куртка для сноубордистов, разм10173.991234
//
//        Требования:
//        •	Программа должна считать имя файла для операций CrUD с консоли.
//        •	В классе Solution не должны быть использованы статические переменные.
//        •	При запуске программы без параметров список товаров должен остаться неизменным.
//        •	При запуске программы с параметрами "-c productName price quantity" в конец файла должна добавится новая строка с товаром.
//        •	Товар должен иметь следующий id, после максимального, найденного в файле.
//        •	Форматирование новой строки товара должно четко совпадать с указанным в задании.
//        •	Созданные для файлов потоки должны быть закрыты.
public class FileCrudTable_1827 {
    public static void main(String[] args) throws Exception {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        String[] arrPath = new String[]{dir + "data.txt", dir + "dataCrypt.txt.crypt",
                dir + "dataEncrypt.txt", "end"};
        String fileName = arrPath[0];

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = bf.readLine();
        bf.close();

        // При запуске без параметров список товар долж остаться неизмен _ убирается стрококй args.length != 0
        if (args.length != 0 && args[0].trim().startsWith("-c")) {
            // Читаем файл и получаем maxId
            BufferedReader bfR = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            String line = null, latestLine = null, productId = null;
            int maxId = Integer.MIN_VALUE;
            // Товар должен иметь следующий id,после максим, найденн в файле. - Убирается благодаря trim()
            while ((line = bfR.readLine()) != null) {
                System.out.println(line.substring(0, 9).trim());
                if (Integer.parseInt(line.substring(0, 9).trim()) > maxId) {
                    maxId = Integer.parseInt(line.substring(0, 9).trim());
                }
            }
            bfR.close(); // Требует после использования сразу же закрывать

            // Форматирование новой строки товара должно четко совпадать с указанным в задании.
            String id = (maxId + 1) + "";
            String pn = args[1];
            String pr = args[2];
            String qu = args[3];

            while (id.length() < 8) {
                id = id + " ";
            }
            while (pn.length() < 30) {
                pn = pn + " ";
            }
            while (pr.length() < 8) {
                pr = pr + " ";
            }
            while (qu.length() < 4) {
                qu = qu + " ";
            }
            String lineIs = id.substring(0, 8) + pn.substring(0, 30) + pr.substring(0, 8) + qu.substring(0, 4);

            // Записываем в файл данные в последнюю строку и увеличиваем id на +1
            BufferedWriter bfWr = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true)));
            bfWr.newLine();
            bfWr.write(lineIs);
            bfWr.close();
        }
    }
}
