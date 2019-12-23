package a_SingleOfRegex;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
// https://javarush.ru/tasks/com.javarush.task.task22.task2208
// Сформируй часть запроса WHERE используя StringBuilder.
//Если значение null, то параметр не должен попадать в запрос.
//
//Пример:
//{name=Ivanov, country=Ukraine, city=Kiev, age=null}
//
//Результат:
//name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'
//
//Требования:
//•	Метод getQuery должен принимать один параметр типа Map.
//•	Метод getQuery должен иметь тип возвращаемого значения String.
//•	Метод getQuery должен быть статическим.
//•	Метод getQuery должен возвращать строку сформированную по правилам описанным в условии задачи.
public class RegexDbRequest_2208 {
    // SELECT * FROM student WHERE name = 'Ivanov' and country = 'Ukraine' and city = 'Kiev'
    public static void main(String[] args) {
        Map<String, String> map = new LinkedHashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        System.out.println(map);
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        if (params.size() < 1) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String key = "", value = "";
        boolean flag = false;
        for (Map.Entry<String, String> pare : params.entrySet()) {
            key = pare.getKey();
            value = pare.getValue();
            if (flag & key != null & value != null) {
                sb.append(" and "); // добавляем add с учетом что текущие данные не null
            }
            if (key != null & value != null) {
                sb.append(key + " = '" + value + "'");
                flag = true; // даём знать что предыдущая интерация была без null, а значит можно добавить add
            }
        }
        return sb.toString();
    }
}
