package z_OOP_BiG_Pack.OOPintrfAnonumusPuzzle_2405;

/*
Black box
*/
// https://javarush.ru/tasks/com.javarush.task.task24.task2405#discussion
public class Solution implements Action {
    // abstract FirstClass - инкрементит эту перменную в своем конструкторе
    public static int countActionObjects;

    private int param;

    // Полю т.е. оно же просто перменная, присвоили Анонимный класс
    private Action solutionAction = new Action() {
        //!!!!! Изменения могут быть тут
        // all code from
        // https://github.com/avedensky/JavaRushTasks/blob/master/3.JavaMultithreading/src/com/javarush/task/task24/task2405/Solution.java
        FirstClass firstClass; //
        SecondClass secondClass; //

        public void someAction() {
            //!!!!! Все изменения должны быть только тут
            // должно использоваться вот это
            if (param > 0) {
                firstClass = new FirstClass() {
                    @Override
                    public Action getDependantAction() {
                        super.someAction();
                        return new Action() {
                            @Override
                            public void someAction() {
                            }
                        };
                    }
                };

                for (int i = 5; i > 0; i--)
                    System.out.println(i);

                param = 0;
                firstClass.someAction();
            }
            secondClass = new SecondClass();
            secondClass.someAction();
            System.out.print(SecondClass.SPECIFIC_ACTION_FOR_ANONYMOUS_SECOND_CLASS_PARAM.substring(1));
            System.out.println(param);


        }
    };


    public Solution(int param) {
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
        Solution solution = new Solution(5);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);

        solution = new Solution(-1);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);
    }
}
