package z_OOP_BiG_Pack.ChaoinOfResponsobility_3713.space.crew;

// P.S. Постарайся реализовать метод handleRequest таким образом,
// чтобы при добавлении новых должностей нам не требовалось вносить в него изменения. Другие методы не трогай.

//P.P.S. Все enum поддерживают интерфейс Comparable.

public abstract class AbstractCrewMember {
    public enum CompetencyLevel {
        NOVICE,
        INTERMEDIATE,
        ADVANCED,
        EXPERT
    }

    protected CompetencyLevel competencyLevel;

    protected AbstractCrewMember nextCrewMember;

    public void setNextCrewMember(AbstractCrewMember nextCrewMember) {
        this.nextCrewMember = nextCrewMember;
    }

    public void handleRequest(CompetencyLevel competencyLevel, String request) {
//        if (this.competencyLevel == competencyLevel)
//            doTheJob(request);

//        if (this.competencyLevel.ordinal() < competencyLevel.ordinal())
////        if (this.competencyLevel.compareTo(competencyLevel) < 0)
//            nextCrewMember.handleRequest(competencyLevel, request);

        // from https://github.com/SergeyYakimaha/JavaRush/blob/71897246eaba1402289f418568a60d55770341ae/4.JavaCollections/src/com/javarush/task/task37/task3713/space/crew/AbstractCrewMember.java
        if (this.competencyLevel.compareTo(competencyLevel) == 0)
            this.doTheJob(request);
        else
            this.nextCrewMember.handleRequest(competencyLevel, request);
    }

    public void handleRequestOrigin(CompetencyLevel competencyLevel, String request) {
        if (nextCrewMember.competencyLevel == CompetencyLevel.EXPERT) {
            doTheJob(request);
        } else if (nextCrewMember != null) {
            nextCrewMember.handleRequest(competencyLevel, request);
        }
    }

    protected abstract void doTheJob(String request);
}
