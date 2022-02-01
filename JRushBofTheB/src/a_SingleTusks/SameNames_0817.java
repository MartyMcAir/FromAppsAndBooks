package a_SingleTusks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Нам повторы не нужны
*/
// https://javarush.ru/tasks/com.javarush.task.task08.task0817
//Создать словарь (Map<String, String>) занести в него десять записей по принципу "фамилия" - "имя".
//        Удалить людей, иеющих одинаковые иммена.
//
//        Требования:
//        •	Программа не должна выводить текст на экран.
//        •	Программа не должна считывать значения с клавиатуры.
//        •	Метод createMap() должен создавать и возвращать словарь Map с типом элементов String,
//        String состоящих из 10 записей.
//        •	Метод removeTheFirstNameDuplicates() должен удалять из словаря всех людей, имеющие одинаковые имена.
//        •	Метод removeTheFirstNameDuplicates() должен вызывать метод removeItemFromMapByValue().
public class SameNames_0817 {
    public static void main(String[] args) {
        removeTheFirstNameDuplicates(createMap());
    }

    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("Pearse", "Cris");
        map.put("Titan", "Djon");
        map.put("Venus", "Bob");
        map.put("Pluton", "Djonatan");
        map.put("Nebula", "Gomer");
        map.put("Gomora", "Piter");
        map.put("Mercury", "Cris");
        map.put("Mars", "Crumb");
        map.put("Earth", "Cris");
        map.put("Skin", "Piter");
        return map; // 3 Cris _ 2 Peter
    }

    public static void removeTheFirstNameDuplicates(Map<String, String> map) {
        //напишите тут ваш код
        // создаем копию значений
        ArrayList<String> list = new ArrayList<String>();
        ArrayList<String> duplicateList = new ArrayList<String>();
        for (Map.Entry<String, String> p : map.entrySet()) {
            list.add(p.getValue());
        }

        System.out.println("original: "+map);
        int count = 0;
        String tmp;

//        HashMap<String, String> copy = new HashMap<String, String>(map);
//        for(Map.Entry<String, String> item : copy.entrySet()){
//            tmp = item.getValue();
//            for(Map.Entry<String, String> item2 : map.entrySet()){
//                if(tmp.equals(item2.getValue())){
//                    count++;
//                    if(count>1){
//                        count++;
////                        removeItemFromMapByValue(map, tmp); // ConcurrentModificationException
//                    }
//                }
//            }
//            count=0;
//        }

        HashMap<String, Integer> counters = new HashMap<String, Integer>();
        for (Map.Entry<String, String> item : map.entrySet()) {
            counters.put(item.getValue(), (counters.getOrDefault(item.getValue(), 0) + 1));
        }

        for (Map.Entry<String, Integer> item2 : counters.entrySet()) {
            if (item2.getValue() > 1) {
                removeItemFromMapByValue(map, item2.getKey());
            }
        }
//
//        for (Map.Entry<String, String> item : map.entrySet()) {
//            tmp = item.getValue();
//            for (String item2 : list) {
//                if (tmp.equals(item2)) {
//                    count++;
//                    if (count > 1) { // map.remove(*).. - ConcurrentModificationException
//                        // при for(int i ... ) тоже ConcurrentModificationException
////                        map.values().removeIf((value) -> (value.equals(item2))); // ConcurrentModificationException
//                        duplicateList.add(tmp);
//                        count = 0;
//                    }
//                }
//            }
//            count = 0;
//        }


//        Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();
//        Iterator<String> it2 = duplicateList.iterator(); // при Iterator в другом Iterator - ConcurrentModificationException


        // Work
//        for (int i = 0; i < duplicateList.size(); i++) {
//            String tmp2 = duplicateList.get(i);
//
//            removeItemFromMapByValue(map, tmp2); // тоже работает и ConcurrentModificationException не вылетает
//
////            map.values().removeIf((value) -> (value.equals(tmp2))); // работает
//
////            while (it.hasNext()) {
////                Map.Entry<String, String> pair = it.next();
////                if (pair.getValue().equals(tmp)) {
////                    map.remove(pair.getKey()); // ConcurrentModificationException
////                }
////            }
//        }

//        System.out.println("duplicateList: "+duplicateList);
        System.out.println("res: " + map);
    }

    public static void removeItemFromMapByValue(Map<String, String> map, String value) {
        // т.е. по скольку нельзя одновременно перебирать и изменять то делают копию
        // которую перебирают а удаляют из оригинала..
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }
}
