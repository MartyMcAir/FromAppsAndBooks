package z_OOP_BiG_Pack.OOPintrfAnonumusPuzzle_2405;

/*
Black box
*/
public class MoreVariants implements Action {
    // abstract FirstClass - инкрементит эту перменную в своем конструкторе
    public static int countActionObjects;

    private int param;

    // Полю т.е. оно же просто перменная, присвоили Анонимный класс
    private Action solutionAction = new Action() {
        //!!!!! Изменения могут быть тут

        public void someAction() {
            //!!!!! Все изменения должны быть только тут
            // должно использоваться вот это
            // Неправда ваша FirstClass класс абстрактный, и нужно реализовывать
            // getDependantAction, в котором и создавать SecondClass
//            SecondClass secondClass = (SecondClass)new FirstClass(){
//                @Override
//                public Action getDependantAction() {
//                    super.someAction();
//                    return new SecondClass();
//                }
//            }.getDependantAction();

//            SecondClass secondClass = new SecondClass() {
//                @Override
//                public void someAction() {
//                    System.out.print(this.sb.toString()); // super.someAction(); // default_
//                }
//            };
////            frc.getDependantAction();
////            scl.someAction();
//
//            for (; param > 0; param--) System.out.println(param); // тож годный цикл
//
//            new FirstClass() {
//                @Override
//                public Action getDependantAction() {
////                    while (param > 0) {
////                        System.out.println(param--);
////                    }
//                    super.someAction();
//                    return null;
//                }
//            }.getDependantAction();
//
//            if (param < 0) {
//                new SecondClass() {
//                    @Override
//                    public void someAction() {
//                        System.out.print(sb.toString());
//                    }
//                }.someAction();
//            }




        }
    };


    public MoreVariants(int param) {
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
        MoreVariants solution = new MoreVariants(5);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);

        solution = new MoreVariants(-1);
        solution.someAction();
        System.out.println("Count of created Action objects is " + countActionObjects);
    }
}
