package z_OOP_BiG_Pack.OOPintrfAnonumusPuzzle_2405;

public abstract class FirstClass implements Action {     //first implementation
    // protected - Конструктор, доступен только для наследующих его
    protected FirstClass() {
        Solution.countActionObjects++;
    }

    public void someAction() {
        System.out.println("class FirstClass, method someAction");
    }

    public abstract Action getDependantAction();
}
