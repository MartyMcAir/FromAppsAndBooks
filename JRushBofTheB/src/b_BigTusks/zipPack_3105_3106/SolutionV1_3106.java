package b_BigTusks.zipPack_3105_3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Разархивируем файл
*/
public class SolutionV1_3106 {
    public static void main(String[] args) throws IOException {
        String[] args2 = getArgs2();
//        args2 = args;
        String resultFileName = args2[0]; // имя результатирующего файла

        List<String> listParts = getListPart(args2); // abc.mp3 в список _ не добавлен

//        ByteArrayInputStream byteArrIn = new ByteArrayInputStream();

        Map<String, ByteArrayOutputStream> mapParts = new TreeMap<>();
        for (String item : listParts) {
            ByteArrayOutputStream byteArrOut = new ByteArrayOutputStream();
//            Files.copy(Paths.get(item), byteArrOut); // NoSuchFileException _ но он есть!
            mapParts.put(item, byteArrOut);
        }

        showAllReadyMap(mapParts); // проверяем созданную мапу


        try (ZipInputStream zipIn = new ZipInputStream(new BufferedInputStream(new FileInputStream(resultFileName)))) {

        }

        try (ZipOutputStream zipOut = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(resultFileName)))) {

        }

    }

    private static void showAllReadyMap(Map<String, ByteArrayOutputStream> mapParts) {
        for (Map.Entry<String, ByteArrayOutputStream> pare : mapParts.entrySet()) {
            System.out.println(pare.getKey());
        }
    }

    private static List<String> getListPart(String[] args2) {
        List<String> listParts = new ArrayList<>(); // Каждый файл (fileNamePart) - это кусочек zip архива
        for (int i = 1; i < args2.length; i++) {
            if (!args2[i].endsWith("abc.mp3")) {
                listParts.add(args2[i]);
            }
        } // abc.mp3 _ не добавлен
        return listParts;
    }

    public static String[] getArgs2() throws IOException {
        String[] args2 = new String[5];
//        args2 = args;
        args2[0] = "C:\\z_path\\result.mp3";

        if (Files.notExists(Paths.get("C:\\z_pathToTest\\test.zip.003"))) {
            Files.createFile(Paths.get("C:\\z_pathToTest\\test.zip.003"));
            Files.createFile(Paths.get("C:\\z_pathToTest\\test.zip.001"));
            Files.createFile(Paths.get("C:\\z_pathToTest\\test.zip.004"));
            Files.createFile(Paths.get("C:\\z_pathToTest\\test.zip.002"));
        }

        for (int i = 1; i < 5; i++) {
            args2[i] = "C:/pathToTest/test.zip.00" + i;
        }
        return args2;
    }
}
