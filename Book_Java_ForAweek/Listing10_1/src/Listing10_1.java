// класс, описывающий объект дочернего потока
class MyThreadClass extends Thread{
    // переопределение метода run()
    @Override
    public void run(){
        // цикл дочернего потока
        for(int i=1;i<=5;i++){
            System.out.println("ƒочерний поток: "+i);
            try{
                Thread.sleep(2500);
            }
            catch(InterruptedException e){
                System.out.println("ѕрерывание дочернего потока");
            }
        }
    }
}

// главный класс программы
public class Listing10_1 {
    public static void main(String[] args) throws InterruptedException{
        // создаем объект дочернего потока
        MyThreadClass thr=new MyThreadClass();
        // запускаем дочерний поток        
        System.out.println("«апуск дочернего потока");
        thr.start();
        // цикл главного потока
        for(int j=0;j<=5;j++){
            System.out.println("√лавный поток: "+j);
            Thread.sleep(1500);
        }
        // провер€ем, работает ли дочерний поток
        // если да, то ждем, пока он завершит работу
        if(thr.isAlive()){
            System.out.println("∆дем завершение дочернего потока");
            thr.join();
        }
        System.out.println("¬се процессы завершены");
    }  
}
