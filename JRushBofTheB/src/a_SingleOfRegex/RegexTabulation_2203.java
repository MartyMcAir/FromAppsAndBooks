package a_SingleOfRegex;

/* 
Между табуляциями
*/
// https://javarush.ru/tasks/com.javarush.task.task22.task2203
// Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
//На некорректные данные бросить исключение TooShortStringException.
//Класс TooShortStringException не менять.
//
//Требования:
//•	Класс TooShortStringException должен быть потомком класса Exception.
//•	Метод getPartOfString должен принимать строку в качестве параметра.
//•	В случае, если строка, переданная в метод getPartOfString содержит менее 2 табуляций должно возникнуть исключение TooShortStringException.
//•	Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
public class RegexTabulation_2203 {
    public static String getPartOfString(String string) throws TooShortStringException {
        if (string == null) throw new TooShortStringException();
//        StringBuilder sb = new StringBuilder();
//        char[] chArr = string.toCharArray();
//        int tmp = 0;
//        for (int i = 0; i < chArr.length; i++) {
//            if (tmp > 0 & tmp < 2) {
//                sb.append(chArr[i]);
//            }
//            if (chArr[i] == '\t') {
//                tmp++;
//            }
//        }
//        if (tmp <= 1) throw new TooShortStringException();
//        return sb.toString();
//        return string.substring(string.indexOf("\t") + 1, string.indexOf("\t", string.indexOf("\t") + 1));

        // считаем кол-во табов
        int match = string.length() - string.replaceAll("\t","").length();
        if(match < 2 ) throw new TooShortStringException();
        String[] parse = string.split("\t");
        return parse[1]; // возвращаем элемент после первого таба
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
        System.out.println(getPartOfString("JavaRush - лучший сервис \tобучения Java\t."));
//        System.out.println(getPartOfString(null));
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java\t."));
    }
}
