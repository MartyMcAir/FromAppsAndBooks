package a_SingleOfRegex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Парсер реквестов
*/
// https://javarush.ru/tasks/com.javarush.task.task15.task1527
//Считать с консоли URL-ссылку.
//        Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
//        URL содержит минимум 1 параметр.
//        Выводить параметры нужно в той же последовательности, в которой они представлены в URL.
//        Если присутствует параметр obj, то передать его значение в нужный метод alert.
//        alert(double value) - для чисел (дробные числа разделяются точкой)
//        alert(String value) - для строк
//        Обрати внимание на то, что метод alert необходимо вызывать ПОСЛЕ вывода списка всех параметров на экран.
//
//        Пример 1
//
//        Ввод:
//        http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
//
//        Вывод:
//        lvl view name
//
//        Пример 2
//
//        Ввод:
//        http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
//
//        Вывод:
//        obj name
//        double: 3.14
//
//        Требования:
//        •	Программа должна считывать с клавиатуры только одну строку.
//        •	Класс Solution_3105 не должен содержать статические поля.
//        •	Программа должна выводить данные на экран в соответствии с условием.
//        •	Программа должна вызывать метод alert с параметром double в случае,
//        если значение параметра obj может быть корректно преобразовано в число типа double.
//        •	Программа должна вызывать метод alert с параметром String в случае,
//        если значение параметра obj НЕ может быть корректно преобразовано в число типа double.
public class RegexUrlParser_1527 {
    public static void main(String[] args) {
        //add your code here
        // Выводить параметры нужно в той же последовательности, в которой они представлены в URL.
//        String url2 = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";
        // lvl view name
//        String url1 = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo";
        // obj name
        // double: 3.14

        String objValue = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String tmpStr = reader.readLine();
            int tmpIndex = tmpStr.indexOf("?"); // получаем № индекса где начинаются параметры после: "?"
            String cutIndex = tmpStr.substring(tmpIndex + 1); // получаем отрезок после "?" с параметрами
//            System.out.println(cutIndex); // lvl=15&view&name=Amigo _ ?obj=3.14&name=Amigo

            if (cutIndex.contains("obj")) {   // если есть параметр obj
                Pattern p = Pattern.compile("[a-zA-Z]+(?=[=])", Pattern.DOTALL +
                        Pattern.CASE_INSENSITIVE); // получаем имена параметров
                Matcher m = p.matcher(cutIndex);
                while (m.find()) {
                    System.out.print(m.group() + " ");   // obj name
                }

                System.out.println();
                // "[0-9]{1}\\.[0-9]{2}"; // для получения заданой последовательности
                // если есть корректное дробное число
//                if (cutIndex.matches("\\w+\\={1}([0-9]{1,}\\.|[0-9]{1,}).*") | cutIndex.matches("\\w+\\={1}([0-9]{2,}).*")) {
//                if (cutIndex.matches("\\w+\\={1}([0-9]{1,}\\.|[0-9]{1,}).*") | cutIndex.matches("\\w+\\={1}([0-9]{2,}).*")) {
                if (true) {
//                    Pattern p1 = Pattern.compile("([0-9.]=?)+[0-9]+(?=[&])", Pattern.DOTALL +
//                    Pattern p1 = Pattern.compile("\"(?<=(obj=)).*(?=[&])", Pattern.DOTALL +
                    Pattern p1 = Pattern.compile("(?<=(obj=)).*(?=[&])", Pattern.DOTALL +
                            Pattern.CASE_INSENSITIVE);

                    Matcher m1 = p1.matcher(cutIndex);
                    while (m1.find()) {
                        objValue = m1.group();
                        double tmp = Double.parseDouble(objValue);
                        alert(tmp); // double: 3.14
//                    System.out.print(m1.group() + " ");
                    }

                } else { // иначе если нет корректного дробного числа
//                    Pattern p1 = Pattern.compile("([0-9.]=?)+[0-9]+(?=[&])", Pattern.DOTALL +
//                    Pattern p1 = Pattern.compile("(?<=(obj=))+.*([0-9]{1,}.*\\..*|.*[0-9]{1,}).*(?=[&])", Pattern.DOTALL +
                    Pattern p1 = Pattern.compile("(?<=(obj=)).*(?=[&])", Pattern.DOTALL +
                            Pattern.CASE_INSENSITIVE);

                    Matcher m1 = p1.matcher(cutIndex);
                    while (m1.find()) {
                        objValue = m1.group();
                    }
//                    alert(objValue);
                    throw new RuntimeException();
                }

            } else {
                String pattern1 = "[a-zA-Z]+(?=[=&])"; // obj name
                Pattern p3 = Pattern.compile(pattern1, Pattern.DOTALL + Pattern.CASE_INSENSITIVE);
                Matcher m3 = p3.matcher(cutIndex);
                while (m3.find()) {
                    System.out.print(m3.group() + " ");
                }
            }
        } catch (RuntimeException e) {
//            e.printStackTrace();
            alert((String) objValue);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
