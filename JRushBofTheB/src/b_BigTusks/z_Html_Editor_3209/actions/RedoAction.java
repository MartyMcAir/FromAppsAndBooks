package b_BigTusks.z_Html_Editor_3209.actions;

import b_BigTusks.z_Html_Editor_3209.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RedoAction extends AbstractAction {
    private View view;

    public RedoAction(View view) {
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) { // должен вызывать метод redo() у представления.
        view.redo();
    }
}
