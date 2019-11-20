class MyClass{
    // статическое числовое поле
    static int number=5;
    // статическое текстовое поле
    static String text="Hello";
    // статическй метод (вывод текста на печать)
    static void showText(){
        System.out.println(text);
    }
    // статический метод (вывод числа на печать)
    static void showNumber(){
        System.out.println(number);
    }
}
public class Listing6_6 {

    public static void main(String[] args) {
        // прямое обращение к статическим методам
        // без создания объекта класса
        MyClass.showText();
        MyClass.showNumber();
        
        // прямое обращение к статическим полям
        // без создания объекта класса
        MyClass.number=15;
        MyClass.text="Java";
        
        // проверяем, изменились ли статические поля
        // после прямого обращения
        MyClass.showText();
        MyClass.showNumber();
        
        // создаем объект класса
        MyClass obj=new MyClass();
        // обращаемся к статическим полям
        // в качестве полей объекта
        obj.showText();
        obj.showNumber();
    }
    
}
