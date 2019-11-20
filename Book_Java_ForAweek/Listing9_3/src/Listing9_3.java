import javax.swing.JOptionPane;

public class Listing9_3 {

    public static void main(String[] args) {
        // создаем объект исключения с описанием ошибки
        Exception myExcept=new Exception("even");
        String userInput;
        int userData;
        // запускаем "вечный" цикл
        while(true){
            // Выводим окно запроса
            userInput = JOptionPane.showInputDialog("Введите произвольное целое число");
            // проверяемый блок try
            try{
                // преобразуем строку в число в явном виде
                userData = Integer.parseInt(userInput);
                // проверяем введенное число на четность
                if((userData%2)==0){
                    // если число четное, генерируем исключение
                    throw myExcept;
                }
            }
            catch(NumberFormatException e){
                // если пользователь нажал кнопку "Cancel"
                if(e.toString().contains("null")){
                    // прерывание работы программы
                    System.exit(0);
                }
                // если ошибка преобразования типа int
                else{
                    JOptionPane.showMessageDialog(null, "Введено недопустимое значение");
                }
            }
            // обработка любых других исключений
            catch(Exception e){
                // проверяем, это сгенерированное исключение?
                if(e.toString().contains("even")){
                    // если да, выводим окно с сообщением
                    JOptionPane.showMessageDialog(null, "Здесь не любят четные числа!");
                }
                else{
                    // если нет, выводим описание ошибки в терминал
                    System.out.println(e);
                }
            }
        }  
    }
}
