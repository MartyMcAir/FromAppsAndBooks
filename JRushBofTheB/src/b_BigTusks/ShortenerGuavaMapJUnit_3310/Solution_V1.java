package b_BigTusks.ShortenerGuavaMapJUnit_3310;


import b_BigTusks.ShortenerGuavaMapJUnit_3310.strategy.HashMapStorageStrategy;
import b_BigTusks.ShortenerGuavaMapJUnit_3310.strategy.OurHashMapStorageStrategy;
import b_BigTusks.ShortenerGuavaMapJUnit_3310.strategy.StorageStrategy;

import java.io.IOException;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

// https://javarush.ru/quests/lectures/questcollections.level06.lecture15 -
public class Solution_V1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        HashMapStorageStrategy hashMapStorageStrategy = new HashMapStorageStrategy();
//        for (int i = 0; i < 1000; i++) {
//
//        }
        testStrategy(new HashMapStorageStrategy(), 10_000);
        System.out.println("=========================================================================================");
        testStrategy(new OurHashMapStorageStrategy(), 10_000);
        System.out.println("=========================================================================================");



//        testStrategy(new OurHashBiMapStorageStrategy(), 10_000);
//        System.out.println("=========================================================================================");
//        testStrategy(new HashBiMapStorageStrategy(), 10_000);
//        System.out.println("=========================================================================================");
//        testStrategy(new DualHashBidiMapStorageStrategy(), 10_000);
//        System.out.println("=========================================================================================");
//        testStrategy(new FileStorageStrategy(), 3);
//        System.out.println("=========================================================================================");
    }

    public static Set<Long> getIds( Shortener shortener, Set<String> strings) throws IOException, ClassNotFoundException {
        Set<Long> result = new HashSet<>();
        for (String item : strings)
            result.add(shortener.getId(item));
        return result;
    }

    public static Set<String> getStrings( Shortener shortener, Set<Long> keys) throws IOException, ClassNotFoundException {
        Set<String> result = new HashSet<>();
        for (Long item : keys)
            result.add(shortener.getString(item));
        return result;
    }

    public static void testStrategy(StorageStrategy strategy, long elementsNumber) throws IOException, ClassNotFoundException {
        Helper.printMessage(strategy.getClass().getSimpleName()); // выводимимя класса Стратегии

        Set<String> setRndStrings = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++)  // генерим указанное кол-во рандомных строк
            setRndStrings.add(Helper.generateRandomString());

        // создаем из сета рандомныхстрок сет ключей
         Shortener shortener = new  Shortener(strategy);
        Set<Long> setIds = new HashSet<>();
        Date start = new Date();
        for (String string : setRndStrings)
            setIds.add(shortener.getId(string));

        Date finish = new Date(); // и выводим результ времени потраченного на создание
        Helper.printMessage(String.valueOf(finish.getTime() - start.getTime()));

        // создем из сета ключей сет строк
        Set<String> setForTest = new HashSet<>();
        start = new Date();
        for (Long id : setIds)
            setForTest.add(shortener.getString(id));
        // и выводим результ времени потраченного на создание
        Helper.printMessage(String.valueOf(new Date().getTime() - start.getTime()));

        if (setRndStrings.equals(setForTest)) // это и есть проверка сравнение одного множества с др..
            Helper.printMessage("Тест пройден.");
        else Helper.printMessage("Тест не пройден.");
    }

    //////////
    public static void testStrategyMy(StorageStrategy strategy, long elementsNumber) {
        System.out.println(strategy.getClass().getSimpleName()); // Выводить имя класса стратегии.

        Set<String> testSet = new HashSet<>();
        for (int i = 0; i < elementsNumber; i++)
            testSet.add(Helper.generateRandomString()); //  Генерировать тестовое множество строк


        Date date = new Date(); //  Замер времени произведи с использованием объектов типа Date.
        long start = date.getTime();
         Shortener shortener = new  Shortener(strategy);  // Создавать объект типа Shortener

        long end = date.getTime();
        System.out.println(end - start);
    }

}
