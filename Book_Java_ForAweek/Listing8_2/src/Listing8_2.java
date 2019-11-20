// описание интерфейса
interface MyInterface{
    // статическа€ константа
    int DISTANCE=25;
    int now=888;    
// объ€вление методов
    int mult(int a);
    double div(double b);
}
// класс, реализующий интерфейс
class MyClass implements MyInterface{
    // реализаци€ метода mult()
    @Override
    public int mult(int a){
        return(a*2);
    }
    // реализаци€ метода div()
    @Override
    public double div(double b){
        return(b/3);
    }
}
public class Listing8_2 {

    public static void main(String[] args) {
        // объект класса
        MyClass obj=new MyClass();
        // вывод на печать результатов работы
        // реализованных методов и константы
        System.out.println(obj.mult(5));
        System.out.println(obj.div(7));
        System.out.println(obj.DISTANCE);
        System.out.println(obj.now);
    }
}
