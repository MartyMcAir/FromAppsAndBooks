package a_SingleMathSimpleLogicAlgo;

/* 
Ханойские башни
*/
// https://javarush.ru/tasks/com.javarush.task.task34.task3411#discussion
// сам бы не допер до такой двойной рекурсии..  (нашел рекомендации читать Кнут'а)
public class HanoyaTowers_3411 {
    public static void main(String[] args) {
        int numRings = 3;
        moveRing('A', 'B', 'C', numRings);
    }

    public static void moveRing(char a, char b, char c, int numRings) {
        //напишите тут ваш код
        if (numRings > 0) {
            moveRing(a, c, b, numRings - 1); // перенести башню из n−1 диска на 2-й штырь
            System.out.println(String.format("from %c to %c", a, b));
            moveRing(c, b, a, numRings - 1); // перенеси башню из n−1 диска на 3-й штырь
        }
    }
}

// Имеется три стержня. На стержень A нанизаны numRings колец, причем кольца отличаются размером и лежат меньшее на большем. Требуется перенести пирамиду из numRings колец с стержня A на стержень B за наименьшее число ходов.
//За один раз разрешается переносить только одно кольцо, причем нельзя класть большее кольцо на меньшее.
//Нужно реализовать публичный статический метод void moveRing(char a, char b, char c, int numRings), который выведет последовательность действий, необходимых для перемещения колец со стержня A на стержень B.
//
//Параметры метода:
//char a - имя стержня, на котором в начале находятся все кольца;
//char b - имя стержня, на который нужно перенести все кольца;
//char c - имя вспомогательного стержня;
//int numRings - общее количество колец, которые необходимо перенести.
//Задачу нужно решать используя рекурсивный вызов метода moveRing.
//
//Пример1:
//Метод moveRing вызывается с параметрами: 'A', 'B', 'C', 1
//
//Ожидаемый вывод:
//from A to B
//
//Пример2:
//Метод moveRing вызывается с параметрами: 'A', 'B', 'C', 3
//
//Ожидаемый вывод:
//from A to B
//from A to C
//from B to C
//from A to B
//from C to A
//from C to B
//from A to B
//
//Подсказка: общее количество действий равно 2 в степени numRings минус 1.