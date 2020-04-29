package b_BigTusks.UrlShortener_3310.strategy;

import java.util.HashMap;
import java.util.Map;

// For Example
// http://hg.openjdk.java.net/jdk7/jdk7/jdk/file/9b8c96f96a0f/src/share/classes/java/util/HashMap.java
// http://coding-geek.com/how-does-a-hashmap-work-in-java/
public class OurHashMapStorageStrategy_My implements StorageStrategy {
    // valya is: В классе OurHashMapStorageStrategy должно присутствовать 6 полей.
    private HashMap<Long, String> data = new HashMap<>();
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;
    private int size, threshold = (int) (DEFAULT_INITIAL_CAPACITY * DEFAULT_LOAD_FACTOR);
    private float loadFactor = DEFAULT_LOAD_FACTOR;
    private Entry[] table = new Entry[DEFAULT_INITIAL_CAPACITY];

    @Override
    public boolean containsKey(Long key) {
        return data.containsKey(key);
    }

    @Override
    public boolean containsValue(String value) {
        return data.containsValue(value);
    }

    @Override
    public void put(Long key, String value) {
        data.put(key, value);
    }

    @Override
    public Long getKey(String value) {
        Long result = null;
        for (Map.Entry<Long, String> pare : data.entrySet()) {
            if (pare.getValue().equals(value)) {
                result = pare.getKey();
                break;
            }
        }

//        Long[] resultLong = new Long[0];
//        AtomicReference<Long> resultAtom = null;
//        data.forEach((k, v) -> {
//            if (v.equals(value))
////                resultLong[0] = k; // можно ток для final or..
//                resultAtom.set(k);
//        });
//        return resultAtom.get();

//        ArrayList<String> list = new ArrayList<>();
//        list.stream()

        return result;
    }

    @Override
    public String getValue(Long key) {
        // внутри мапы Node<K,V>, у которой getValue() - что возвращает key()
        return data.get(key);
    }

    //////////// Additional methods..
    public int hash(Long k) {
        return Long.hashCode(k);
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
