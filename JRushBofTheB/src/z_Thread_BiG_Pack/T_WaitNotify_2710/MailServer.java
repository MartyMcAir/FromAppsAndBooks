package z_Thread_BiG_Pack.T_WaitNotify_2710;

public class MailServer implements Runnable {
    private Mail mail;

    public MailServer(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        //сделайте что-то тут - do something here
        synchronized (mail) {
            try {
                mail.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String name = Thread.currentThread().getName();
        long endTime = System.currentTimeMillis();
        System.out.format("%s MailServer received: [%s] in %d ms after start",
                name, mail.getText(), (endTime - startTime));
    }

//    public void runV0() { // работает но валя не пускает
//        long startTime = System.currentTimeMillis();
//        synchronized (mail) { // т.к. используется 2мя нитями
//            while (mail.getText() == null) { // пока текст не засетен _ ждем т.е. wait()
//                try { // обычно внутри цикла, который что-то  проверяет _ но и так работает
//                    mail.wait(); // юзается только, внути synchronized блока
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        String name = Thread.currentThread().getName();
//        long afterTime = System.currentTimeMillis();
//        System.out.format("%s MailServer has got: [%s] in %d ms after start",
//                name, mail.getText(), (afterTime - startTime));
//    }
}
