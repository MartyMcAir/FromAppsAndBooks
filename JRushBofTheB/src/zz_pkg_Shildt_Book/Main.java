package zz_pkg_Shildt_Book;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JTextField textField;

    private static final String TEXT = "You can get a blog started in less time than \n"
            + " it takes you to read this sentence. All you need is an email \n"
            + " address. You’ll get your own WordPress.com address \n"
            + " (like you.wordpress.com), a selection of great free \n"
            + " and customizable designs for your blog (we call them themes), \n"
            + " 3 gigabytes of file storage (that’s about 2,500 pictures!) \n"
            + " and all the other great features listed here. \n"
            + " You can blog as much as you want for free, \n"
            + " your blog can be public to the world or private \n"
            + " for just your friends, and our premium features \n"
            + "are completely optional.";

    public static void createGUI() {
        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JTextArea textArea = new JTextArea(10, 20);
        textArea.setText(TEXT);
        textArea.setCaretPosition(0);

        final JScrollPane scrollPane = new JScrollPane(textArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        final JCheckBox checkBox1 = new JCheckBox("Show vertical scrollbar");
        checkBox1.setSelected(true);
        checkBox1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkBox1.isSelected()) {
                    scrollPane
                            .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
                } else {
                    scrollPane
                            .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
                }
            }
        });
        panel.add(checkBox1);
        final JCheckBox checkBox2 = new JCheckBox("Show horizontal scrollbar");
        checkBox2.setSelected(true);
        checkBox2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkBox2.isSelected()) {
                    scrollPane
                            .setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                } else {
                    scrollPane
                            .setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
                }
            }
        });
        panel.add(checkBox2);

        mainPanel.add(panel, BorderLayout.SOUTH);

        frame.getContentPane().add(mainPanel);
        frame.setPreferredSize(new Dimension(350, 200));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                createGUI();
            }
        });
    }
}

