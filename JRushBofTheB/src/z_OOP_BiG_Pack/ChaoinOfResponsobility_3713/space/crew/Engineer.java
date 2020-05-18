package z_OOP_BiG_Pack.ChaoinOfResponsobility_3713.space.crew;

public class Engineer extends AbstractCrewMember {
    public Engineer(AbstractCrewMember.CompetencyLevel competencyLevel) {
        this.competencyLevel = competencyLevel;
    }

    protected void doTheJob(String request) {
        System.out.println(request + " is a common engineering task. To the work!");
    }
}
