package a_SingleMathSimpleLogicAlgo;

/* 
Мама мыла раму
*/
// https://javarush.ru/tasks/com.javarush.task.task03.task0313
// Вывести на экран все возможные комбинации слов "Мама", "Мыла", "Раму".
//
//Подсказка: их 6 штук.
//Каждую комбинацию вывести с новой строки. Слова не разделять.
//
//Пример:
//МылаРамуМама
//РамуМамаМыла
//...
//
//Требования:
//•	Программа должна выводить текст.
//•	Выведенный текст должен содержать 6 строк.
//•	Текст в каждой строке должен быть уникален.
//•	Должны быть выведены все возможные комбинации.
public class CombinatoricsWords_0313 {
    public static void main(String[] args) {
        String a = "Мама";
        String b = "Мыла";
        String c = "Раму";
        System.out.println(a+b+c);
        System.out.println(a+c+b);
        System.out.println(b+a+c);
        System.out.println(c+a+b);
        System.out.println(b+c+a);
        System.out.println(c+b+a);
    }
}
