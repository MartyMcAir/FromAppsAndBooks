package z_OOP_BiG_Pack.OOPinnerClassMagazine_2409;

public class Denim extends AbstractJeans {
    public Denim(int id, int length, int size, double price) {
        super(id, length, size, price);
    }

    @Override
    public String getName() {
        return getClass().getSimpleName();
//        return Denim.class.getSimpleName();
    }

//    @Override
//    public String getTM() {
//        return getClass().getSimpleName();
//    }
}
