package a_SingleTusks;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

/* 
Добрая Зинаида и летние каникулы
*/
// https://javarush.ru/tasks/com.javarush.task.task08.task0816
//Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: "фамилия" - "дата рождения".
//        Удалить из словаря всех людей, родившихся летом.
//
//        Требования:
//        •	Программа не должна выводить текст на экран.
//        •	Программа не должна считывать значения с клавиатуры.
//        •	Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String,
//        Date состоящий из 10 записей.
//        •	Метод removeAllSummerPeople() должен удалять из словаря всех людей, родившихся летом.
public class DateInSummer_0816 {
    public static HashMap<String, Date> createMap() throws ParseException {
        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", df.parse("JUNE 1 1980"));
        //напишите тут ваш код

        map.put("Shwartzneger", df.parse("JANUARY 2 1982"));
        map.put("Kandalizarice", df.parse("FEBRUARY 3 1983"));
        map.put("Timberlake", df.parse("MARCH 4 1984"));
        map.put("Higchcock", df.parse("APRIL 5 1985"));
        map.put("Alkapone", df.parse("JULY 6 1986"));
        map.put("Timkuk", df.parse("AUGUST 7 1987"));
        map.put("Enshtain", df.parse("SEPTEMBER 8 1988"));
        map.put("Sokrat", df.parse("DECEMBER 9 1989"));
        map.put("Skyrfoll", df.parse("NOVEMBER 10 1990"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) throws ParseException {
        //напишите тут ваш код
        ArrayList<String> listKey = new ArrayList<String>();
        Date d;
//        Calendar cal = Calendar.getInstance();
//        for (Map.Entry<String, Date> item : map.entrySet()) {
//            d = item.getValue();
//            cal.setTime(d); // set Date()
//            int month = cal.get(Calendar.MONTH);
//            if (month >= 5 && month <= 7) { // >5 9< _ 5 -7 прошло _
//                listKey.add(item.getKey());
////                map.remove(item.getKey()); // err ConcurrentModificationException
////                System.out.println(d.toString());
//            }
//        }
//
//        String tmp;
//        for (String st : listKey) {
//            tmp = st;
//            map.remove(tmp);
//        }
        map.values().removeIf(item -> (item.getMonth() == 5 | item.getMonth() == 6 | item.getMonth() == 7));
        System.out.println(map);

    }

    public static void main(String[] args) throws ParseException {
        Locale lc = Locale.US;
        DateFormatSymbols dfs = DateFormatSymbols.getInstance(lc);
//        System.out.println(Arrays.toString(dfs.getMonths()).toUpperCase());
        // [JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER, ]

        System.out.println(createMap());
        removeAllSummerPeople(createMap());
    }
}
