package z_OOP_BiG_Pack.OOPinnerClassMagazine_2409;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Util {
    protected static Collection<Object[]> jeansArray = new LinkedList<>();

    static { // каждый массив объектов содержит разные типы данных -
        // т.е. для как параметры одной вещи
        jeansArray.add(new Object[]{1, Company.Levis, 34, 6, 150.0});
        jeansArray.add(new Object[]{2, Company.Denim, 35, 8, 154.0});
        jeansArray.add(new Object[]{3, Company.Colins, 32, 6, 120.0});
        jeansArray.add(new Object[]{4, Company.CalvinKleinJeans, 31, 8, 125.0});
    }

    public static List<Jeans> getAllJeans() {

        //add your code here
        abstract class AbstractJeans implements Jeans {
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
        class Levis extends AbstractJeans {
            public Levis(int id, int length, int size, double price) {
                super(id, length, size, price);
            }

            @Override
            public String getName() {
                return getClass().getSimpleName();
//        return Levis.class.getSimpleName();
            }

        }
        class Denim extends AbstractJeans {
            public Denim(int id, int length, int size, double price) {
                super(id, length, size, price);
            }

            @Override
            public String getName() {
                return getClass().getSimpleName();
//        return Denim.class.getSimpleName();
            }
        }
        ////////////
        List<Jeans> allJeans = new LinkedList<>();

        for (Object[] obj : getJeansArray()) {
            int id = (int) obj[0];
            final Company company = (Company) obj[1];
            int length = (int) obj[2];
            int size = (int) obj[3];
            double price = (double) obj[4];

            Jeans jeans = null;
            // если объект соответствует как помеченный Levis в enum перечислении Сompany
            if (Company.Levis == company) { // созд соответствующий объект
                jeans = new Levis(id, length, size, price);
            } else if (Company.Denim == company) {
                jeans = new Denim(id, length, size, price);
            } else { // иначе создаем абстрактн анонимн объект неизвестного продукта
                // (ил эт прост новый его вид)
                jeans = new AbstractJeans(id, length, size, price) {
                    @Override ///
                    public String getName() {
//                        return AbstractJeans.class.getSimpleName(); //
//                        return this.getClass().getName(); // ..
                        return company.toString(); // Colins
                    } // fullName выводит String лэйблу .. COLIN'S

                    public String getTM() {
                        return company.fullName;
                    }
                };
            }
            allJeans.add(jeans);
        }
        return allJeans;
    }

    public static Collection<Object[]> getJeansArray() {
        return jeansArray;
    }

    static enum Company {
        Levis("Levi's"),
        Denim("Denim"),
        Colins("COLIN'S"),
        CalvinKleinJeans("Calvin Klein Jeans");

        final String fullName;

        Company(String name) {
            this.fullName = name;
        }
    }
}
