package a_SingleOfFileIO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/
// https://javarush.ru/tasks/com.javarush.task.task19.task1916
// Считать с консоли 2 имени файла - file1, file2.
//Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
//Нужно создать объединенную версию строк, записать их в список lines.
//Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME.
//Пустые строки даны в примере для наглядности.
//В оригинальном и редактируемом файлах пустых строк нет!
//
//Пример 1:
//оригинальный    редактированный    общий
//file1:          file2:             результат:(lines)
//
//строка1         строка1            SAME строка1
//строка2                            REMOVED строка2
//строка3         строка3            SAME строка3
//строка4                            REMOVED строка4
//строка5         строка5            SAME строка5
//                строка0            ADDED строка0
//строка1         строка1            SAME строка1
//строка2                            REMOVED строка2
//строка3         строка3            SAME строка3
//                строка4            ADDED строка4
//строка5         строка5            SAME строка5
//строка0                            REMOVED строка0
//
//Пример 2:
//оригинальный    редактированный    общий
//file1:          file2:             результат:(lines)
//
//строка1         строка1            SAME строка1
//                строка0            ADDED строка0
//
//Пустые строки в примере означают, что этой строки нет в определенном файле.
//
//Требования:
//•	Класс Solution должен содержать класс LineItem.
//•	Класс Solution должен содержать enum Type.
//•	Класс Solution должен содержать публичное статическое поле lines типа List<LineItem>, которое сразу проинициализировано.
//•	В методе main(String[] args) программа должна считывать имена файлов с консоли (используй BufferedReader).
//•	В методе main(String[] args) BufferedReader для считывания данных с консоли должен быть закрыт.
//•	Программа должна считывать содержимое первого и второго файла (используй FileReader).
//•	Потоки чтения из файлов (FileReader) должны быть закрыты.
//•	Список lines должен содержать объединенную версию строк из файлов, где для каждой строки указана одна из операций ADDED, REMOVED, SAME.
public class MergeTablesInFile_1916 {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bf.readLine();
        String file2 = bf.readLine();
        bf.close();

        ArrayList<String> f1 = new ArrayList<>();
        ArrayList<String> f2 = new ArrayList<>();
//        BufferedReader bfR1 = new BufferedReader(new FileReader(file1, Charset.forName("cp1251")));
        BufferedReader bfR1 = new BufferedReader(new FileReader(file1));
        while (bfR1.ready()) {
            f1.add(bfR1.readLine());
        }
        bfR1.close();

//        BufferedReader bfR2 = new BufferedReader(new FileReader(file2, Charset.forName("cp1251")));
        BufferedReader bfR2 = new BufferedReader(new FileReader(file2));
        while (bfR2.ready()) {
            f2.add(bfR2.readLine());
        }
        bfR2.close();

//        listOrigin.forEach(v -> System.out.print(v + " _ "));
//        System.out.println("");
//        listEdition.forEach(v -> System.out.print(v + " _ "));

        for (int i = 0; i < f1.size() && i < f2.size(); i++) {
            try {
                if (f1.get(i).equals(f2.get(i))) {
                    lines.add(new LineItem(Type.SAME, f2.get(i)));
                    f1.remove(i);
                    f2.remove(i);
                    i--;
                } else if (!f1.get(i).equals(f2.get(i)) && f2.size() > 1) {
                    if (!f1.get(i).equals(f2.get(i + 1))) {
                        lines.add(new LineItem(Type.REMOVED, f1.get(i)));
                        f1.remove(i);
                        i--;
                    } else if (f1.get(i).equals(f2.get(i + 1))) {
                        lines.add(new LineItem(Type.ADDED, f2.get(i)));
                        f2.remove(i);
                        i--;
                    }
                } else {
                    lines.add(new LineItem(Type.REMOVED, f1.get(i)));
                    f1.remove(i);
                    i--;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                lines.add(new LineItem(Type.REMOVED, f1.get(i)));
                f1.remove(i);
                i--;
            }
        }

        while (!f1.isEmpty()) {
            lines.add(new LineItem(Type.REMOVED, f1.get(0)));
            f1.remove(0);
        }
        while (!f2.isEmpty()) {
            lines.add(new LineItem(Type.ADDED, f2.get(0)));
            f2.remove(0);
        }

//        lines.forEach(v -> System.out.println(v.toString()));
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
