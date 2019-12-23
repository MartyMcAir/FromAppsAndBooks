package a_SingleOfRegex;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
// https://javarush.ru/tasks/com.javarush.task.task19.task1907
// Считать с консоли имя файла.
//Файл содержит слова, разделенные знаками препинания.
//Вывести в консоль количество слов "world", которые встречаются в файле.
//Закрыть потоки.
//
//Требования:
//•	Программа должна считывать имя файла с консоли (используй BufferedReader).
//•	BufferedReader для считывания данных с консоли должен быть закрыт.
//•	Программа должна считывать содержимое файла (используй FileReader c конструктором принимающим String).
//•	Поток чтения из файла (FileReader) должен быть закрыт.
//•	Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
public class RegexPuktuationMarks_1907 {
    public static void main(String[] args) throws IOException {
        // Интересно, если файл будет 10Гб... Тогда варианты с впихиванием всего файла в строку не годятся..
        // Надо искать частями или до первого знака препинания.
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        String[] arrF = new String[]{dir + "file.txt", dir + "file2.txt", dir + "file3.txt"};
//        String file = arrF[0]; // 8 world
        ArrayList<String> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        reader.close();

        BufferedReader bfR = new BufferedReader(new FileReader(file));
        String tmp;
        while ((tmp = bfR.readLine()) != null) {
            if (tmp.contains("world")) {
                list.add(tmp);   // наполняем список, строками содержащими слово world
            }
        }
        bfR.close();

        String[] arrStr;
        int counter = 0;
        for (String item : list) {
            // сохраняем в массив, разделенные слова знаками и пробелами
            // Проверь, почему программа находит больше слов "world" чем есть в файле.
            // - вылечилось поменя в split()
            arrStr = item.split("^\\w");
            for (int i = 0; i < arrStr.length; i++) {
                if (arrStr[i].contains("world")) {
                    counter++;
                }
            }
        }

        System.out.println(counter);
    }
}
