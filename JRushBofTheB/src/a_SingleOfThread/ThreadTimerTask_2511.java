package a_SingleOfThread;

import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/
// https://javarush.ru/tasks/com.javarush.task.task25.task2511#discussion
// Создай свой UncaughtExceptionHandler в виде локального класса внутри конструктора.
//UncaughtExceptionHandler должен маскировать звездочками имя трэда и выводить в консоль описание возникшей ошибки.
//"Thread-0" должно быть заменено на "********".
//"Thread-4321" должно быть заменено на "***********".
//
//Требования:
//•	Определение класса Solution_3105 и его поля менять нельзя.
//•	Конструктор Solution_3105 должен создавать свой UncaughtExceptionHandler, и сохранять его в поле handler.
//•	Созданный UncaughtExceptionHandler должен выводить описание возникшей ошибки в консоль.
//•	В описании ошибки имя трэда должно быть замаскировано символами "*".
public class ThreadTimerTask_2511 extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public ThreadTimerTask_2511(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                // мое решение не подошло опять непонятная задача
                // сделай то-то непонятно-что
//                if (t.getName().equals("Thread-0")) {
//                    t.setName("********");
//                }
//                if (t.getName().equals("Thread-4321")) {
//                    t.setName("***********");
//                }
//                System.out.println(e);

                // copy past
//                StringBuilder hidedThreadName = new StringBuilder();
//                for (int i = 0; i < t.getName().length(); i++) {
//                    hidedThreadName.append('*');
//                }
//
//                String newName = String.valueOf(hidedThreadName);
//                System.out.println(e.getMessage().replaceAll(t.getName(), newName));

                // OR
                String stars = t.getName().replaceAll(".", "*");
                String newMessage = e.getMessage().replace(t.getName(), stars);
                e = new Exception(newMessage, e);
                System.out.println(e.getMessage());
                t.setName(stars);
            }
        };    //init handler here
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
        ThreadTimerTask_2511 s = new ThreadTimerTask_2511(new TimerTask() {
            @Override
            public void run() {
                int i = 1 / 0;
            }
        });

        s.run();
    }
}