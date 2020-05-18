package z_DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/*
Работа с датами
*/
// https://javarush.ru/tasks/com.javarush.task.task40.task4007#discussion
public class ShowDateAndTime_4007 {
    public static void main(String[] args) throws ParseException {
        printDate("21.4.2014 15:56:45");
        System.out.println();
        printDate("21.4.2014");
        System.out.println();
        printDate("17:33:40");
    }

    public static void printDate(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d.M.y");
        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat("H:m:s");
        Calendar calendar = Calendar.getInstance();
        if (date.contains(" ")) {
            String[] dateParts = date.split(" ");
            calendar.setTime(simpleDateFormat.parse(dateParts[0]));
            printLocalDate(calendar);
            calendar.setTime(simpleTimeFormat.parse(dateParts[1]));
            printLocalTime(calendar);
        } else if (date.contains(".")) {
            calendar.setTime(simpleDateFormat.parse(date));
            printLocalDate(calendar);
        } else if (date.contains(":")) {
            calendar.setTime(simpleTimeFormat.parse(date));
            printLocalTime(calendar);
        }
    }

    private static void printLocalDate(Calendar calendar) {
        System.out.println("День: " + calendar.get(Calendar.DATE));
        System.out.println("День недели: " + ((calendar.get(Calendar.DAY_OF_WEEK) - 1) == 0 ? 7
                : calendar.get(Calendar.DAY_OF_WEEK) - 1));
        System.out.println("День месяца: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("День года: " + calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("Неделя месяца: " + calendar.get(Calendar.WEEK_OF_MONTH));
        System.out.println("Неделя года: " + calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("Месяц: " + (calendar.get(Calendar.MONTH) + 1));
        System.out.println("Год: " + calendar.get(Calendar.YEAR));
    }

    private static void printLocalTime(Calendar calendar) {
        System.out.println("AM или PM: " + (calendar.get(Calendar.AM_PM) == 0 ? "AM" : "PM"));
        System.out.println("Часы: " + calendar.get(Calendar.HOUR));
        System.out.println("Часы дня: " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("Минуты: " + calendar.get(Calendar.MINUTE));
        System.out.println("Секунды: " + calendar.get(Calendar.SECOND));
    }
}

// https://stackoverflow.com/questions/29227153/java-calendar-setfirstdayofweek-not-working
// Он должен в качестве параметра принимать дату (в одном из 3х форматов) и выводить ее в консоль в соответствии с примером:
//1) Для "21.4.2014 15:56:45" вывод должен быть:
//День: 21
//День недели: 1
//День месяца: 21
//День года: 111
//Неделя месяца: 4
//Неделя года: 17
//Месяц: 4
//Год: 2014
//AM или PM: PM
//Часы: 3
//Часы дня: 15
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
//
//Используй класс Calendar.
