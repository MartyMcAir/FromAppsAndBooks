package z_OOP_BiG_Pack.OOPextendsClass_2411;

/* 
Вспомним наследование
*/
// Решил _ запутанный пример
// https://javarush.ru/tasks/com.javarush.task.task24.task2411#discussion
public class Solution extends C {
    //public class Solution_3105 {
    private class A {
        protected String value = "A";

        public A() {
            System.out.print(value);
        }
    }

    private A a = new A() {
        { //у анонимных классов нет своих конструкторов, но что-то можно сделать в блоке инициализации класса
//            {
//                System.out.print("C"); //
//            }
            value = "Y";
            // getName(): CBA com.javarush.task.task24.task2411.Solution_3105$
            // результ и без if (..) условия, такой же
            if (super.getClass().getName().contains(".Solution_3105$")) {
                System.out.print(value);
            }
        }
    };

    public Solution() {
        System.out.print("S");
    }

    public static void main(String[] args) {
        // Solution_3105 extends C -> конструктор C печатает "С" и след строка переменная B
        // B - внутр класс интерф JustInterface - от туда B печатает "B" - но т.к. он наследует C
        // то печатается опять C и только потом B,
        // текущ результ CCB
        // далее идет Solution_3105 сам последний потомок
        // и в нем в Solution_3105 внутр класс A и он же анонимный, печатает A
        // потом нижеидет A аноним пишет Y _ - внутри проверка if(..) - которая ничего не меняет
        // и конструктор Solution_3105 класса пишет S
        new Solution(); // STEP1 _
    }
}



