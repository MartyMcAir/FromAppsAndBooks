package z_OOP_BiG_Pack.OOPintrfAnonumusPuzzle_2405;

/*
Black box
*/
public class OrigSol implements Action {
    public static int countActionObjects;

    private int param;

    private Action solutionAction = new Action() {
        //!!!!! Изменения могут быть тут

        public void someAction() {
            //!!!!! Все изменения должны быть только тут
        }
    };


    public OrigSol(int param) {
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
        OrigSol solution = new OrigSol(5);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);

        solution = new OrigSol(-1);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);
    }
}
