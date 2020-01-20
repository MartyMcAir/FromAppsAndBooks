package z_Thread_BiG_Pack.T_WaitNotify_2709;

/* 
Producer–consumer
*/
// https://javarush.ru/tasks/com.javarush.task.task27.task2709#discussion
// сам не допер, стало понятно позже
public class Solution {
    public static void main(String args[]) throws InterruptedException {
        // пограничный объект хранилище значения value
        // он же и выводит в консоль при put() и get()
        TransferObject transferObject = new TransferObject();
        // поставщик _ юзает put(), объекта TransferObject
        ProducerTask producerTask = new ProducerTask(transferObject);
        // потребитель _ юзает get(), объекта TransferObject
        ConsumerTask consumerTask = new ConsumerTask(transferObject);

        Thread.sleep(50);
        producerTask.stop();
        consumerTask.stop();
    }
}
