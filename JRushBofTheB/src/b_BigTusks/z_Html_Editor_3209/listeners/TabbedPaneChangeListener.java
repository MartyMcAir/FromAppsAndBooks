package b_BigTusks.z_Html_Editor_3209.listeners;

import b_BigTusks.z_Html_Editor_3209.View;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

// класс будет слушать и обрабатывать изменения состояния панели вкладок.
public class TabbedPaneChangeListener implements ChangeListener {
    private View view;

    public TabbedPaneChangeListener(View view) {
        this.view = view;
    }


    @Override
    public void stateChanged(ChangeEvent e) {
        view.selectedTabChanged();
    }
}
