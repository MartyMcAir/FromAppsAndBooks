// функциональный интерфейс
interface myFunction{
    boolean isTrue(int n);
}

public class Listing11_2 {
    public static void main(String[] args) {
        // определяем условие проверки
        myFunction term = (n)-> n%2==0;
        // формируем массив чисел
        int[] nums = {1,2,3,4,5,6,7,8,9};
        // вызываем метод sum(), которому передаем
        // лямбда-выражение term в качестве аргумента
        System.out.println(sum(nums, term));
    }
    // описываем метод для вычисления суммы
    private static int sum (int[] numbers, myFunction func)
    {
        int result = 0;
        // перебираем элементы массива
        for(int i : numbers)
        {
            if (func.isTrue(i)) {result += i;}
        }
        return result;
    }    
}
