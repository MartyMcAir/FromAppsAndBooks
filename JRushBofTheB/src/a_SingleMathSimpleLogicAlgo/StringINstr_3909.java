package a_SingleMathSimpleLogicAlgo;

/* 
Одно изменение
*/
// https://javarush.ru/tasks/com.javarush.task.task39.task3909#discussion
// Реализуй метод isOneEditAway(String first, String second) который будет возвращать true, если возможно изменить/добавить/удалить один символ в одной из строк и получить другую.
//
//Символы в анализируемой строке ограничены кодировкой ASCII.
//Регистр символов учитывается.

// непоял задания
public class StringINstr_3909 {
    public static void main(String[] args) {

    }

    public static boolean isOneEditAway(String first, String second) {
        if (first == null || second == null) return false;
        if (first.equals(second)) return true;
        if (Math.abs(first.length()-second.length()) > 1) return false;

        char[] chars1 = first.toCharArray();
        char[] chars2 = second.toCharArray();
        boolean wasBadChar = false;

        int length = chars1.length < chars2.length ? chars1.length : chars2.length;

        for (int i = 0, j = 0; i < length; i++, j++) {
            System.out.println(i +" - "+j);
            if (chars1[i] != chars2[j]){
                if (wasBadChar) return false;
                if (chars1.length > chars2.length){
                    j--;
                }else if (chars1.length < chars2.length){
                    i--;
                }
                wasBadChar = true;
            }
        }

        return true;
    }
}
