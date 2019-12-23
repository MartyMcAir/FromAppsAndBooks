package a_SingleMathSimpleLogicAlgo;

/* 
Задача на проценты
*/
// https://javarush.ru/tasks/com.javarush.task.task03.task0304
// Напиши код метода addTenPercent, который увеличивает переданное целое число на 10%.
//Для возврата результата из метода addTenPercent используй оператор return.
//
//Пример:
//return 123 * 435;
//
//Требования:
//•	Метод addTenPercent должен увеличивать переданное число на 10% процентов.
//•	Метод main должен вызывать метод addTenPercent.
//•	Метод main должен выводить результаты вызова на экран.
//•	Метод addTenPercent не должен ничего выводить на экран.
public class MathTenPercent_0304 {
    public static double addTenPercent(int i) {
        return (double) (i*0.1)+i;
    }

    public static void main(String[] args) {
        System.out.println(addTenPercent(9));
    }
}
