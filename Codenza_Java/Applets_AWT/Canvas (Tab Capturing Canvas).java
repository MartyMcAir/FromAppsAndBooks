Canvas (Tab Capturing Canvas)

import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/**
 * This Canvas class show how to make a canvas part of the tab sequece
 * so that it can be  reached by pressing the tab key.  It also shows
 * how to prevent tab from getting focus to leave the Canvas by
 * consuming the event before it gets propogated to the containing
 * Window.
 */
public class TabCapturingCanvas extends Canvas {
    /**
     * Constructor.
     */
    public TabCapturingCanvas() {
        setBackground(Color.green);
        // Key events must be enabled so that the canvas can consume them.
        enableEvents(AWTEvent.KEY_EVENT_MASK);
    } // constructor()

    /**
     * Override processKeyEvent so that it consumes tab key events.
     * Since consumed AWT events are not delivered to listeners, tab key
     * events that are delivered to this Canvas will not be dispatched
     * to the Window that is listening for them, so the Window will
     * never have the opportinity to respond to the tab by requesting a
     * change of focus.
     */
    protected void processKeyEvent(KeyEvent e) {
        if (e.getKeyCode() == '	') {
            e.consume();
            return;
        } // if
        super.processKeyEvent(e);
    } // processKeyEvent(KeyEvent)

    /**
     * Returns whether this component can be traversed using
     * Tab or Shift-Tab keyboard focus traversal.  If this method
     * returns "false", this component may still request the keyboard
     * focus using requestFocus(), but it will not automatically
     * be assigned focus during tab traversal.
     */
    public boolean isFocusTraversable() {
	return true;
    }

    public Dimension getMinimumSize() {
        return new Dimension(50,50);
    } // getMinimumSize()

    public Dimension getPreferredSize() {
        return new Dimension(50,50);
    } // getPreferredSize()
} // class TabCapturingCanvas
