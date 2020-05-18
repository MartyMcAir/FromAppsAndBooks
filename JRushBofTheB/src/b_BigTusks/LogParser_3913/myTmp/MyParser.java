package b_BigTusks.LogParser_3913.myTmp;


import b_BigTusks.LogParser_3913.Event;
import b_BigTusks.LogParser_3913.Status;
import b_BigTusks.LogParser_3913.query.IPQuery;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

// работает валя не принимает
public class MyParser implements IPQuery {
    private final Path pathDirectory;
    private List<String> listLogFiles = new ArrayList<>(); // список найденных в пути pathDirectory *.log файлов
    private List<MyLogEntry> myLogEntries = new ArrayList<>(); // список полученных данных из лог-файлов

    public static void main(String[] args) throws IOException {
        String paths = "c:/logs/";
        MyParser myParser = new MyParser(Paths.get(paths));

//        myParser.getListLogFiles().forEach(v -> System.out.println(v));
//        myParser.getMyLogEntries().forEach(v -> System.out.println(v.userName));

        testIs(myParser);
    }

    public static void testIs(MyParser logParser) {    // Код для тестирования
        try {
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

    public MyParser(Path pathDirectory) {
        this.pathDirectory = pathDirectory;
        fillListLogFiles(pathDirectory);   // наполняем список *.log файлами

        /// Очень необычный у вас подход, но думаете парсить заново все файлы при любом вызове метода - хорошая идея?
        // Не думали над тем, чтобы 1 раз всё распарсить и хранить список всех своих логЭнтри?
        //Не знаю поможет или нет, но вижу, что у вас используется другой сдф, попробуйте такой:

        // Подход как раз верный. Вы видимо не сталкивались с реальными логами которые легко могут по размеру составлять сотни Гб.
        // Логи в сотни Гб встречаются гораздо чаще, чем конфигурации с сотнями Гб оперативки.
        //Если есть необходимость сделать много разных запросов на выборку из логов, то их пишут в БД. Если лог таки текстовый,
        // то один раз считать и записать в БД и уже к ней делать запросы.
        //Считывать весь лог неизвестного размера в память и уже там его анализировать для реальных задач в любом случае неприемлемо.
        // т.е. вот это лучше изменить на каждый раз чтение, каждого отдельного файла
        fillListLogEntry();   // наполняем список MyLogEntry - объектами с файлов
    }

    public void fillListLogEntry() {
        // List<Path> files = Files.list(logDir).filter(f -> f.toString().endsWith(".log")).collect(Collectors.toList());
        for (int i = 0; i < listLogFiles.size(); i++) {
            try (BufferedReader bfr = new BufferedReader(new InputStreamReader(new FileInputStream(new File(listLogFiles.get(i)))))) {
                while (bfr.ready()) {
                    String str = bfr.readLine();
                    MyLogEntry logEntry = new MyLogEntry(str);
                    myLogEntries.add(logEntry);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void fillListLogFiles(Path pathDirectory) {
        File file = new File(pathDirectory.toString());
        if (file.isFile() & file.toString().endsWith(".log"))
            listLogFiles.add(file.toString());
        else {
            File[] files = file.listFiles();
            for (File item : files)
                fillListLogFiles(item.toPath());
        }
    }

    public Set<String> getIPsSetAny(Date after, Date before, String userName, Event event, Status status) {
        Set<String> ipSet = new HashSet<>();
        for (MyLogEntry entry : myLogEntries) {
            if ((after == null || entry.date.getTime() >= after.getTime()) &&
                    (before == null || entry.date.getTime() <= before.getTime()) &&
                    (userName == null || userName.equals(entry.userName)) &&
                    (event == null || event == entry.event) &&
                    (status == null || status == entry.status))
                ipSet.add(entry.ip);
        }
        return ipSet;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        Set<String> uniqueIPs = getUniqueIPs(after, before);
        return uniqueIPs.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return getIPsSetAny(after, before, null, null, null);
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return getIPsSetAny(after, before, user, null, null);
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return getIPsSetAny(after, before, null, event, null);
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return getIPsSetAny(after, before, null, null, status);
    }

    ///////////////

    public static class MyLogEntry {
        SimpleDateFormat sdf = new SimpleDateFormat("d.M.y h:m:s");
        // 127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK

        String ip, userName;
        Date date;
        Event event; //     LOGIN, DOWNLOAD_PLUGIN, WRITE_MESSAGE, SOLVE_TASK, DONE_TASK
        int taskId;
        Status status; // OK, FAILED, ERROR

        public static void main(String[] args) {
            String st = "127.0.0.1	Amigo	30.08.2012 16:08:13	LOGIN	OK";
            try {
                String[] split = st.split("\t");
                // 127.0.0.1 _ Amigo _ 30.08.2012 16:08:13 _ LOGIN _ OK _
//                Arrays.stream(split).forEach(v -> System.out.print(v + " _ "));

                Date dateParse = new MyLogEntry(st).sdf.parse(split[2]);
                System.out.println("dateParse: " + dateParse);

                String pattern_1R = "h:m:s d.M.yyy"; // 4:8:13 30.8.2012
                String pattern_2E = "HH:mm:ss dd.MM.y"; // 16:08:13 30.08.2012
                SimpleDateFormat sdf2 = new SimpleDateFormat(pattern_2E);
                String format = sdf2.format(dateParse);
                System.out.println("format: " + format);

                Event event = Event.valueOf(split[3].split(" ")[0]); // доп split, на случай если там еще что-то..
                System.out.println(event.toString()); // LOGIN
                Status status = Status.valueOf(split[split.length - 1]); // т.е. индекс с конца сам полсден..
                System.out.println(status); // OK
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public MyLogEntry(String lineFromFile) {
            String[] logElements = lineFromFile.split("\t");// сплитим через., разделитель -табуляция

            ip = logElements[0];
            userName = logElements[1];

            try {
                date = sdf.parse(logElements[2]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            event = Event.valueOf(logElements[3].split(" ")[0]); // доп split, на случай если там taskId..
            if (event == Event.SOLVE_TASK || event == Event.DONE_TASK)
                taskId = Integer.parseInt(logElements[3].split(" ")[1]);
            status = Status.valueOf(logElements[logElements.length - 1]); // т.е. индекс с конца сам последн..
        }
    }

    //////
    public List<String> getListLogFiles() {
        return listLogFiles;
    }

    public List<MyLogEntry> getMyLogEntries() {
        return myLogEntries;
    }
}
