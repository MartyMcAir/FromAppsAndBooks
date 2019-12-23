package z_OOP_BiG_Pack.OOPintrfAnonumusPuzzle_2405;

/*
Black box
*/
public class MyFirstV1 implements Action {
    // abstract FirstClass - инкрементит эту перменную в своем конструкторе
    public static int countActionObjects;

    private int param;

    // Полю т.е. оно же просто перменная, присвоили Анонимный класс
    private Action solutionAction = new Action() {
        //!!!!! Изменения могут быть тут
        // Работает но валидацию не проходит
        public void someAction() {
            //!!!!! Все изменения должны быть только тут
            SecondClass secondClass = new SecondClass() {
                @Override
                public void someAction() {
                    System.out.print(this.sb.toString()); // super.someAction(); // default_
                }
            };
//            frc.getDependantAction();
//            scl.someAction();

            if (param > 0) {
                FirstClass firstClass = new FirstClass() { // требует обязательной реализации т.к. abstract класс и его метод
                    @Override   //  так, что делаем это через анонимный класс
                    public Action getDependantAction() {
                        return null; //  Solution.this::someAction;
                    }
                };

                for (int i = 0; i < 5; i++) {
                    System.out.println(param--);
                }
                firstClass.someAction();
                secondClass.someAction();
                secondClass.sb.delete(0, secondClass.sb.toString().length()); // 1ий вариант вывода Specific action..
                secondClass.sb.append(SecondClass.SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM + param + "\n");
                secondClass.someAction();
            } else {
                secondClass.someAction();
//                Solution.countActionObjects--; // необходимо в случае если FirstClass создан в скоупе всего метода
                System.out.println(); // 2ий вариант вывода Specific action..
                System.out.println(SecondClass.SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM.
                        substring(1) + param);
            }

        }
    };


    public MyFirstV1(int param) {
        this.param = param;
    }

    @Override
    public void someAction() {
        solutionAction.someAction();
    }

    /**
     * 5
     * 4
     * 3
     * 2
     * 1
     * class FirstClass, method someAction
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = 0
     * Count of created Action objects is 2
     * class SecondClass, method someAction
     * Specific action for anonymous SecondClass, param = -1
     * Count of created Action objects is 3
     */
    public static void main(String[] args) {
        MyFirstV1 solution = new MyFirstV1(5);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);

        solution = new MyFirstV1(-1);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);
    }
}
