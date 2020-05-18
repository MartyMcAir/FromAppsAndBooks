package b_BigTusks.zipPack_3105_3106;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class SolutionV2_3106 {
    public static void main(String[] args) throws IOException {
//        String file1 = "C:\\z_path\\result.mp3";
//        String file = "C:\\z_path\\words.txt";
//
        String inputDirectory = "C:\\z_path\\ttt";
//        // наполняем массив путями к файлам
        String[] files = {"result.zip.001", "result.zip.002", "result.zip.003", "result.zip.004"};
        exampleV1(inputDirectory, files);


    }

    private static void exampleV1(String inputDirectory, String[] files) throws IOException {
        Vector<FileInputStream> v = new Vector<FileInputStream>(files.length);
        for (int x = 0; x < files.length; x++) {
            v.add(new FileInputStream(inputDirectory + File.separator + files[x]));
        }
        // ещё вариант для создания Enumeration
//        Enumeration<FileInputStream> enumeration = Collections.enumeration(Arrays.asList(new FileInputStream("test.zip.001"),
//                new FileInputStream("test.zip.002"), new FileInputStream("test.zip.003")));

        // конвертим список в Enumeration - аналог iterator'a
        Enumeration<FileInputStream> e = v.elements();
        // Объект позволяющий конкатенировать Input потоки
        SequenceInputStream sequenceInputStream = new SequenceInputStream(e);

        // отправляем откантенированный поток в ZipInput.. и дале как обычно
        try (ZipInputStream is = new ZipInputStream(new BufferedInputStream(sequenceInputStream))) {
            for (ZipEntry entry = null; (entry = is.getNextEntry()) != null; ) { // необычный use для цикла for

                // путь куда кидать распакованные файлы
                String fileOutPath = "C:\\z_path\\ttt\\333\\" + entry.getName();
                // при каждой интерации создается новый поток для каждого распаковывающегося Entry-файла
                // в конкретном примере будет на выходе 1 файл по пути C:\z_path\ttt\333\result.mp3
                try (OutputStream os = new BufferedOutputStream(new FileOutputStream(fileOutPath))) {
//                    byte[] bytes = is.readAllBytes();
//                    os.write(bytes);

                    // для чтения побайтово частями _ для оч. больших файлов
                    final int bufferSize = 1024;
                    byte[] buffer = new byte[bufferSize];
                    for (int amountOfBytes = -1; (amountOfBytes = is.read(buffer, 0, bufferSize)) > -1; ) {
                        // запись от 0 до amountOfBytes, т.е. что бы записывал именно то кол-во байтов за 1 цикл
                        // на сколько расчитан баффер, а последн интерация будет естественно уникал размера
                        // потому и получают это число из read(..) метода __ (а не юзают просто bufferSize)
                        os.write(buffer, 0, amountOfBytes);
                    }
                }
            }
        }
    }

    private static void myTry(String file) throws IOException {
        ByteArrayOutputStream byteArrOut = new ByteArrayOutputStream();
        Files.copy(Paths.get(file), byteArrOut); // получаем поток всех байтов
        int byteSize = byteArrOut.size(); // размер в байтах
        int partSize = byteSize / 4;  // вычисляем размер отдельной части
        byte[] bytes = byteArrOut.toByteArray(); // массив всех байтов Out потока

//        System.out.println(bytes.length);
        System.out.println("byteSize: " + byteSize + ", partSize: " + partSize);


        List<byte[]> listParts = new ArrayList<>();
//        listParts.forEach(v -> System.out.println(v.length));
//        System.out.println(Arrays.toString(bytes)); // 22
//        listParts.forEach(v -> System.out.println(Arrays.toString(v)));


        // непонятно почему добавляет не сам buffer а одни нули
//        for (int i = 0; i < 5; i++) {
//            byte[] buffer = new byte[partSize]; // после каждой нов интерации обнуляем
////            byteArrOut.write(buffer);
//            byteArrOut.writeBytes(buffer);
////            System.out.println(buffer.length);
//            listParts.add(buffer);
//        }


//            // OutOfMemoryError: Java heap space
//        for (int i = 0; i < bytes.length; i++) {
//            byte[] bytesPart = new byte[partSize]; // после каждой нов интерации обнуляем
//            for (int count = 0; count < partSize; count++) {
//                bytesPart[count] = bytes[i];
//            }
//            listParts.add(bytesPart);
//        }


//        try (ZipOutputStream zipIn = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(file)))) {
//            byte[] bufferPart = new byte[partSize];
//            byteArrOut.write(bufferPart);
//        }
//
//        try (ZipInputStream zipIn = new ZipInputStream(new BufferedInputStream(new FileInputStream(file)))) {
//        }


        int x = 1; // C:/pathToTest/result.zip.003
        System.out.printf("%03d%n", x);
    }
}
