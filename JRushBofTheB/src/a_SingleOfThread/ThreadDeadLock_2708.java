package a_SingleOfThread;

import java.util.HashSet;
import java.util.Set;

/* 
Убираем deadLock используя открытые вызовы
*/
// https://javarush.ru/tasks/com.javarush.task.task27.task2708#discussion
// Синхронизированные методы, которые вызывают внутри себя синхронизированные методы других классов, приводят к dead-lock-у.
//1. Перенесите синхронизацию с метода в синхронизированный блок, куда поместите лишь необходимые части кода.
//2. Уберите избыточную синхронизацию методов.
//3. В стеке вызова методов не должно быть перекрестной синхронизации, т.е. такого synchronizedMethodAClass().synchronizedMethodBClass().synchronizedMethodAClass()
//
//Этот способ избавления от дэдлока называется "открытые вызовы", о нем читайте в дополнительном материале к лекции.
//Метод main не участвует в тестировании.
public class ThreadDeadLock_2708 {
    public static void main(String[] args) {
        final long deadline = System.currentTimeMillis() + 5000; //waiting for 5 sec

        final RealEstate realEstate = new RealEstate();
        Set<Apartment> allApartments = realEstate.getAllApartments();

        // зачем-то сет в массив
        final Apartment[] apartments = allApartments.toArray(new Apartment[allApartments.size()]);

        for (int i = 0; i < 20; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        realEstate.revalidate();  // зачищает activeApartments
                        // и заполняет его ранодмно элементами apartment из allApartments
                    }
                }
            }, "RealEstateThread" + i).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    // перебирает apartments и кидает все в activeApartments _
                    // true означает, что кажд туда идет
                    for (int i = 0; i < apartments.length; i++) {
                        apartments[i].revalidate(true);
                    }
                }
            }, "ApartmentThread" + i).start();
        }

        Thread deamonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                // если прошло меньше 5 сек..
                while (System.currentTimeMillis() < deadline)
                    try {
                        Thread.sleep(2); // ждем 2 сек
                    } catch (InterruptedException ignored) {
                    }
                System.out.println("Deadlock occurred");
            }
        });
        deamonThread.setDaemon(true);  // живет сам и при завершении всех потоков
        deamonThread.start();
    }

    public static class Apartment {
        private String location;
        private final RealEstate realEstate;

        public Apartment(RealEstate realEstate) {
            this.realEstate = realEstate;
            setLocation(String.valueOf(Math.random() * 10));
        }

        public synchronized String getLocation() {
            return location;
        }

        public synchronized void setLocation(String location) {
            this.location = location;
        }

        public void revalidate(boolean isEmpty) { // synchronized
            if (isEmpty)
                realEstate.up(this);
        }
    }

    public static class RealEstate {

        private final Set<Apartment> allApartments;
        private final Set<Apartment> activeApartments;

        public RealEstate() {
            allApartments = new HashSet();
            activeApartments = new HashSet();

            //add some data
            allApartments.add(new Apartment(this));
            allApartments.add(new Apartment(this));
            allApartments.add(new Apartment(this));
            allApartments.add(new Apartment(this));
            allApartments.add(new Apartment(this));
            allApartments.add(new Apartment(this));
        }

        public Set<Apartment> getAllApartments() {
            return allApartments;
        }

        // но кстатить Dead Lock при тако подходе исчезал ..
        // а надо убирать не только у него
        public void up(Apartment apartment) { // synchronized _ думал что надо убрать здесь
            activeApartments.add(apartment);
        }

        public void revalidate() { // synchronized
            activeApartments.clear();
            for (Apartment apartment : allApartments) {
                boolean randomValue = Math.random() * 2 % 2 == 0;
                synchronized (apartment) {
                    apartment.revalidate(randomValue);
                }
            }
        }
    }
}