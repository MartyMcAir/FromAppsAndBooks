package z_OOP_BiG_Pack.Factory_3702.female;

import z_OOP_BiG_Pack.Factory_3702.AbstractFactory;
import z_OOP_BiG_Pack.Factory_3702.Human;

public class FemaleFactory implements AbstractFactory {
    public Human getPerson(int age) {
        if (12 >= age)
            return new KidGirl();
        if (19 >= age)
            return new TeenGirl();
        return new Woman();
    }
}
