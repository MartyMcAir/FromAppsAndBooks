package b_BigTusks.ConsoleArchiver_3110;



import b_BigTusks.ConsoleArchiver_3110.exception.PathIsNotFoundException;
import b_BigTusks.ConsoleArchiver_3110.exception.WrongZipFileException;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class Tmp {
    // до 16 задания (из18) проходится за ~ 4-6ч., при том что project is simple
    //      и при том, что chapters практически "ведут за ручку" (&IDEA не слабо так help..)
    //      и копипаст с Git'a _ да и если затруднялся неюзал дебагер а это + 0.5-3ч и более если не скопипастить
    // на запись описания того что ниже, т.е. что происходит в коде ~2-3ч.

    // Archiver - основной класс спрашивает комманду
    //      и делегирует распоряжение классу CommandExecutor
    //      а тот соспостовляет enum Operation -> Классу исполнителю в пакете command & execute()
    //          ___ в то время как можно было обойтись просто enum + switch case.. (без Map)
    //          или даже как в Factory через интерфейс..

    // ConsoleHelper - обычный (бессполезный) консольный ввод вывод
    //      ___ мол разделение на способы получения инфы от юзера _ типо. вот своеобразный консольный..
    // FileManager(Path p) - рекурсивно наполняет список fileList всеми путями и под путями из Path p
    //      единственный метод для юза List<Path> getFileList()

    // FileProperties(name, size, compressedSize, compMethod) - использ. как объект-сущность для описания
    //      запакованного Entity файла или папки и toString его параметры
    //          ___(лучше бы в конструктор принимал ZipEntry - и сам вытаскивал, что надо..)

    // ZipFileManager(Path zipFile) - делает всю самую главную работу с zip файлами..
    //      упаковка, распаковка, удаление из архива файла или файлов, добавление в zip архив,
    //              из-за повторов кода, часть методов имеют вложенную в др. друга структуру вызовов
    //      в конструктор принимает путь к zipFile - и почти в каждом методе идет проверка на его Exists..
    //          ___ хотя можно было бы это вынести в классы пакета Command, но тогда бы это значило, что
    //          часть функционала ZipFileManager - вынесена по сути в места, где должна быть
    //          дружелюбная обертка для юзеров и только (строка загрузки и опрос по конкретной операции)
    //          ..мол в настройки и вьюхи для спец операций вынесена _ обработка Exception - не порядок


    // ------------------------------------------------------------------
    // ZipFileManager   ___ Additional info:
    // copyData(in, out) - читает из потока in и записывает в out

    // addNewZipEntry(zipOutputStream, filePath, fileName) - добавляет в out _ zipEntity
    //      полученные из пути: при скллеивании путь+имяФайла = fullPath
    //      ZipEntry entry=..(юзает fileName), и делается её zipOutputStream.putNextEntry(entry)
    //          putNextEntry(..) - добавляет объект Entry в архив
    //      потом идет перекидывание потоков copyData(newInFromFullPath, zipOutputStream);
    //          ___до конца не ясно зачем, ведь уже сделали putNextEntry..!?
    //          и закрытие потока _ .closeEntry(); - закрывает все по-юзаные потоком, Entry..

    // getFilesList() - из zipFile - получает поток ZipIn.. - из него в цикле вытаскивает
    //      ..getNextEntry() - для забивания объекта FileProperties(zipEntry.getName()..)
    //          а потом добавления этого объекта в список
    //      ___использует непонятную заглушку ByteArrayOutputStream, для получения значений
    //      из методов zipEntry.getName().. - а иначе без заглушки вернется -1

    // extractAll(Path outputFolder) - принимает путь назначения распаковки
    //      создает zipInputStream..(zipFile) поток
    //      создет директории пути назначения Files.createDirectories(ouputFolder);
    //      в цикле обходит все zipEntry = zipInputStream.getNextEntry();
    //          получаем имя zipEntry.getName() и склеиваем outputFolder.resolve(fileName) = fileFullName
    //              т.е. склейка пункта назначения с пунктом того каков путь в архиве до файла
    //          создание директорий куда распаковывается текущий zipEntry
    //          создается Files.newOutputStream(fileFullName) поток
    //              и перекидываем copyData(zipInputStream, outputStream);

    // createZip(Path source) - source - это то что надо запоковать
    //      созд поток out-записи ..newOutputStream(zipFile), где zipFile место назначения new архива
    //      если архивир файл то, юзаем addNewZipEntry(..)
    //          ___и этот метод, для удобства его использ. сам бы мог делить путь, а не потом resolve()
    //      если архивир папку, то получаем список путей к файлам из ..getFileList() - через Path source
    //      и юзаем addNewZipEntry(..), в цикле

    // removeFiles(List<Path> pathList) - получает список путей на файлы внутри архива
    //       _ это список файлов, что следует удалить, внутри архива
    //
    // removeFile(Path p) - получает путь к файлу что надо удалить


    //      ----------------------самое не итересное in Down------------------------

    // package command interface Command{ void execute(); }
    //      все классы пакета extends ZipCommand - а тот implements Command
    // ZipCommand содержит один метод используемый всеми классами что его extends
    //      ZipFileManager getZipFileManager() - запрашивает с консоли путь к файлу архива
    //          и return new ZipFileManger(zipPath);
    // все классы пакета используют полученный объект ZipFileManager - для вызова всех комманд архиватора
    //      предварительно перед этим спрашивают юзера, в соответствии с полученной командой и показывают
    //      мол загружено, создано, выполнено и т.д.. _ - такой пользовательский-информатор..
    //      ___ а так же выводит содержимое на экран (class ZipContentCommand _ юзает getFilesList() )

    // package exception _ все классы extends Exception
    //      мол чисто индивидуальный Exception - только наши (не стандартные) Exception
    //      ___ т.е. около 400+ стандартных недостаточно..

    // Создаем архив C:\z_n\new_test_folder\12_05_19.zip
    //      внутри C:\z_n\new_test_folder\12_05_19\z_SimpleFV\Hello.java
    // для удаления из архива указываем: z_SimpleFV\Hello.java

    private Path zipFile = null;

    // что-то не так делаю
    public void addFilesV2(List<Path> absolutePathList) throws Exception {
        if (!Files.isRegularFile(zipFile)) {
            throw new WrongZipFileException();
        }

        List<String> listFilesInNewZip = new ArrayList<>();

        Path tempFile = Files.createTempFile(zipFile.getParent(), "_prefix_", "_suffix_");
        // Создать временный файл архива
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(tempFile));
             ZipInputStream zipInputStream = new ZipInputStream(Files.newInputStream(zipFile));) {

            // Пройти по всем файлам оригинального архива, переписать каждый файл в новый архив,
            // добавить имя переписанного файла в какой-нибудь локальный список.
            ZipEntry zipEntry = zipInputStream.getNextEntry();
            while (zipEntry != null) {
                listFilesInNewZip.add(zipEntry.getName());

                // записываем в новый архив
                zipOutputStream.putNextEntry(zipEntry);

                // читает in и записывает в out _ смысл не понял
                // наверно не надо
//                copyData(zipInputStream, zipOutputStream);

                // передвигаем указатель на след. элемент архива
                zipEntry = zipInputStream.getNextEntry();
            }

            // Для каждого файла проверить, есть ли он на диске и является ли он обычным файлом,
            //      на диске всмысле!? в архиве новом или старом!?
            //      на каком диске!? _ - мы же с файлом архивом раотаем или не!?

            // дошло _ т.е. это список файлов, что надо добавить _ и если совпало с уже добавленными
            // то сообщить юзеру что в архиве этот файл уже есть..
            String currentInNewZip;
            Path currentAdded;
            for (int i = 0; i < absolutePathList.size(); i++) {
                // текущ элемент из списка добавляемых файлов
                currentAdded = absolutePathList.get(i);
                if (Files.notExists(currentAdded)) {
                    throw new PathIsNotFoundException();
                }

                for (int j = 0; j < listFilesInNewZip.size(); j++) {
                    // текущ элемент из списка файлов _ нового архива
                    currentInNewZip = listFilesInNewZip.get(j);
                    if (currentAdded.getFileName().toString().equals(currentInNewZip)) {
                        ConsoleHelper.writeMessage("Такой файл уже существует: " + currentAdded);
                    } else { // добавляем его даж если это дубликат предыдущего и т.д..
                        addNewZipEntry(zipOutputStream, currentAdded.getParent(), currentAdded.getFileName());
                    }
                }
            }
            // если что-то не так, кинь исключение PathIsNotFoundException()
            try {
                Files.move(tempFile, zipFile, StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    // получает список путей на файлы внутри архива _ это список файлов, что следует удалить
    // что-то тут не то..
    public void removeFilesV1(List<Path> pathList) throws Exception {
        if (Files.notExists(zipFile)) {   // Проверяем существует ли zip файл
            throw new WrongZipFileException();
        }

        // создаем временный файл _ в директории, где и архив
        // внего будет сохранять всё, что не надо удалять
        Path fileTmp = Files.createTempFile(zipFile.getParent(), "myTmp", "zip");
        // создаем зип архив
        ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(fileTmp));

        FileManager fileManager = new FileManager(zipFile);
        // полный список путей внутри архива
        List<Path> pathsOrigin = fileManager.getFileList();
        Path pCurrent, pDelete;
        boolean flag = false;
        for (int i = 0; i < pathsOrigin.size(); i++) {
            flag = false;
            // текущ файл оригинал архива
            pCurrent = pathsOrigin.get(i);
            for (int j = 0; j < pathList.size(); j++) {
                pDelete = pathList.get(j);
                // сравниваем с элементом, списком файлов на удаление
//                if (pDelete.equals(pCurrent)) {
                if (Files.isSameFile(pCurrent, pDelete)) {
                    flag = true; // если найдено совпадение, даем знать что надо удалить
                    break; // прерываем ибо на этой интерации миссия выполнена
                }
            }
            if (flag) {
                ConsoleHelper.writeMessage("удален файл: " + pCurrent.getFileName().toString());
            } else { //иначе этот файл сохраняем, во временный файл архив
                addNewZipEntry(zipOutputStream, pCurrent.getParent(), pCurrent.getFileName());
            }
        }
        zipOutputStream.close();
        // заменяем оринал копией, но уже не содержащей файлы, что следовало удалить
        Files.move(fileTmp, zipFile, StandardCopyOption.REPLACE_EXISTING);
        // Метод Files.move перенесет его на место старого файла и назовет как нужно.
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
        Path fullPath = filePath.resolve(fileName);
        try (InputStream inputStream = Files.newInputStream(fullPath)) {
            ZipEntry entry = new ZipEntry(fileName.toString());

            zipOutputStream.putNextEntry(entry);

            copyData(inputStream, zipOutputStream);

            zipOutputStream.closeEntry();
        }
    }

    private void copyData(InputStream in, OutputStream out) throws Exception {
        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }
}
