// Описание пользовательского класса
class MyClass{
    // Описание метода, выполняющего сложение
    int summ(int a, int b){
        int summa=a+b;
        return summa;
    }
    // Описание метода, выполняющего умножение
    int proiz(int a, int b){
        int proizvedenie=a*b;
        return proizvedenie;
    }
}
public class Listing6_2 {

    public static void main(String[] args) {
        // Создаем объект класса MyClass
        MyClass test=new MyClass();
        // Вызов метода, выполняющего сложение
        System.out.println("Сумма чисел 4+5="+test.summ(4,5));
        // Вызов метода, выполняющего умножение
        System.out.println("Произведение чисел 5*6="+test.proiz(5,6));
    }
    
}
