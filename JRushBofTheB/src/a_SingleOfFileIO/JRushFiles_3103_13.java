package a_SingleOfFileIO;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Scanner;

public class JRushFiles_3103_13 {
    // https://javarush.ru/tasks/com.javarush.task.task31.task3103#discussion
    public static byte[] readBytes(String fileName) throws IOException {
        return Files.readAllBytes(Paths.get(fileName)); // возвращать все байты файла fileName.
    }

    // возвращать все строки файла fileName. Используй кодировку по умолчанию.
    public static List<String> readLines(String fileName) throws IOException {
        return Files.readAllLines(Paths.get(fileName));
    }

    public static void writeBytes(String fileName, byte[] bytes) throws IOException {
        Files.write(Paths.get(fileName), bytes); // должен записывать массив bytes в файл fileName.
    }

    // должен копировать файл resourceFileName на место destinationFileName.
    public static void copy(String resourceFileName, String destinationFileName) throws IOException {
        Files.copy(Paths.get(resourceFileName), Paths.get(destinationFileName));
    }

    //////////////////////
    // https://javarush.ru/tasks/com.javarush.task.task31.task3104#discussion
    public static class Solution_3111 extends SimpleFileVisitor<Path> {
        public static void main(String[] args) throws IOException {
            EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
            final Solution_3111 solution3111 = new Solution_3111();
            Files.walkFileTree(Paths.get("D:/"), options, 20, solution3111);

            List<String> result = solution3111.getArchived();
            System.out.println("All archived files:");
            for (String path : result) {
                System.out.println("\t" + path);
            }

            List<String> failed = solution3111.getFailed();
            System.out.println("All failed files:");
            for (String path : failed) {
                System.out.println("\t" + path);
            }
        }

        private List<String> archived = new ArrayList<>();
        private List<String> failed = new ArrayList<>();

        public List<String> getArchived() {
            return archived;
        }

        public List<String> getFailed() {
            return failed;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//        Path p = Paths.get(file.toString());
//        p.endsWith()
            if (file.toString().endsWith(".zip") | file.toString().endsWith(".rar")) {
                archived.add(file.toString());
            }
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
//        Files.isReadable(file);
//        Files.isWritable(file);
            failed.add(file.toString());
            return FileVisitResult.SKIP_SUBTREE;
        }
    }

    // https://javarush.ru/tasks/com.javarush.task.task31.task3112#discussion
    public class Solution_3112 {
        public static void main(String[] args) throws IOException {
            Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

            for (String line : Files.readAllLines(passwords)) {
                System.out.println(line);
            }

        }

        public static Path downloadFileFromGitNeo(String urlString, Path downloadDirectory) throws IOException {
            URL url = new URL(urlString);
            Path tmp = Files.createTempFile("temp-", "tmp");
            Files.copy(url.openStream(), tmp, StandardCopyOption.REPLACE_EXISTING);
            Path result = Paths.get(downloadDirectory.toString(), urlString.substring(urlString.lastIndexOf("/")));
            Files.move(tmp, result);
            return result;
        }

        // my V1
        public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
            // implement this method
            // Имя сохраненного файла должно быть таким же, как в URL-ссылке.
            // https://yastatic.net/morda-logo/i/citylogos/yandex19-logo-ru.png
            int index = urlString.lastIndexOf("/");   // 43
            String fileNameStr = urlString.substring(index + 1, urlString.length());   // yandex19-logo-ru.png

            URL url = new URL(urlString);
            InputStream inputStream = url.openStream();
//        Files.copy(inputStream, downloadDirectory);

            // Выкачивай сначала во временную директорию,
            // чтобы в случае неуспешной загрузки в твоей директории не оставались недокачанные файлы.
            Path tempFile = Files.createTempFile("tmp", "_file_");
            Files.copy(inputStream, tempFile, StandardCopyOption.REPLACE_EXISTING);

            // Затем перемести файл в пользовательскую директорию. Имя для файла возьми из ссылки.
            // должен переместить файл из временной директории в пользовательскую
            String separator = System.lineSeparator();
//        String strForNewPath = downloadDirectory.toString() + separator + fileNameStr;
            Path newPath = Paths.get(downloadDirectory.toString(), fileNameStr);
            Files.move(tempFile, newPath);

            return newPath;   // возвращаем путь к скачанному файлу _ т.е. место на диске куда его кинули
        }
    }

    // https://javarush.ru/tasks/com.javarush.task.task31.task3113#discussion
    public static class Solution_3113 {
        private static int filesCounter = 0;
        private static int directoryCounter = 0;
        private static long commonSize = 0;

        public static void main(String[] args) throws IOException {
//        Path path = Paths.get("c:\\z_n\\new_test_folder\\");

//        Scanner sc = new Scanner(System.in);
//        String line = sc.nextLine();
            Path path = Paths.get(new Scanner(System.in).nextLine());

            if (Files.isDirectory(path)) {
                Files.walkFileTree(path, new MyWalkOnTheTree());
                // ри подсчете количества папок, изначальную директорию считать не нужно.
                System.out.println("Всего папок - " + (directoryCounter - 1));
                System.out.println("Всего файлов - " + filesCounter);
                System.out.println("Общий размер - " + commonSize); // b
            } else {
                System.out.println(path.toString() + " - не папка");
            }
//        System.out.println("Общий размер - " + (commonSize / 1024)); // kb
//        System.out.println("Общий размер - " + ((commonSize / 1024) / 1024)); // mb
        }

        public static class MyWalkOnTheTree extends SimpleFileVisitor<Path> {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//            byte[] bytes = Files.readAllBytes(file);
//            long size = Files.size(file);
                commonSize += attrs.size();
                filesCounter++;
                return super.visitFile(file, attrs);
            }

//        @Override   // тож подходит
//        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
//            directoryCounter++;
//            return super.postVisitDirectory(dir, exc);
//        }

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                directoryCounter++;
                return super.preVisitDirectory(dir, attrs);
            }
        }
    }

}
