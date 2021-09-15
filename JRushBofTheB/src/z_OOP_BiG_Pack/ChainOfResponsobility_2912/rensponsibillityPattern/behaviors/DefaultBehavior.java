package z_OOP_BiG_Pack.ChainOfResponsobility_2912.rensponsibillityPattern.behaviors;

import z_OOP_BiG_Pack.ChainOfResponsobility_2912.rensponsibillityPattern.Unit;

public class DefaultBehavior implements IBehavior {
    static public int WAIT = 0;
    static public int ATTACK = 1;
    static public int RUN = 2;
    protected DefaultBehavior behavior;
    protected Unit unit;

    public DefaultBehavior(Unit unit) {
        this.unit = unit;
    }

    public int handle(int distance, int power) {
        if (behavior != null) {
            return behavior.handle(distance, power);
        } else {
            System.out.println("DefaultBehavoir::handle()");
            return DefaultBehavior.WAIT;
        }
    }

    public DefaultBehavior addBehavior(DefaultBehavior behavoir) {
        this.behavior = behavoir;
        return this;
    }

    static public String getCode(int option) {
        switch (option) {
            case 1:
                return "attack!!!";
            case 2:
                return "run!";
            default:
                return "waiting...";
        }
    }
}