package RecursiveThreadShortStr_2201;

public class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) { // срабатывает при исключении само
        final String string = "%s : %s : %s";
        if (Solution.FIRST_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForFirstThread(t, e, string));
        } else if (Solution.SECOND_THREAD_NAME.equals(t.getName())) {
            System.out.println(getFormattedStringForSecondThread(t, e, string));
        } else {
            System.out.println(getFormattedStringForOtherThread(t, e, string));
        }
    }

    protected String getFormattedStringForOtherThread(Thread t, Throwable e, String string) {
        return String.format(
                string,
                e.getClass().getSimpleName(),
//                "RuntimeException",
                e.getCause(),
                t.getName()
        );
    }

    protected String getFormattedStringForSecondThread(Thread t, Throwable e, String string) {
        return String.format(
                string,
                e.getCause().getClass().getCanonicalName() + ": " + e.getCause().getMessage(),
                e.getClass().getSimpleName(),
                t.getName());
    }

    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {
        return String.format(
                string,
                t.getName(),
                e.getClass().getSimpleName(),
                e.getCause());
//                e.getCause().getClass().getCanonicalName() + ": " + e.getCause().getMessage());
    }

//    protected String getFormattedStringForFirstThread(Thread t, Throwable e, String string) {
//        String t_id = Long.toString(t.getId()); // 1
//        String message = e.getMessage(); // String index out of range: 10
//        String gName = e.getClass().getName(); // java.lang.StringIndexOutOfBoundsException
//        String gSimpleName = e.getClass().getSimpleName(); // StringIndexOutOfBoundsException
//        return String.format(string, t_id + "# :" + gSimpleName, gName, message);
//    }
}

