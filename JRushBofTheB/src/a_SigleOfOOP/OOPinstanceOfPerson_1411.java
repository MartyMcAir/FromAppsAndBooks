package a_SigleOfOOP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
User, Loser, Coder and Proger
*/
// https://javarush.ru/tasks/com.javarush.task.task14.task1411
//1. Ввести [в цикле] с клавиатуры несколько строк (ключей).
//        Строки(ключи) могут быть такими: "user", "loser", "coder", "proger".
//        Ввод окончен, когда строка не совпадает ни с одной из выше указанных.
//
//        2. Для каждой введенной строки нужно:
//        2.1. Создать соответствующий объект [см. Person.java], например, для строки "user" нужно создать объект класса User.
//        2.2. Передать этот объект в метод doWork.
//
//        3. Написать реализацию метода doWork, который:
//        3.1. Вызывает метод live() у переданного объекта, если этот объект (person) имеет тип User.
//        3.2. Вызывает метод doNothing(), если person имеет тип Loser.
//        3.3. Вызывает метод writeCode(), если person имеет тип Coder.
//        3.4. Вызывает метод enjoy(), если person имеет тип Proger.
//
//        Требования:
//        •	Метод main должен считывать строки с клавиатуры.
//        •	Метод main должен прекращать считывать строки с клавиатуры, как только введенная строка не совпадает с одной из ожидаемых(user, loser, coder, proger).
//        •	Для каждой корректной(user, loser, coder, proger) введенной строки должен быть вызван метод doWork с соответствующим объектом класса Person в качестве параметра.
//        •	В классе Solution_3105 должен быть реализован метод doWork с одним параметром типа Person.
//        •	Метод doWork должен вызывать метод live() у переданного объекта, если этот объект имеет тип User.
//        •	Метод doWork должен вызывать метод doNothing() у переданного объекта, если этот объект имеет тип Loser.
//        •	Метод doWork должен вызывать метод writeCode() у переданного объекта, если этот объект имеет тип Coder.
//        •	Метод doWork должен вызывать метод enjoy() у переданного объекта, если этот объект имеет тип Proger.
public class OOPinstanceOfPerson_1411 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        //тут цикл по чтению ключей, пункт 1
        Map<String, Person> map = new HashMap<>();
        map.put("user", new Person.User());
        map.put("loser", new Person.Loser());
        map.put("coder", new Person.Coder());
        map.put("proger", new Person.Proger());

        while (true) {
            key = reader.readLine();
            if (map.containsKey(key)) {
                //создаем объект, пункт 2
                person = map.get(key);
                doWork(person); //вызываем doWork
            } else {
                break;
            }
        }
    }

    public static void doWork(Person person) {
        // пункт 3
        if(person instanceof Person.User){
//            new Person.User().live();
            ((Person.User) person).live(); // считает это более правильным вариантом
            // нисходящее сужающее приведение
        }
        if(person instanceof Person.Loser){
//            new Person.Loser().doNothing();
            ((Person.Loser) person).doNothing();
        }
        if(person instanceof Person.Coder){
//            new Person.Coder().writeCode();
            ((Person.Coder) person).writeCode();
        }
        if(person instanceof Person.Proger){
//            new Person.Proger().enjoy();
            ((Person.Proger) person).enjoy();
        }
    }

    public interface Person {
        class User implements Person {
            void live() {
                System.out.println("I usually just live.");
            }
        }

        class Loser implements Person {
            void doNothing() {
                System.out.println("I usually do nothing.");
            }
        }

        class Coder implements Person {
            void writeCode() {
                System.out.println("I usually write code.");
            }
        }

        class Proger implements Person {
            void enjoy() {
                System.out.println("It's a wonderful life!");
            }
        }

    }
}
