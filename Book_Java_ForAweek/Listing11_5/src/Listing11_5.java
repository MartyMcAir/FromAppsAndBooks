// функциональный интерфейс
interface myInterface{
    int calc(int n);
}
// класс
class MyClass{
    // деление на два
    static int div2(int n){
        return n/2;
    }
    // просто возвращаем значение
    static int none(int n){
        return n;
    }
}
public class Listing11_5 {
    public static void main(String[] args) {
        // создаем объект класса
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
            System.out.println(tmp.calc(i));
        }
    }
}
