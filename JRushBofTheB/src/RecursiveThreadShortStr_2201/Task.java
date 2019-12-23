package RecursiveThreadShortStr_2201;

public class Task implements Runnable {
    private String initialString;
    private Solution solution;

    public Task(Solution solution, String initialString) {
        this.solution = solution;
        this.initialString = initialString;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        String str = this.initialString;
        do {
            System.out.println(name + str); // печатает если str не null
        } while ((str = solution.getPartOfString(str, name)) != null || !str.isEmpty());
        // получаем str из getPartOfString и проверяем условие, если норм опять вызываем
        // метод что обрезает нашу строку и возвращает нам же, её уже обрезанную
        // когда обрезать будет нечего, кидаем Exception внутри метода getPartOfString()
        // согласно условиям
    }
}
