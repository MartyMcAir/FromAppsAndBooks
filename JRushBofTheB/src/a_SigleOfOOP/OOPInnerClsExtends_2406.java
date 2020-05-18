package a_SigleOfOOP;

import java.math.BigDecimal;
// https://javarush.ru/tasks/com.javarush.task.task24.task2406#discussion
// Внутри класса Solution_3105 создай 2 внутренних public класса Apt3Bedroom, BigHall.
//Унаследуй их от Apartments и Hall.
//
//Требования:
//•	Класс Apt3Bedroom должен быть создан внутри класса Solution_3105.
//•	Класс BigHall должен быть создан внутри класса Solution_3105.
//•	Класс Apt3Bedroom должен быть публичным.
//•	Класс BigHall должен быть публичным.
//•	Класс Apt3Bedroom должен быть потомком класса Building.Apartments.
//•	Класс BigHall должен быть потомком класса Building.Hall.
public class OOPInnerClsExtends_2406 {
    public class Building {
        public class Hall {
            private BigDecimal square;

            public Hall(BigDecimal square) {
                this.square = square;
            }
        }

        public class Apartments {
        }
    }

    public static void main(String[] args) {

    }

    public class Apt3Bedroom extends Building.Apartments {

        public Apt3Bedroom(Building building) {
            building.super();
        }
    }

    public class BigHall extends Building.Hall {
        public BigHall(BigDecimal square) {
            new Building().super(square);
        }
        // OR
//        public BigHall(Building building, BigDecimal square) {
//            building.super(square);
//
//        }
        // OR
        // если мы хотим не число а какой то объект типа Hall в конструктор воткнуть
//        BigHall(Building building, Building.Hall hall) {
//            building.super(hall.square);
//        }
    }
}
