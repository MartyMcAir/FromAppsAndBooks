package b_BigTusks.zipPack_3105_3106;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/
// https://javarush.ru/tasks/com.javarush.task.task31.task3105#discussion
public class Solution_3105 {
    public static void main(String[] args) throws IOException {
        String zipPath = args[1];
        String filesPath = args[0];

        // From https://github.com/XFNeo/JavaRushTasks/blob/master/4.JavaCollections/src/com/javarush/task/task31/task3105/Solution.java
        ZipEntry entry;
        Map<String, ByteArrayOutputStream> map = new HashMap<>();

        try (ZipInputStream inputZip = new ZipInputStream(new FileInputStream(zipPath))) {
            while ((entry = inputZip.getNextEntry()) != null) { // читаем внутренности zip файла
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int count = 0;
                while ((count = inputZip.read(buffer)) != -1) {
                    byteArrayOutputStream.write(buffer, 0, count);
                }
                map.put(entry.getName(), byteArrayOutputStream); // наполняем мапу ключ: путь - значение: Byte..Out.. поток
            }
        }

        try (ZipOutputStream outputZip = new ZipOutputStream(new FileOutputStream(zipPath))) {
            for (Map.Entry<String, ByteArrayOutputStream> line : map.entrySet()) { // перебираем мапу
                // если мапа не new/.., то перезаписываем в этот же архив _ т.е. фактически он идёт new с нуля
                if (!line.getKey().equals("new/" + Paths.get(filesPath).getFileName().toString())) {
                    entry = new ZipEntry(line.getKey());
                    outputZip.putNextEntry(entry);
                    outputZip.write(line.getValue().toByteArray());
                }
            }
            // в конце кидаем наш новый добавляемые файл
            outputZip.putNextEntry(new ZipEntry("new/" + Paths.get(filesPath).getFileName().toString()));
            // Копируем все байты из пути файла в Output
            // _ т.е. это вместо юза readAllBytes() и вместо создания отдельного метода write(InputStream in, OutpuStream out)
            // Внутри используется in.transferTo(out);
            Files.copy((Paths.get(filesPath)), outputZip);
        }
    }

}
