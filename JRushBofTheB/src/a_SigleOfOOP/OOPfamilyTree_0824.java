package a_SigleOfOOP;

/* 
Собираем семейство
*/

import java.util.ArrayList;
import java.util.Collections;
// https://javarush.ru/tasks/com.javarush.task.task08.task0824
//1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
//        2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
//        3. Выведи все объекты Human на экран (Подсказка: используй метод toString() класса Human).
//
//        Требования:
//        •	Программа должна выводить текст на экран.
//        •	Класс Human должен содержать четыре поля.
//        •	Класс Human должен содержать один метод.
//        •	Класс Solution должен содержать один метод.
//        •	Программа должна создавать объекты и заполнять их так, чтобы получилось:
//        два дедушки, две бабушки, отец, мать, трое детей и выводить все объекты Human на экран.
public class OOPfamilyTree_0824 {
    public static void main(String[] args) {
        //напишите тут ваш код
        // два дедушки, две бабушки, отец, мать, трое детей.

        // kids 3
        ArrayList<Human> kids = new ArrayList<Human>();
        ArrayList<Human> parents1 = new ArrayList<Human>();
        ArrayList<Human> parents2 = new ArrayList<Human>();

        Human monica = new Human("monica", false, 3, null);
        Human alice = new Human("alice", false, 6, null);
        Human keisse = new Human("keisse", false, 8, null);

        Collections.addAll(kids, monica, alice, keisse);
//        Collections.addAll(list2, keisse);

        // parents
        Human fother = new Human("Djon", true, 43, kids);
        Human mother = new Human("Kerly", false, 33, kids);
        Collections.addAll(parents1, fother);
        Collections.addAll(parents2, mother);

        // grandparents
        Human GrandMother1 = new Human("KerlyMa", false, 68, parents1);
        Human GrandMother2 = new Human("DjonMa", false, 66, parents2);

        Human GrandFother1 = new Human("DjonPa", true, 88, parents2);
        Human GrandFother2 = new Human("KerlyPa", true, 86, parents1);


        System.out.println(GrandMother1);
        System.out.println(GrandMother2);
        System.out.println(GrandFother1);
        System.out.println(GrandFother2);
        System.out.println(parents1);
        System.out.println(parents2);
        System.out.println(monica);
        System.out.println(alice);
        System.out.println(keisse);

    }

    public static class Human {
        //напишите тут ваш код
        public String name; // если будет static то раб будет не верно
        public boolean sex;
        public int age;
        public ArrayList<Human> children = new ArrayList<Human>();

        Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.children != null) {
                int childCount = this.children.size();
                if (childCount > 0) {
                    text += ", дети: " + this.children.get(0).name;

                    for (int i = 1; i < childCount; i++) {
                        Human child = this.children.get(i);
                        text += ", " + child.name;
                    }
                }
            }
            return text;
        }
    }
}
