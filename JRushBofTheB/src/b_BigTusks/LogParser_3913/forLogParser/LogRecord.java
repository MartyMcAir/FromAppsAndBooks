package com.javarush.task.task39.task3913.forLogParser;

import com.javarush.task.task39.task3913.Event;
import com.javarush.task.task39.task3913.Status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LogRecord {
    private String ip;
    private String user;
    public Date date;
    private Event event;
    private String taskNumber;
    private Status status;

    public LogRecord(String ip, String user, Date date, Event event, Status status) {
        this.ip = ip;
        this.user = user;
        this.date = date;
        this.event = event;
        this.status = status;
    }

    public LogRecord(String record) {
        String[] strings = record.split("\t");
        this.ip = strings[0].trim();
        this.user = strings[1];
        SimpleDateFormat dateFormat = new SimpleDateFormat("d.M.yyyy H:m:s");
        try {
            date = dateFormat.parse(strings[2]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String eventAndParameter[] = strings[3].split(" ");
        event = Event.valueOf(eventAndParameter[0]);
        if (eventAndParameter.length > 1) taskNumber = eventAndParameter[1];
        status = Status.valueOf(strings[4]);
    }

    public String getIp() {
        return ip;
    }

    public String getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public Event getEvent() {
        return event;
    }

    public String getTaskNumber() {
        return taskNumber;
    }

    public Status getStatus() {
        return status;
    }
}
