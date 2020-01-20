package Refactoring_2909.user;

import java.util.concurrent.atomic.AtomicInteger;

public class UserHelper {
    private User userAnya = new User("Аня", "Смирнова", 10);
    private User userRoma = new User("Рома", "Виноградов", 30);

    // Необходимо заменить поля isManAnya и isManRoma класса UserHelper полем boolean man в классе User.
    // Так же добавь сеттер и геттер для нового поля.
//    private boolean isManAnya = man;
//    private boolean isManRoma = man;

    public void printUsers() {
//        System.out.println("Имя: " + userAnya.getName());
//        System.out.println("Фамилия: " + userAnya.getSurname());
//        User u = userAnya;
//        u.printInfo();
//        u.printAdditionalInfo();
        userAnya.printInfo();
        userAnya.printAdditionalInfo();
//        printAdditionalInfo(userAnya);

//        System.out.println("Имя: " + userRoma.getName());
//        System.out.println("Фамилия: " + userRoma.getSurname());
//        printAdditionalInfo(userRoma);
        userRoma.printInfo();
        userRoma.printAdditionalInfo();
    }

//    public void printAdditionalInfo(User user) {
//        if (ageLessThan16(user))
//            System.out.println("Пользователь моложе 16 лет");
//        else
//            System.out.println("Пользователь старше 16 лет");
//    }

//    private boolean ageLessThan16(User user) {
//        if (user.getAge() < 16) {
//            return true;
//        }
//        return false;
//    }

    public int calculateAverageAge() {
        // age в методе используется для разных промежуточных значений.
        // Перепиши метод без использования этой переменной.
        int res = 0;
//        int age = 28;
//        User userUra = new User("Юра", "Карп", age);
//        age = (userAnya.getAge() + userRoma.getAge() + userUra.getAge()) / 3;

        res = (userAnya.getAge() + userRoma.getAge() +
                new User("Юра", "Карп", 28).getAge()) / 3;
        return res;
    }

    public int calculateRate(AtomicInteger base, int age, boolean hasWork, boolean hasHouse) {
        // чтобы он не пытался менять входные параметры,
        // а просто возвращал рассчитанное значение.
//        base.set(base.get() + age / 100);
//        base.set((int) (base.get() * (hasWork ? 1.1 : 0.9)));
//        base.set((int) (base.get() * (hasHouse ? 1.1 : 0.9)));

        // AtomicInteger integ = new AtomicInteger(8);
        // протестированно, возвращает тоже, что и код __ что выше
        double res = 0, baseOrigin = base.get();
        res = baseOrigin + age / 100;
        res = (int) res * (hasWork ? 1.1 : 0.9);
        res = (int) res * (hasHouse ? 1.1 : 0.9);
        return (int) res;
//         OR
//        return (int) ((base.get() + age / 100) * (hasWork ? 1.1 : 0.9) * (hasHouse ? 1.1 : 0.9));
    }

    public String getBossName(User user) {
        // Перепиши реализацию метода getBossName(User user) класса UserHelper.
        // (используй метод getBoss() класса User).
        //        Work work = user.getWork();
        //        return work.getBoss();
        return user.getBoss();
    }
}