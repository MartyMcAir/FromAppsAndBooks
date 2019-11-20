// �����, ����������� ��������� Runnable
class MyThreadClass implements Runnable{
    // �������� ������ run()
    @Override
    public void run(){
        // ��������� ��������� ���������� thr
        Thread thr;
        // ����������� ���������� ������ �� ������� �����
        thr=Thread.currentThread();
        for(int i=1;i<=5;i++){
            // �������� ��� �������� ������
            // � ������� �� ������ ��� � �������� ��������
            System.out.println(thr.getName()+": "+i);
            try{
                Thread.sleep(2500);
            }
            catch(InterruptedException e){
                System.out.println("���������� ��������� ������");
            }
        }        
    }
}
public class Listing10_4 {

    public static void main(String[] args) throws InterruptedException{
        // ������� ��������� �������� �������� �������
        Thread thr1=new Thread(new MyThreadClass(), "����� 1");
        Thread thr2=new Thread(new MyThreadClass(), "����� 2");
        Thread thr3=new Thread(new MyThreadClass(), "����� 3");
        // ��������� �������� ������        
        thr1.start();
        thr2.start();
        thr3.start();
        // ���� �������� ������
        for(int j=0;j<=5;j++){
            System.out.println("������� �����: "+j);
            Thread.sleep(1500);
        }
        // ���������, �������� �� �������� �����
        // ���� ��, �� ����, ���� �� �������� ������
        if(thr1.isAlive() || thr2.isAlive() || thr3.isAlive()){
            System.out.println("���� ���������� �������� �������");
            thr1.join();
            thr2.join();
            thr3.join();
        }
        System.out.println("��� �������� ���������");
    }
    
}
