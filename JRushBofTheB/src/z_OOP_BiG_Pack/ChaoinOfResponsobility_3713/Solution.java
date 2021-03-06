package z_OOP_BiG_Pack.ChaoinOfResponsobility_3713;

import z_OOP_BiG_Pack.ChaoinOfResponsobility_3713.space.SpaceShip;
import z_OOP_BiG_Pack.ChaoinOfResponsobility_3713.space.crew.AbstractCrewMember;

/* 
Chain of Responsibility
*/
// https://javarush.ru/tasks/com.javarush.task.task37.task3713#discussion
public class Solution {
    public static void main(String[] args) {
        SpaceShip spaceShip = new SpaceShip();
        // там сетиттся цепочка из объектов и возвращает первый объект с которого все и стратует
        AbstractCrewMember crewMember = spaceShip.getCrewChain();

        crewMember.handleRequest(AbstractCrewMember.CompetencyLevel.EXPERT, "ATTACK");
        System.out.println("-----------------------------------------");
        crewMember.handleRequest(AbstractCrewMember.CompetencyLevel.NOVICE, "WASH THE FLOOR");
        System.out.println("-----------------------------------------");
        crewMember.handleRequest(AbstractCrewMember.CompetencyLevel.INTERMEDIATE, "CHECK ENGINE");
        System.out.println("-----------------------------------------");
        crewMember.handleRequest(AbstractCrewMember.CompetencyLevel.ADVANCED, "SET ROUTE");
    }
}
