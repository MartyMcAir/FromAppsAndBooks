package b_BigTusks.zipPack_3105_3106;

import java.io.*;
import java.util.Arrays;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

// https://javarush.ru/dialogues/81702
public class FromUser_3106 {
    public static void main(String[] args) throws Exception {
//        args = new String[] {"E:\\zips\\music.mp3", "E:\\zips\\143.zip.001",
//                "E:\\zips\\143.zip.002", "E:\\zips\\143.zip.003",
//                "E:\\zips\\143.zip.004", "E:\\zips\\143.zip.005",
//                "E:\\zips\\143.zip.006", "E:\\zips\\143.zip.007",
//                "E:\\zips\\143.zip.008", "E:\\zips\\143.zip.009",
//                "E:\\zips\\143.zip.010"};

//        String[] filesParts = {"c:\\z_path\\words.txt.zip.001",
        args = new String[]{
                "c:\\z_path\\result_is_new.mp3",
                "c:\\z_path\\result.zip.002",
                "c:\\z_path\\result.zip.001",
                "c:\\z_path\\result.zip.004",
                "c:\\z_path\\result.zip.003",
        };

        // наполняем массив с пропуском 0 элемента _(0левой это путь для результ файла)
        String[] zipFileNames = new String[args.length - 1];
        for (int i = 0; i < args.length; i++) {
            if (i > 0) {
                zipFileNames[i - 1] = args[i]; // i-1 это так скипается первый элемент
            }
        }
        Arrays.sort(zipFileNames); // сортируем пути, чтоб склейка байтов была верной

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        for (String item : zipFileNames) {   // перебираем массив и созд потоки для каждого
            InputStream inputStream = new FileInputStream(item);

            while (inputStream.available() > 0) {
                byte[] b = new byte[200];
                int cnt = inputStream.read(b); // считываем в буффер
                stream.write(b, 0, cnt);  // запиываем в него же начиная от 0 до cnt
            }
            inputStream.close();
        }
        stream.close();

        // получаем общий ByteArrayOutputStream и кидаем его в ZipIn..
        ZipInputStream zipInputStream = new ZipInputStream(new ByteArrayInputStream(stream.toByteArray()));
        OutputStream outputResultStream = new FileOutputStream(args[0]);
        ZipEntry zipEntry = zipInputStream.getNextEntry();
        if (zipEntry != null) {
            copyData(zipInputStream, outputResultStream); // copyData - копирует из in в out
        }
        outputResultStream.close();
        zipInputStream.close();

    }

    private static void copyData(InputStream in, OutputStream out) throws Exception {
        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }
}
