package zz_pkg_Shildt_Book;

import java.awt.*;
import java.awt.event.*;

public class AdapterDemo extends Frame {
    String msg = "";

    public AdapterDemo() throws HeadlessException {
        // т.к. мы наследуем Frame
        addMouseListener(new MyMouseAdapter(this)); // можем добавить в качестве слушателя событий
        addMouseMotionListener(new MyMouseAdapter(this));
        addWindowListener(new MyWindowAdapter());
    }

    public static void main(String[] args) {
        AdapterDemo appWin = new AdapterDemo();
        appWin.setSize(new Dimension(200, 150));
        appWin.setTitle("AdapterDemo");
        appWin.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, 20, 80);
    }

    // --- Классы Адаптеры _ источники событий ---
    private class MyMouseAdapter extends MouseAdapter { // адаптер мыши
        AdapterDemo adapterDemo;

        public MyMouseAdapter(AdapterDemo adapterDemo) {
            this.adapterDemo = adapterDemo;
        }

        @Override
        public void mouseClicked(MouseEvent e) { // щелчки
            adapterDemo.msg = "Mouse clicked " + e.getX() + ", " + e.getY();
            adapterDemo.repaint();
        }

        @Override
        public void mouseDragged(MouseEvent e) { // перемещения мыши
            adapterDemo.msg = "Mouse dragged " + e.getX() + ", " + e.getY();
            adapterDemo.repaint();
        }
    }

    private class MyWindowAdapter extends WindowAdapter { // адаптер окна
        @Override
        public void windowClosing(WindowEvent e) { // закрываем гл окно на крестике справа вверху
            System.exit(0);
        }
    }
}

