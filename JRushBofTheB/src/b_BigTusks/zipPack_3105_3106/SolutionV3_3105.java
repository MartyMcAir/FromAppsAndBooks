package b_BigTusks.zipPack_3105_3106;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
// https://javarush.ru/tasks/com.javarush.task.task31.task3105#discussion
public class SolutionV3_3105 {  // Не проходит валидацию _ работает слишком долго..
    // именование путей взято из ZipFileManager JRush Tusk - archive
    private static Map<Path, byte[]> mapFiles = new LinkedHashMap<>();
    private static Map<Path, byte[]> mapFilesFromZip = new LinkedHashMap<>();
    private static List<Path> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
//        String filePath = args[0];
//        String zipPath = args[1];

        String testFiles = "C:\\z_n\\new_test_folder\\1\\2";

        String pathForUnzipIn = "C:\\z_pathToTest\\3\\";
        String pathForCreate = "C:\\z_pathToTest\\";


        String filePath2 = "C:\\z_path\\result.mp3";
        String zipPath2 = "C:\\z_pathToTest\\test.zip";

        prepareFiles(Paths.get(filePath2)); // подготавливаем список файлов для запаковки
        prepareFilesFromZip(Paths.get(zipPath2));  // подготавливаем список файлов находящихся внутри архива

        String testStrZip = "C:\\z_pathToTest\\isPath.zip";
        mergeZipAndFiles(Paths.get(zipPath2));

//        prepareFiles(Paths.get(pathForCreate)); // подготавливаем список файлов для запаковки
//        createZipForPath(Paths.get(testStrZip)); // создаем zip из подготовленного списка
// распаковка указанного архива в указ директорию
//        unpackZipFromPath(Paths.get(testStrZip), Paths.get((pathForUnzipIn)));

