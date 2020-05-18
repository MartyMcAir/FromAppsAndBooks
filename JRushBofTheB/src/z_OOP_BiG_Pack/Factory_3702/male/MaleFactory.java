package z_OOP_BiG_Pack.Factory_3702.male;

import z_OOP_BiG_Pack.Factory_3702.AbstractFactory;
import z_OOP_BiG_Pack.Factory_3702.Human;

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
