package z_OOP_BiG_Pack.ChainOfResponsobility_2912.rensponsibillityPattern;

import z_OOP_BiG_Pack.ChainOfResponsobility_2912.rensponsibillityPattern.behaviors.DefaultBehavior;

public class Unit {
    protected int power;
    protected int attackDistance;
    private DefaultBehavior behavior;

    public Unit(int power, int attackDistance) {
        this.power = power;
        this.attackDistance = attackDistance;
    }

    public int getPower() {
        return power;
    }

    public int getAttackDistance() {
        return attackDistance;
    }

    protected void setBehavior(DefaultBehavior behavior) {
        this.behavior = behavior;
    }

    protected DefaultBehavior getBehavior() {
        return behavior;
    }

    public int processSituation(int distance, int power) {
        return behavior.handle(distance, power);
    }
}