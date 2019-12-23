package a_SingleOfFileIO;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Читаем и пишем в файл: Human
*/
// https://javarush.ru/tasks/com.javarush.task.task20.task2001
// Реализуй логику записи в файл и чтения из файла для класса Human.
//Поле name в классе Human не может быть пустым.
//Метод main реализован только для вас и не участвует в тестировании.
//
//Требования:
//•	Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список assets пустой.
//•	Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если поле name и список assets не пустые.
//•	Класс Solution.Human не должен поддерживать интерфейс Serializable.
//•	Класс Solution.Human должен быть публичным.
//•	Класс Solution.Human не должен поддерживать интерфейс Externalizable.
public class FileSaveLoadNoSerializable_2001 {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            //            File your_file_name1 = File.createTempFile(myPath()[0], "pontY");
            //            OutputStream outputStream = new FileOutputStream(your_file_name1);
            //            InputStream inputStream = new FileInputStream(your_file_name1);

            OutputStream outputStream = new FileOutputStream(myPath()[0]);
            InputStream inputStream = new FileInputStream(myPath()[0]);

//            OutputStream outputStream = new FileOutputStream("C:\\Users\\OOS 4\\Desktop\\abd.txt");
//            InputStream inputStream = new FileInputStream("C:\\Users\\OOS 4\\Desktop\\abd.txt");

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true; // если текущий объект равен o
            if (o == null || getClass() != o.getClass()) return false; // если класс текущего не равен классу o

            Human human = (Human) o;
            // если name != null т.е. true, то вернет результат выражения !name.equals(human)
            // иначе если name == null т.е. false, то венет результат выражения human != null

            // если name объектов НЕ equals или если human.name не равен null
            // короче вернет false если строки объектов не равны и они не null
            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            // сравнивается объект список assets текущего объекта с human списком
            // если assets != null т.е. true, то вернету результ выражения assets.equals(human.assets)
            // а иначе human.assets == null
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);
            String assetSiza = assets.isEmpty() ? "no" : "yes";
            writer.write(assetSiza);
            writer.write(System.lineSeparator());
            writer.write(name);
            writer.write(System.lineSeparator());

            if (assetSiza.equals("yes")) {
                for (Asset e : assets) {
                    writer.write(e.getName());
                    writer.write(System.lineSeparator());
                    writer.write((Double.toString(e.getPrice())));
                    writer.write(System.lineSeparator());
                }
            }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String assetSiza = reader.readLine();
            name = reader.readLine();
            Asset ass = null;
            while (reader.ready()) {
                if (assetSiza.equals("yes")) {
                    //for (int i=0;i<assets.size();i++) {
                    ass = new Asset(reader.readLine(), Double.parseDouble(reader.readLine()));
                    this.assets.add(ass);
                    //System.out.println(ass.getName() + " " + ass.getPrice());
                    //}
                }
            }
            reader.close();
        }
    }

    public static String[] myPath() {
        String dir = "C:\\z_n\\new_test_folder\\1\\";
        return new String[]{dir
                + "file1.txt.pont", dir
                + "file_2.txt", dir
                + "file3.txt"};
    }

    ///////////////////////////////////////////////////////
    public static class Asset {
        public Asset(String name, double price) {
            this.name = name;
            this.price = price;
        }

        private String name;
        private double price;

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Asset asset = (Asset) o;

            if (Double.compare(asset.price, price) != 0) return false;
            return name != null ? name.equals(asset.name) : asset.name == null;
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            result = name != null ? name.hashCode() : 0;
            temp = Double.doubleToLongBits(price);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
    }
}
