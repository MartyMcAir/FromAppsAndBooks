package z_OOP_BiG_Pack.ChainOfResponsobility_2912.rensponsibillityPattern.behaviors;

import z_OOP_BiG_Pack.ChainOfResponsobility_2912.rensponsibillityPattern.Unit;

public class AngryBehavior extends DefaultBehavior implements IBehavior {
    public AngryBehavior(Unit unit) {
        super(unit);
    }

    public int handle(int distance, int power) {
        System.out.println("AngryBehavoir::handle()");
        if ((distance / 2 < unit.getAttackDistance()) && (power / 5 < unit.getPower())) {
            return DefaultBehavior.ATTACK;
        }
        return super.handle(distance, power);
    }
}