        // если попытаться прочитать архив созднанный не в Java то Exception, _ а архив созданный через java то работает
//        mapFiles.forEach((k, v) -> System.out.println("key: " + k + ", v: " + v));
//        mapFilesFromZip.forEach((k, v) -> System.out.println("key: " + k + ", v: " + v));
    }

    public static void mergeZipAndFiles(Path outZip) {
        try (ZipOutputStream zipOut = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(outZip.toString())))) {
            for (Map.Entry<Path, byte[]> pare : mapFiles.entrySet()) {
//                Path pathForNewFiles = Paths.get("new").resolve(pare.getKey()); // создаем путь к новым файлам
//                ZipEntry entry = new ZipEntry(pathForNewFiles.toString());
                ZipEntry entry = new ZipEntry("new" + File.separator + pare.getKey().toString());
                zipOut.putNextEntry(entry);
                zipOut.write(pare.getValue());
            }

            for (Map.Entry<Path, byte[]> pare2 : mapFilesFromZip.entrySet()) {
                zipOut.putNextEntry(new ZipEntry(pare2.getKey().toString()));
                zipOut.write(pare2.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void unpackZipFromPath(Path pathToZipFile, Path outputFolder) throws IOException {
        if (Files.notExists(outputFolder)) {
            Files.createDirectories(outputFolder);
        }

        try (ZipInputStream zipIn = new ZipInputStream(new BufferedInputStream(new FileInputStream(new File(pathToZipFile.toString()))))) {
            ZipEntry zipEntry = null;

            // получаем следующий внутренний файл через zip поток (т.е. как интератор по коллекции)
            while ((zipEntry = zipIn.getNextEntry()) != null) {
                String name = zipEntry.getName();
                Path fileFullName = outputFolder.resolve(name); // совмещаем внутрений путь архива с исходной папкой
                Path parent = fileFullName.getParent(); // получаем имя папки для исходного файла
                if (Files.notExists(parent)) { // создаем недостающие директории
                    Files.createDirectories(parent);
                }

//                byte[] bytes1 = zipIn.readAllBytes();   // JRush компилятор ругается
                for (int c = zipIn.read(); c != -1; c = zipIn.read()) {
                    try (BufferedOutputStream bfOut = new BufferedOutputStream(new FileOutputStream(new File(fileFullName.toString())))) {
                        bfOut.write(c);  // записываем полученное в файл
                    }
                }

            }
        }
    }

    public static void createZipForPath(Path pathForZipFile) {
        try (ZipOutputStream zipOut = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(pathForZipFile.toString())))) {
            for (Map.Entry<Path, byte[]> pare : mapFiles.entrySet()) {
                Path pathKey = pare.getKey();
//                pathForNewEntry = pathKey.toAbsolutePath() + File.separator + pathKey.getFileName();
                ZipEntry entry = new ZipEntry(pathKey.toString()); // устанавливаем внтренний путь нового архива
                zipOut.putNextEntry(entry);
//            byte[] bytesFromFile = getBytesFromFile(pathFile);
                byte[] bytesFromFile = pare.getValue();
                // т.е. для каждого архивируемого файла/папка следует указывать внутренний путь putNextEntry(..)
                //  только потом записыват массив байтов нужного файла в архив (предварительно подготовив массив байтов)
                zipOut.write(bytesFromFile);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void prepareFilesFromZip(Path path) {
        try (ZipInputStream zipIn = new ZipInputStream(new BufferedInputStream(new FileInputStream(path.toString())))) {
            ZipEntry nextEntry;
            while ((nextEntry = zipIn.getNextEntry()) != null) {

//                byte[] bytes = zipIn.readAllBytes();  // JRush компилятор ругается

                List<Byte> list = new ArrayList<>();
                for (int c = zipIn.read(); c != -1; c = zipIn.read()) {
//                        bfOut.write(c);  // записываем полученное в файл
//                        list.add(Byte.valueOf(String.valueOf(c)));
                    list.add((byte) c);
                }

                byte[] bytes = new byte[list.size()];
                for (int i = 0; i < list.size(); i++) {
                    bytes[i] = list.get(i);
                }

                mapFilesFromZip.put(Paths.get(nextEntry.getName()), bytes);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /////////////////////
    public static void prepareFiles(Path path) throws IOException { // получаем список файлов с путями к ним для архивации
        if (new File(path.toString()).isFile()) { // если это 1 файл
//            mapFiles.put(path.relativize(path), getBytesFromFile(path)); // C:\z_path\result.mp3
            mapFiles.put(path.getParent().relativize(path), getBytesFromFile(path)); // result.mp3
        } else {
            Files.walkFileTree(path, new MyFileVisitor(path));
        }
    }

    private static byte[] getBytesFromFile(Path pathFile) {
        try (BufferedInputStream bfIn = new BufferedInputStream(new FileInputStream(new File(pathFile.toString())))) {
//        try (BufferedInputStream bfIn = new BufferedInputStream(new ByteArrayInputStream(byte[]))) {
//            byte[] bytesFile = new byte[bfIn.available()];

            List<Byte> list = new ArrayList<>();
            for (int c = bfIn.read(); c != -1; c = bfIn.read()) {
//                        bfOut.write(c);  // записываем полученное в файл
//                        list.add(Byte.valueOf(String.valueOf(c)));
                list.add((byte) c);
            }

            byte[] bytes = new byte[list.size()];
            for (int i = 0; i < list.size(); i++) {
                bytes[i] = list.get(i);
            }

            return bytes;
//            return bfIn.readAllBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    public static class MyFileVisitor extends SimpleFileVisitor<Path> {
        private Path rootPath;

        public MyFileVisitor(Path rootPath) {
            this.rootPath = rootPath;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//            Path p = file.toAbsolutePath(); // C:\z_n\new_test_folder\1\2\333\move.txt
//            Path p = file; // C:\z_n\new_test_folder\1\2\333\move.txt
//            Path p = file.getParent(); // C:\z_n\new_test_folder\1\2\333
            mapFiles.put(rootPath.relativize(file), getBytesFromFile(file));
            return super.visitFile(file, attrs);
        }
    }

}
