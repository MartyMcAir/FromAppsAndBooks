package b_BigTusks.ConsoleArchiver_3110.command;



import b_BigTusks.ConsoleArchiver_3110.ConsoleHelper;
import b_BigTusks.ConsoleArchiver_3110.FileProperties;
import b_BigTusks.ConsoleArchiver_3110.ZipFileManager;

import java.util.List;

public class ZipContentCommand extends ZipCommand {
    @Override
    public void execute() throws Exception {
        ConsoleHelper.writeMessage("Просмотр содержимого архива.");

        ZipFileManager zipFileManager = getZipFileManager();

        ConsoleHelper.writeMessage("Содержимое архива:");

        List<FileProperties> files = zipFileManager.getFilesList();
        for (FileProperties file : files) {
            ConsoleHelper.writeMessage(file.toString());
        }

        ConsoleHelper.writeMessage("Содержимое архива прочитано.");
    }
}
