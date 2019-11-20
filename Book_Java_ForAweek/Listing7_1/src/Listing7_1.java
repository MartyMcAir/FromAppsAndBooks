// описание суперкласса
class MyParentClass{
    // числовое поле суперкласса
    int number=5;
    // текстовое поле суперкласса
    String text="Hello";
    // методы суперкласса
    void showText(){
        System.out.println(text);
    }
    void showNumber(){
        System.out.println(number);
    }
}
// описание подкласса
class MyChildClass extends MyParentClass{
    int sum(int a){
        return number+a;
    }
}
public class Listing7_1 {

    public static void main(String[] args) {
        // создаем объект суперкласса
        MyParentClass objParent=new MyParentClass();
        // создаем объект подкласса
        MyChildClass objChild=new MyChildClass();
        // вызываем методы суперкласса
        objParent.showNumber();
        objParent.showText();
        // вызываем методы подкласса
        objChild.showNumber();
        objChild.showText();
        // вызываем дополнительный метод подкласса
        int b=objChild.sum(12);
        // выводим результат вызова метода на печать
        System.out.println(b);
    }   
}
