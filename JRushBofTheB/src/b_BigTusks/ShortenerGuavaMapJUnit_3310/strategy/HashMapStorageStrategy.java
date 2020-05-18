package b_BigTusks.ShortenerGuavaMapJUnit_3310.strategy;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorageStrategy implements StorageStrategy {
    private HashMap<Long, String> data = new HashMap<>();

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
        if (!data.containsValue(value))
            return 0L;

        for (Map.Entry<Long, String> entry : data.entrySet()) {
            if (entry.getValue().equals(value))
                return entry.getKey();
        }
        return 0L;
    }

    @Override
    public String getValue(Long key) {
        return data.get(key);
    }
}
