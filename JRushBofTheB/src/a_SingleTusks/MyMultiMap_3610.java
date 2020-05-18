package a_SingleTusks;

import java.io.Serializable;
import java.util.*;

// https://javarush.ru/tasks/com.javarush.task.task36.task3610#discussion
// по методу remove следует читать как:
// Если после удаления элемента получился лист размером ноль элементов - удали такую пару ключ : значение.

// Амиго, иногда существующих в Java коллекций недостаточно. Тогда можно либо взять стороннюю реализацию, например,
// Google Guava или Apache Commons, либо реализовать свою структуру данных. Сегодня у тебя есть уникальная возможность
// испытать свои силы и написать часть своей структуры данных.
//
//Наша структура данных называется MyMultiMap. Она параметризована дженериками, наследуется от HashMap, и реализует
// интерфейсы Cloneable, Serializable. Особенность нашей мапы будет в том, что конструктор принимает число типа int
// repeatCount - это количество, сколько значений может хранится по одному ключу.
//
//Реализуй методы:
//1) int size() - должен возвращать количество значений в нашей коллекции.
//2) V put(K key, V value) - должен добавить элемент value по ключу key. Если в мапе такой ключ уже есть, и количество
// значений по этому ключу меньше, чем repeatCount - то добавь элемент value в конец листа в объекте map.
// Если по такому ключу количество значений равняется repeatCount - то удали из листа в объекте map элемент с
// индексом ноль, и добавь в конец листа value. Метод должен возвращать значение последнего добавленного элемента по
// ключу key (но не значение, которое мы сейчас добавляем). Если по ключу key значений еще нет - верни null.
//3) V remove(Object key) - должен удалить элемент по ключу key. Если по этому ключу хранится несколько элементов -
// должен удаляться элемент из листа с индексом ноль. Если по какому-то ключу хранится лист размером ноль элементов -
// удали такую пару ключ : значение. Метод должен возвращать элемент, который ты удалил. Если в мапе нет ключа key -
// верни null.
//4) Set<K> keySet() - должен вернуть сет всех ключей, которые есть в мапе map.
//5) Collection<V> values() - должен вернуть ArrayList<V> всех значений. Порядок значений в листе не имеет значения.
//6) boolean containsKey(Object key) - должен вернуть true, если в мапе присутствует ключ key, иначе вернуть false.
//7) boolean containsValue(Object value) - должен вернуть true, если в мапе присутствует значение value, иначе вернуть false.
public class MyMultiMap_3610<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new MyMultiMap_3610<>(3);
        for (int i = 0; i < 7; i++) {
            map.put(i, i);
        }
        map.put(5, 56);
        map.put(5, 57);
        System.out.println(map.put(5, 58));             // Expected: 57

        System.out.println(map);                        // Expected: {0=0, 1=1, 2=2, 3=3, 4=4, 5=56, 57, 58, 6=6}
        System.out.println(map.size());                 // Expected: size = 9

        System.out.println(map.remove(5));              // Expected: 56
        System.out.println(map);                        // Expected: {0=0, 1=1, 2=2, 3=3, 4=4, 5=57, 58, 6=6}
        System.out.println(map.size());                 // Expected: size = 8

        System.out.println(map.keySet());               // Expected: [0, 1, 2, 3, 4, 5, 6]
        System.out.println(map.values());               // Expected: [0, 1, 2, 3, 4, 57, 58, 6]

        System.out.println(map.containsKey(5));         // Expected: true
        System.out.println(map.containsValue(57));      // Expected: true
        System.out.println(map.containsValue(7));       // Expected: false
    }


    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap_3610(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() { // возвращать количество значений
        //напишите тут ваш код
        int counter = 0;
        for (Entry<K, List<V>> entry : map.entrySet()) {
            List<V> value = entry.getValue();
            counter += value.size();
        }
        return counter;
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        if (!map.containsKey(key)) { // если в мапе такого ключа нет
            List<V> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
            return null; // предыдущего не было значит null
        } else {
            List<V> list = map.get(key);
            int size = list.size();
//            if (size < repeatCount)
//                list.add(value);
            if (size == repeatCount)
                list.remove(0);
            V v = list.get(list.size() - 1);
            list.add(value);
            return v; // вернет последнее предыдущее добавленное
        }
    }

    @Override
    public V remove(Object key) {
        if (!map.containsKey(key))
            return null;

        V removedObject = null;
        List<V> valuesByKey = map.get(key);

        if (valuesByKey != null && valuesByKey.size() > 0) {
            removedObject = valuesByKey.get(0);
            valuesByKey.remove(0);
        }

        if (valuesByKey.isEmpty()) {
            map.remove(key);
        } else map.put((K) key, valuesByKey);

        for (Entry<K, List<V>> entry : map.entrySet()) {
            if (entry.getValue().isEmpty())
                map.remove(entry.getKey());
        }
        return removedObject;
    }

    public V removeMy(Object key) { // тоже работает но валя против
        //напишите тут ваш код
//        if (!map.containsKey(key)) // что бы ниже в коде не вылетал NPE в случае пустой мапы
//            return null; // мапе нет ключа key - верни null.

        V v = null;
        if (map.containsKey(key)) {
            List<V> list = map.get(key);
            if (list.size() > 0) { // удаляться элемент из листа с индексом ноль.
                v = list.get(0);
                list.remove(0);
            } else map.remove(key);
        }
        return v;
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        List<V> list = new ArrayList<>();
        for (Entry<K, List<V>> entry : map.entrySet()) {
            List<V> value = entry.getValue();
            for (V v : value)
                list.add(v);
        }
        return list;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
//        if (containsKey(key))
//            return true;
//        return false;
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
//        return map.containsValue(value);
//        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
//            List<V> values = entry.getValue();
//            if (values.contains(value))
//                return true;
//        }
//        return false;

        return this.values().contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}