package b_BigTusks.z_Html_Editor_3209;

// создано на 13ом задании (17_01_2020) _ часть пропустил недопоняв так что..
public class z_Prj_Descriptions {
    // Controller - инициализрует в main методе view и controller (там реализация MVC)
    // ExceptionHandler - просто метод вывода log(e) -> toString _ юзается в классе View

    // MenuHelper - методы где пчти кажд отдельный - вкладка со списком меню (например цвет: и его элементы)
    //      пчт кажд метод принимает view и JMenuBar - где внутри добавл элементы через метод что вернет JMenuItem

    // View extends JFrame - и юзает init(){.. initGui(){.. initMenuBar(){..
    //      - в котором MenuHelper.initFileMenu(this, jMenuBar)..
    //      т.е. инициализурует целый тулБар из класса MenuHelper и добавляет его на фрейм
    //      поле controller - юзается для вызова его метода exit()
    //      внутри init(){ устанавливается this.addWindowListener(new FrameListener(this));

    // pkj listeners
    // UndoMenuListener implements MenuListener - в MenuHelper в initEditMenu()
    // TextEditMenuListener implements MenuListener - в MenuHelper в куче методов, что для менюшек
    // FrameListener extends WindowAdapter - инициализируется в View в методе init()
    // TabbedPaneChangeListener implements ChangeListener - в View в initEditor()
    // UndoListener implements UndoableEditListener (отменить действия <->) - в View в getUndoListener()

    // pkj actions
    // RedoAction extends AbstractAction - в MenuHelper в initEditMenu()
    // UndoAction extends AbstractAction - в MenuHelper в initEditMenu()
    // StrikeThroughAction extends StyledEditorKit.StyledTextAction - в MenuHelper в initStyleMenu()
    // SubscriptAction extends StyledEditorKit.StyledTextAction - в MenuHelper в initStyleMenu()
    // SuperscriptAction extends StyledEditorKit.StyledTextAction - в MenuHelper в initStyleMenu()


}
