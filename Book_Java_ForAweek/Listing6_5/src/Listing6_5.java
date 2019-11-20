class MyClass{
    // Объявляем поля класса
    int digit;
    char letter;
    // Конструктор класса без аргументов
    MyClass(){
        digit=9;
        letter='Z';
        System.out.println("Вызван конструктор объекта без аргументов.");
        System.out.println("Полям присвоены значения "+digit+" и "+letter);
    }
    // Конструктор класса с двумя аргументами
    MyClass(int a, char b){
        digit=a;
        letter=b;
        System.out.println("Вызван конструктор объекта с двумя аргументами.");
        System.out.println("Полям присвоены значения "+digit+" и "+letter);
    }
}

public class Listing6_5 {

    public static void main(String[] args) {
        // Создаем первый объект класса MyClass
        // Вызывается конструктор без аргументов
        MyClass objFirst=new MyClass();
        
        // Создаем второй объект класса MyClass
        // Вызывается конструктор с двумя аргументами
        MyClass objSecond=new MyClass(8, 'B');
    }
    
}
