package a_SingleOfRegex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона
*/
// https://javarush.ru/tasks/com.javarush.task.task22.task2212
// Метод checkTelNumber должен проверять, является ли аргумент telNumber валидным номером телефона.
//
//Критерии валидности:
//1) если номер начинается с '+', то он содержит 12 цифр
//2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
//3) может содержать 0-2 знаков '-', которые не могут идти подряд
//4) может содержать 1 пару скобок '(' и ')' , причем если она есть, то она расположена левее знаков '-'
//5) скобки внутри содержат четко 3 цифры
//6) номер не содержит букв
//7) номер заканчивается на цифру
//
//Примеры:
//+380501234567 - true
//+38(050)1234567 - true
//+38050123-45-67 - true
//050123-4567 - true
//+38)050(1234567 - false
//+38(050)1-23-45-6-7 - false
//050ххх4567 - false
//050123456 - false
//(0)501234567 - false
//
//Требования:
//•	Метод checkTelNumber должен возвращать значение типа boolean.
//•	Метод checkTelNumber должен быть публичным.
//•	Метод checkTelNumber должен принимать один параметр типа String.
//•	Метод checkTelNumber должен корректно проверять валидность номера телефона переданного ему в качестве параметра.
public class RegexPhoneNumber_2212 {
    public static boolean checkTelNumber(String telNumber) {
        // Сам не решил ____ не понял
        // https://www.youtube.com/watch?v=_pLpx6btq6U - хоршо объясняет
        // from https://github.com/seferen/JavaLearn/blob/master/src/Main/Java/Task2212.java
        if (telNumber == null || telNumber.isEmpty()) return false;
        Pattern p = Pattern.compile("\\d");
        Matcher find = p.matcher(telNumber);
        int count = 0;
        while (find.find()) count++;
        if ((telNumber.split("")[0].equals("+") && count == 12) || count == 10) {
            if (telNumber.matches("^\\+?\\d+\\(?\\d{3}\\)?(\\d+-\\d){0,2}\\d+")) return true;
        }
        return false;
    }

    public static boolean checkTelNumber3(String telNumber) {// WORK FROM https://gist.github.com/Shtaba09/9ab6fcf97e33b288a5544c34a5b7f858
        if (telNumber==null||telNumber.isEmpty()){return false;}
        return telNumber.matches("(^\\+\\d{12}|\\+\\d*\\-\\d*\\-\\d*)|(\\+|\\d)\\d{1,2}\\(\\d{3}\\)\\d{7}|(\\d*\\-\\d*)");
    }

    public static boolean checkTelNumber2(String telNumber) {
        if (telNumber != null) {
            return false;
        }
        boolean res = false;
//        res = telNumber.matches("\\+?(\\d{2})?\\(?(\\d{3})\\)?(\\d{3}[-]?\\d{2}[-]?\\d{2})");
//        res = telNumber.matches("^\\+?[3]?[8]?\\(?\\d{3}\\)?(\\d{7}|(\\d{3}\\-\\d{2}-\\d{2})|(\\d{3}\\-\\d{4})|(\\-\\d{3}\\-\\d{4}))");
        // А затем убрать из строки все лишние "+","-" и скобки, и посчитать количество символов
//        res = telNumber.matches("^\\+?\\d*(\\(\\d{3}\\))?\\d*-?\\d+-?\\d+-?\\d+$");

//        Для тех кто сам решал и не смог решить, предлагаю такой вариант поразбираться:
//        Делаем проверки:
//        (^\+\d{12}|^\(?\d{10})
//\+?[0-9]+\([0-9]{3}\)[0-9]+\d+
//                ^\+[0-9]+-[0-9]+-[0-9]+$
//                ^[0-9]+-[0-9]+$


//        можно и классикой
//        int count = 0;
//        for (int i = 0; i < telNumber.length(); i++) {
//            if (Character.isDigit(telNumber.charAt(i))) count++;
//        }
//        if (count != 12)  return false;

//        Подсчитал сначала количество цифр
//        Pattern pattern = Pattern.compile("\\d");
//        Matcher matcher = pattern.matcher(telNumber);
//        int q = 0;
//        while (matcher.find()) {
//            q++;
//        };
//        если 10 то используется одно регулярное выражение, если 12 то другое.
//        ТО у меня получилось 2 условия if и 2 регулярки. Можно и в одну регулярку написать
//        но слишком длинная получается, трудночитаемо.


        // Нужно просто читать внимательно условия задачи и выполнить соответствующую начальную проверку,
        // которая поможет откинуть лишнее и сделать запись итоговой регулярки более лаконичной:
        if (telNumber == null || telNumber.isEmpty()
                || telNumber.matches(".*-{2,}.*") ||
                telNumber.split("")[telNumber.length() - 1].matches("\\D")) return false;

        return telNumber != null && res;
    }

    public static void main(String[] args) {
        String[] strArr = new String[]{"+380501234567", "+38(050)1234567", "+38050123-45-67", "050123-4567",
                "+38)050(1234567", "+38(050)1-23-45-6-7", "050ххх4567", "050123456", "(0)501234567"};

        for (String item : strArr) {
            System.out.println("for phone: " + item + ", is: " + checkTelNumber(item));
        }


        // если номер начинается с '+', то он содержит 12 цифр
        // если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
        // может содержать 0-2 знаков '-', которые не могут идти подряд
        // может содержать 1 пару скобок '(' и ')' , причем если она есть, то она расположена левее знаков '-'
        // номер не содержит букв
        // скобки внутри содержат четко 3 цифры
//        System.out.println("123 is: " + "123".matches("[0-9]{3}"));   // true
//        System.out.println("(123)".matches("[0-9]{3}"));   // false
//
//
//        // номер заканчивается на цифру
//        System.out.println("___   ___   ___");
//        String[] reg = new String[]{".*^[a-z]+$", // false
//                "^[a-z]+$", // false
//                "^\\w+$", // true
//                "[^a-z]", // false
//                ".*[0-9]", // true
//                "[0-9]{3}$", // false
//                ".*[0-9]{3}$", // true
//        };
//        System.out.println("String is abc for .*^[a-z]+$: " + "abc".matches(".*^[a-z]+$"));
//        System.out.println("String is: abc123...");
//        for (String item : reg) {
//            System.out.println("for " + item + ": " + "abc123".matches(item));
//        }
    }

//        if(telNumber.startsWith("+")){ // 12numbers
//        }

//        Pattern p = Pattern.compile("");
//        Matcher m = p.matcher(telNumber);
//        return m.matches();
//        return telNumber.matches(" ");
}
