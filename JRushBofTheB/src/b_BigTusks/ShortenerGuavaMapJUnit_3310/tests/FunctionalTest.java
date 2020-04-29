package b_BigTusks.UrlShortener_3310.tests;

import b_BigTusks.UrlShortener_3310.Shortener;
import b_BigTusks.UrlShortener_3310.strategy.*;
import org.junit.Assert;
import org.junit.Test;


public class FunctionalTest {
    public void testStorage(Shortener shortener)  {
        String str1 = "Java one Love";
        String str2 = "Android C# JS TypeScript";
        String str3 = "Java one Love";

        // 14.4.2. Получать и сохранять идентификаторы для всех трех строк с помощью shorten'er.
        Long id1 = shortener.getId(str1);
        Long id2 = shortener.getId(str2);
        Long id3 = shortener.getId(str3);

        // 14.4.3. Проверять, что идентификатор для 2 строки не равен идентификатору для 1 и 3 строк.
        Assert.assertNotEquals(id2, id1);
        Assert.assertNotEquals(id2, id3);

        // 14.4.4. Проверять, что идентификаторы для 1 и 3 строк равны
        Assert.assertEquals(id1, id3);

        // 14.4.3. Проверять, что идентификатор для 2 строки не равен идентификатору для 1 и 3 строк.
        String testedStr1 = shortener.getString(id1);
        String testedStr2 = shortener.getString(id2);
        String testedStr3 = shortener.getString(id3);

        // 14.4.6. Проверять, что строки, полученные в предыдущем пункте, эквивалентны оригинальным.
        Assert.assertEquals(str1, testedStr1);
        Assert.assertEquals(str2, testedStr2);
        Assert.assertEquals(str3, testedStr3);
    }

    @Test
    public void testHashMapStorageStrategy() {
        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
        Shortener shortener = new Shortener(hashMapStorageStrategy);
        testStorage(shortener);
    }

    @Test
    public void testOurHashMapStorageStrategy()
    {
        OurHashMapStorageStrategy ourHashMapStorageStrategy = new OurHashMapStorageStrategy();
        Shortener shortener = new Shortener(ourHashMapStorageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testFileStorageStrategy()
    {
        FileStorageStrategy fileStorageStrategy = new FileStorageStrategy();
        Shortener shortener = new Shortener(fileStorageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testHashBiMapStorageStrategy()
    {
        HashBiMapStorageStrategy hashBiMapStorageStrategy = new HashBiMapStorageStrategy();
        Shortener shortener = new Shortener(hashBiMapStorageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testDualHashBidiMapStorageStrategy()
    {
        DualHashBidiMapStorageStrategy dualHashBidiMapStorageStrategy = new DualHashBidiMapStorageStrategy();
        Shortener shortener = new Shortener(dualHashBidiMapStorageStrategy);
        testStorage(shortener);
    }
    @Test
    public void testOurHashBiMapStorageStrategy()
    {
        OurHashBiMapStorageStrategy ourHashBiMapStorageStrategy = new OurHashBiMapStorageStrategy();
        Shortener shortener = new Shortener(ourHashBiMapStorageStrategy);
        testStorage(shortener);
    }
}
