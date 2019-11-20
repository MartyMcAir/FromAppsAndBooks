// класс с перегруженным методом
class MyClass{
    // первый вариант метода (без аргумента)
    void mult(){
        System.out.println("Вызван пустой метод.");
    }
    // второй вариант метода (с аргументом)
    void mult(int n){
        System.out.println("Вызвано умножение на два: "+n*2);
    }
}
// первый интерфейс
interface Method1{
    void doit();
}
// второй интерфейс
interface Method2{
    void doit(int n);
}
public class Listing11_6 {
    public static void main(String[] args) {
        // создаем объект класса
        MyClass obj=new MyClass();
        // первая интерфейсная переменная
        Method1 A=obj::mult;
        // вторая интерфейсная переменная
        Method2 B=obj::mult;
        // вызываем первый вариант метода
        A.doit();
        // вызываем второй вариант метода
        B.doit(5);
    }
}
