package b_BigTusks.ConsoleArchiver_3110.command;



import b_BigTusks.ConsoleArchiver_3110.ConsoleHelper;
import b_BigTusks.ConsoleArchiver_3110.ZipFileManager;

import java.nio.file.Path;
import java.nio.file.Paths;

public abstract class ZipCommand implements Command {

    public ZipFileManager getZipFileManager() throws Exception{
        ConsoleHelper.writeMessage("Введите полный путь файла архива:");
        Path zipPath = Paths.get(ConsoleHelper.readString());
        return new ZipFileManager(zipPath);
    }
}