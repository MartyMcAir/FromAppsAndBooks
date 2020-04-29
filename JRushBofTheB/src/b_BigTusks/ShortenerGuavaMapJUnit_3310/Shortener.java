package b_BigTusks.UrlShortener_3310;


import b_BigTusks.UrlShortener_3310.strategy.StorageStrategy;

public class Shortener {
    private Long lastId = 0L;
    private StorageStrategy storageStrategy;

    public Shortener(StorageStrategy storageStrategy) {
        this.storageStrategy = storageStrategy;
    }

    public synchronized Long getId(String string) {
        if (this.storageStrategy.containsValue(string)) {
            return this.storageStrategy.getKey(string);
        } else {
            this.lastId++;
            storageStrategy.put(this.lastId, string);
            return this.lastId;
        }
    }

    public synchronized Long getIdMy(String string) {
        Long lastIdOld = this.lastId;
        if (!storageStrategy.containsValue(string)) {
            storageStrategy.put(++this.lastId, string);
        }
        return lastIdOld;
    }

    public synchronized String getString(Long id) {
        return storageStrategy.getValue(id);
    }
}
