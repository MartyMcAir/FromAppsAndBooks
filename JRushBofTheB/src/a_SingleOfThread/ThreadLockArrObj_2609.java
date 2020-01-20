package a_SingleOfThread;

/* 
Распределение элементов по корзинам с собственным локом
*/
// https://javarush.ru/tasks/com.javarush.task.task26.task2609#discussion
// В синхронизированных блоках используй нужный лок.
// не доконца понял
public class ThreadLockArrObj_2609 {
    private static final int NUMBER_LOCKS = 12;
    private final Node[] buckets;
    private final Object[] locks;

    static class Node {
        public Node next;
        public Object key;
        public Object value;
    }

    public ThreadLockArrObj_2609(int numberBuckets) {
        buckets = new Node[numberBuckets];
        locks = new Object[NUMBER_LOCKS];
        for (int i = 0; i < NUMBER_LOCKS; i++) {
            locks[i] = new Object();
        }
    }

    private final int hash(Object key) {
        // abs() - возвращает абсолютное значение аргумента _ модуль числа
        // хэш и получаем остаток от деления его на длину Node[] массива
        return Math.abs(key.hashCode() % buckets.length);
    }

    public Object get(Object key) {
        int hash = hash(key);
//        synchronized (this) {
        // используй lock из массива locks в зависимости от хэша объекта и количества лок объектов.
        synchronized (locks[hash % locks.length]) {
            for (Node m = buckets[hash]; m != null; m = m.next) {
                if (m.key.equals(key)) return m.value;
            }
        }
        return null;
    }

    public void clear() {
        for (int i = 0; i < buckets.length; i++) {
//            synchronized (this) {
            synchronized (locks[i % locks.length]) {
                buckets[i] = null;
            }
        }
    }

    public static void main(String[] args) {

        // Судя по всему это такой способ разбить ограниченное колличество ключей (массив Object[] locks)
        // на неопределённое колличество элементов массива Node[] buckets. В итоге получаеться что
        // в зависимости от хэша каждого объекта класса Node ему соответствует определённый "лок"
        // который расчитывается по тому самому способу через оператор %.

        // можно добавить что деление с остатком(%) здесь используется, потому что остаток всегда меньше делителя,
        // поэтому за границы массива locks выйти никак не получится)
    }
}
