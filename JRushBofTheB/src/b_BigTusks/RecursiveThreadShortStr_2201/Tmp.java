package b_BigTusks.RecursiveThreadShortStr_2201;

public class Tmp {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("ff1 _ started");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("thread is started.");
            }
        });
        t1.setName("1#");
        t1.start();

        Throwable thr = new Throwable("java.lang.StringIndexOutOfBoundsException:");
//        System.out.println(t1.toString() + thr.toString());
        uncaughtException(t1, thr);
//        System.out.println(String.format("%s : %s : %s", "#1", "v1", "cause"));

        System.out.println("ff2");
        Thread.sleep(500);
        t1.interrupt();
        System.out.println("ff3 _ ended");
    }

    public static void uncaughtException(Thread t, Throwable e) {
        final String string = "%s : %s : %s";
        System.out.println(getFormattedStringForOtherThread(t, e, string));
    }

    public static String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {
        return String.format(string, t.getName(), e.getMessage(), "String index out of range: -1");
    }
}
