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
public class SolutionV2_3105 {
    private static Map<Path, byte[]> mapFiles = new LinkedHashMap<>();
    private static Map<Path, byte[]> mapFilesFromZip = new LinkedHashMap<>();
    private static List<Path> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
//        String filePath = args[0];
//        String zipPath = args[1];

        String testStr = "c:\\z_n\\new_test_folder\\";
        String testStrZip = "C:\\z_n\\new_test_folder\\2.zip";

        String filePath = "C:\\z_path\\result.mp3";
        String zipPath = "C:\\z_pathToTest\\test.zip";

//        prepareFiles(Paths.get(filePath));
        prepareFilesFromZip(Paths.get(testStrZip));
//        mapFiles.forEach((k, v) -> System.out.println("key: " + k + ", v: " + v));
        mapFilesFromZip.forEach((k, v) -> System.out.println("key: " + k + ", v: " + v));
    }


    public static void unpackZipFromPath() {
        Path pathZipFile = Paths.get("c:\\z_n\\new_test_folder\\Point.zip"); // путь к будущему архиву
        // путь к будущему архиву
        // надо проверять наличи необходимой папки и если нет, то создавать а иначе FileNotFoundException
//        Path pathUnpackIn = Paths.get("c:\\z_n\\new_test_folder\\out_fromZip\\" + pathZipFile.getFileName());
        Path pathUnpackIn = Paths.get("c:\\z_n\\new_test_folder\\newPoint.java");

        try (ZipInputStream zipIn = new ZipInputStream(new BufferedInputStream(new FileInputStream(new File(pathZipFile.toString()))));
             BufferedOutputStream bfOut = new BufferedOutputStream(new FileOutputStream(new File(pathUnpackIn.toString())));
        ) {
            ZipEntry zipEntry = null;
            // получаем следующий внутренний файл через zip поток (т.е. как интератор по коллекции)
            while ((zipEntry = zipIn.getNextEntry()) != null) {
                // это не массив байтов _ это полученияхранилищя каки=то данных к конкретной Entry
//                byte[] extra = zipEntry.getExtra();  // this entry's last modification time, last access time

                // вариант 0 _ don't work
//                byte[] bytes = new byte[zipIn.available()];
//                zipIn.read(bytes); // считываем в массив байтов __ запись в файле не корректна
//                bfOut.write(bytes);

                // вариант 1
//                byte[] bytes1 = zipIn.readAllBytes();
//                bfOut.write(bytes1);  // записываем полученное в файл

                // вариант 2
//                for (int c = zipIn.read(); c != -1; c = zipIn.read()) {
//                    bfOut.write(c);
//                }
            }

            // вариант 3
            // либо получаем entries() что-то вроде массива.., объект Enumeration и интерируемся по нему
            // при этом при каждой интерации по новой создаются потоки вывода (т.е. отдельно для каждого Entry)
            // _ а поток чтения Entry получают из ZipFile - объекта
//            try (ZipFile zipFile = new ZipFile(new File(pathZipFile.toString()))) {
//                Enumeration<? extends ZipEntry> entries = zipFile.entries();
//                while (entries.hasMoreElements()) {
//                    zipEntry = (ZipEntry) entries.nextElement();
//                    write(zipFile.getInputStream(zipEntry), new BufferedOutputStream(new FileOutputStream(
//                            new File(pathUnpackIn.getParent().toString(), "suffix" + zipEntry.getName()))));
//                }
//            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void write(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) >= 0)
            out.write(buffer, 0, len);
        out.close();
        in.close();
    }

    public static void createZipFromPath(Path fileName, Path inToZipPath) {
//        Path pathFile = Paths.get("c:\\z_n\\new_test_folder\\Point.java"); // путь к файлу что архивируем
//        Path pathZipFile = Paths.get("c:\\z_n\\new_test_folder\\Point.zip"); // путь к будущему архиву
        Path pathFile = fileName;
        Path pathZipFile = inToZipPath;

        // не понял ошибку в subpath
//        Path subpath = pathFile.getParent().subpath(pathFile.getNameCount() - 1, pathFile.getNameCount());
//        Path correctPath = Paths.get(pathFile.getParent() + File.separator + subpath + ".zip");
//        System.out.println(correctPath);
//        File file = new File(pathFile.getParent() + File.separator + pathFile.getFileName() + ".zip");

        File file = new File(pathZipFile.toString());
        try (ZipOutputStream zipOut = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(pathZipFile.toString())))) {
            ZipEntry entry = new ZipEntry(pathFile.getFileName().toString()); // устанавливаем внтренний путь нового архива
            zipOut.putNextEntry(entry);
            byte[] bytesFromFile = getBytesFromFile(pathFile);
            // т.е. для каждого архивируемого файла/папка следует указывать внутренний путь putNextEntry(..)
            //  только потом записыват массив байтов нужного файла в архив (предварительно подготовив массив байтов)
            zipOut.write(bytesFromFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void prepareFilesFromZip(Path path) {
        try (ZipInputStream zipIn = new ZipInputStream(new BufferedInputStream(new FileInputStream(path.toString())))) {
            ZipEntry nextEntry;
            while ((nextEntry = zipIn.getNextEntry()) != null) {
//                ZipFile zipFile = new ZipFile(zipIn.getNextEntry())
//                byte[] bytes = zipIn.readAllBytes();
//                mapFilesFromZip.put(Paths.get(nextEntry.getName()), bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /////////////////////
    public static void prepareFiles(Path path) throws IOException { // получаем список файлов с путями к ним для архивации
        Files.walkFileTree(path, new MyFileVisitor());
    }

    private static byte[] getBytesFromFile(Path pathFile) {
        try (BufferedInputStream bfIn = new BufferedInputStream(new FileInputStream(new File(pathFile.toString())))) {
//        try (BufferedInputStream bfIn = new BufferedInputStream(new ByteArrayInputStream(byte[]))) {
//            byte[] bytesFile = new byte[bfIn.available()];
//            return bfIn.readAllBytes();
            return new byte[0];
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }


    public static class MyFileVisitor extends SimpleFileVisitor<Path> {

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            mapFiles.put(file, getBytesFromFile(file));
            return super.visitFile(file, attrs);
        }
    }

}
