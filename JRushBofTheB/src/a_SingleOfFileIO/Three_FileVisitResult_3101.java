package a_SingleOfFileIO;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/*
Проход по дереву файлов
*/
// https://javarush.ru/tasks/com.javarush.task.task31.task3101#discussion
// 1. На вход метода main() подаются два параметра.
//Первый - path - путь к директории, второй - resultFileAbsolutePath - имя (полный путь) существующего файла,
// который будет содержать результат.
//2. Переименовать resultFileAbsolutePath в allFilesContent.txt (используй метод FileUtils.renameFile(), и,
// если понадобится, FileUtils.isExist()).
//3. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
//Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
//3.1. Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
//3.2. В allFilesContent.txt последовательно записать содержимое всех файлов из п. 3.1. После каждого тела файла записать "\n".
//Все файлы имеют расширение txt.
//В качестве разделителя пути используй "/".
// from https://github.com/XFNeo/JavaRushTasks/blob/master/4.JavaCollections/src/com/javarush/task/task31/task3101/Solution.java
public class Three_FileVisitResult_3101 {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) return;
        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
        List<Path> allFiles = new ArrayList<>();

        if (FileUtils.isExist(resultFileAbsolutePath)) {
            FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
        }
        Files.walkFileTree(Paths.get(path.getPath()), new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                if (attrs.size() <= 50) {
                    allFiles.add(file);
                }
                return FileVisitResult.CONTINUE;
            }
        });
        allFiles.sort(Comparator.comparing(Path::getFileName));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(allFilesContent))) {
            for (Path file : allFiles) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file.toFile()))) {
                    while (reader.ready()) {
                        writer.write(reader.readLine());
                        writer.write("\n");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class FileUtils {

        public static void deleteFile(File file) {
            if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
        }

        public static void renameFile(File source, File destination) {
            if (!source.renameTo(destination)) System.out.println("Can not rename file with name " + source.getName());
        }

        public static boolean isExist(File file) {
            return file.exists();
        }
    }

    ////////////////////////
    public static class Solution_My {
        private List<String> list = new ArrayList<>();
        public static void main(String[] args) throws IOException {
            Solution_My sol = new Solution_My();
            String param_path = args[0];
            String param_resultFileAbsolutePath = args[1];
//        String param_path = "C:\\z_n\\new_test_folder";
//        String param_resultFileAbsolutePath = "C:\\z_n\\new_test_folder\\result.txt";

            File filePath = new File(param_resultFileAbsolutePath);

            String param_resultRename = "C:\\z_n\\new_test_folder\\allFilesContent.txt";

            File newFileName = new File(filePath.getParent() + File.separator + "allFilesContent.txt");
            if (FileUtils.isExist(filePath)) { //  Переименовать resultFileAbsolutePath в allFilesContent.txt
                FileUtils.renameFile(filePath, newFileName);
            }

            for (File item : Objects.requireNonNull(newFileName.getParentFile().listFiles())) {
                sol.prepareRecursivePath(item.toString()); // заполняем список путей ко всем файлам учитывая под папки
            }

            // Отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке.
            Collections.sort(sol.list, (v1, v2) -> {
                File f1 = new File(v1);
                File f2 = new File(v2); // учитываем ток имя
                return f1.getName().compareTo(f2.getName());
            });

            // В allFilesContent.txt последовательно записать содержимое всех файлов из п. 3.1.
            // После каждого тела файла записать "\n".
            List<byte[]> listBytes = new ArrayList<>();
            for (String item : sol.list) {
//            try (InputStream in = Files.newInputStream(Paths.get(item))) { //  try для AutoCloseable
//                    listBytes.add(in.readAllBytes()); // валя не пускает
                try (InputStream in = new FileInputStream(item)) {
                    byte[] buf = new byte[in.available()];
                    for (int i = 0; i < in.available(); i++) {
                        in.read(buf);
                    }
                    listBytes.add(buf);
                }
            }

            // валя ругается на try with resource
//        try (OutputStream out = Files.newOutputStream(newFileName.toPath())) {
            OutputStream out = null;
            try {
                out = Files.newOutputStream(newFileName.toPath());
                for (byte[] item : listBytes) {
                    out.write(item);
                    out.write("\n".getBytes());
                }
            } finally {
                out.close();
            }

        }

        public void prepareRecursivePath(String path) throws IOException {
            File file = new File(path);
            if (Files.isRegularFile(file.toPath())) {
                try (InputStream in = new FileInputStream(file)) {
                    // Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
                    if (in.available() < 50) {
                        list.add(path); // добавляем ток пути к файлу
                    }
                }
// если файл то файл отправляется и опять вызывает в этом же методе этот же блок ветвления = StackOverFlowError
//            for (File item : file.getParentFile().listFiles()) {
//                recursivePath(item.toString());
//            }
            } else {
// если директория то директория отправляется и опять вызывает в этом же методе этот же блок ветвления
// = StackOverFlowError
//        for (File item : Objects.requireNonNull(newFileName.getParentFile().listFiles())) {
                for (File item : Objects.requireNonNull(file.listFiles())) { // а так всё норм
                    prepareRecursivePath(item.toString());
                }
            }
        }
    }

}

