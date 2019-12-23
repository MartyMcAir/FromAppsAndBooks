package a_SingleOfRegex;

/* 
Найти подстроку
*/
// https://javarush.ru/tasks/com.javarush.task.task22.task2202
// Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
//которое следует после 4-го пробела.
//
//Пример:
//"JavaRush - лучший сервис обучения Java."
//
//Результат:
//"- лучший сервис обучения"
//
//Пример:
//"Амиго и Диего лучшие друзья!"
//
//Результат:
//"и Диего лучшие друзья!"
//
//На некорректные данные бросить исключение TooShortStringException (сделать исключением).
//
//Требования:
//•	Класс TooShortStringException должен быть потомком класса RuntimeException.
//•	Метод getPartOfString должен принимать строку в качестве параметра.
//•	В случае, если в метод getPartOfString были переданы некорректные данные, должно возникнуть исключение TooShortStringException.
//•	Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
// которое следует после 4-го пробела.
public class RegexSplitFirst_2202 {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));

        System.out.println(getPartOfString("JavaRush - лучший сервис"));
//        System.out.println(getPartOfString("Амиго и Диего лучшие")); // Exception
    }

    public static String getPartOfString(String string) {
//        StringBuilder sb = new StringBuilder();
//        if (string == null || string.split(" ").length < 5) {
//            throw new TooShortStringException("Sting is too short..");
//        } else {
//            int n = 5;
//            for (int i = 1; i < n; i++) {
//                sb.append(string.split(" ")[i]);
//                if (i < n - 1) sb.append(" ");
//            }
//        }
//        return sb.toString();

        String[] arrSt = string.split("\\s");
        if (arrSt.length < 5) throw new TooShortStringException("is to short..");
//        return string.substring(string.indexOf(" ") + 1, string.indexOf(arrSt[4]) + arrSt[arrSt.length - 1].length());
//        return string.substring(string.indexOf(" ") + 1, string.length());
//        return string.substring(string.indexOf(" ") + 1);
        Object obj = string.split("\\s").length < 5 ? new TooShortStringException("is to short..") :
                string.substring(string.indexOf(" ") + 1);
        return (String) obj;
    }

    public static class TooShortStringException extends RuntimeException {
        public TooShortStringException(String message) {
            super(message);
        }
    }
}
