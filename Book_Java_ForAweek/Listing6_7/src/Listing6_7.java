class MyClass{
    // закрытое статическое текстовое поле
    private static String text="Hello";
    // открытый статический метод 
    // для изменения закрытого поля
    static void setText(String txt){
        text=txt;
    }
    static void showText(){
        System.out.println(text);
    }
}
public class Listing6_7 {
    
    public static void main(String[] args) {
        // Выводим значение поля на печать
        MyClass.showText();
        // Модифицируем значение поля
        MyClass.setText("New text");
        // Выводим новое значение на печать
        MyClass.showText();
    }   
}