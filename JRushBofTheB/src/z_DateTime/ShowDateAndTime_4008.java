package z_DateTime;

/* 
Работа с Java 8 DateTime API
*/

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.WeekFields;
import java.util.Locale;

// https://javarush.ru/tasks/com.javarush.task.task40.task4008#discussion
public class ShowDateAndTime_4008 {
    public static void main(String[] args) {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("d.M.y");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("H:m:s");
        if (date.contains(" ")) {
            String[] dateParts = date.split(" ");
            LocalDate localDate = LocalDate.parse(dateParts[0], dateFormatter);
            LocalTime localTime = LocalTime.parse(dateParts[1], timeFormatter);
            printLocalDate(localDate);
            printLocalTime(localTime);
        } else if (date.contains(".")) {
            LocalDate localDate = LocalDate.parse(date, dateFormatter);
            printLocalDate(localDate);
        } else if (date.contains(":")) {
            LocalTime localTime = LocalTime.parse(date, timeFormatter);
            printLocalTime(localTime);
        }
    }

    private static void printLocalDate(LocalDate localDate) {
        System.out.println("День: " + localDate.get(ChronoField.DAY_OF_MONTH));
        System.out.println("День недели: " + localDate.getDayOfWeek().getValue());
        System.out.println("День месяца: " + localDate.getDayOfMonth());
        System.out.println("День года: " + localDate.getDayOfYear());
        System.out.println("Неделя месяца: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfMonth()));
        System.out.println("Неделя года: " + localDate.get(WeekFields.of(Locale.getDefault()).weekOfYear()));
        System.out.println("Месяц: " + localDate.getMonthValue());
        System.out.println("Год: " + localDate.getYear());
    }

    private static void printLocalTime(LocalTime dateTime) {
        System.out.println("AM или PM: " + (dateTime.get(ChronoField.AMPM_OF_DAY) == 0 ? "AM" : "PM"));
        System.out.println("Часы: " + dateTime.get(ChronoField.HOUR_OF_AMPM));
        System.out.println("Часы дня: " + dateTime.getHour());
        System.out.println("Минуты: " + dateTime.getMinute());
        System.out.println("Секунды: " + dateTime.getSecond());
    }
}

// Выполни задание, используя Java 8 DateTime API.
//Реализуй метод printDate(String date).
//Он должен в качестве параметра принимать дату (в одном из 3х форматов)
//и выводить ее в консоль в соответствии с примером:
//
//1) Для "9.10.2017 5:56:45" вывод должен быть:
//День: 9
//День недели: 1
//День месяца: 9
//День года: 282
//Неделя месяца: 3
//Неделя года: 42
//Месяц: 10
//Год: 2017
//AM или PM: PM
//Часы: 5
//Часы дня: 5
//Минуты: 56
//Секунды: 45
//
//2) Для "21.4.2014":
//День: 21
//День недели: 1
//День месяца: 21
//День года: 111
//Неделя месяца: 4
//Неделя года: 17
//Месяц: 4
//Год: 2014
//
//3) Для "17:33:40":
//AM или PM: PM
//Часы: 5
//Часы дня: 17
//Минуты: 33
//Секунды: 40