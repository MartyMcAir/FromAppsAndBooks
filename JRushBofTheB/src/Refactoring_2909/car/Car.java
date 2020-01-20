package Refactoring_2909.car;

import java.util.Date;

public abstract class Car {

    public static final int MAX_TRUCK_SPEED = 80;
    public static final int MAX_SEDAN_SPEED = 120;
    public static final int MAX_CABRIOLET_SPEED = 90;

    static public final int TRUCK = 0;
    static public final int SEDAN = 1;
    static public final int CABRIOLET = 2;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public static Car create(int type, int numberOfPassengers) {
//        return new Car(type, numberOfPassengers);
        switch (type) {
            case 0:
                return new Truck(numberOfPassengers);
            case 1:
                return new Sedan(numberOfPassengers);
            case 2:
                return new Cabriolet(numberOfPassengers);
        }
        return null;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0)
            throw new Exception();
//        return -1;
        fuel += numberOfLiters;
//        return 0;
    }

    // определяющий относится ли переданная дата к лету
    public boolean isSummer(Date date, Date summerStart, Date summerEnd) {
        // My Version
//        boolean res = false;
//        long check = date.getTime(), start = summerStart.getTime(),
//                end = summerEnd.getTime();
//        if (check >= start & check <= end) {
//            res = true;
//        }
//        return res;
        // from comment
//        return date.before(summerEnd) && date.after(summerStart);
        // Origin
        if (summerStart.after(date) || summerEnd.before(date)) {
            return false;
        } else {
            return true;
        }
    }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        double consumption;
        if (isSummer(date, SummerStart, SummerEnd)) {
            consumption = getSummerConsumption(length);
        } else {
            consumption = getWinterConsumption(length);
        }
        return consumption;
    }

    public double getWinterConsumption(int length) {
        // сам не допер
        return length * winterFuelConsumption + winterWarmingUp;
    }

    public double getSummerConsumption(int length) {
        return length * summerFuelConsumption;
    }

//    public boolean getNumberOfPassengersCanBeTransferred() {
//        if (!canPassengersBeTransferred()) return 0;
//        return numberOfPassengers;
//        if (!isDriverAvailable())
//            return 0;
//        if (fuel <= 0)
//            return 0;
    // вал не примет
//        return canPassengersBeTransferred() ? numberOfPassengers : 0;
//        return isDriverAvailable() && fuel > 0;
//    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (canPassengersBeTransferred()) {
            return numberOfPassengers;
        } else {
            return 0;
        }
    }


    private boolean canPassengersBeTransferred() {
        return isDriverAvailable() & fuel > 0;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    public void startMoving() {
        if (numberOfPassengers > 0) {
            fastenPassengersBelts();
        }
        fastenDriverBelt();

    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }


    public abstract int getMaxSpeed();
//        if (type == TRUCK)
//            return MAX_TRUCK_SPEED;
//        if (type == SEDAN)
//            return MAX_SEDAN_SPEED;
//        return MAX_CABRIOLET_SPEED;

}