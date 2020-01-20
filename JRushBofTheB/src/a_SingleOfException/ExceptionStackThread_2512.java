package a_SingleOfException;

/*
Живем своим умом
*/
// https://javarush.ru/tasks/com.javarush.task.task25.task2512#discussion
// Живем своим умом
//В классе Solution реализуй интерфейс UncaughtExceptionHandler, который должен:
//1. прервать нить, которая бросила исключение.
//2. вывести в консоль стек исключений, начиная с самого вложенного.
//
//Пример исключения:
//new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")))
//
//Пример вывода:
//java.lang.IllegalAccessException: GHI
//java.lang.RuntimeException: DEF
//java.lang.Exception: ABC
public class ExceptionStackThread_2512 implements Thread.UncaughtExceptionHandler {
//    private volatile static ArrayList<String> list = new ArrayList<>();

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        // code here
        // OR v4 _ правильно но надо, вывод в обратном порядке
//        System.out.print(e.getClass() + ": "); // java.lang.IllegalAccessException..
//        System.out.print(e.getLocalizedMessage() + "\n"); // GHI DEF ABC
        // V4 upd _ Work!
        t.interrupt();
        if (e.getCause() != null) {
            uncaughtException(t, e.getCause());
        }
        // обеспечивает вывод в обратномпорядке
//        System.out.print(e.getClass() + ": "); // java.lang.IllegalAccessException..
//        System.out.print(e.getLocalizedMessage() + "\n"); // GHI DEF ABC
        // принимает именно такой вывод
        System.out.println(e); // java.lang.IllegalAccessException: GHI

        // OR V6 _ work!
//        list.add(e.getClass() + ": " + e.getLocalizedMessage());
//        if (e.getCause() != null) {
//            uncaughtException(t, e.getCause());
//            // После вызова uncaughtException нужно прервать нить, которая бросила исключение.
//            t.interrupt();
//        }
//        if (e.getCause() == null) {
//            for (int i = list.size() - 1; i > 0; i--) {
//                // Сообщения должны выводиться в формате "exception class: exception message".
//                System.out.println(list.get(i));
//            }
//        }

        // OR V5
//        StackTraceElement[] traceArr = e.getStackTrace();
//        for (int i = 0; i < traceArr.length; i++) {
//            System.out.println(traceArr[i]);
//            System.out.println(traceArr[i].getClassName());
//        }

        // OR V3
//        System.out.println("getCause: " + e.getCause());
//        System.out.println("getMessage: " + e.getMessage());
//        if (e.getCause() != null) {
////            for (int i = 0; i < e.getStackTrace().length; i++) {
//            for (int i = e.getStackTrace().length; i > e.getStackTrace().length; i--) {
//                uncaughtException(t, new Throwable(String.valueOf(e.getStackTrace()[i])));
//            }
//        }
        // OR V1
//        if (e.getCause() != null) {
//            System.out.println("getCause: " + e.getCause());
//            System.out.println("getMessage: " + e.getMessage());
//            uncaughtException(t, e.getCause());
//        }
        // OR _ V2
//        for(StackTraceElement elem : t.getStackTrace()){
//            System.out.println(elem.getClassName());
//        }
    }

    public static void main(String[] args) {
        // my test variant wrong
//        Solution sol = new Solution();
//        sol.division(10, 0);
//
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int z = 10 / 0;
//            }
//        });
//        t.setUncaughtExceptionHandler(sol);

        // И если вы еще не разобрались с рекурсивными методами и методом .getCause()
        // к этому моменту (как это было со мной), то самое время...
        new ExceptionStackThread_2512().uncaughtException(Thread.currentThread(),
                // т.е. Exception, внутри которого другой Exception
                new Exception("ABC", new RuntimeException("DEF",
                        new IllegalAccessException("GHI"))));


    }

    public int division(int a, int b) {
        return a / b;
    }

    //  в методе мэйн у нас получется пирамида которая одна ошибка пройсходит от 2 и так по стэку!
    //есль мы в методе вызовём простой код
    //e.printStackTrace();
    //
    //мы получим:
    //java.lang.Exception: ABC
    //	at com.javarush.task.task25.task2512.Solution.main(Solution.java:13)
    //Caused by: java.lang.RuntimeException: DEF
    //	... 1 more
    //Caused by: java.lang.IllegalAccessException: GHI
    //	... 1 more
    //
    //ВОТ и наша пирамида но проблема, мы не можем её запихнуть в массив стеков для этого мы просто ловим все Throwable переменые.
    //для этого нам нужна либо медот рекурсий (вызывает самого себя до выполнения условия(край)) (более красивее получается код примеры ниже) или через метод while() добавляем в Массив <Throwable> все переменые с помощю метода
    //e.getCause()
    //
    //через колекцию переворачеваем наш список(обязательно иначе не пропустит валидатор) (((((
    //пытался вывести от конца списка к началу и не пропустило
    //
    //после без никаких танцев с бубном с именем класса и мессаже вызываем метод
    //е.fillInStackTrace()


    ///////////
    //         t.interrupt();
    //        Stack<Throwable> exceptions = new Stack<>();
    //        exceptions.push(e);
    //        Throwable throwable = e.getCause();
    //        while (throwable != null) {
    //            exceptions.push(throwable);
    //            throwable = throwable.getCause();
    //        }
    //        while (!exceptions.empty())
    //        {
    //            Throwable currentException = exceptions.pop();
    //            System.out.println(currentException.getClass().getName() + ": " +currentException.getMessage());
    //        }
}
