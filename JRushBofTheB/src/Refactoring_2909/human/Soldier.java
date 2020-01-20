package Refactoring_2909.human;

public class Soldier extends Human {

    public Soldier(String name, int age) {
        super(name, age);
    }

    @Override
    public void live() {
//        super.live();
        fight();
    }

    public void fight() {
//        super.fight();
    }
}
