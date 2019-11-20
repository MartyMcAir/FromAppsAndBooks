import javax.swing.JOptionPane;

public class Listing9_2 {

    public static void main(String[] args) {
        // объявляем массив и сразу присваиваем значения его элементам
        int[] arr=new int[] {1,2,3,4,5,6,7,8,9,10};
        String userInput;
        int userData;
        // запускаем "вечный" цикл
        while(true){
            // Выводим окно запроса
            userInput = JOptionPane.showInputDialog("Введите индекс от 0 до 9");
            // внешний блок try-catch
            try{
                // вложенный блок try-catch
                try{
                    // Преобразуем строку в число в явном виде
                    userData = Integer.parseInt(userInput);
                    // выводим в терминал значение элемента массива
                    System.out.println(arr[userData]);
                }
                // перехват ситуации отмены ввода
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
                finally{
                    System.out.println("Сработал вложенный блок finally");
                }
            }
            // если индекс выходит за пределы диапазона 0-10
            catch(ArrayIndexOutOfBoundsException e){
                JOptionPane.showMessageDialog(null, "Элeмента с таким индексом нет!");
            }
            finally{
                System.out.println("Сработал внешний блок finally");
            }
        }
    }
}
    
