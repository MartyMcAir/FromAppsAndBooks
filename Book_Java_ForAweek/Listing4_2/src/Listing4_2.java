// импортируем класс JOptionPane из библиотеки Swing
import javax.swing.JOptionPane;
public class Listing4_2{

    public static void main(String[] args) {
        int userData;
        String userInput;
        // Выводим окно запроса текущей даты
        userInput = JOptionPane.showInputDialog("Введите число от 1 до 3");
        // Преобразуем строку в число в явном виде
        userData = Integer.parseInt(userInput);
        
        if((userData>=1)&(userData<=3)){
            JOptionPane.showMessageDialog(null, "Вы ввели число " + userData);
        }
        else {
            JOptionPane.showMessageDialog(null, "Вы ввели недопустимое число!");
        }
    }
}

