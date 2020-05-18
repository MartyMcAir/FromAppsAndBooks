package b_BigTusks.Game_2048_3513;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        Controller controller = new Controller(model);
//        View view = new View(controller);

        JFrame game = new JFrame();
        game.setTitle("2048");
        game.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        game.setSize(450, 500);
        game.setResizable(false);

        game.add(controller.getView()); // extends JPanel
        game.setLocationRelativeTo(null);
        game.setVisible(true);

    }
}
