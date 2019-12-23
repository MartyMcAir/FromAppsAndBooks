package a_SingleOfRegex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Хуан Хуанович
*/
// https://javarush.ru/tasks/com.javarush.task.task19.task1921
// В метод main первым параметром приходит имя файла.
//В этом файле каждая строка имеет следующий вид:
//имя день месяц год
//где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String.
//[день] - int, [месяц] - int, [год] - int
//данные разделены пробелами.
//
//Заполнить список PEOPLE используя данные из файла.
//Закрыть потоки.
//
//Пример входного файла:
//Иванов Иван Иванович 31 12 1987
//Вася 15 5 2013
//
//Требования:
//•	Класс Solution должен содержать публичную константу PEOPLE типа List<Person>, которая должна быть сразу проинициализирована.
//•	Программа НЕ должна считывать данные с консоли.
//•	Программа должна считывать содержимое файла (используй FileReader).
//•	Поток чтения из файла (FileReader) должен быть закрыт.
//•	Программа должна заполнить список PEOPLE данными из файла.
//•	Программа должна правильно работать с двойными именами, например Анна-Надежда.
public class RegexDateStrParser_1921 {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        String file1 = myPath()[0];
//        String file1 = args[0];

//        BufferedReader reader = new BufferedReader(new FileReader(file1));
        BufferedReader reader = new BufferedReader(new FileReader(file1, Charset.forName("cp1251")));
        SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
        while (reader.ready()) {
            String line = reader.readLine();
            String name = line.replaceAll("\\d", "").trim();
            String date = line.replace(name, "").trim();
            System.out.println(name);
            PEOPLE.add(new Person(name, sdf.parse(date)));
        }
        reader.close();
    }

    public static String[] myPath() {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        return new String[]{dir + "file1.txt", dir + "file2.txt", dir + "file3.txt"};
    }

    //////////////////////////////////////////////
    public static class Person {
        private String name;
        private Date birthDate;

        public Person(String name, Date birthDate) {
            this.name = name;
            this.birthDate = birthDate;
        }

        public String getName() {
            return name;
        }

        public Date getBirthDate() {
            return birthDate;
        }
    }
}
