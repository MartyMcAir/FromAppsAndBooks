package z_OOP_BiG_Pack.Factory_3702;

import z_OOP_BiG_Pack.Factory_3702.female.FemaleFactory;
import z_OOP_BiG_Pack.Factory_3702.male.MaleFactory;

public class FactoryProducer {
    public static AbstractFactory getFactory(HumanFactoryType type) {
//        if (HumanFactoryType.MALE.ordinal() == type.ordinal())
        if (type == HumanFactoryType.MALE)
            return new MaleFactory();
        return new FemaleFactory();
    }

    public static enum HumanFactoryType {
        MALE, FEMALE;
    }
}
