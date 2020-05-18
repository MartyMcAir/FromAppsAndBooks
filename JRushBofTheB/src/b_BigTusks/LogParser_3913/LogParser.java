package b_BigTusks.LogParser_3913;


import b_BigTusks.LogParser_3913.forLogParser.EventRow;
import b_BigTusks.LogParser_3913.forLogParser.LogRecord;
import b_BigTusks.LogParser_3913.query.*;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// https://github.com/viktorpavlovi4/JavaRushTasks/blob/f6a7f3bb7d6f8fda42254f32818bf57bb1857c32/4.JavaCollections/src/com/javarush/task/task39/task3913/LogParser.java
public class LogParser implements IPQuery, UserQuery, DateQuery, EventQuery, QLQuery {
    private Path logDir;
    private List<EventRow> logData;

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    // -------------------------------- IPQuery
    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return getIpSet(null, after, before);
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return getIpSet(user, after, before);
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return getIpSet(event, after, before);
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return getIpSet(status, after, before);
    }

    // -----------------------
    private void readLogs(Path logDir) {
        if (this.logData == null) this.logData = new ArrayList<>();
        try {
            for (Path log : Files.newDirectoryStream(logDir)) {
                if (Files.isRegularFile(log) && log.toString().endsWith(".log")) {
                    logData.addAll(Files
                            .readAllLines(log)
                            .stream()
                            .map(s -> new EventRow(s))
                            .collect(Collectors.toList()));
                } else {
                    if (Files.isDirectory(log)) readLogs(log);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // --------------------------- Methods Matchers
    private boolean isFieldMatch(String field, String value, LogRecord record) throws ParseException {
        boolean criteria = false;
        if (field == null) return true;
        if (value == null) return false;
        switch (field) {
            case "ip": {
                criteria = record.getIp().equals(value);
                break;
            }
            case "user": {
                criteria = record.getUser().equals(value);
                break;
            }
            case "date": {
                criteria = record.getDate().equals(new SimpleDateFormat("d.M.yyyy H:m:s").parse(value));
                break;
            }
            case "event": {
                criteria = record.getEvent().equals(Event.valueOf(value));
                break;
            }
            case "status": {
                criteria = record.getStatus().equals(Status.valueOf(value));
                break;
            }
        }
        return criteria;
    }

    private boolean isFieldMatch(Object recordField, LogRecord record) {
        boolean criteria = false;
        if (recordField == null)
            return true;
        if (recordField instanceof String)
            criteria = record.getUser().equals(recordField);
        else if (recordField instanceof Event)
            criteria = record.getEvent().equals(recordField);
        else if (recordField instanceof Status)
            criteria = record.getStatus().equals(recordField);
        return criteria;
    }

    private boolean isDateValid(Date after, Date before, Date currentDate) {
        if (after != null) {
            if (currentDate.getTime() <= after.getTime())
                return false;
        }
        if (before != null) {
            if (currentDate.getTime() >= before.getTime())
                return false;
        }
        return true;
    }

    // ----------------------------------------- UserQuery
    @Override
    public Set<String> getAllUsers() {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (!users.contains(record.getUser())) {
                users.add(record.getUser());
            }
        }
        return users;
    }

    @Override
    public int getNumberOfUsers(Date after, Date before) {
//        return getAllUsers().size();
        Set<String> users = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate()) && !users.contains(record.getUser()))
                users.add(record.getUser());
        }
        return users.size();
    }

    @Override
    public int getNumberOfUserEvents(String user, Date after, Date before) {
        Set<Event> resultSet = new HashSet<>();
        // не получать все рекорды, а перебирать каждый файл _ и на основе этого отфильтрованный Set
        // но getAllParsedRecords(..) - каждый раз перебирает все файлы и создает Set
        // не оч. эффективно как для постоянно делать чтение с ПК повторно и создание Set - а не за раз поле заполнить
        // и не оч. эффективно если логов гигабайты, то перебирать все файл и наполнять Set - записями то
        // будет StackOverFlow
        for (LogRecord record : getAllParsedRecords(logDir)) {
            // isDateValid(..) - проверка на валидность дат _ там сравнение с текущ датой record.getDate()
            if (isDateValid(after, before, record.getDate()) && (record.getUser().equals(user)))
                resultSet.add(record.getEvent());
        }
        return resultSet.size();
    }

    @Override
    public Set<String> getUsersForIP(String ip, Date after, Date before) {
        Set<String> resultSet = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate()) && (record.getIp().equals(ip)))
                resultSet.add(record.getUser());
        }
        return resultSet;
    }

    @Override
    public Set<String> getLoggedUsers(Date after, Date before) {
        Set<String> resultSet = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate()) && (record.getEvent() == Event.LOGIN))
                resultSet.add(record.getUser());
        }
        return resultSet;
    }

    @Override
    public Set<String> getDownloadedPluginUsers(Date after, Date before) {
        Set<String> resultSet = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate()) && (record.getEvent() == Event.DOWNLOAD_PLUGIN))
                resultSet.add(record.getUser());
        }
        return resultSet;
    }

    @Override
    public Set<String> getWroteMessageUsers(Date after, Date before) {
        Set<String> resultSet = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate()) && (record.getEvent() == Event.WRITE_MESSAGE))
                resultSet.add(record.getUser());
        }
        return resultSet;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before) {
        Set<String> resultSet = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate()) && (record.getEvent() == Event.SOLVE_TASK))
                resultSet.add(record.getUser());
        }
        return resultSet;
    }

    @Override
    public Set<String> getSolvedTaskUsers(Date after, Date before, int task) {
        Set<String> resultSet = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate()) && ((record.getEvent()) == Event.SOLVE_TASK)
                    && (Integer.parseInt(record.getTaskNumber()) == task)) {
                resultSet.add(record.getUser());
            }
        }
        return resultSet;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before) {
        Set<String> resultSet = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate()) && (record.getEvent() == Event.DONE_TASK))
                resultSet.add(record.getUser());
        }
        return resultSet;
    }

    @Override
    public Set<String> getDoneTaskUsers(Date after, Date before, int task) {
        Set<String> resultSet = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate()) && (record.getEvent() == Event.DONE_TASK)
                    && (Integer.parseInt(record.getTaskNumber()) == task))
                resultSet.add(record.getUser());
        }
        return resultSet;
    }

    // ----------------------------------------- UserQuery
    @Override
    public Set<Date> getDatesForUserAndEvent(String user, Event event, Date after, Date before) {
        Set<Date> resultSet = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate()) && (record.getUser().equals(user))
                    && (record.getEvent() == event))
                resultSet.add(record.getDate());
        }
        return resultSet;
    }

    @Override
    public Set<Date> getDatesWhenSomethingFailed(Date after, Date before) {
        Set<Date> resultSet = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate()) && (record.getStatus() == Status.FAILED))
                resultSet.add(record.getDate());
        }
        return resultSet;
    }

    @Override
    public Set<Date> getDatesWhenErrorHappened(Date after, Date before) {
        Set<Date> resultSet = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate()) && (record.getStatus() == Status.ERROR))
                resultSet.add(record.getDate());
        }
        return resultSet;
    }

    @Override
    public Date getDateWhenUserLoggedFirstTime(String user, Date after, Date before) {
        Date date = null;
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate()) && (record.getUser().equals(user))
                    && (record.getEvent() == Event.LOGIN)) {
//                return record.getDate();
                if (date == null) date = record.getDate();
                else date = date.compareTo(record.getDate()) > 0 ? record.getDate() : date;
            }
        }
        return date;
    }

    @Override
    public Date getDateWhenUserSolvedTask(String user, int task, Date after, Date before) {
        Date date = null;
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate())
                    && record.getUser().equals(user)
                    && record.getEvent().equals(Event.SOLVE_TASK)
                    && record.getTaskNumber() != null
                    && !record.getTaskNumber().isEmpty()
                    && Integer.parseInt(record.getTaskNumber()) == task) {
                if (date == null) date = record.getDate();
                else date = date.compareTo(record.getDate()) > 0 ? record.getDate() : date;
            }
        }
        return date;
    }

    @Override
    public Date getDateWhenUserDoneTask(String user, int task, Date after, Date before) {
        Date date = null;
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate())
                    && record.getUser().equals(user)
                    && record.getEvent().equals(Event.DONE_TASK)
                    && record.getTaskNumber() != null
                    && !record.getTaskNumber().isEmpty()
                    && Integer.parseInt(record.getTaskNumber()) == task) {
                if (date == null) date = record.getDate();
                else date = date.compareTo(record.getDate()) > 0 ? record.getDate() : date;
            }
        }
        return date;
    }

    @Override
    public Set<Date> getDatesWhenUserWroteMessage(String user, Date after, Date before) {
        Set<Date> resultSet = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate()) && (record.getUser().equals(user))
                    && (record.getEvent() == Event.WRITE_MESSAGE))
                resultSet.add(record.getDate());
        }
        return resultSet;
    }

    @Override
    public Set<Date> getDatesWhenUserDownloadedPlugin(String user, Date after, Date before) {
        Set<Date> resultSet = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate()) && record.getUser().equals(user)
                    && (record.getEvent()) == Event.DOWNLOAD_PLUGIN)
                resultSet.add(record.getDate());
        }
        return resultSet;
    }

    // ----------------------------------------- EventQuery
    @Override
    public int getNumberOfAllEvents(Date after, Date before) {
//        int count = 0;
//        for (LogRecord record : getAllParsedRecords(logDir)) {
//            if (isDateValid(after, before, record.getDate()))
//                count++;
//        }
//        return count;
        return getAllEvents(after, before).size();
    }

    @Override
    public Set<Event> getAllEvents(Date after, Date before) {
        Set<Event> resultSet = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate()))
                resultSet.add(record.getEvent());
        }
        return resultSet;
    }

    @Override
    public Set<Event> getEventsForIP(String ip, Date after, Date before) {
        Set<Event> resultSet = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate()) && (record.getIp().equals(ip)))
                resultSet.add(record.getEvent());
        }
        return resultSet;
    }

    @Override
    public Set<Event> getEventsForUser(String user, Date after, Date before) {
        Set<Event> resultSet = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate()) && (record.getUser().equals(user)))
                resultSet.add(record.getEvent());
        }
        return resultSet;
    }

    @Override
    public Set<Event> getFailedEvents(Date after, Date before) {
        Set<Event> resultSet = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate()) && (record.getStatus() == Status.FAILED))
                resultSet.add(record.getEvent());
        }
        return resultSet;
    }

    @Override
    public Set<Event> getErrorEvents(Date after, Date before) {
        Set<Event> resultSet = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate()) && (record.getStatus() == Status.ERROR))
                resultSet.add(record.getEvent());
        }
        return resultSet;
    }

    @Override
    public int getNumberOfAttemptToSolveTask(int task, Date after, Date before) {
        int count = 0;
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate()) && (record.getEvent() == Event.SOLVE_TASK)
                    && (Integer.parseInt(record.getTaskNumber()) == task))
                count++;
        }
        return count;
    }

    @Override
    public int getNumberOfSuccessfulAttemptToSolveTask(int task, Date after, Date before) {
        int i = 0;
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate())
                    && record.getEvent().equals(Event.DONE_TASK)
                    && record.getTaskNumber() != null
                    && !record.getTaskNumber().isEmpty()
                    && Integer.parseInt(record.getTaskNumber()) == task) {
                i++;
            }
        }
        return i;
    }

    @Override
    public Map<Integer, Integer> getAllSolvedTasksAndTheirNumber(Date after, Date before) {
        //  (номер_задачи : количество_попыток_решить_ее).
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate()) && (record.getEvent() == Event.SOLVE_TASK))
//                resultMap.put(Integer.parseInt(record.getTaskNumber()), )
                resultMap.merge(Integer.parseInt(record.getTaskNumber()), 1, Integer::sum);
        }
        return resultMap;
    }

    @Override
    public Map<Integer, Integer> getAllDoneTasksAndTheirNumber(Date after, Date before) {
        // (номер_задачи : сколько_раз_ее_решили).
        Map<Integer, Integer> resultMap = new HashMap<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate()) && (record.getEvent() == Event.DONE_TASK))
                resultMap.merge(Integer.parseInt(record.getTaskNumber()), 1, Integer::sum);
        }
        return resultMap;
    }

    // ---------------------------------------- QLQuery
    // Вызов метода execute("get ip") должен вернуть Set<String>, содержащий все уникальные IP из лога
    // (это будет: 127.0.0.1, 12.12.12.12, 146.34.15.5, 192.168.100.2 для тестового файла).
    // Аналогично должны работать и другие запросы.

    // Пример запроса: get ip for user = "Vasya"
    @Override
    public Set<Object> execute(String query) {
        // 5.1.1. get ip
        //5.1.2. get user
        //5.1.3. get date
        //5.1.4. get event
        //5.1.5. get status
        Set<Object> res = new HashSet<>();
        if (query == null || query.isEmpty()) return res;

        // такой паттерн бы не написал
        Pattern p = Pattern.compile("get (ip|user|date|event|status)"
                + "( for (ip|user|date|event|status) = \"(.*?)\")?"
                + "( and date between \"(.*?)\" and \"(.*?)\")?");
        Matcher m = p.matcher(query);

        String field1 = null, field2 = null, value1 = null;
        Date dateFrom = null, dateTo = null;
        if (m.find()) {
            field1 = m.group(1);
            field2 = m.group(3);
            value1 = m.group(4);
            String d1 = m.group(6);
            String d2 = m.group(7);

            try {
                dateFrom = new SimpleDateFormat("d.M.yyyy H:m:s").parse(d1);
            } catch (Exception e) {
                dateFrom = null;
            }
            try {
                dateTo = new SimpleDateFormat("d.M.yyyy H:m:s").parse(d2);
            } catch (Exception e) {
                dateTo = null;
            }

            switch (field1) {
                case "ip": {
                    res.addAll(getAllIps(field2, value1, dateFrom, dateTo));
                    break;
                }
                case "user": {
                    res.addAll(getAllUsers(field2, value1, dateFrom, dateTo));
                    break;
                }
                case "date": {
                    res.addAll(getAllDates(field2, value1, dateFrom, dateTo));
                    break;
                }
                case "event": {
                    res.addAll(getAllEvents(field2, value1, dateFrom, dateTo));
                    break;
                }
                case "status": {
                    res.addAll(getAllStatuses(field2, value1, dateFrom, dateTo));
                    break;
                }
            }
        }
        return res;
    }

    // ----------------------------------- Methods Getter's
    private List<LogRecord> getAllParsedRecords(Path logDir) {
        List<LogRecord> recordList = new ArrayList<>();
        try {
            for (File file : logDir.toFile().listFiles()) {
                if (file.isFile() && file.getName().toLowerCase().endsWith(".log"))
                    for (String record : Files.readAllLines(file.toPath(), Charset.defaultCharset())) {
                        recordList.add(new LogRecord(record));
                    }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return recordList;
    }

    private Set<String> getAllIps(String field, String value, Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            try {
                if (isDateValid(after, before, record.getDate()) && isFieldMatch(field, value, record))
                    users.add(record.getIp());
            } catch (ParseException e) {
                //e.printStackTrace();
            }
        }
        return users;
    }

    private Set<Date> getAllDates(String field, String value, Date after, Date before) {
        Set<Date> dates = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            try {
                if (isDateValid(after, before, record.getDate()) && isFieldMatch(field, value, record))
                    dates.add(record.date);
            } catch (ParseException e) {
                //e.printStackTrace();
            }
        }
        return dates;
    }

    private Set<Status> getAllStatuses(String field, String value, Date after, Date before) {
        Set<Status> set = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            try {
                if (isDateValid(after, before, record.getDate()) && isFieldMatch(field, value, record))
                    set.add(record.getStatus());
            } catch (ParseException e) {
                //e.printStackTrace();
            }
        }
        return set;
    }

    private Set<Event> getAllEvents(String field, String value, Date after, Date before) {
        Set<Event> set = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            try {
                if (isDateValid(after, before, record.getDate()) && isFieldMatch(field, value, record))
                    set.add(record.getEvent());
            } catch (ParseException e) {
                //e.printStackTrace();
            }
        }
        return set;
    }

    private Set<String> getAllUsers(String field, String value, Date after, Date before) {
        Set<String> users = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            try {
                if (isDateValid(after, before, record.getDate()) && isFieldMatch(field, value, record))
                    users.add(record.getUser());
            } catch (ParseException e) {
                //e.printStackTrace();
            }
        }
        return users;
    }

    private Set<String> getIpSet(Object recordField, Date after, Date before) {
        Set<String> ipSet = new HashSet<>();
        for (LogRecord record : getAllParsedRecords(logDir)) {
            if (isDateValid(after, before, record.getDate()) && isFieldMatch(recordField, record))
                ipSet.add(record.getIp());
        }
        return ipSet;
    }
}