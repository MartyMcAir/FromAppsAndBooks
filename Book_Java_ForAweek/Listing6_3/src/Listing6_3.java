import javax.swing.JOptionPane;

class MyClass{
    // Поля класса
    int fieldOne;
    int fieldTwo;
    // Метод для присваивания значений полям
    void set(int a, int b){
        fieldOne = a;
        fieldTwo = b;
    }
    // Метод для перемножения значений полей
    int multiply(){
        return fieldOne*fieldTwo;
    }
    // Метод для суммирования значений полей
    int summ(){
        return fieldOne+fieldTwo;
    }
}
public class Listing6_3 {

    public static void main(String[] args) {
        // Объявляем переменные главного класса
        int input1, input2;
        String inputString;
        
        // Создаем объект своего класса
        MyClass obj=new MyClass();
        
        // Окно ввода первого значения
        inputString=JOptionPane.showInputDialog("Введите первое значение");
        input1 = Integer.parseInt(inputString);
        
        // Окно ввода второго значения
        inputString=JOptionPane.showInputDialog("Введите второе значение");
        input2 = Integer.parseInt(inputString);
        
        // Вызываем метод для присвоения значений полям объекта
        obj.set(input1, input2);
        
        // Выводим в диалоговое окно результат сложения
        JOptionPane.showMessageDialog(null,"Результат сложения: "+obj.summ());
        // Выводим в диалоговое окно результат умножения
        JOptionPane.showMessageDialog(null,"Результат умножения: "+obj.multiply());
    }
    
}
