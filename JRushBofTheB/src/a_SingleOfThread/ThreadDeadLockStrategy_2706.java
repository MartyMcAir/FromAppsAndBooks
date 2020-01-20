package a_SingleOfThread;

/* 
Убираем deadlock
*/
// https://javarush.ru/tasks/com.javarush.task.task27.task2706#discussion
// Метод main не участвует в тестировании.
// Действуй аналогично примеру из лекций.
// Изменения вноси только в safeMethod.
public class ThreadDeadLockStrategy_2706 {
    public void safeMethod(Object obj1, Object obj2) {
        // не прокатило _ потому что я менял порядок отправки объектов
//        obj1 = obj2.hashCode() > obj1.hashCode() ? obj2 : obj1;
//        obj2 = obj2.hashCode() < obj1.hashCode() ? obj2 : obj1;
        // надо было ссылки имена менять и их уже отправлять в синхрониз
        Object first = obj1.hashCode() > obj2.hashCode() ? obj1 : obj2;
        Object second = obj1.hashCode() < obj2.hashCode() ? obj1 : obj2;

        synchronized (first) {
            longTimeMethod();
            synchronized (second) {
                unsafeMethod(obj1, obj2);
            }
        }

//        synchronized (obj1) {
//            longTimeMethod();
//            synchronized (obj2) {
////                longTimeMethod(); // прокатило
//                unsafeMethod(obj1, obj2);
//            }
//        }
    }

    public void longTimeMethod() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }

    protected void unsafeMethod(Object obj1, Object obj2) {
        System.out.println(obj1 + " " + obj2);
    }

    public static void main(String[] args) {
        final Object o1 = new Object();
        final Object o2 = new Object();
        final ThreadDeadLockStrategy_2706 solution = new ThreadDeadLockStrategy_2706();

        new Thread() {
            @Override
            public void run() {
                solution.safeMethod(o1, o2);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                solution.safeMethod(o2, o1);
            }
        }.start();
    }
}
