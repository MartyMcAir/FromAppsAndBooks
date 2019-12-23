package a_SingleTusks;

/* 
Задача №6 на преобразование целых типов
*/
// https://javarush.ru/tasks/com.javarush.task.task10.task1006
//Убери ненужные операторы приведения типа, чтобы получился ответ: result: 1000.0
//        double d = (short) 2.50256e2d;
//        char c = (short) 'd';
//        short s = (short) 2.22;
//        int i = (short) 150000;
//        float f = (short) 0.50f;
//        double result = f + (i / c) - (d * s) - 500e-3;
//
//        Требования:
//        •	Программа должна выводить текст на экран.
//        •	Нельзя менять команду вывода на экран.
//        •	Метод main() должен содержать переменную c типа char.
//        •	Метод main() должен содержать переменную s типа short.
//        •	Метод main() должен содержать переменную i типа int.
//        •	Метод main() должен содержать переменную f типа float.
//        •	Метод main() должен содержать переменную d типа double.
//        •	Метод main() должен содержать переменную result типа double.
//        •	Начальное значение переменных при инициализации менять нельзя.
//        Можно добавлять только операторы приведения типа.
//        •	Программа должна выводить текст "result: 1000.0".
public class CastingPrimitive_1006 {
    public static void main(String[] args) {
        // Original
//        double d = (short) 2.50256e2d;
//        char c = (short) 'd';
//        short s = (short) 2.22;
//        int i = (short) 150000;
//        float f = (short) 0.50f;
//        double result = f + (i / c) - (d * s) - 500e-3;
//        System.out.println("d: "+d+", c: "+c+", s: "+s+", i: "+i+", f: "+f);
//        System.out.println("result: " + result); // -311.5

        // Resolved
        double d = (short) 2.50256e2d;   // 250.0
        char c = (byte) 'd';   // d
        short s = (short) 2.22;   // 2
        int i = (int) 150000;   // 18928
        float f = (float) 0.50f;   // 0.0 __
        double result = f + (i / c) - (d * s) - 500e-3;

//        System.out.println("d: " + d + ", c: " + c + ", s: " + s + ", i: " + i + ", f: " + f);
//
//        System.out.println((i / c)); // 189
//        System.out.println((d * s)); // 500.0
//        System.out.println((i / c) - (d * s)); // -311.0
//        System.out.println((i / c) - (d * s) - 500e-3); // -311.5

        System.out.println("result: " + result); // -311.5
    }
}