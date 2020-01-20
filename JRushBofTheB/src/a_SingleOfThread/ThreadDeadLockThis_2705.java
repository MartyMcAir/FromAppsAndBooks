package a_SingleOfThread;

/* 
Второй вариант deadlock
*/
// https://javarush.ru/tasks/com.javarush.task.task27.task2705#discussion
// В методе secondMethod расставь synchronized блоки так, чтобы при использовании класса Solution
// нитями образовывался deadlock.
public class ThreadDeadLockThis_2705 {
    private final Object lock = new Object();

    public synchronized void firstMethod() {
        synchronized (lock) {
            doSomething();
        }
    }

    public void secondMethod() {
        synchronized (lock) { //
            synchronized (this) { //
                doSomething();
            }
        }
    }

    private void doSomething() {
    }

    public static void main(String[] args) {

    }
}