package a_SingleOfFileIO;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

// https://javarush.ru/tasks/com.javarush.task.task31.task3111#discussion
// Давай реализуем настраиваемый поиск файлов в директории.
//Просмотри интерфейс java.nio.file.FileVisitor и его базовую реализацию java.nio.file.SimpleFileVisitor.
//Во время поиска по дереву файлов с помощью метода Files.walkFileTree(Path start, FileVisitor<? super Path> visitor)
//мы используем объект FileVisitor для выполнения необходимых операций над найденными объектами Path.
//
//Наш класс для поиска будет называться SearchFileVisitor и расширять SimpleFileVisitor.
//
//Поиск можно будет выполнять по таким критериям:
//- выражение, встречающееся в названии файла (String);
//- выражение, встречающееся в содержимом файла (String);
//- максимальный и минимальный размер файла (int).
//Можно задавать либо один, либо сразу несколько критериев для поиска.

// сам сделал _ интересная задача взомжно стоит попробовать ее реализовать через паттерн Цепочка Ответственности
// Потенциально.., ещё её можно решить, используя паттерн Цепочка обязанностей, или иcпользуя Package java.util.function - с лямбдами..
public class SearchFileVisitor_3111 extends SimpleFileVisitor<Path> {
    public static void main(String[] args) throws IOException {
        SearchFileVisitor_3111 searchFileVisitor = new SearchFileVisitor_3111();
        // Можно задавать либо один, либо сразу несколько критериев для поиска.
        searchFileVisitor.setPartOfName("amigo"); // встречающееся в названии файла
        searchFileVisitor.setPartOfContent("programmer"); // встречающееся в содержимом файла
        searchFileVisitor.setMinSize(500); // минимал размер файла
        searchFileVisitor.setMaxSize(10000); // максимал размер файла

        Files.walkFileTree(Paths.get("D:/SecretFolder"), searchFileVisitor);

        List<Path> foundFiles = searchFileVisitor.getFoundFiles();
        for (Path file : foundFiles) {
            System.out.println(file);
        }
    }



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
