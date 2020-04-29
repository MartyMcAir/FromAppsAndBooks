package com.javarush.task.task39.task3913.myTmp;

import com.javarush.task.task39.task3913.Event;
import com.javarush.task.task39.task3913.Status;
import com.javarush.task.task39.task3913.query.IPQuery;
import com.javarush.task.task39.task3913.query.UserQuery;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

// https://javarush.ru/help/714
public class LogParser_714 implements IPQuery {
    private List<Record> recordList = new ArrayList<>();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");

    public LogParser_714(Path logDir) {
        writeRecordsList(logDir);
    }

    private void writeRecordsList(Path logDir) {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(logDir)) {
            for (Path log : directoryStream) {
                if (Files.isRegularFile(log) && log.toString().endsWith(".log")) {
                    BufferedReader reader = Files.newBufferedReader(log, StandardCharsets.UTF_8);
                    while (reader.ready()) {
                        Record record = new Record();
                        String[] entry = reader.readLine().split("\t");
                        record.ip = entry[0];
                        record.user = entry[1];
                        record.date = formatter.parse(entry[2]);

                        if (entry[3].indexOf(' ') == -1) {
                            record.event = Event.valueOf(entry[3]);
                            record.taskNumber = null;
                        } else {
                            String[] event = entry[3].split(" ");
                            record.event = Event.valueOf(event[0]);
                            record.taskNumber = Integer.parseInt(event[1]);
                        }

                        record.status = Status.valueOf(entry[4]);

                        recordList.add(record);
                    }
                    reader.close();
                } else {
                    if (Files.isDirectory(log))
                        writeRecordsList(log);
                }
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    private Set<Record> getFilteredEntries(Date after, Date before) {
        Set<Record> filteredRecords = new HashSet<>();
        for (Record record : recordList) {
            if (isBetween(record.date, after, before)) {
                filteredRecords.add(record);
            }
        }
        return filteredRecords;
    }

    private boolean isBetween(Date date, Date after, Date before) {
        return (after == null || date.after(after) || date.equals(after)) &&
                (before == null || date.before(before) || date.equals(before));
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        Set<String> ips = getUniqueIPs(after, before);
        return ips.size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        Set<Record> filteredRecords = getFilteredEntries(after, before);
        Set<String> ips = new HashSet<>();

        for (Record record : filteredRecords) {
            ips.add(record.ip);
        }
        return ips;
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        Set<Record> filteredRecords = getFilteredEntries(after, before);
        Set<String> ips = new HashSet<>();

        for (Record record : filteredRecords) {
            if (record.user.equals(user))
                ips.add(record.ip);
        }
        return ips;
    }

    // Метод getIPsForEvent(Event, Date, Date) класса LogParser должен возвращать IP адреса,
    // с которых было произведено переданное событие за выбранный период.
    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        Set<Record> filteredRecords = getFilteredEntries(after, before);
        Set<String> ips = new HashSet<>();

        for (Record record : filteredRecords) {
            if (record.event == event)
                ips.add(record.ip);
        }
        return ips;
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        Set<Record> filteredRecords = getFilteredEntries(after, before);
        Set<String> ips = new HashSet<>();

        for (Record record : filteredRecords) {
//            if (record.status.equals(status)) // тож прокатывает
            if (record.status == status)
                ips.add(record.ip);
        }
        return ips;
    }

    ////////
    private class Record {
        String ip;
        String user;
        Date date;
        Event event;
        Integer taskNumber;
        Status status;

        @Override
        public String toString() {
            return "Record{" +
                    "ip='" + ip + '\'' +
                    ", user='" + user + '\'' +
                    ", date=" + date +
                    ", event=" + event +
                    ", taskNumber=" + taskNumber +
                    ", status=" + status +
                    '}';
        }
    }

}