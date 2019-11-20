import javax.swing.JOptionPane;
import java.util.Random;
public class Listing4_4{

    public static void main(String[] args) {
        Random rnd = new Random(System.currentTimeMillis());
        int secret = 1 + rnd.nextInt(10);
        int userData;
        String userInput;
        while(true){
        // Выводим окно запроса
        userInput = JOptionPane.showInputDialog("Угадайте число от 1 до 10");
        // Преобразуем строку в число в явном виде
        userData = Integer.parseInt(userInput);
        if(userData == secret){
            JOptionPane.showMessageDialog(null, "Вы угадали число!");
            break;
        }
        }
    }
}
