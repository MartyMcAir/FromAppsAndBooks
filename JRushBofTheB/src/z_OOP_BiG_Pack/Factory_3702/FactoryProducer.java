package com.javarush.task.task37.task3702;

import com.javarush.task.task37.task3702.female.FemaleFactory;
import com.javarush.task.task37.task3702.male.MaleFactory;

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
