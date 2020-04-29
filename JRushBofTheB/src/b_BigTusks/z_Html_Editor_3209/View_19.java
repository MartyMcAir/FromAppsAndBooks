package b_BigTusks.z_Html_Editor_3209;

import b_BigTusks.z_Html_Editor_3209.listeners.FrameListener;
import b_BigTusks.z_Html_Editor_3209.listeners.TabbedPaneChangeListener;
import b_BigTusks.z_Html_Editor_3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// View - явл приемником событий т.к. наследует JFrame
// и View - явл источником событий т.к. реаллизует ActionListener
public class View_19 extends JFrame implements ActionListener {
    private View viewOrigin;
    private Controller controller;
    private JTabbedPane tabbedPane = new JTabbedPane(); // панель с двумя вкладками
    // будет размещен на первой вкладке.
    private JTextPane htmlTextPane = new JTextPane(); // компонент для визуал редактирования HTML
    // компонент для редактирования html в виде текста, он будет отображать код html (теги и их содержимое)
    private JEditorPane plainTextPane = new JEditorPane();
    private UndoManager undoManager = new UndoManager();
    // поле UndoListener undoListener, проинициализируй его используя undoManager.
    private UndoListener undoListener = new UndoListener(undoManager);

    public View_19() {
        //  должен устанав внеш вид и поведен (look and feel) приложения такими же, как это определено в системе.
        // Конструктор не должен кидать исключений, только логировать их с помощью ExceptionHandler
        // Подсказа: для реализации задания используй класс UIManager.
        // ___ Понятия не имею что надо..
        try {  // from http://www.javaportal.ru/java/articles/GUISwing.html
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void initGui() {
        initMenuBar();
        initEditor();
        pack(); // - обеспечивает плоность занимаемой площади элементами интерфейса
    }

    public void initEditor() { // метод инициализации панелей редактора
        // Устанавливать значение "text/html" в качестве типа контента для компонента htmlTextPane.
        // Найди и используй подходящий метод. - ???
        // пробежался по Шилдт Book900-1100стр _ непонял что надо JRush
        htmlTextPane.setContentType("text/html");
        // Если хотите исправить эксепшен во вкладке Текст
        plainTextPane.setContentType("text/html");
        JScrollPane jScrollHtml = new JScrollPane(htmlTextPane);
        JScrollPane jScrollTextPane = new JScrollPane(plainTextPane);
        // Добавлять вкладку в панель tabbedPane с именем "HTML" и компонентом из предыдущего пункта. ???
        tabbedPane.addTab("HTML", jScrollHtml);
        tabbedPane.addTab("Текст", jScrollTextPane);
        tabbedPane.setPreferredSize(new Dimension(300, 300));
        // Создавать объект класса TabbedPaneChangeListener и устанавливать его в качестве слушателя измен в tabbedPane
        TabbedPaneChangeListener changeListener = new TabbedPaneChangeListener(viewOrigin);
        tabbedPane.addChangeListener(changeListener);
        // Добавлять по центру панели контента текущего фрейма нашу панель с вкладками.
        // Получить панель контента текущ фрейма с помощью getContentPane(), его реализация унаследовалась от JFrame.
        // Подум, метод с какими парам необход вызв, чтоб панель с вкладк отображ по центр панел контент текущ фрейма.
        getContentPane().add(tabbedPane, BorderLayout.CENTER); // BorderLayout - юзаем диспетчер компонентов
    }

    public void initMenuBar() {
        // Создавать новый объект типа JMenuBar. Это и будет наша панель меню.
        JMenuBar jMenuBar = new JMenuBar();
        // С помощью MenuHelper инициализировать меню в следующем порядке: Файл, Редактировать, Стиль,
        // Выравнивание, Цвет, Шрифт и Помощь.
        MenuHelper.initFileMenu(viewOrigin, jMenuBar);
        MenuHelper.initEditMenu(viewOrigin, jMenuBar);
        MenuHelper.initStyleMenu(viewOrigin, jMenuBar);
        MenuHelper.initAlignMenu(viewOrigin, jMenuBar);
        MenuHelper.initColorMenu(viewOrigin, jMenuBar);
        MenuHelper.initFontMenu(viewOrigin, jMenuBar);
        MenuHelper.initHelpMenu(viewOrigin, jMenuBar);
        // Добавлять в верхнюю часть панели контента текущего фрейма нашу панель меню, аналогично тому,
        // как это мы делали с панелью вкладок. ( my: т.е. в initEditor()!? )
        getContentPane().add(jMenuBar, BorderLayout.NORTH); // BorderLayout - юзаем диспетчер компонентов

    }

    public void init() {
        initGui();
        // Добавлять слушателя событий нашего окна. В качестве подписчика ??? создай и использ объект кл FrameListener.
        //В качестве метода для добавления подписчика используй подходящий метод из класса Window от которого
        // наследуется и наш класс через классы JFrame и Frame.
        FrameListener frameListener = new FrameListener(viewOrigin); // обеспечивает чтоб окно можно было растягивать
        this.addWindowListener(frameListener);
        setVisible(true);
    }

    public boolean isHtmlTabSelected() {
        // должен возвращать true, если выбрана вкладка, отображающая html в панели вкладок (подсказка: ее индекс 0).
        // думал как то юзать actionPerformed _ - но не дошло как
        return tabbedPane.getSelectedIndex() == 0;
//        return tabbedPane.getSelectedComponent() == tabbedPane.getComponents()[0]; // или так:
    }


    @Override
    public void actionPerformed(ActionEvent e) {
//        if (e.getModifiers() == 0) {
//            tabbedPane.
//        }
    }

    public void selectedTabChanged() { // вызывается, когда произошла смена выбранной вкладки.
        // 18.2. Если выбрана вкладка с индексом 0 (html вкладка), значит нам нужно получить текст из plainTextPane
        // и установить его в контроллер с помощью метода setPlainText.
        if (tabbedPane.getSelectedIndex() == 0) {
            controller.setPlainText(plainTextPane.getText());
        }
        // 18.3. Если выбрана вкладка с индексом 1 (вкладка с html текстом), то необходимо получить текст
        // у контроллера с помощью метода getPlainText() и установить его в панель plainTextPane.
//        if (tabbedPane.getSelectedIndex() == 1) { // if не принял
        else  {
            plainTextPane.setText(controller.getPlainText());
        }
        resetUndo(); // 18.4. Сбросить правки (вызвать метод resetUndo представления).
    }

    public void exit() {
        controller.exit();
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public void setUndoListener(UndoListener undoListener) {
        this.undoListener = undoListener;
    }

    public void undo() {
        //  отменяет последнее действие. Реализуй его используя undoManager.
        // Метод не должен кидать исключений, логируй их.__ непонял как юзать undoManager
        try {
            undoManager.undo();
        } catch (CannotUndoException e) {
            // Убедись, что исключения логируются с помощью ExceptionHandler
            ExceptionHandler.log(e);
        }
    }

    public void redo() {
        try {
            undoManager.redo();
        } catch (CannotRedoException e) {
            ExceptionHandler.log(e);
        }
    }

    public boolean canUndo() { // в меню пункты отменить _ возвратить
        // Реализуй методы boolean canUndo() и boolean canRedo() используя undoManager.
        return undoManager.canUndo();
    }

    public boolean canRedo() {
        return undoManager.canRedo();
    }

    public void resetUndo() {
        // должен сбрасывать все правки в менеджере undoManager. _ непонял как
        undoManager.discardAllEdits();
    }

    public void selectHtmlTab() {
        // 14.1.1. Выбирать html вкладку (переключаться на нее). __ непонял как и для чего
        // 14.1.2. Сбрасывать все правки с помощью метода, который ты реализовал ранее.
        tabbedPane.setSelectedIndex(0); // оказывается оч. просто
        resetUndo();
    }

    public void update() {
        // должен получать документ у контроллера и устанавливать его в панель редактирования htmlTextPane.
        htmlTextPane.setDocument(controller.getDocument());
    }

    public void showAbout() {
        // должен показывать диалоговое окно с информацией о программе. Информацию придумай сам,
        // а вот тип сообщения должен быть JOptionPane.INFORMATION_MESSAGE.
        JOptionPane.showMessageDialog(viewOrigin, "метод showAbout", "title View class",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
