package a_SingleMathSimpleLogicAlgo;

/* 
Особенности автобоксинга
*/
// https://javarush.ru/tasks/com.javarush.task.task29.task2904#discussion
// Исправь ошибку в методе getValueByIndex().
// Читай доп. статью про особенности автобоксинга.

// from comments:
// Брюс Эккель в своей книге упоминает об этой особенности тернарного оператора. Всегда приводится к большему типу,
// даже если этот больший тип никогда не будет возвращаться.

// Нужно делать через утилитарные классы Arrays.asList(array).contains(index)), чтобы работало норм в реальности)
// А такой нечитаемый код, как говорили в одной из предыдущих лекций, будет выкинут при рефакторинге :D
public class AutoBoxing_2904 {
    private Integer[] array = new Integer[]{1, 2, 3, 4};

    public static void main(String[] args) {
        Number value1 = new AutoBoxing_2904().getValueByIndex(5); //-1.0, class java.lang.Double expected
        Number value2 = new AutoBoxing_2904().getValueByIndex(2); //3, class java.lang.Integer expected

        System.out.println(value1 + ", " + value1.getClass().toString());
        System.out.println(value2 + ", " + value2.getClass().toString());
    }

    Number getValueByIndex(int index) {
//        return (index >= 0 && index < array.length) ? array[index] : new Double(-1);
        // alt+enter
//        if (index >= 0 && index < array.length) return array[index];
//        else return (Number) new Double(-1);
        // or
        // если индекс больш ил равно 0 и index меньш длмны массива array (и если перв услов false то второ непроверится)
        // то вернуть при true элемент стало быть array[0]
        // а иначе т.е. при false Double(-1) приведенный-кастованный к Number
        // без cast будет 3.0 _ а надо просто 3
        return (index >= 0 && index < array.length) ? array[index] : (Number) new Double(-1);
    }
}
