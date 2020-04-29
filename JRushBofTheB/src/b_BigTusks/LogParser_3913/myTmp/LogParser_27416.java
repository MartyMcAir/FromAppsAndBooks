package com.javarush.task.task39.task3913.myTmp;

import com.javarush.task.task39.task3913.Event;
import com.javarush.task.task39.task3913.Status;
import com.javarush.task.task39.task3913.query.IPQuery;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

// https://javarush.ru/help/27416
public class LogParser_27416 implements IPQuery {
    private List<LogEntry> entries = new ArrayList<>();
    private Path logDir;

    public LogParser_27416(Path logDir) {
        this.logDir = logDir;
        getEntries();
    }

    private void getEntrie() {
        List<Path> logs = new ArrayList<>();
        try {
            logs = Files.list(logDir)
                    .filter(Files::isRegularFile)
                    .filter(line -> line.toString().endsWith(".log"))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Path path : logs) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path.toString())));
                String input = "";
                while ((input = reader.readLine()) != null) {
                    entries.add(new LogEntry(input));
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<String> ips = new HashSet<>();
        List<LogEntry> entries = getFilteredLogEntries(after, before);
        for (LogEntry entry : entries) {
            ips.add(entry.getIp());
        }
        return ips;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        List<LogEntry> entries = getFilteredLogEntries(after, before);
        Set<String> ips = new HashSet<>();
        for (LogEntry entry : entries) {
            if (user.equals(entry.getName())) {
                ips.add(entry.getIp());
            }
        }
        return ips;
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        List<LogEntry> entries = getFilteredLogEntries(after, before);
        Set<String> ips = new HashSet<>();
        for (LogEntry entry : entries) {
            if (event == entry.getEvent()) {
                ips.add(entry.getIp());
            }
        }
        return ips;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        List<LogEntry> entries = getFilteredLogEntries(after, before);
        Set<String> ips = new HashSet<>();
        for (LogEntry entry : entries) {
            if (status == entry.getStatus()) {
                ips.add(entry.getIp());
            }
        }
        return ips;
    }

    private List<LogEntry> getFilteredLogEntries(Date after, Date before) {
        List<LogEntry> logs = new ArrayList<>();
        if (after == null && before == null) {
            logs = entries;
        } else if (after == null) {
            for (LogEntry entry : entries) {
                if (entry.getDateOfEvent().getTime() <= before.getTime()) { //entry is before "before"
                    logs.add(entry);
                }
            }
        } else if (before == null) {
            for (LogEntry entry : entries) {
                if (entry.getDateOfEvent().getTime() >= after.getTime()) { //entry is after "after"
                    logs.add(entry);
                }
            }
        } else {
            for (LogEntry entry : entries) {
                if ((entry.getDateOfEvent().getTime() <= before.getTime()) && (entry.getDateOfEvent().getTime() >= after.getTime())) {
                    logs.add(entry);
                }
            }
        }
        /*for (LogEntry entry : entries){
            if (after == null && before != null && !before.before(entry.dateOfEvent)){
                logs.add(entry);
            } else if (before == null && after != null && !after.after(entry.dateOfEvent)){
                logs.add(entry);
            } else if (after == null && before == null){
                logs.add(entry);
            } else if (!after.after(entry.getDateOfEvent()) && !before.before(entry.getDateOfEvent())){
                logs.add(entry);
            }
        }*/

        return logs;
    }

    class LogEntry {
        // Поменял свои паттерны на общий:
        //Pattern pattern = Pattern.compile("(?<ip>[\\d]+.[\\d]+.[\\d]+.[\\d]+)\\s" +
        //                                                "(?<name>[a-zA-Z ]+)\\s" +
        //                                                "(?<date>[\\d]+.[\\d]+.[\\d]+ [\\d]+:[\\d]+:[\\d]+)\\s" +
        //                                                "(?<event>[\\w]+)\\s?(" +
        //                                                "(?<taskNumber>[\\d]+)|)\\s" +
        //                                                "(?<status>[\\w]+)");
        //И всё заработало, видимо мои старые паттерны были не особо универсальные, но с примером работали хорошо.

        private String ip;
        private String name;
        private Date dateOfEvent;
        private Event event;
        private Integer eventNumber = null;
        private Status status;

        public LogEntry(String log) {
            parseIP(log);
            parseName(log);
            parseDate(log);
            parseEvent(log);
            parseStatus(log);
        }

        private void parseIP(String log) {
            String ipPattern = "\\b\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\b";
            Pattern p = Pattern.compile(ipPattern);
            Matcher matcher = p.matcher(log);
            matcher.find();
            ip = matcher.group(0);
        }

        private void parseName(String log) {
            String namePattern = "(?![\b .])[a-zA-Z .]+";
            Pattern p = Pattern.compile(namePattern);
            Matcher matcher = p.matcher(log);
            matcher.find();
            name = matcher.group(0);
        }

        private void parseDate(String log) {
            String datePatten = "[0-9]{0,}\\.[0-9]{0,}\\.[0-9]{0,}\\s{1,}[0-9 :]+";
            Pattern p = Pattern.compile(datePatten);
            Matcher matcher = p.matcher(log);
            matcher.find();
            String sDate = matcher.group(0);
            //12.12.2013 21:56:30
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss", Locale.US);
            try {
                dateOfEvent = simpleDateFormat.parse(sDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        private void parseEvent(String log) {
            String eventPattern = "[A-Z]{4,9}\\_{0,1}[A-Z]{0,7}";
            Pattern p = Pattern.compile(eventPattern);
            Matcher matcher = p.matcher(log);
            matcher.find();
            event = Event.valueOf(matcher.group(0));
            if ((event == Event.SOLVE_TASK) || (event == Event.DONE_TASK)) {
                String numberPattern = "(?<!\\S)\\d+(?!\\S)";
                Pattern pNumber = Pattern.compile(numberPattern);
                Matcher matcherNumber = pNumber.matcher(log);
                matcherNumber.find();
                eventNumber = Integer.parseInt(matcherNumber.group(0));
            }
        }

        private void parseStatus(String log) {
            String statusPattern = "[A-Z]{2,6}$";
            Pattern p = Pattern.compile(statusPattern);
            Matcher matcher = p.matcher(log);
            matcher.find();
            status = Status.valueOf(matcher.group(0));
        }

        public String getIp() {
            return ip;
        }

        public String getName() {
            return name;
        }

        public Date getDateOfEvent() {
            return dateOfEvent;
        }

        public Event getEvent() {
            return event;
        }

        public Integer getEventNumber() {
            return eventNumber;
        }

        public Status getStatus() {
            return status;
        }
    }

    ///

    public List<LogEntry> getEntries() {
        return entries;
    }
}