// класс, в котором описан общий метод
class CommonResClass{
    int x=0;
    // объявляем синхронизированный метод
    synchronized void increment(){
        x=1;
        for (int i = 1; i <= 5; i++){
            System.out.printf("%s %d \n", Thread.currentThread().getName(), x);
            x++;
            try{
                Thread.sleep(100);
            }
            catch(InterruptedException e){}
        }
    }
}
// класс для создания потоков
class CountClass implements Runnable{
    CommonResClass res;
    // конструктор класса
    CountClass(CommonResClass res){
        this.res=res;
    }
    // реализация метода run()
    @Override
    public void run(){
        res.increment();
    }
}

public class Listing10_7 {
    public static void main(String[] args) {
        // создаем объект класса CommonResClass
        CommonResClass myRes= new CommonResClass();
        // в цикле создаем четыре потока и запускаем их
        for (int i = 1; i < 5; i++){
            Thread thr = new Thread(new CountClass(myRes));
            thr.setName("Поток "+ i);
            thr.start();
        }
    }
}