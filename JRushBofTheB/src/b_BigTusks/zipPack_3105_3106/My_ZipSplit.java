package b_BigTusks.zipPack_3105_3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class My_ZipSplit {
    public static void main(String[] args) throws IOException {
        String filePath = "c:\\z_path\\result.mp3";
        String filePath2 = "c:\\z_path\\words.txt";
        String pathForOut = "c:\\z_path\\";
        splitFileToZip(filePath2, pathForOut, 1024);

        String[] filesParts = {"c:\\z_path\\words.txt.zip.001",
                "c:\\z_path\\words.txt.zip.002",
                "c:\\z_path\\words.txt.zip.003",};
        mergeAllZipPartsAndUnPackV2(pathForOut, filesParts);

//        exampleV1(pathForOut, filesParts);
    }

    private static void exampleV1(String pathOut, String... filesParts) throws IOException {
        List<InputStream> list = new ArrayList<>();
        for (String item : filesParts) {
            list.add(new FileInputStream(item));
        }
//        Vector<InputStream> vector = new Vector<>();
//        vector.addAll(list);
//        Enumeration<InputStream> elements = vector.elements();

        SequenceInputStream sq = new SequenceInputStream(Collections.enumeration(list));
        String suffixName = "_new_";
        /////////////////////
        if (Files.isDirectory(Paths.get(pathOut))) {
            if (Files.notExists(Paths.get(pathOut))) {
                Files.createDirectory(Paths.get(pathOut));
            }
        }
        /////////////

        // отправляем откатенированный поток в ZipInput.. и дале как обычно
        try (ZipInputStream is = new ZipInputStream(new BufferedInputStream(sq))) {
            for (ZipEntry entry = null; (entry = is.getNextEntry()) != null; ) { // необычный use для цикла for

                // путь куда кидать распакованные файлы
                String fileOutPath = "C:\\z_path\\zzz\\" + entry.getName();
                // при каждой интерации создается новый поток для каждого распаковывающегося Entry-файла
                // в конкретном примере будет на выходе 1 файл по пути C:\z_path\ttt\333\result.mp3
                try (OutputStream os = new BufferedOutputStream(new FileOutputStream(fileOutPath))) {
//                    byte[] bytes = is.readAllBytes();   // для чтения и записи за раз без циклов и т.д.
//                    os.write(bytes);

                    // для чтения побайтово частями _ для оч. больших файлов
                    final int bufferSize = 1024;
                    byte[] buffer = new byte[bufferSize];
//                     read() - заполняет баффер
                    for (int amountOfBytes = -1; (amountOfBytes = is.read(buffer, 0, bufferSize)) > -1; ) {
                        // запись от 0 до amountOfBytes, т.е. что бы записывал именно то кол-во байтов за 1 цикл
                        // на сколько расчитан баффер, а последн интерация будет естественно уникал размера
                        // потому и получают это число из read(..) метода __ (а не юзают просто bufferSize)
                        os.write(buffer, 0, amountOfBytes);    // write читает из баффера и пишет в свой поток..
                    }
                }
            }
        }
    }

    // точь в точь как в решенной задаче 3106 _ и все равно не работает так как надо..
    private static void mergeAllZipPartsAndUnPackV2(String pathOut, String... filesParts) throws IOException {
        // Create Enumerations
        List<InputStream> list = new ArrayList<>();
        for (String item : filesParts) {
            list.add(new FileInputStream(item));
        }
        SequenceInputStream sq = new SequenceInputStream(Collections.enumeration(list));
        String suffixName = "_new_";

        ZipInputStream zipIn = new ZipInputStream(new BufferedInputStream(sq));
        ZipEntry nextEntry = zipIn.getNextEntry();

        Path pathUnpackFile = Paths.get(pathOut).resolve(Paths.get(suffixName + nextEntry.getName()));
        FileOutputStream fos = fos = new FileOutputStream(pathUnpackFile.toString());

        byte[] buffer = new byte[1024];
        int count = 0;
        while ((count = zipIn.read(buffer)) != -1) {
            fos.write(buffer, 0, count);
        }

        zipIn.close();
        fos.close();
    }

    private static void mergeAllZipPartsAndUnPack(String pathOut, String... filesParts) throws IOException {
        // Create Enumerations
        List<InputStream> list = new ArrayList<>();
        for (String item : filesParts) {
            list.add(new FileInputStream(item));
        }
//        Vector<InputStream> vector = new Vector<>();
//        vector.addAll(list);
//        Enumeration<InputStream> elements = vector.elements();

        SequenceInputStream sq = new SequenceInputStream(Collections.enumeration(list));
        String suffixName = "_new_";
        /////////////////////
        if (Files.isDirectory(Paths.get(pathOut))) {
            if (Files.notExists(Paths.get(pathOut))) {
                Files.createDirectory(Paths.get(pathOut));
            }
        }
        ////

        try (ZipInputStream zipIn = new ZipInputStream(new BufferedInputStream(sq))) {
            for (ZipEntry nextEntry = null; (nextEntry = zipIn.getNextEntry()) != null; ) {
                Path pathUnpackFile = Paths.get(pathOut).resolve(Paths.get(suffixName + nextEntry.getName()));
                if (Files.notExists(pathUnpackFile.getParent())) {
                    Files.createDirectory(pathUnpackFile.getParent());
                }

//                FileOutputStream fos = new FileOutputStream(pathUnpackFile.toString());
//                byte[] buffer = new byte[1024];
//                int count = 0;
//                while ((count = zipIn.read(buffer)) != -1) {
//                    fos.write(buffer, 0, count);
//                }
//                fos.close();


                byte[] bytes = zipIn.readAllBytes(); // читаем все байты
                try (BufferedOutputStream bfOut = new BufferedOutputStream(new FileOutputStream(pathUnpackFile.toString()))) {
                    bfOut.write(bytes); // записываем все байты
                }
            }
        }

    }

    private static void splitFileToZip(String filePath, String pathForOut, int bufferSize) throws IOException {
        if (bufferSize == 0) {
            bufferSize = (1024 * 1024) * 2; // по умолчанию бафер т.е. и partSize равен 2mb
        }
        List<String> listZipFiles = new ArrayList<>(); // список для новых файлов

        try (BufferedInputStream bfIn = new BufferedInputStream(new FileInputStream(filePath))) {
            byte[] bytes = new byte[bufferSize];

            DecimalFormat decimalFormat = new DecimalFormat("000"); // для форматирования Parts
            // считывает за раз, только определенное кол-во байт с файла
//            for (int amountOfBytes = -1, counter = 1; (amountOfBytes = bfIn.read(bytes, 0, bufferSize)) > -1; counter++) {
            for (int amountOfBytes = -1, counter = 1; (amountOfBytes = bfIn.read(bytes)) != -1; counter++) {

                String numberOfPart = decimalFormat.format(counter);
                Path fileName = Paths.get(filePath).getFileName();

//                String pathForNewPart = "" + Paths.get(filePath).getParent() + fileName + ". " + numberOfPart;
                String pathForNewPart = pathForOut + fileName + ".zip." + numberOfPart; // имя для след части zip.00*

//                listZipFiles.add(Paths.get(pathForNewPart).getFileName().toString()); // только имя в список
                listZipFiles.add(pathForNewPart); // полный путь

                try (ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(pathForNewPart))) {
//                    ZipEntry zipEntry = new ZipEntry(fileName + "_" + numberOfPart);
                    ZipEntry zipEntry = new ZipEntry(fileName.toString());  // имя внутри архива у всех одно и тоже
                    zipOut.putNextEntry(zipEntry);
                    zipOut.write(bytes);
                    zipOut.finish();
//                    zipOut.write(bytes, 0 , amountOfBytes);
                }

            }
        }

        // записываем список созданных файлов в, ту же директорию где и zip Parts _ имя файла такое же как и zipParts
        Path fileName = Paths.get(filePath).getFileName();
        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(pathForOut + fileName + "PartsDescription.txt"))) {
            for (String item : listZipFiles) {
                fileWriter.write("\"" + item + "\",");
                fileWriter.newLine();
            }
        }
    }

}
