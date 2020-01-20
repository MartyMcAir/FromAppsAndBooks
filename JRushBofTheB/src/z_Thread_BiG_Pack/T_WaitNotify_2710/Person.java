package z_Thread_BiG_Pack.T_WaitNotify_2710;

public class Person implements Runnable {
    private final Mail mail;

    public Person(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        try {
            Thread.sleep(1000);
            //сделайте что-то тут - do something here
            synchronized (mail) {
                mail.setText("Person [" + name + "] wrote an email 'AAA'");
                mail.notifyAll();
            }
            //сделайте что-то тут - do something here
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    public void runV0() {// работает но валя не пускает
//        String name = Thread.currentThread().getName();
//        try {
//            Thread.sleep(1000);
//            synchronized (mail) { // т.к. используется 2мя нитями
//                mail.setText("Person [" + name + "] has written an email 'AAA'");
//                mail.notifyAll(); // notify - надо именно для объекта mail!
//                // так мы сообщаем, для тех кто wait(), что mail - готов!
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
}