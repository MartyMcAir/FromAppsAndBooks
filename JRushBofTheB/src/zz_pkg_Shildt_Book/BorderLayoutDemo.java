package zz_pkg_Shildt_Book;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BorderLayoutDemo extends Frame {
    public BorderLayoutDemo() throws HeadlessException {
        // диспетчер граничной компановки используется по умолчанию
        add(new Button("This is across the top."), BorderLayout.NORTH);
        add(new Label("The footer message might go here."), BorderLayout.SOUTH);
        add(new Button("Right"), BorderLayout.EAST);
        add(new Button("Left"), BorderLayout.WEST);
        // используется метод add​(Component comp, Object constraints)
        // наследуемый из https://docs.oracle.com/javase/10/docs/api/java/awt/Container.html

        String msg = "The reasonable man adapts "
                + "himself to the world:\n"
                + "the unreasonable one persists in "
                + "trying to adapt the world to himself.\n"
                + "Therefore all progress depends "
                + "on the unreasonable man.\n\n"
                + " - George Bernard Shaw\n\n";

        add(new TextArea(msg), BorderLayout.CENTER);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        BorderLayoutDemo appWin = new BorderLayoutDemo();
        appWin.setSize(new Dimension(300, 220));
        appWin.setTitle("BorderLayoutDemo");
        appWin.setVisible(true);
    }
}
