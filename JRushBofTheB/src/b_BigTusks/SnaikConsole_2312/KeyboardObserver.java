package b_BigTusks.SnaikConsole_2312;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class KeyboardObserver extends Thread {
    private Queue<KeyEvent> keyEvents = new ArrayBlockingQueue<KeyEvent>(100);

    private JFrame frame;

    @Override
    public void run() {
        frame = new JFrame("KeyPress Tester");
        frame.setTitle("Transparent JFrame Demo"); // Имя окна
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close на крестик

        frame.setUndecorated(true); // Disables or enables decorations for this frame.
        frame.setSize(400, 400); // размеры окна
        // Устанавливает состояние этого кадра _ хз как понять
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Sets the state of this frame.
        frame.setLayout(new GridBagLayout());  // слой

        frame.setOpacity(0.0f);   // непрозрачность .. - Sets the opacity of the window
        frame.setVisible(true);   // видимость true

        // https://docs.oracle.com/javase/10/docs/api/java/awt/Component.html#addFocusListener(java.awt.event.FocusListener)
        // method from class Component
        frame.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                //do nothing
            }

            @Override
            public void focusLost(FocusEvent e) {
                System.exit(0);
            }
        });

        // https://docs.oracle.com/javase/10/docs/api/java/awt/Component.html#addFocusListener(java.awt.event.FocusListener)
        // method from class Component
        frame.addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
                //do nothing
            }

            public void keyReleased(KeyEvent e) {
                //do nothing
            }

            public void keyPressed(KeyEvent e) {
                keyEvents.add(e);
            }
        });
    }


    public boolean hasKeyEvents() {
        return !keyEvents.isEmpty();
    }

    public KeyEvent getEventFromTop() {
        return keyEvents.poll();
    }
}

