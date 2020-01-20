package zz_pkg_Shildt_Book;

import java.awt.*;
import java.awt.event.*;

public class MouseEventDemo extends Frame implements MouseListener, MouseMotionListener {
    String msg = "";
    int mouseX = 0, mouseY = 0;

    public MouseEventDemo() throws HeadlessException {
        // т.к. мы реализуем интерфейс MouseListener
        addMouseListener(this); // можем добавить самого себя в качестве слушателя событий
        addMouseMotionListener(this);
        addWindowListener(new MyWindowAdapter());
    }

    public static void main(String[] args) {
        MouseEventDemo appWin = new MouseEventDemo();
        appWin.setSize(new Dimension(300, 300));
        appWin.setTitle("MouseEventsDemo");
        appWin.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) { // щелчок
        msg += " - click received";
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) { // нажатие кнопки
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Button down.";
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) { // отпускание кнопки
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "Button released.";
        repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) { // наведение курсора
        mouseX = 100;
        mouseY = 100;
        msg = "Mouse entered.";
        repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) { // отведение курсора
        mouseX = 100;
        mouseY = 100;
        msg = "Mouse exited.";
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent e) { // перетаскивание курсора
        mouseX = e.getX();
        mouseY = e.getY();
        msg = "*" + " mouse at " + mouseX + ", " + mouseY;
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) { // перемещение мыши
        msg = "Moving mouse at " + e.getX() + ", " + e.getY();
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawString(msg, mouseX, mouseY);
    }

    private class MyWindowAdapter extends WindowAdapter {
        @Override
        public void windowClosing(WindowEvent e) {
            System.exit(0);
        }
    }
}
