package a_SingleOfRegex;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;
// https://javarush.ru/tasks/com.javarush.task.task19.task1925
// В метод main первым параметром приходит имя файла1, вторым - файла2.
//Файл1 содержит слова, разделенные пробелом.
//Записать через запятую в Файл2 слова, длина которых строго больше 6.
//В конце файла2 запятой не должно быть.
//Закрыть потоки.
//
//Пример выходных данных в файл2:
//длинное,короткое,аббревиатура
//
//Требования:
//•	Программа НЕ должна считывать данные с консоли.
//•	Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
//•	Поток чтения из файла (FileReader) должен быть закрыт.
//•	Программа должна записывать через запятую во второй файл все слова из первого файла длина которых строго больше 6(используй FileWriter).
//•	Поток записи в файл (FileWriter) должен быть закрыт.
public class RegexStrLength_1925 {
    public static void main(String[] args) throws IOException {
//        String file1 = myPath()[0];
//        String file2 = myPath()[1];
        String file1 = args[0];
        String file2 = args[1];
        ArrayList<String> list = new ArrayList<>();

//        BufferedReader bfR = new BufferedReader(new FileReader(file1, Charset.forName("cp1251")));
        BufferedReader bfR = new BufferedReader(new FileReader(file1));
        while (bfR.ready()) {
            String tmp = "";
            String[] arrStr = bfR.readLine().split("\\s+"); // "\\s+" ",| "
//            System.out.println(Arrays.toString(arrStr));
            for (int i = 0; i < arrStr.length; i++) {
//                if (arrStr[i].matches("[а-я]+") | arrStr[i].length() > 6) { // не работает !?
//                if (arrStr[i].length() > 6) {
                if (arrStr[i].matches("\\S{7,}")) {
                    tmp += arrStr[i] + " ";
                }
            }
            if (!tmp.equals("")) {
                list.add(tmp);
            }
        }
        bfR.close();

//        list.forEach(v -> System.out.print(v));

        BufferedWriter bfWr = new BufferedWriter(new FileWriter(file2));
        for (int i = 0; i < list.size(); i++) {
            String[] arrSt = list.get(i).split(" "); // Разбиваем строку
            for (int j = 0; j < arrSt.length; j++) { // перебираем элементы массива
                if (i == (list.size() - 1) & j == (arrSt.length - 1)) {
//                    System.out.println(arrSt[j]); // последенее слово последней строки
                    bfWr.write(arrSt[j]); // последенее слово последней строки
                } else {
//                    System.out.print(arrSt[j] + ",");
                    bfWr.write(arrSt[j] + ",");
                }
            }
//            System.out.println();
//            if (i != (list.size() - 1)) { // чтоб если последняя строка запись не начинал с новой строки
//                bfWr.newLine();
//            }
        }
        bfWr.close();

    }

    public static String[] myPath() {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        return new String[]{dir
                + "file1.txt", dir
                + "file2.txt", dir
                + "file3.txt"};
    }
}
