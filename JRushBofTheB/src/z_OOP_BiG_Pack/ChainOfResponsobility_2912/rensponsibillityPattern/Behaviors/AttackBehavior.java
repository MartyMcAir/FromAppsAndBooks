package z_OOP_BiG_Pack.ChainOfResponsobility_2912.rensponsibillityPattern.behaviors;

import z_OOP_BiG_Pack.ChainOfResponsobility_2912.rensponsibillityPattern.Unit;

public class AttackBehavior extends DefaultBehavior implements IBehavior {
    public AttackBehavior(Unit unit) {
        super(unit);
    }

    public int handle(int distance, int power) {
        System.out.println("AttackBehavoir::handle()");
        if ((distance < unit.getAttackDistance()) && (power < unit.getPower())) {
            return DefaultBehavior.ATTACK;
        }
        return super.handle(distance, power);
    }
}