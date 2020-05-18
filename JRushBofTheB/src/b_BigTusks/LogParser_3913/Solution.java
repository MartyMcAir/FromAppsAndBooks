package b_BigTusks.LogParser_3913;

import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
//        String pathStr = "C:\\z_n\\new_test_folder\\dSimpleLoge.txt";
//        String pathStr = "C:\\z_n\\new_test_folder\\";
//        String pathStr = "c:/logs/";
        String pathStr = "c:\\logs\\";

        LogParser logParser = new LogParser(Paths.get(pathStr));
//        LogParser logParser = new LogParser(Paths.get("c:/logs/"));
//        logParser.getEntries().forEach(v -> System.out.println(v));

        testIs(pathStr);
//        LogParser logParser = new LogParser(Paths.get(pathStr));
//        testGetNumberOfUniqueIPs(logParser);
//        testGetUniqueIPs(logParser);
//        testGetIPsForUser(logParser);
//        testGetIPsForEvent(logParser);
//        testGetIPsForStatus(logParser);

//        System.out.println(logParser.getNumberOfUniqueIPs(null, null));
    }

    public static void testIs(String path) {
        // Код для тестирования
        try {
            LogParser logParser = new LogParser(Paths.get(path));
            ///////////
            System.out.println("isss");
//            logParser.getLogsList().forEach(v -> System.out.println(v.getName()));
//            logParser.getEntries().forEach(v -> System.out.println(v.getName()));

            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
            Date after = format.parse("30.01.2014 12:56:22"); // c
            Date before = format.parse("14.11.2015 07:08:01"); // по
            System.out.println(logParser.getNumberOfUniqueIPs(after, before)); // 2
            System.out.println(logParser.getNumberOfUniqueIPs(null, before)); // 3
            System.out.println(logParser.getNumberOfUniqueIPs(after, null)); // 5
            System.out.println(logParser.getNumberOfUniqueIPs(null, null)); // 5
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //////////////// from https://javarush.ru/help/27416
    private static void testGetNumberOfUniqueIPs(LogParser logParser) {
        System.out.println("testGetNumberOfUniqueIPs");
        System.out.println(logParser.getNumberOfUniqueIPs(null, new Date()));  // 3
        System.out.println(logParser.getNumberOfUniqueIPs(new Date(), null));  // 4

        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.ENGLISH);
        Date start = null;
        try {
            start = format.parse("30.08.2012 16:08:40");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(logParser.getNumberOfUniqueIPs(start, null)); // 5
    }

    private static void testGetUniqueIPs(LogParser logParser) {
        System.out.println("\n========================================================");
        System.out.println("testGetUniqueIPs");
        Set<String> IPs = logParser.getUniqueIPs(null, null);
        IPs.stream().forEach(System.out::println);

        // IPs = logParser.getUniqueIPs(null, new Date());
        // IPs.stream().forEach(System.out::println);
    }

    private static void testGetIPsForUser(LogParser logParser) {
        System.out.println("\n========================================================");
        System.out.print("testGetIPsForUser");

        String user = "Amigo";
        System.out.println(": " + user);

        Set<String> userIPs = logParser.getIPsForUser(user, null, null);
        // Set<String> userIPs = logParser.getIPsForUser(user, null, new Date());
        userIPs.stream().forEach(System.out::println);
    }

    private static void testGetIPsForEvent(LogParser logParser) {
        System.out.println("\n========================================================");
        System.out.print("testGetIPsForEvent");
        Event event = Event.LOGIN;
        // Event event = Event.WRITE_MESSAGE;
        // Event event = Event.SOLVE_TASK;
        System.out.println(": " + event.name());

        Set<String> userIPs = logParser.getIPsForEvent(event, null, null);
        // Set<String> userIPs = logParser.getIPsForUser(event, null, new Date());
        userIPs.stream().forEach(System.out::println);
    }

    private static void testGetIPsForStatus(LogParser logParser) {
        System.out.println("\n========================================================");
        System.out.print("testGetIPsForStatus");

        Status status = Status.OK;
        // Status status = Status.ERROR;
        // Status status = Status.FAILED;
        System.out.println(": " + status.name());

        Set<String> userIPs = logParser.getIPsForStatus(status, null, null);
        // Set<String> userIPs = logParser.getIPsForUser(status, null, new Date());
        userIPs.stream().forEach(System.out::println);
    }

}