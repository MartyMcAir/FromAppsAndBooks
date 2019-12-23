package a_SigleOfOOP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/
// https://javarush.ru/tasks/com.javarush.task.task06.task0621
//Задача: У каждой кошки есть имя и кошка-мама.
//        Создать класс, который бы описывал данную ситуацию.
//        Создать два объекта: кошку-дочь и кошку-маму.
//        Вывести их на экран.
//
//        Новая задача: У каждой кошки есть имя, кот-папа и кошка-мама.
//        Изменить класс Cat так, чтобы он мог описать данную ситуацию.
//        Создать 6 объектов: дедушку (папин папа), бабушку (мамина мама), папу, маму, сына, дочь.
//        Вывести их всех на экран в порядке: дедушка, бабушка, папа, мама, сын, дочь.
//
//        Пример ввода:
//        дедушка Вася
//        бабушка Мурка
//        папа Котофей
//        мама Василиса
//        сын Мурчик
//        дочь Пушинка
//
//        Пример вывода:
//        The cat's name is дедушка Вася, no mother, no father
//        The cat's name is бабушка Мурка, no mother, no father
//        The cat's name is папа Котофей, no mother, father is дедушка Вася
//        The cat's name is мама Василиса, mother is бабушка Мурка, no father
//        The cat's name is сын Мурчик, mother is мама Василиса, father is папа Котофей
//        The cat's name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
//
//        Требования:
//        •	Программа должна считывать имена 6 котов в указанном порядке.
//        •	Метод main должен создавать 6 объектов типа Cat.
//        •	Программа должна выводить 6 строк с информацией о котах.
//        •	Строка про дедушку (первая) должна соответствовать условию.
//        •	Строка про бабушку (вторая) должна соответствовать условию.
//        •	Строка про папу (третья) должна соответствовать условию.
//        •	Строка про маму (четвертая) должна соответствовать условию.
//        •	Строка про сына (пятая) должна соответствовать условию.
//        •	Строка про дочь (шестая) должна соответствовать условию.
public class OOPcatsRelativies_0621 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String ct1 = reader.readLine();
        String ct2 = reader.readLine();
        String ct3 = reader.readLine();
        String ct4 = reader.readLine();
        String ct5 = reader.readLine();
        String ct6 = reader.readLine();

//        Cat cat1 = new Cat("дедушка Вася"); // дедушка Вася _
//        Cat cat2 = new Cat("бабушка Мурка"); // бабушка Мурка _
//        Cat cat3 = new Cat("папа Котофей", null ,cat1); // папа Котофей _ // дедушка Вася
//        Cat cat4 = new Cat("мама Василиса", cat2, null); // мама Василиса _ // бабушка Мурка
//        Cat cat5 = new Cat("сын Мурчик", cat4, cat3); // сын Мурчик _ // мама Василиса // папа Котофей - cat3
//        Cat cat6 = new Cat("дочь Пушинка", cat4, cat3); // дочь Пушинка _ // мама Василиса // папа Котофей - cat3

        Cat cat1 = new Cat(ct1); // дедушка Вася _
        Cat cat2 = new Cat(ct2); // бабушка Мурка _
        Cat cat3 = new Cat(ct3, null ,cat1); // папа Котофей _ // дедушка Вася
        Cat cat4 = new Cat(ct4, cat2, null); // мама Василиса _ // бабушка Мурка
        Cat cat5 = new Cat(ct5, cat4, cat3); // сын Мурчик _ // мама Василиса // папа Котофей - cat3
        Cat cat6 = new Cat(ct6, cat4, cat3); // дочь Пушинка _ // мама Василиса // папа Котофей - cat3

        System.out.println(cat1);
        System.out.println(cat2);
        System.out.println(cat3);
        System.out.println(cat4);
        System.out.println(cat5);
        System.out.println(cat6);
    }

    public static class Cat {
//        У каждой кошки есть имя, кот-папа и кошка-мама.
//        Изменить класс Cat так, чтобы он мог описать данную ситуацию.
        private String name;
        private Cat mother, father;

        Cat(String name) {
            this.name = name;
        }

        Cat(String name, Cat parent1, Cat parent2) {
            this.name = name;
            this.mother = parent1;
            this.father = parent2;
        }

        @Override
        public String toString() {
            String res = "fff", vasya = "дедушка Вася";
            if(mother ==null && father==null){
                res = "The cat's name is "+name+", no mother, no father";
            } else if(mother != null && father==null){
                res= "The cat's name is "+name+", mother is "+mother.name+", no father";
            } else if(mother == null && father!=null){
                res= "The cat's name is "+name+", no mother, father is "+father.name;
            } else if(mother != null && father!=null){
                res= "The cat's name is "+name+", mother is "+mother.name+", father is "+father.name;
            }
            return res;
        }
    }
}
