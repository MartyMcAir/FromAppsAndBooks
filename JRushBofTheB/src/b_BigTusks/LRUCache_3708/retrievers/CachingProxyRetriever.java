package b_BigTusks.LRUCache_3708.retrievers;

import b_BigTusks.LRUCache_3708.cache.LRUCache;
import b_BigTusks.LRUCache_3708.storage.Storage;

//import com.mysql.cj.util.LRUCache;

public class CachingProxyRetriever implements Retriever {
    Storage storage;
    OriginalRetriever originalRetriever;
    LRUCache lruCache = new LRUCache(10);

    public CachingProxyRetriever(Storage storage) {
        this.storage = storage;
        this.originalRetriever = new OriginalRetriever(this.storage);
    }

    @Override
    public Object retrieve(long id) { // My
        Object o = lruCache.find(id);
        if (o != null) // если в кэше найдено
            return o;

        Object newObject = originalRetriever.retrieve(id); // не понял почему NPE
        lruCache.set(id, newObject); // кладем в кэш
        return newObject;
    }

    public Object retrieveOth(long id) { // по моему неверно
        Object o;
        if ((o = lruCache.find(id)) == null) {
            o = originalRetriever.retrieve(id);
            lruCache.set(id, o);
        }
        return o;
    }

}
