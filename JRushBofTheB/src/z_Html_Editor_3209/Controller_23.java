package z_Html_Editor_3209;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import java.io.*;

public class Controller_23 {
    private View view;
    private HTMLDocument document; // модель
    private File currentFile;

    public Controller_23(View view) {
        this.view = view;
    }

    public static void main(String[] args) {
        View view = new View();
        Controller controller = new Controller(view);
        view.setController(controller);
        view.init();
        controller.init();
    }

    public void init() {
        createNewDocument();
    }

    public void exit() {
        System.exit(0);
    }

    public HTMLDocument getDocument() {
        return document;
    }

    public void resetDocument() { // будет сбрасывать текущий документ.
        // 15.1. Удалять у текущего документа document слушателя правок которые можно отменить/вернуть
        // (найди подходящий для этого метод, унаследованный от AbstractDocument).
        // Слушателя нужно запросить у представления (метод getUndoListener()).
        if (document != null) {   //Не забудь проверить, что текущий документ существует (не null).
            document.removeUndoableEditListener(view.getUndoListener()); // а не -> removeDocumentListener()
        }
        // Создавать новый документ по умолчанию и присваивать его полю document.
        // Подсказка: воспользуйся подходящим методом класса HTMLEditorKit.
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
//        document = new HTMLDocument();
        document = (HTMLDocument) htmlEditorKit.createDefaultDocument();
        // 15.3. Добавлять новому документу слушателя правок.
        document.addUndoableEditListener(view.getUndoListener()); // не догадался бы
        view.update();  // 15.4. Вызывать у представления метод update().
    }

    public void setPlainText(String text) { // будет записывать переданный текст с html тегами в документ document.
        // 16.1. Сбрось документ. _ не знаю как _ в HTMLDocument и в доках нет reset _ дошло описано в требованиях
        resetDocument();
        // 16.2. Создай новый реадер StringReader на базе переданного текста.
        StringReader stringReader = new StringReader(text);
        // 16.3. Вызови метод read() из класса HTMLEditorKit, который вычитает данные из реадера в документ document.
        try {
            HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
            htmlEditorKit.read(stringReader, document, 0);
        } catch (IOException | BadLocationException e) {
            ExceptionHandler.log(e); // 16.4. Проследи, чтобы метод не кидал исключения. Их необходимо логировать.
        }
    }

    public String getPlainText() { // 17 должен получать текст из документа со всеми html тегами.
        StringWriter stringWriter = new StringWriter();
        // Перепиши все содержимое из документа document в созд объект с помощью write() класса HTMLEditorKit.
        HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
        try {
            htmlEditorKit.write(stringWriter, document, 0, document.getLength());
        } catch (IOException | BadLocationException e) {
            ExceptionHandler.log(e);
        }
        return stringWriter.toString();
    }

    public void createNewDocument() {
        view.selectHtmlTab(); // 20.1.1. Выбирать html вкладку у представления.
        resetDocument(); // 20.1.2. Сбрасывать текущий документ.
        // 20.1.3. Устанавливать новый заголовок окна, например: "HTML редактор".
        // Воспользуйся методом setTitle(), который унаследован в нашем представлении.
        view.setTitle("HTML редактор");
        // 20.1.4. Сбрасывать правки в Undo менеджере. Используй метод resetUndo представления.
        view.resetUndo();
        currentFile = null; // 20.1.5. Обнулить переменную currentFile.
    }

    public void openDocument() {
    }

    public void saveDocument() {

    }

    public void saveDocumentAs() {
        // 22.1. Переключать представление на html вкладку.
        view.selectHtmlTab();
        // 22.2. Создавать новый объект для выбора файла JFileChooser.
        JFileChooser jFileChooser = new JFileChooser();
        // 22.3. Устанавливать ему в качестве фильтра объект HTMLFileFilter.
        HTMLFileFilter htmlFileFilter = new HTMLFileFilter();
        jFileChooser.setFileFilter(htmlFileFilter);
        // 22.4. Показывать диалоговое окно "Save File" для выбора файла.
//        JOptionPane.showMessageDialog();

        // Вообще не понял что к чему..
//        jFileChooser.showSaveDialog(); // Component принимает.. а какой надо?

        // 22.5. Если пользователь подтвердит выбор файла:
//        if (jFileChooser.isFileSelectionEnabled()) {
        if (jFileChooser.showSaveDialog(view) == JFileChooser.APPROVE_OPTION) {
            // 22.5.1. Сохранять выбранный файл в поле currentFile.
            // 22.5.2. Устанавливать имя файла в качестве заголовка окна представления.
                currentFile = jFileChooser.getSelectedFile();
                view.setTitle(currentFile.getName());

            // view.getContentPane() тоже работает нормально, файлы сохраняются, диалог показывается там где его ждешь,
            //  но валидатор принял только с view
            // На основании этого параметра задаётся "Look and feel" а так же расположение диалога на экране,
            // так как view - это наше основное окно, то логично его и передать в метод .showSaveDialog.
            // Не будет ошибкой передать параметром null тогда Look and feel будут по умолчанию и расположение диалога
            //          - по центру экрана, но валидотор хочет view.
            // Я в начале тоже showSaveDialog(null) написал.

            // 22.5.3. Создавать FileWriter на базе currentFile.
            try (FileWriter fileWriter = new FileWriter(currentFile);) {
//            try {
//                FileWriter fileWriter = new FileWriter(currentFile);

                HTMLEditorKit htmlEditorKit = new HTMLEditorKit();
                // 22.5.4. Переписывать данные из документа document в объекта FileWriter-а аналогично тому,
                // как мы это делали в методе getPlainText().
                htmlEditorKit.write(fileWriter, document, 0, document.getLength());
            } catch (IOException | BadLocationException e) {
                ExceptionHandler.log(e);
            }
        }
    }
}
