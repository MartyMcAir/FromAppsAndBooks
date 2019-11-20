// импортируем класс JOptionPane из библиотеки Swing
import javax.swing.JOptionPane;
public class Listing4_1{

    public static void main(String[] args) {
        int userData;
        String userInput;
        // Выводим окно запроса текущей даты
        userInput = JOptionPane.showInputDialog("Введите число от 1 до 3");
        // Преобразуем строку в число в явном виде
        userData = Integer.parseInt(userInput);
        
        switch(userData) {
            case 1:
                JOptionPane.showMessageDialog(null, "Вы ввели число 1");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "Вы ввели число 2");
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "Вы ввели число 3");
                break;
            default:
                JOptionPane.showMessageDialog(null, "Вы ввели недопустимое число!");
        }
    }  
}


