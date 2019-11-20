// класс, реализующий интерфейс Runnable
class MyThreadClass implements Runnable{
    // описание метода run()
    @Override
    public void run(){
        // объявляем объектную переменную thr
        Thread thr;
        // присваиваем переменной ссылку на текущий поток
        thr=Thread.currentThread();
        for(int i=1;i<=5;i++){
            // получаем имя текущего потока
            // и выводим на печать имя и значение счетчика
            System.out.println(thr.getName()+": "+i);
            try{
                Thread.sleep(2500);
            }
            catch(InterruptedException e){
                System.out.println("Прерывание дочернего потока");
            }
        }        
    }
}
public class Listing10_4 {

    public static void main(String[] args) throws InterruptedException{
        // создаем несколько объектов дочерних потоков
        Thread thr1=new Thread(new MyThreadClass(), "Поток 1");
        Thread thr2=new Thread(new MyThreadClass(), "Поток 2");
        Thread thr3=new Thread(new MyThreadClass(), "Поток 3");
        // запускаем дочерние потоки        
        thr1.start();
        thr2.start();
        thr3.start();
        // цикл главного потока
        for(int j=0;j<=5;j++){
            System.out.println("Главный поток: "+j);
            Thread.sleep(1500);
        }
        // проверяем, работает ли дочерний поток
        // если да, то ждем, пока он завершит работу
        if(thr1.isAlive() || thr2.isAlive() || thr3.isAlive()){
            System.out.println("Ждем завершение дочерних потоков");
            thr1.join();
            thr2.join();
            thr3.join();
        }
        System.out.println("Все процессы завершены");
    }
    
}
