package z_Html_Editor_3209.listeners;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

// класс будет следить за правками, которые можно отменить или вернуть.
public class UndoListener implements UndoableEditListener {
    private UndoManager undoManager;

    public UndoListener(UndoManager undoManager) {
        this.undoManager = undoManager;
    }

    @Override
    public void undoableEditHappened(UndoableEditEvent e) {
        // должен из переданного события получать правку и добавлять ее в undoManager.
        undoManager.addEdit(e.getEdit());
    }

    public UndoManager getUndoManager() {
        return undoManager;
    }
}
