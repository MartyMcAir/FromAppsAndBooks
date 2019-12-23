package z_OOP_BiG_Pack.OOPinnerClassMagazine_2409;

public abstract class AbstractJeans implements Jeans {
    private int id, length, size;
    private double price;

    public AbstractJeans(int id, int length, int size, double price) {
        this.id = id;
        this.length = length;
        this.size = size;
        this.price = price;
    }

    public abstract String getName();

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public String getTM() {
        return super.getClass().getName();
    }

    @Override
    public String toString() {
        return getName() + "{" +
                "id=" + id +
                ", length=" + length +
                ", size=" + size +
                ", price=" + price +
                '}';
    }
}
