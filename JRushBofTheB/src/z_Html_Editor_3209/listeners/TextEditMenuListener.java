package z_Html_Editor_3209.listeners;

import z_Html_Editor_3209.View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;

// будет работать аналогично классу UndoMenuListener только для других пунктов меню.
// Пункты меню, отвечающие за стиль, шрифт, цвет и т.д. должны быть доступны только тогда,
// когда в нашем редакторе выбрана первая вкладка.
public class TextEditMenuListener implements MenuListener {
    private View view;

    public TextEditMenuListener(View view) {
        this.view = view;
    }

    @Override
    public void menuSelected(MenuEvent e) {
        // Из переданного параметра получать объект, над которым было совершено действие.
        // В нашем случае это будет объект с типом JMenu.
        JMenu jMenu = (JMenu) e.getSource();
        // У полученного меню получать список компонентов (пунктов меню).
        Component[] components = jMenu.getMenuComponents();
        // Для каждого пункта меню вызывать метод setEnabled, передав в качестве параметра результат
        // вызова метода isHtmlTabSelected() из представления.
        boolean res = view.isHtmlTabSelected();
        for (Component item : components) {
            item.setEnabled(res);
        }
        // убедись, что пункты меню стиль, выравнивание, цвет и шрифт доступны только,
        // когда активна закладка HTML и не доступны для закладки Текст
    }

    @Override
    public void menuDeselected(MenuEvent e) {

    }

    @Override
    public void menuCanceled(MenuEvent e) {

    }
}
