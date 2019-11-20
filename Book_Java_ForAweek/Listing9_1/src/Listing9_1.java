import javax.swing.JOptionPane;
import java.util.Random;
public class Listing9_1{

    public static void main(String[] args) {
        Random rnd = new Random(System.currentTimeMillis());
        int secret = 1 + rnd.nextInt(10);
        int userData;
        String userInput;
        while(true){
            // Выводим окно запроса
            userInput = JOptionPane.showInputDialog("Угадайте число от 1 до 10");
            // проверка опасного участка кода
            try{
                // Преобразуем строку в число в явном виде
                userData = Integer.parseInt(userInput);
                // проверяем введенное число на совпадение с секретным
                if(userData == secret){
                    JOptionPane.showMessageDialog(null, "Вы угадали число!");
                    break;
                }
            }
            // обработчик исключения
            catch(NumberFormatException e){
                // если пользователь нажал кнопку "Cancel"
                if(e.toString().contains("null")){
                    // прерывание работы программы
                    System.exit(0);
                }
                // если пользователь ввел недопустимое значение
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"Недопустимое значение!","Ошибка",JOptionPane.ERROR_MESSAGE);   
            }
			finally (){
			
			}
        }
    }
}
