package z_DateTime;

/* 
Buon Compleanno!
*/

import java.time.LocalDate;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

// Реализуй метод getWeekdayOfBirthday.
//Метод должен возвращать день недели на итальянском языке, в который будет (или был) день рождения в определенном году.
//Пример формата дат смотри в методе main.
//
//Пример:
//1) Для "30.05.1984" и "2015" метод должен вернуть: sabato
//2) Для "1.12.2015" и "2016" метод должен вернуть: gioved?

//Выполни задание, используя Java 8 DateTime API.

// https://javarush.ru/tasks/com.javarush.task.task40.task4009#discussion
public class DartaAPIJava8_4009 {
    public static void main(String[] args) {
        System.out.println(getWeekdayOfBirthday("30.05.1984", "2015"));
    }

    public static String getWeekdayOfBirthday(String birthday, String year) {
        //напишите тут ваш код
        DateTimeFormatter formatterBrt=DateTimeFormatter.ofPattern("d.M.yyyy", Locale.ITALIAN);
        LocalDate localDate = LocalDate.parse(birthday,formatterBrt);
        localDate = localDate.with(Year.parse(year));

        return DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.ITALIAN).format(localDate).split(" ")[0];
    }
}
