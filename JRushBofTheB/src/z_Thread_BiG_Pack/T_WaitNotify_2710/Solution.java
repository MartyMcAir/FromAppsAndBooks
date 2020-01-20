package z_Thread_BiG_Pack.T_WaitNotify_2710;

/* 
Расставьте wait-notify
*/
// https://javarush.ru/tasks/com.javarush.task.task27.task2710#discussion
// сам бы не допер..
public class Solution {
    public static void main(String[] args) {
        Mail mail = new Mail(); // хранитель String text _ with get() set(..)

        // нить выводит значения из Mail с помощью get() + имяНити и currentTimeMillis..- startTime
        Thread server = new Thread(new MailServer(mail));
        // нить сеттит внутырь Main сообщение
        Thread amigo = new Thread(new Person(mail));

        server.start();
        amigo.start();
    }
}
