package z_Html_Editor_3209.listeners;

import z_Html_Editor_3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

// cлушатель будет следить за меню, а если конкретнее, то за моментом,
// когда меню редактирования будет выбрано пользователем.
// он будет запрашивать у представления можем ли мы сейчас отменить или вернуть какое-то действие,
// и в зависимости от этого делать доступными или не доступными пункты меню "Отменить" и "Вернуть".
public class UndoMenuListener implements MenuListener {
    private View view;
    private JMenuItem undoMenuItem;
    private JMenuItem redoMenuItem;

    public UndoMenuListener(View view, JMenuItem undoMenuItem, JMenuItem redoMenuItem) {
        this.view = view;
        this.undoMenuItem = undoMenuItem;
        this.redoMenuItem = redoMenuItem;
    }

    @Override
    public void menuSelected(MenuEvent e) {
        // Спрашивать у представления можем ли мы отменить действие с помощью метода boolean canUndo().
        //  Делать доступным или не доступ пункт меню undoMenuItem в зависимости от того, что нам вернул представление
        // Подсказка: используй метод setEnabled().
//        if (view.canRedo()) {
//            undoMenuItem.setEnabled(true);
//        } else {
//            undoMenuItem.setEnabled(false);
//        }
        undoMenuItem.setEnabled(view.canUndo());
        redoMenuItem.setEnabled(view.canRedo());
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
