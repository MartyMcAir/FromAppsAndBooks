package a_SigleOfOOP;

/* 
Исправление ошибок
*/
// https://javarush.ru/tasks/com.javarush.task.task14.task1416
//1. Подумай, как связаны интерфейсы Swimmable(способен плавать) и Walkable(способен ходить) с классом OceanAnimal(животное океана).
//        2. Расставь правильно наследование интерфейсов и класса OceanAnimal.
//        3. Подумай, как могут быть связаны классы Orca(Косатка), Whale(Кит), Otter(Выдра) с классом OceanAnimal.
//        4. Расставь правильно наследование между классами Orca, Whale, Otter и классом OceanAnimal.
//        5. Подумай, какой класс должен реализовать интерфейс Walkable и добавить интерфейс этому классу.
//        6. Подумай, какое животное еще не умеет плавать и добавить ему интерфейс Swimable.
//
//        Требования:
//        •	Косатка(Orca) является животным океана(потомком OceanAnimal) и умеет плавать(поддерживает интерфейс Swimmable).
//        •	Кит(Whale) является животным океана(потомком OceanAnimal) и умеет плавать(поддерживает интерфейс Swimmable).
//        •	Выдра(Otter) умеет ходить(поддерживает интерфейс Walkable) и плавать(поддерживает интерфейс Swimmable).
//        •	Выдра(Otter) НЕ является животным океана(потомком OceanAnimal).
//        •	Кит(Whale) и Косатка(Orca) НЕ умеют ходить(не поддерживают интерфейс Walkable).
public class OOPextendsImplements_1416 {
    public static void main(String[] args) {
        Swimmable animal = new Orca();
        animal.swim();
        animal = new Whale();
        animal.swim();
        animal = new Otter();
        animal.swim();
    }

    public static void test(Swimmable animal) {
        animal.swim();
    }

    interface Walkable {
        void walk();
    }

    interface Swimmable {
        void swim();
    }

    static abstract class OceanAnimal {
        public void swim() {
            OceanAnimal currentAnimal = (OceanAnimal) getCurrentAnimal();
            currentAnimal.displaySwim();
        }

        private void displaySwim() {
            // Вызываем абстрактный метод для классов наследовавших его
            System.out.println(getCurrentAnimal().getClass().getSimpleName() + " is swimming");
        }

        abstract Swimmable getCurrentAnimal();
    }

    static class Orca extends OceanAnimal implements Swimmable{
        @Override
        public Swimmable getCurrentAnimal() {
            return new Orca();
        }
    }

    static class Whale extends OceanAnimal implements Swimmable{
        @Override
        public Swimmable getCurrentAnimal(){
            return new Whale();
        }
    }

    static class Otter implements Swimmable, Walkable{

        @Override
        public void walk() {

        }

        @Override
        public void swim() {
            System.out.println("Otter" + " is swimming");
        }
    }
}
