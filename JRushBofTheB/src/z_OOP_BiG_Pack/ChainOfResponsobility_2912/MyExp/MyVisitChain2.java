package z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class TestServer2 extends SimpleFileVisitor<Path> {
    // Можно задавать либо один, либо сразу несколько критериев для поиска.
    private int maxSize, minSize;
    private int contentLength; // минимал и максимал размеры файла
    private String partOfContent; // встречающееся в содержимом файла
    private String partOfName; // встречающееся в названии файла
    private Path filePath;
    private List<Path> foundFiles = new ArrayList<>();
    private ChainCommon chainCommon;

    public void setChainCommon(ChainCommon chainCommon) {
        this.chainCommon = chainCommon;
    }

    public boolean runAllCheck() throws IOException {
        return chainCommon.check();
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        contentLength = content.length;
        filePath = file;

        // My способ через паттерн цепочка обязанностей
//        ChainCommon chainCommon = new CheckMaxSize(this)
//                .linkWith(new CheckMinSize(this));
//
//        // this - через этот объект, "чекеры" получают данные, что им надо проверить
//        ChainCommon chainCommon2 = new CheckMinSize(this)
//                .linkWith(new CheckMaxSize(this));
////                .linkWith(new CheckPartOfName(this));
////                .linkWith(new CheckPartOfContent(this)); // MalformedInputException
//
//        this.setChainCommon(chainCommon2);  // сеттим нужную цепь проверок
//
//        if (this.runAllCheck()) { // запускает все проверки (слева направо) и возвращает boolean
//            foundFiles.add(file);
//        }

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
