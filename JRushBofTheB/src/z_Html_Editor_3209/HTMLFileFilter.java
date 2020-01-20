package z_Html_Editor_3209;

import javax.swing.filechooser.FileFilter;
import java.io.File;

// Для открытия или сохранения файла мы будем использовать JFileChooser из библиотеки swing.
// Объекты этого типа поддерживают фильтры, унаследованные от FileFilter.
public class HTMLFileFilter extends FileFilter {
    @Override
    public boolean accept(File f) {
        // 21.2. Мы хотим, чтобы окно выбора файла отображало только html/htm файлы или папки.
        // Переопредели метод accept(File file), чтобы он возвращал true,
        // если переданный файл директория или содержит в конце имени ".html" или ".htm" без учета регистра.
        String fileName = f.getName().toLowerCase();
        if (fileName.endsWith(".html") | fileName.endsWith(".htm") | f.isDirectory()) {
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        // 21.3. Чтобы в окне выбора файла в описании доступных типов файлов отображался текст "HTML и HTM файлы"
        // переопредели соответствующим образом метод getDescription().

        return "HTML и HTM файлы";
    }
}
