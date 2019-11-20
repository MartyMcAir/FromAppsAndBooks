// объявляем функциональный интерфейс
interface MyFunction{
    // метод по умолчанию
    default void doit(int n){
        System.out.println("Результат: "+calc(n));
    }
    // абстрактный метод
    double calc(int n);
}
public class Listing11_1 {

    public static void main(String[] args) {
        // присваиваем лямбда-выражение
        // (возведение в куб)
        MyFunction Cube=(int n)->{
            return Math.pow(n,3);
        };
        // (возведение в квадрат)
        MyFunction Square=(int n)->{
            return Math.pow(n,2);
        };
        // (умножение на 5)
        MyFunction Mult=(int n)->{
            return n*5;
        };
        // отправляем код выражения Cube
        Cube.doit(3);
        // отправляем код выражения Square
        Square.doit(12);
        // отправляем код выражения Mult
        Mult.doit(5);
        // переопределяем код выражения Mult
        Mult=n->n*10;
        // повторно отправляем код выражения Mult
        Mult.doit(5);
               
    } 
}
