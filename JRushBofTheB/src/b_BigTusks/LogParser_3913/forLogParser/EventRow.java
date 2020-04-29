package com.javarush.task.task39.task3913.forLogParser;

import com.javarush.task.task39.task3913.Event;
import com.javarush.task.task39.task3913.Status;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EventRow {
    private String ip;
    public String name;
    private Date date;
    private Event event;
    private int task;
    private Status status;
    public EventRow(String logRow) {
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("dd.MM.yyyy HH:mm:ss");
        String[] s = logRow.split("\\t");
        ip = s[0];
        name = s[1];
        try {
            date = sdf.parse(s[2]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        event = getEvent(s[3]);
        task = getTask(s[3]);
        status = Status.valueOf(s[4].toUpperCase());
    }
    private Event getEvent(String s) {
        int i;
        String event = s.toUpperCase();
        if ((i = event.indexOf(" ")) > 0) event = event.substring(0, i);
        return Event.valueOf(event);
    }
    private int getTask(String s) {
        int i;
        String task = s.toUpperCase();
        if ((i = task.indexOf(" ")) > 0) return Integer.parseInt(task.substring(i).trim());
        return -1;
    }
    @Override
    public String toString() {
        return "EventRow{" +
                "ip='" + ip + '\'' +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", event=" + event +
                ", task=" + task +
                ", status=" + status +
                '}';
    }
}
