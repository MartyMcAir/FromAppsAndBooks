package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;

/*
Проход по дереву файлов
*/
public class Solution {
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
}
