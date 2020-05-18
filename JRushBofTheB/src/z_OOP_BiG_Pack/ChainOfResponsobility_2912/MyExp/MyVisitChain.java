package z_OOP_BiG_Pack.ChainOfResponsobility_2912.MyExp;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
// Вместо цепочки Ответственности + можно применять кучу ветвлений или..
// Потенциально.., ещё её можно решить, используя паттерн Цепочка обязанностей, или иcпользуя Package java.util.function - с лямбдами..

public class MyVisitChain extends SimpleFileVisitor<Path> {
    public static void main(String[] args) throws IOException {
        MyVisitChain searchFileVisitor = new MyVisitChain();
        // Можно задавать либо один, либо сразу несколько критериев для поиска.
        searchFileVisitor.setPartOfName("new"); // встречающееся в названии файла
        searchFileVisitor.setPartOfContent("Pokemon"); // встречающееся в содержимом файла
        searchFileVisitor.setMinSize((1024 * 1024) * 3); // минимал размер файла 10мб
        searchFileVisitor.setMaxSize((1024 * 1024) * 9); // максимал размер файла 100мб


        Files.walkFileTree(Paths.get("c:\\z_n\\new_test_folder\\ttt\\"), searchFileVisitor);

        List<Path> foundFiles = searchFileVisitor.getFoundFiles();
        for (Path file : foundFiles) {
            System.out.println(file);
        }
        System.out.println("size is: " + foundFiles.size()); // 267 всего
//        System.out.println((1024 * 1024) * 10);
    }


    // Можно задавать либо один, либо сразу несколько критериев для поиска.
    boolean isMinSize = false, isMaxSize = false, isPartOfContent = false, isPartOfName = false;

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
        if (chainCommon.check()) {
            return true;
        }
        return false;
//        return chainCommon.check();
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        contentLength = content.length;
        filePath = file;

        // мой способ
//        validateAndAddFile(file, content.length);

        // Лямбдами _ если юзать a.getContentLength() - то будет результ не верен
        // слово не содержащее в своем имени new, не отсеивается.. хз почему
//                .and(a -> file.getFileName().toString().contains(a.getPartOfName()));

//                .and(a -> {
//                    try {
//                        List<String> list = Files.readAllLines(file);
//                        for (String item : list) {
//                            if (item.contains(a.getPartOfContent())) {
//                                return true;
//                            }
//                        }
//                        return false;
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                    return true;
//                });


//        Predicate<MyVisitChain> minMax = a -> contentLength > a.getMinSize();
//        minMax.and(a -> contentLength < a.getMaxSize());
//        boolean isMinMax = minMax.test(this);

        Predicate<MyVisitChain> min = a -> contentLength > a.getMinSize();
        Predicate<MyVisitChain> max = a -> contentLength < a.getMaxSize();
        Predicate<MyVisitChain> fileName = a -> file.getFileName().toString().contains(a.getPartOfName());
        Predicate<MyVisitChain> checkContent = a -> {
            try {
                List<String> list = Files.readAllLines(file);
                for (String item : list) {
                    if (item.contains(a.getPartOfContent())) {
                        return true;
                    }
                }
                return false;
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        };

        boolean isMin = min.test(this);
        boolean isMax = max.test(this);
        boolean isName = fileName.test(this);
        boolean isContains = checkContent.test(this);

        if (isMin && isMax && isName && isContains) {
            foundFiles.add(file);
        }

        // My способ через паттерн цепочка обязанностей
//        ChainCommon chainCommon = new CheckMaxSize(this)
//                .linkWith(new CheckMinSize(this));

//        boolean expFlag = new CheckMaxSize(this)
//                .linkWith(new CheckMinSize(this)).runAllChecks();
        // как бы не пытался всеравно запускает ток последн метод что со списком что без
        // работает ток если сетит цепь на сервер
//                .check(); // запускает ток последн проверку

        // this - через этот объект, "чекеры" получают данные, что им надо проверить
//        ChainCommon chainCommon2 = new CheckMinSize(this)
//                .linkWith(new CheckMaxSize(this));
//                .linkWith(new CheckPartOfName(this));
//                .linkWith(new CheckPartOfContent(this)); // MalformedInputException

//        this.setChainCommon(chainCommon2);  // сеттим нужную цепь проверок

//        if (this.runAllCheck()) { // запускает все проверки (слева направо) и возвращает boolean
//        if (expFlag) {
//        foundFiles.add(file);
//        }

        // способ ветвлений
//        if (partOfName != null && !file.getFileName().toString().contains(partOfName)) return FileVisitResult.CONTINUE;
//        if (partOfContent != null && Files.readAllLines(file).stream().noneMatch(s -> s.contains(partOfContent))) return FileVisitResult.CONTINUE;
//        if (minSize != 0 && attrs.size() < minSize) return FileVisitResult.CONTINUE;
//        if (maxSize != 0 && attrs.size() > maxSize) return FileVisitResult.CONTINUE;
//        foundFiles.add(file);
//        return super.visitFile(file, attrs);
        return FileVisitResult.CONTINUE;
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

    ///////////

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
