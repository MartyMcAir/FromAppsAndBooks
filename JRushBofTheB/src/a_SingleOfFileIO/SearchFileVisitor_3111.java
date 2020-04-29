package com.javarush.task.task31.task3111;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    // Можно задавать либо один, либо сразу несколько критериев для поиска.
    boolean isMinSize = false, isMaxSize = false, isPartOfContent = false, isPartOfName = false;

    private int minSize, maxSize; // минимал и максимал размеры файла
    private String partOfContent; // встречающееся в содержимом файла
    private String partOfName; // встречающееся в названии файла
    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length

        validateAndAddFile(file, content.length);
        return super.visitFile(file, attrs);
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
        this.isMinSize = true;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
        this.isMaxSize = true;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
        this.isPartOfContent = true;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
        this.isPartOfName = true;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    //////
    private void validateAndAddFile(Path file, int length) throws IOException {
        if (checkMaxSize(length) && checkMinSize(length)
                && checkPartOfContent(file) && checkPartOfName(file)) {
            foundFiles.add(file);
        }
    }

    private boolean checkMinSize(int length) {
        if (isMinSize) {
            return length > minSize;
        }
        return true;
    }

    private boolean checkMaxSize(int length) {
        if (isMaxSize) {
            return length < maxSize;
        }
        return true;
    }

    private boolean checkPartOfName(Path file) {
        if (isPartOfName) {
            return new File(file.toString()).getName().contains(partOfName);
        }
        return true;
    }

    private boolean checkPartOfContent(Path file) throws IOException {
        if (isPartOfContent) {
            List<String> list = Files.readAllLines(file);
            for (String item : list) {
                if (item.contains(partOfContent)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

}
