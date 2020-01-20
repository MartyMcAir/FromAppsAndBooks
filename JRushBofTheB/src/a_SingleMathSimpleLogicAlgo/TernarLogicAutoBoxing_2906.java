package a_SingleMathSimpleLogicAlgo;

/* 
Особенности автобоксинга - 2
*/
// https://docs.oracle.com/javase/specs/jls/se12/html/jls-15.html#jls-15.25
// Исправь ошибку реализации, приводящую к NullPointerException, в методе getValue().
// Читай доп. статью про особенности автобоксинга.
// https://javarush.ru/tasks/com.javarush.task.task29.task2906#discussion
public class TernarLogicAutoBoxing_2906 {
    public static void main(String[] args) {
        Integer a = getValue(Boolean.TRUE, Boolean.TRUE);   //100 expected
        Integer b = getValue(Boolean.FALSE, Boolean.TRUE);  //200 expected
        Integer c = getValue(Boolean.FALSE, Boolean.FALSE); //null expected

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
    }

    public static Integer getValue(boolean first, boolean second) {
//        return first ? 100 : second ? 200 : null;
//        return first ? 100 : second ? 200 : null;
        // т.е. надо было сделать тоже что и слева, просто сделать парсинг к нужному типу
        return first ? Integer.valueOf(100) : second ? Integer.valueOf(200) : null;
    }
}

// c комментов
// В Docs Oracle (15.25. Conditional Operator ? :) написано что "The conditional operator is syntactically
// right-associative (it groups right-to-left). Thus, a?b:c?d:e?f:g means the same as a?b:(c?d:(e?f:g))".
//Исходя из этого наш тернарный оператор можно представить так:
//(first ? 100 : (second ? 200 : null))
//
//Так же в пункте документации 15.25 приведены таблицы типов результата тернарного оператора в зависимости
// от типов операндов.
//Руководствуясь ими:
//(second ? 200 : null) - (int, null) -> lub(Integer,null)
//
//где lub - Least Upper Bound. Если я правильно понял, то это "как бы считается за Integer" (хотя до конца
// я это все равно не понял) и следовательно
//(first ? 100 : lub(Integer,null)) - (int, Integer) -> int
//
//результат тернарного оператора int.

// https://habr.com/ru/post/201334/
// Как сказано в статье т.к. результат int надо совершить unboxing, вызвав intValue, что и выдаёт исключение.
// По примеру кода из ссылки выше можем сделать эквивалентный код метода getValue:
//public static Integer getValue(boolean first, boolean second) {
//        Integer n;
//        if( first ) {
//            n = Integer.valueOf(100);
//        }
//        else {
//            if( second ) {
//                n = Integer.valueOf(Integer.valueOf(200).intValue());
//            }
//            else {
//                n = Integer.valueOf(((Integer) null).intValue());
//            }
//        }
//        return n;
//    }
//
//Для решения задачи мы 100 делаем Integer - Integer.valueOf(100), и получается
//(first ? Integer.valueOf(100) : lub(Integer,null)) - (Integer, Integer) -> Integer
//
//результат тернарного оператора Integer.
//
//Я тут все правильно описал? Если нет, поправьте.
//Но смутное понимание lub (least upper bound) не даёт мне покоя. Может кто-нибудь объяснить на пальцах.