package a_SingleOfFileIO;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
// https://javarush.ru/tasks/com.javarush.task.task20.task2003
// В методе fillInPropertiesMap считайте имя файла с консоли и заполни карту properties данными из файла.
//Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
//Реализуй логику записи в файл и чтения из файла для карты properties.
//
//Требования:
//•	Метод fillInPropertiesMap должен считывать данные с консоли.
//•	Метод fillInPropertiesMap должен создавать FileInputStream, передавая считанную строку в качестве параметра.
//•	Метод fillInPropertiesMap должен вызывать метод load передавая только что созданный FileInputStream в качестве параметра.
//•	Метод save должен сохранять карту properties в полученный в качестве параметра объект типа OutputStream.
//•	Метод load должен восстанавливать состояние карты properties из полученного в качестве параметра объекта типа InputStream.
public class FileSaveLoadNoSerializable2_2003 {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader bfR = new BufferedReader(new InputStreamReader(System.in));
        String file1 = bfR.readLine();
//        String file1 = myPath()[0];

        FileInputStream fl = new FileInputStream(file1);
        load(fl);
        fl.close();
        bfR.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.putAll(properties);
        prop.save(outputStream, "");
    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();
        prop.load(inputStream);
        prop.forEach((k, v) -> properties.put(k + "", v + ""));
    }

    public static void main(String[] args) throws Exception {
        FileSaveLoadNoSerializable2_2003 s = new FileSaveLoadNoSerializable2_2003();
        s.fillInPropertiesMap(); // наполняем map

        String file1 = myPath()[1];
        FileOutputStream flOut = new FileOutputStream(file1);
        s.save(flOut); // записываем в файл map
    }

    public static String[] myPath() {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        return new String[]{dir
                + "data_properties.txt.properties", dir
                + "data_properties2.txt.properties", dir
                + "file3.txt"};
    }
}
