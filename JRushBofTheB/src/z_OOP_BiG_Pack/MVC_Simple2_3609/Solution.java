package z_OOP_BiG_Pack.MVC_Simple2_3609;

/* 
Рефакторинг MVC
*/
// https://javarush.ru/tasks/com.javarush.task.task36.task3609#discussion
// MVC Simple Example 2
public class Solution {
    public static void main(String[] args) {
        // Fetch car record from the database
        CarModel model = retrieveCarFromDatabase();

        // Create a view to show the car's speed on a speedometer (the console)
        SpeedometerView view = new SpeedometerView();

        CarController controller = new CarController(model, view);
        controller.updateView();

        // Update the model data
//        model.increaseSpeed(15);
        controller.increaseSpeed(15);
        controller.updateView();

        // Update the model data
//        model.increaseSpeed(50);
        controller.increaseSpeed(50);
        controller.updateView();

        // Update the model data
//        model.decreaseSpeed(7);
        controller.decreaseSpeed(7);
        controller.updateView();
    }

    private static CarModel retrieveCarFromDatabase() {
        CarModel currentCar = new CarModel();
        currentCar.setBrand("Nissan");
        currentCar.setModel("Almera Classic");
        currentCar.setSpeed(0);
        currentCar.setMaxSpeed(200);
        return currentCar;
    }
}