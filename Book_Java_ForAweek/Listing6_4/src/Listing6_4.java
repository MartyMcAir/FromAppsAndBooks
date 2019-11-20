// Объявляем собственный класс
class MyClass{
    // Объявляем поля класса
    int digit;
    char letter;
    // Метод с одним числовым аргументом
    void set(int n){
        digit=n;
    }
    // Метод с одним символьным аргументом
    void set(char s){
        letter=s;
    }
    // Метод с двумя аргументами
    void set(int n, char s){
        set(n); //Присвоить значение полю digit
        set(s); //Присвоить значение полю letter
    }
    // Метод без аргументов
    void set(){
        // Присваиваем значение 5 полю digit 
        // и значение А полю letter
        set(5, 'A');
    }
    // Метод для отображения значений полей
    void show(){
        System.out.println("Поле digit: "+digit);
        System.out.println("Поле letter: "+letter);
    }
}
    
public class Listing6_4 {
    public static void main(String[] args) {
        // Объявляем первый объект класса MyClass
        MyClass objFirst=new MyClass();
        // Объявляем второй объект класса MyClass
        MyClass objSecond=new MyClass();
        // Присваиваем числовое значение полю
        // первого объекта
        objFirst.set(10);
        // Присваиваем символьное значение полю
        // первого объекта
        objFirst.set('F');
        // Присваиваем значения по умолчанию полям
        // второго объекта
        objSecond.set();
        // Выводим на печать значения полей первого объекта
        System.out.println("Свойства первого объекта");
        objFirst.show();
        // Выводим на печать значения полей второго объекта
        System.out.println("\nСвойства второго объекта");
        objSecond.show();
    }
    
}
