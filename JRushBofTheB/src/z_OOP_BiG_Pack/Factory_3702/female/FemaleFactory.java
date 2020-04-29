package com.javarush.task.task37.task3702.female;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

public class FemaleFactory implements AbstractFactory {
    public Human getPerson(int age) {
        if (12 >= age)
            return new KidGirl();
        if (19 >= age)
            return new TeenGirl();
        return new Woman();
    }
}
