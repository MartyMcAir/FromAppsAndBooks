package a_SingleOfFileIO;

import java.io.*;

/* 
Найти ошибки
*/
// https://javarush.ru/tasks/com.javarush.task.task20.task2018
// Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
//
//Найди проблему и исправь ее.
//
//Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
//
//В сигнатуре класса В ошибки нет :).
//
//В методе main ошибок нет.
//
//Требования:
//•	Класс B должен быть потомком класса A.
//•	Класс B должен поддерживать интерфейс Serializable.
//•	Класс A не должен поддерживать интерфейс Serializable.
//•	Класс A не должен поддерживать интерфейс Externalizable.
//•	Программа должна выполняться без ошибок.
//•	При десериализации должны корректно восстанавливаться значение полей nameA и nameB.
public class FileSerializableFindErr_2018 implements Serializable { // Serializable - added
    public static class A {

        protected String nameA = "A";

        //you need this default constructor for proper deserialization
        public A() {
        } // без конструктора ошибка

        public A(String nameA) {
            this.nameA += nameA;
        }
    }


    public class B extends A implements Serializable {

        private String nameB;

//        public B() {
//        } // тож надо пустой констр..

        public B(String nameA, String nameB) {
            super(nameA);
            this.nameA += nameA;
            this.nameB = nameB;
        }


        private void writeObject(ObjectOutputStream objOut) throws IOException {
            objOut.defaultWriteObject();
            objOut.writeObject(nameA);
        }

        private void readObject(ObjectInputStream objIn) throws IOException, ClassNotFoundException {
            objIn.defaultReadObject();
            this.nameA = (String) objIn.readObject();
        }

    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(arrayOutputStream);

        FileSerializableFindErr_2018 solution = new FileSerializableFindErr_2018();
        B b = solution.new B("B2", "C33");
        System.out.println("nameA: " + b.nameA + ", nameB: " + b.nameB);

        oos.writeObject(b);

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(arrayOutputStream.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(arrayInputStream);

        B b1 = (B) ois.readObject();
        System.out.println("nameA: " + b1.nameA + ", nameB: " + b1.nameB);
    }
}
