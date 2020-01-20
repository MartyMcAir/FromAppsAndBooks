package a_SingleOfThread;

/* 
Создаем deadlock
*/
// https://javarush.ru/tasks/com.javarush.task.task27.task2703#discussion
// Расставь модификаторы так, чтобы при работе с этим кодом появился deadlock.
// Метод main порождает deadlock, поэтому не участвует в тестировании.
public class ThreadDeadLoack_2703 {
    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void bow(Friend bower) { // synchronized
            System.out.format("%s: %s"
                            + " bowed to me!%n",
                    this.name, bower.getName());
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) { // synchronized
            System.out.format("%s: %s"
                            + " bowed back to me!%n",
                    this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend alphonse =
                new Friend("Alphonse");
        final Friend gaston =
                new Friend("Gaston");
        new Thread(new Runnable() {
            public void run() {
                alphonse.bow(gaston);
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                gaston.bow(alphonse);
            }
        }).start();
    }
}
