package z_OOP_BiG_Pack.MVC_Simple2_3609;

public class CarController {
    private CarModel model;
    private SpeedometerView view;

    public CarController(CarModel model, SpeedometerView view) {
        this.model = model;
        this.view = view;
    }

    public void increaseSpeed(int seconds) {
        int speed = model.getSpeed();
        int maxSpeed = model.getMaxSpeed();

        if (speed < maxSpeed) {
            speed += (3.5 * seconds);
            model.setSpeed(speed);
        }
        if (speed > maxSpeed) {
            speed = maxSpeed;
            model.setSpeed(speed);
        }
    }

    public void decreaseSpeed(int seconds) {
        int speed = model.getSpeed();
        if (speed > 0) {
            speed -= (12 * seconds);
            model.setSpeed(speed);
        }
        if (speed < 0) {
            speed = 0;
            model.setSpeed(speed);
        }
    }

//    public void increaseSpeed(int seconds) {
//        if (speed < maxSpeed) {
//            speed += (3.5 * seconds);
//        }
//        if (speed > maxSpeed) {
//            speed = maxSpeed;
//        } }

//    public void decreaseSpeed(int seconds) {
//        if (speed > 0) {
//            speed -= (12 * seconds);
//        }
//        if (speed < 0) {
//            speed = 0;
//        } }

    public String getCarBrand() {
        return model.getBrand();
    }

    public String getCarModel() {
        return model.getModel();
    }

    public void setCarSpeed(int speed) {
        model.setSpeed(speed);
    }

    public int getCarSpeed() {
        return model.getSpeed();
    }

    public int getCarMaxSpeed() {
        return model.getMaxSpeed();
    }

    public void updateView() {
        view.printCarDetails(getCarBrand(), getCarModel(), getCarSpeed());
    }
}