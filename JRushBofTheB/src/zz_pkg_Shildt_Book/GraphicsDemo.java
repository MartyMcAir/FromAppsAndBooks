package zz_pkg_Shildt_Book;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GraphicsDemo extends Frame {
    public GraphicsDemo() throws HeadlessException {
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        GraphicsDemo appWin = new GraphicsDemo();
        appWin.setSize(new Dimension(370, 700));
        appWin.setTitle("GraphicsDemo");
        appWin.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        // линия
        g.drawLine(10, 40, 100, 90);
        g.drawLine(20, 90, 100, 40);
        g.drawLine(40, 45, 250, 80);
        // прямоугольник
        g.drawRect(20, 150, 60, 50);
        g.fillRect(110, 150, 60, 50);
        g.drawRoundRect(200, 150, 60, 50, 15, 15);
        g.fillRoundRect(290, 150, 60, 50, 30, 40);
        // элипс и окружность
        g.drawOval(20, 250, 50, 50);
        g.fillOval(100, 250, 75, 50);
        g.drawOval(200, 260, 100, 40);
        // дуги
        g.drawArc(20, 350, 70, 70, 0, 180);
        g.fillArc(70, 350, 70, 70, 0, 75);
        // многоугольник
        int[] xpoints = {20, 200, 20, 200, 20};
        int[] ypoints = {450, 450, 650, 650, 450};
        int num = 5;
        g.drawPolygon(xpoints, ypoints, num);
    }
}
