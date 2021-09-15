package z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp.chainCommon;

import z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp.chainCommon.checkers.*;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class MyVisitChain_V3 extends SimpleFileVisitor<Path> {
    // Можно задавать либо один, либо сразу несколько критериев для поиска.
    private int maxSize, minSize;
    private int contentLength; // минимал и максимал размеры файла
    private String partOfContent; // встречающееся в содержимом файла
    private String partOfName; // встречающееся в названии файла
    private Path filePath;
    private List<Path> foundFiles = new ArrayList<>();
    private ChainCommon chainCommon;

    public static void main(String[] args) throws IOException {
        MyVisitChain_V3 searchFileVisitor = new MyVisitChain_V3();
        // Можно задавать либо один, либо сразу несколько критериев для поиска.
//        searchFileVisitor.setPartOfName("new"); // встречающееся в названии файла
        searchFileVisitor.setPartOfContent("Pokemon"); // встречающееся в содержимом файла
//        searchFileVisitor.setMinSize((1024 * 1024) * 4); // минимал размер файла 10мб
//        searchFileVisitor.setMinSize((1024 * 1024)); // 1mb?
//        searchFileVisitor.setMinSize(0); // минимал размер файла 10мб
//        searchFileVisitor.setMaxSize((1024 * 1024) * 11); // максимал размер файла 100мб

        Files.walkFileTree(Paths.get("C:\\z_dev\\z_test_forJava"), searchFileVisitor);

        List<Path> foundFiles = searchFileVisitor.getFoundFiles();
        for (Path file : foundFiles) {
            System.out.println(file);
        }
        System.out.println("size is: " + foundFiles.size()); // 267 всего
//        System.out.println((1024 * 1024) * 10);


    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        contentLength = content.length;
        this.filePath = file;

        CheckMaxSize maxSize = new CheckMaxSize(this);
        maxSize.linkWith(new CheckMinSize(this))
                .linkWith(new CheckPartOfName(this))
                .linkWith(new CheckPartOfContent(this));
        boolean result = maxSize.foolCheck();

        if (result) {
            foundFiles.add(file);
        }

        return FileVisitResult.CONTINUE;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public int getMinSize() {
        return minSize;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public String getPartOfContent() {
        return partOfContent;
    }

    public String getPartOfName() {
        return partOfName;
    }

    public int getContentLength() {
        return contentLength;
    }

    public Path getFilePath() {
        return filePath;
    }
}
