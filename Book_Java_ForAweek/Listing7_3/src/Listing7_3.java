class MyParentClass{
    int number=5;
    // исходный метод суперкласса
    void show(){
        System.out.println("Метод суперкласса");
        System.out.println(number);
    }
}
class MyChildClass extends MyParentClass{
    // переопределение метода суперкласса
    @Override
    void show(){
        System.out.println("Новый метод подкласса");
        System.out.println(number*2);
    }
}
public class Listing7_3 {

    public static void main(String[] args) {
        // создаем объект суперкласса
        MyParentClass objParent=new MyParentClass();
        // создаем объект подкласса
        MyChildClass objChild=new MyChildClass();
        // вызываем метод суперкласса
        objParent.show();
        // вызываем переопределенный метод подкласса
        objChild.show();
    }
    
}
