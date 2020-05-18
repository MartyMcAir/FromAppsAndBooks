package b_BigTusks.zipPack_3105_3106;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
// https://javarush.ru/tasks/com.javarush.task.task31.task3106#discussion
public class Solution_3106 {
    public static void main(String[] args) throws IOException {
//        String resultFileName = args[0]; // имя результатирующего файла_ должно быть именно таким,
        // а не как указано внтури архива в его Entry - fileName..
//        List<InputStream> listParts = getListPart(args); // abc.mp3 в список _ не добавлен

        FileOutputStream fos = new FileOutputStream(args[0]);
        List<FileInputStream> inputStreams = Arrays.stream(args).skip(1).sorted().map(name -> {
            try {
                return new FileInputStream(name);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return null;
        }).collect(Collectors.toList());

        ZipInputStream zin = new ZipInputStream(new SequenceInputStream(Collections.enumeration(inputStreams)));
        zin.getNextEntry();
        byte[] buffer = new byte[1024];
        int count = 0;
        while ((count = zin.read(buffer)) != -1) {
            fos.write(buffer, 0, count);
        }
        zin.close();
        fos.close();

//        myV3_valyaNePrinyal(resultFileName, listParts);
    }

    private static void myV3_valyaNePrinyal(String resultFileName, List<InputStream> listParts) throws IOException {
        Enumeration<InputStream> enumeration = Collections.enumeration(listParts);
        SequenceInputStream sq = new SequenceInputStream(enumeration);

        try (ZipInputStream zipIn = new ZipInputStream(new BufferedInputStream(sq))) {
            for (ZipEntry zipEntry = null; (zipEntry = zipIn.getNextEntry()) != null; ) {

                byte[] buffer = new byte[1024];
                for (int amountOfBytes = -1; (amountOfBytes = zipIn.read(buffer, 0, 1024)) > -1; ) {
                    try (OutputStream os = new BufferedOutputStream(new FileOutputStream(resultFileName))) {
                        os.write(buffer, 0, amountOfBytes);
                    }
                }
            }
        }
    }

    private static List<InputStream> getListPart(String[] args2) throws FileNotFoundException {
        List<InputStream> listParts = new ArrayList<>(); // Каждый файл (fileNamePart) - это кусочек zip архива
        for (int i = 1; i < args2.length; i++) {
            if (!args2[i].endsWith("abc.mp3")) {
                listParts.add(new FileInputStream(args2[i]));
            }
        }
        return listParts;
    }
}
