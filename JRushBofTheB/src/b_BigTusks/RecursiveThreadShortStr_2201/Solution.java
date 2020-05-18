package b_BigTusks.RecursiveThreadShortStr_2201;

/*
Строки нитей или строковые нити? Вот в чем вопрос
*/
// https://javarush.ru/tasks/com.javarush.task.task22.task2201#discussion
public class Solution {
    public static void main(String[] args) {
        new Solution();   // STEP1 запускаем Solution_3105
    }

    public static final String FIRST_THREAD_NAME = "1#";
    public static final String SECOND_THREAD_NAME = "2#";

    private Thread thread1;
    private Thread thread2;
    private Thread thread3;

    public Solution() {
        initThreads();   // STEP2 инициализируем наши Threads _ variables
    }

    protected void initThreads() {
        // в Task передается текущий Solution_3105, и строка, потом имя потока
//        this.thread1 = new Thread(new Task(this, "\tZ"), FIRST_THREAD_NAME);
//        this.thread2 = new Thread(new Task(this, "J\tK"), SECOND_THREAD_NAME);
//        this.thread2 = new Thread(new Task(this, "J\tK"), "ff"); // for oth Exception

        this.thread1 = new Thread(new Task(this, "A\tB\tC\tD\tE\tF\tG\tH\tI"), FIRST_THREAD_NAME);
        this.thread2 = new Thread(new Task(this, "J\tK\tL\tM\tN\tO\tP\tQ\tR\tS\tT\tU\tV\tW\tX\tY\tZ"), SECOND_THREAD_NAME);
        this.thread3 = new Thread(new Task(this, "\t\t"), "3#"); // вызывает исключение!?
        // чтобы сделать возможным обработку runtime исключений,
        // отправляем класс реализовавший интерфейс UncaughtExceptionHandler
        Thread.setDefaultUncaughtExceptionHandler(new OurUncaughtExceptionHandler());
//        this.thread1.run();
//        this.thread2.run();
//        this.thread3.run();

        // стартуем наши потоки
        this.thread1.start();
        this.thread2.start();
        this.thread3.start();
    }

    // synchronized метод _ с блокировкой доступен только для одного потока - пока не освободится
    public synchronized String getPartOfString(String string, String threadName) {
//        int match = string.length() - string.replaceAll("\t", "").length();
        String res = "";
        try {
            res = string.substring(string.indexOf("\t") + 1, string.lastIndexOf("\t"));
        } catch (StringIndexOutOfBoundsException e) {
            if (threadName.equals(FIRST_THREAD_NAME)) {
//                System.out.println("сработал бросок исключаения на Thread 1");
                throw new StringForFirstThreadTooShortException(e.getMessage(), e);
            } else if (threadName.equals(SECOND_THREAD_NAME)) {
//                throw new StringForSecondThreadTooShortException("String index out of range: -1");
//                System.out.println(e.getCause()+"_____"); // null
                throw new StringForSecondThreadTooShortException(e.getMessage(), e);
            } else {
//                e.initCause(new RuntimeException(e.getMessage(), thr));
//                throw e;
//                throw new StringForOtherThreadTooShortException("String index out of range: -1", e.getCause());
//                RuntimeException runT = new RuntimeException(e.getMessage(), thr);
//                throw new StringForOtherThreadTooShortException(runT.getMessage(), runT);
//                throw new RuntimeException(e.getMessage(), thr);

//                Throwable thr = new Throwable("String index out of range: -1");
//                rte.addSuppressed(new Throwable("String index out of range: -1"));
//                RuntimeException rte = new RuntimeException();
//                rte.initCause(e);
//                throw rte;

//                Throwable thr = new Throwable("Ошибка!");
//                thr.initCause(e);
//                e.initCause(thr);
//                throw e;

//                e.initCause(new ArithmeticException());
//                throw e;

                throw new RuntimeException(e);
            }
        }
        return res;
    }
}
