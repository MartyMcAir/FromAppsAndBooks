// функциональный интерфейс
interface myInterface{
    int calc(MyClass obj, int n);
}
// класс
class MyClass{
    // деление на два
    int div2(int n){
        return n/2;
    }
    // просто возвращаем значение
    int none(int n){
        return n;
    }
}
public class Listing11_4 {
    public static void main(String[] args) {
        // создаем объект класса
        MyClass obj=new MyClass();
        // объ€вл€ем интерфейсную переменную
        myInterface tmp;
        // формируем массив исходных значений
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        for(int i : nums)
        {
            if (i%2==0){ // если делитс€ на два
                // то используем метод делени€ на два
                tmp=MyClass::div2;
            }
            else { // дл€ всех остальных
                // выводим исходное число
                tmp=MyClass::none;
            }
            System.out.println(tmp.calc(obj,i));
        }
    }
}
