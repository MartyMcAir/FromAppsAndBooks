package b_BigTusks.LogParser_3913.myTmp;


import b_BigTusks.LogParser_3913.Event;
import b_BigTusks.LogParser_3913.Status;
import b_BigTusks.LogParser_3913.query.IPQuery;

import java.io.*;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogParser__28459 implements IPQuery {
    private Path directoryPath;
    List<File> logsList = getLogFiles(directoryPath.toFile());

    public LogParser__28459(Path directoryPath) {
        this.directoryPath = directoryPath;
    }

    private List<File> getLogFiles(File file) {
//        List<File> logsList = new ArrayList<>();
        if (file.isDirectory()) {
            File[] dirArr = file.listFiles();
            if (dirArr != null)
                for (File x : dirArr)
                    logsList.addAll(getLogFiles(x));
        } else if (file.isFile() && file.getName().toLowerCase().endsWith(".log") && file.exists())
            logsList.add(file);
        return logsList;
    }

    private BufferedReader logReader(List<File> files) {
        List<FileInputStream> list = new ArrayList<>();
        for (File file : files)
            try {
                list.add(new FileInputStream(file));
            } catch (FileNotFoundException ignored) {
            }
        SequenceInputStream logs = new SequenceInputStream(Collections.enumeration(list));
        return new BufferedReader(new InputStreamReader(logs));
    }

    public Set<String> getUniqueIPsAny(Date after, Date before, String username, Event event, Status status) {
        HashSet<String> ip = new HashSet<>();
//        try (BufferedReader reader = logReader(getLogFiles(directoryPath.toFile()))) {
        try (BufferedReader reader = logReader(logsList)) {
            while (reader.ready()) {
                LogEntry e = new LogEntry(reader.readLine());
                if ((after == null || e.date.getTime() >= after.getTime()) &&
                        (before == null || e.date.getTime() <= before.getTime()) &&
                        (username == null || username.equals(e.username)) &&
                        (event == null || event == e.event) &&
                        (status == null || status == e.status))
                    ip.add(e.ip);
            }
        } catch (IOException ignored) {
        }
        return ip;
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return getUniqueIPs(after, before).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return getUniqueIPsAny(after, before, null, null, null);
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return getUniqueIPsAny(after, before, user, null, null);
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return getUniqueIPsAny(after, before, null, event, null);
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return getUniqueIPsAny(after, before, null, null, status);
    }

    static class LogEntry {
        String ip, username;
        Date date;
        Event event;
        Integer taskId = null;
        Status status;

        LogEntry(String string) {
            SimpleDateFormat sdf = new SimpleDateFormat("d.M.y H:m:s");
//            SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            String[] log = string.split("\t");
            ip = log[0];
            username = log[1];
            try {
                date = sdf.parse(log[2]);
            } catch (ParseException e) {
                date = null;
            }
            event = Event.valueOf(log[3].split(" ")[0]);
            if (event == Event.SOLVE_TASK || event == Event.DONE_TASK)
                taskId = Integer.parseInt(log[3].split(" ")[1]);
            status = Status.valueOf(log[log.length - 1]);
        }
    }

    ///////////

    public List<File> getLogsList() {
        return logsList;
    }
}