package b_BigTusks.Refactoring_2909.car;

public class Sedan extends Car {
    public Sedan(int numberOfPassengers) {
        super(1, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return Car.MAX_SEDAN_SPEED;
    }
}
