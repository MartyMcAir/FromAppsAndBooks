package b_BigTusks.UrlShortener_3310.strategy;

// For Example
// http://hg.openjdk.java.net/jdk7/jdk7/jdk/file/9b8c96f96a0f/src/share/classes/java/util/HashMap.java
// http://coding-geek.com/how-does-a-hashmap-work-in-java/
public class OurHashMapStorageStrategy_V3 implements StorageStrategy {
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];
    int size;
    int threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    float loadFactor = DEFAULT_LOAD_FACTOR;

    @Override
    public boolean containsKey(Long key) {
        return getValue(key) != null;
    }

    @Override
    public boolean containsValue(String value) {
//        if (value == null) return false;
        
//        Entry[] entries = table;   // присваиваем  др. ссылкена массив, что бы..!?
        for (int i = 0; i < table.length; i++)        // перебираем entries
            // если текущ элемент entries не null, тогда преключаемся на след элемент e.next
            for (Entry e = table[i]; e != null; e = e.next)
                if (value.equals(e.value)) // есои найдено совпадение..
                    return true;

        return false;


    }

    @Override
    public void put(Long key, String value) {
        int hash = hash((long) key.hashCode());
        int i = indexFor(hash, table.length);
        // т.е. из хэшкода генерится, хэш номер нахлождения в таблице table[i] wtf!?
        for (Entry e = table[i]; e != null; e = e.next) {
            Object k;
            // если они в талице равны то заменяем oldValue - новым value
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                String oldValue = e.value;
                e.value = value;
            }
        }
        addEntry(hash, key, value, i);
    }

    @Override
    public Long getKey(String value) {
//        for (Map.Entry<Long, String> pare : data.entrySet()) {
//            if (pare.getValue().equals(value))
//                return pare.getKey();
//        }
        // по сути тож самое но перебираем table
//        for (int i = 0; i < table.length; i++)
//            if (table[i].equals(value))
//                return table[i].getKey();

        // У объекта типа Shortener созданного на основе OurHashMapStorageStrategy некорректно работает метод getString.
        // - у вали опечатка
        // Or not my _ т.е. еще надо перебирать внутренности Entry..
        Entry[] tab = table;
        for (int i = 0; i < tab.length; i++)
            for (Entry e = tab[i]; e != null; e = e.next)
                if (e.getValue().equals(value)) return e.getKey();

        return null;
    }

    @Override
    public String getValue(Long key) {
        if (this.containsKey(key))
            return getEntry(key).getValue();

        return null;
    }

    //////////// Additional methods..
    public int hash(Long h) { // битовая магия
        // This function ensures that hashCodes that differ only by
        // constant multiples at each bit position have a bounded
        // number of collisions (approximately 8 at default load factor).
        h ^= (h >>> 20) ^ (h >>> 12);
        return (int) (h ^ (h >>> 7) ^ (h >>> 4));
    }

    public int indexFor(int hash, int length) {
        return 0;
    }

    public Entry getEntry(Long key) {
        int hash = (key == null) ? 0 : hash((long) key.hashCode());
        for (Entry e = table[indexFor(hash, table.length)];
             e != null;
             e = e.next) {
            Object k;
            if (e.hash == hash &&
                    ((k = e.key) == key || (key != null && key.equals(k))))
                return e;
        }
        return null;
    }

    public void resize(int newCapacity) {
    }

    public void transfer(Entry[] newTable) {
    }

    public void addEntry(int hash, Long key, String value, int bucketIndex) {

    }

    public void createEntry(int hash, Long key, String value, int bucketIndex) {

    }
}
