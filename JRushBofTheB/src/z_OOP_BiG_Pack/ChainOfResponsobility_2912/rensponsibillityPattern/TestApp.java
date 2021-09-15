package z_OOP_BiG_Pack.ChainOfResponsobility_2912.rensponsibillityPattern;

import z_OOP_BiG_Pack.ChainOfResponsobility_2912.rensponsibillityPattern.behaviors.AngryBehavior;
import z_OOP_BiG_Pack.ChainOfResponsobility_2912.rensponsibillityPattern.behaviors.AttackBehavior;
import z_OOP_BiG_Pack.ChainOfResponsobility_2912.rensponsibillityPattern.behaviors.CarefulBehavior;
import z_OOP_BiG_Pack.ChainOfResponsobility_2912.rensponsibillityPattern.behaviors.DefaultBehavior;

// From https://pro-prof.com/forums/topic/chain_of_responsibility_pattern
public class TestApp {
    public static void main(String[] args) {
        Unit unit = new Unit(5, 10);
        unit.setBehavior(
                new CarefulBehavior(unit).addBehavior(
                        new AttackBehavior(unit).addBehavior(
                                new DefaultBehavior(unit)
                        )
                )
        );

        System.out.println(DefaultBehavior.getCode(unit.processSituation(1, 1)));
        System.out.println(DefaultBehavior.getCode(unit.processSituation(5, 10)));
        System.out.println(DefaultBehavior.getCode(unit.processSituation(20, 5)));

        unit.setBehavior(new AngryBehavior(unit)
                .addBehavior(new CarefulBehavior(unit)
                        .addBehavior(new DefaultBehavior(unit))));

        System.out.println(DefaultBehavior.getCode(unit.processSituation(1, 1)));
        System.out.println(DefaultBehavior.getCode(unit.processSituation(7, 20)));
        System.out.println(DefaultBehavior.getCode(unit.processSituation(20, 5)));
    }
}