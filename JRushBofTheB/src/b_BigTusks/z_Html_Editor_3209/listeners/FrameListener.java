package b_BigTusks.z_Html_Editor_3209.listeners;

import b_BigTusks.z_Html_Editor_3209.View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// обеспечивает растягиваемость окна..
public class FrameListener extends WindowAdapter {
    private View view;

    public FrameListener(View view) {
        this.view = view;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        view.exit();
    }
}
