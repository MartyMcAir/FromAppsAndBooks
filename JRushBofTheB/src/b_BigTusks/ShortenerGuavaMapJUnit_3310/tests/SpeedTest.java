package b_BigTusks.ShortenerGuavaMapJUnit_3310.tests;

import b_BigTusks.ShortenerGuavaMapJUnit_3310.Helper;
import b_BigTusks.ShortenerGuavaMapJUnit_3310.Shortener;
import b_BigTusks.ShortenerGuavaMapJUnit_3310.strategy.HashBiMapStorageStrategy;
import b_BigTusks.ShortenerGuavaMapJUnit_3310.strategy.HashMapStorageStrategy;
import org.junit.Test;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SpeedTest {
    // возвращать время в миллисекундах необходимое для получения идентификаторов для всех строк из strings.
    // Идентификаторы должны быть записаны в ids.
    public long getTimeToGetIds(Shortener shortener, Set<String> strings, Set<Long> ids) {
        long start1 = new Date().getTime();
        for (String x : strings) {
            ids.add(shortener.getId(x));
        }
        long finish1 = new Date().getTime();
        return finish1 - start1;
    }

    //  возвращать время в миллисекундах необходимое для получения строк для всех идентификаторов из ids.
    //  Строки должны быть записаны в strings.
    public long getTimeToGetStrings(Shortener shortener, Set<Long> ids, Set<String> strings) {
        long st = System.currentTimeMillis();
        // пробмный Hard core, секты в одну строку..
        for (Iterator<Long> iterator = ids.iterator(); iterator.hasNext(); strings.add(shortener.getString(iterator.next()))) {
        }
        return System.currentTimeMillis() - st;
    }

    @Test
    public void testHashMapStorage() {
        Shortener shortener1 = new Shortener(new HashMapStorageStrategy());
        Shortener shortener2 = new Shortener(new HashBiMapStorageStrategy());

        // Генерировать с помощью Helper 10000 строк и помещать их в сет со строками, назовем его origStrings.
        Set<String> origStrings = new HashSet<>();
        for (int i = 0; i < 10_000; i++) {
            String s = Helper.generateRandomString();
            origStrings.add(s);
        }

        Set<Long> ids1 = new HashSet<>();
        Set<Long> ids2 = new HashSet<>();
        // 15.4.3. Получать время получения идентификаторов для origStrings
        // (вызывать метод getTimeToGetIds для shortener1, а затем для shortener2).
        long timeToGetIds1 = getTimeToGetIds(shortener1, origStrings, ids1);
        long timeToGetIds2 = getTimeToGetIds(shortener2, origStrings, ids2);

        // 15.4.4. Проверять с помощью junit, что время, полученное в предыдущем пункте для shortener1 больше,
        // чем для shortener2.
        assertTrue(timeToGetIds1 > timeToGetIds2);

        // 15.4.5. Получать время получения строк (вызывать метод getTimeToGetStrings для shortener1 и shortener2).
        long timeToGetStrings1 = getTimeToGetStrings(shortener1, ids1, origStrings);
        long timeToGetStrings2 = getTimeToGetStrings(shortener2, ids2, origStrings);

        // 15.4.6. Проверять с помощью junit, что время, полученное в предыдущем пункте для shortener1
        // примерно равно времени для shortener2.
        assertEquals(timeToGetStrings1, timeToGetStrings2, 30);
    }
}
