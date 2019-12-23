package a_SingleOfRegex;

/* 
Слова с цифрами
*/

import java.io.*;
// https://javarush.ru/tasks/com.javarush.task.task19.task1923
// В метод main первым параметром приходит имя файла1, вторым - файла2.
//Файл1 содержит строки со словами, разделенными пробелом.
//Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d.
//Закрыть потоки.
//
//Требования:
//•	Программа НЕ должна считывать данные с консоли.
//•	Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
//•	Поток чтения из файла (FileReader) должен быть закрыт.
//•	Программа должна записывать во второй файл все слова из первого файла которые содержат цифры (используй FileWriter).
//•	Поток записи в файл (FileWriter) должен быть закрыт.
public class RegexSymbolsWithDigits_1923 {
    public static void main(String[] args) throws IOException {
//        String file1 = myPath()[0];
//        String file2 = myPath()[1];
        String file1 = args[0];
        String file2 = args[1];

        BufferedReader bf = new BufferedReader(new FileReader(file1));
//        BufferedReader bf = new BufferedReader(new FileReader(file1, Charset.forName("cp1251")));
        BufferedWriter bfR = new BufferedWriter(new FileWriter(file2));

        String line, tmp;
        while ((line = bf.readLine()) != null) {
            String[] arrStr = line.split("\\s+");
            for (String item : arrStr) {
                if (item.matches(".*[0-9]+.*")) {
                    bfR.write(item + " ");
                }
            }
        }
        bfR.close();
        bf.close();
    }

    public static String[] myPath() {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        return new String[]{dir + "file_1.txt", dir + "file2.txt", dir + "file3.txt"};
    }
}
