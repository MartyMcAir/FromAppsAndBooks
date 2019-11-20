// объ€вление интерфейса
interface MyInterface{
    // объ€вление метода интерфейса
    void show();
}
// описание класса, реализующего интерфейс
class MyClass implements MyInterface{
    int number;
    // конструктор класса
    MyClass(int n){
        number=n;
    }
    // реализаци€ метода интерфейса
    @Override
    public void show(){
        System.out.println(number);
    }
    // дополнительный метод класса
    void showDouble(){
        System.out.println(number*2);
    }
}
public class Listing8_3 {

    public static void main(String[] args) {
        // объ€вл€ем интерфейсную переменную ref
        MyInterface ref;
        
        // создаем объект класса MyClass
        // и сохран€ем ссылку в переменной интерфейса
        ref=new MyClass(5);
        // вызываем метод интерфейса
        ref.show();
        
        // создаем второй объект класса MyClass
        MyClass obj=new MyClass(6);
        // присваиваем ссылку интерфейсной переменной
        ref=obj;
        // вызываем метод интерфейса
        ref.show();
        // вызываем дополнительный метод класса
        obj.showDouble();
    }   
}
