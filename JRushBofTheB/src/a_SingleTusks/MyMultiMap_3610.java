package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() { // возвращать количество значений
        //напишите тут ваш код
        int counter = 0;
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
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
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
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
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
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