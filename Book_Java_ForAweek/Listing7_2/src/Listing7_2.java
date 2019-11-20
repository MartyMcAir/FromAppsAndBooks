// описание суперкласса
class MyParentClass{
    // поля родительского класса
    String text;
    int number;
    // конструктор родительского класса
    MyParentClass(String text, int number){
        // присваиваем полям значения аргументов
        this.text=text;
        this.number=number;
        // выводим значения полей на печать
        System.out.println("Сработал конструктор суперкласса!");
    }
}
// описание подкласса
class MyChildClass extends MyParentClass{
    char letter;
    int digit;
    // конструктор подкласса
    MyChildClass(String text, int number, char letter, int digit){
        // вызываем конструктор суперкласса
        super(text, number);
        this.letter=letter;
        this.digit=digit;
        System.out.println("Сработал конструктор подкласса!");
    }
    // описание метода подкласса
    void show(){
        // Выводим на печать значения всех полей объекта
        // присвоенные конструктором подкласса
        System.out.println("text="+this.text);
        System.out.println("number="+this.number);
        System.out.println("letter="+this.letter);
        System.out.println("digit="+this.digit);
    }
}
public class Listing7_2 {
    public static void main(String[] args) {
        // создаем объект подкласса
        // и передаем аргументы в конструктор подкласса
        MyChildClass obj=new MyChildClass("Hello",200,'S',5);
        obj.show();
    }
}
