package com.javarush.task.task37.task3702.male;

import com.javarush.task.task37.task3702.AbstractFactory;
import com.javarush.task.task37.task3702.Human;

public class MaleFactory implements AbstractFactory {
    public Human getPerson(int age) {
        if (12 >= age)
            return new KidBoy();
        if (19 >= age)
            return new TeenBoy();
        return new Man();
//        switch (age) {
//            case 12:
//                return new KidBoy();
//            case 19:
//                return new TeenBoy();
//            default:
//                return new Man();
//        }
    }
}
