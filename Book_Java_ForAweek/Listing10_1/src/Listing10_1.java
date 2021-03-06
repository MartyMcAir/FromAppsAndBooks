// �����, ����������� ������ ��������� ������
class MyThreadClass extends Thread{
    // ��������������� ������ run()
    @Override
    public void run(){
        // ���� ��������� ������
        for(int i=1;i<=5;i++){
            System.out.println("�������� �����: "+i);
            try{
                Thread.sleep(2500);
            }
            catch(InterruptedException e){
                System.out.println("���������� ��������� ������");
            }
        }
    }
}

// ������� ����� ���������
public class Listing10_1 {
    public static void main(String[] args) throws InterruptedException{
        // ������� ������ ��������� ������
        MyThreadClass thr=new MyThreadClass();
        // ��������� �������� �����        
        System.out.println("������ ��������� ������");
        thr.start();
        // ���� �������� ������
        for(int j=0;j<=5;j++){
            System.out.println("������� �����: "+j);
            Thread.sleep(1500);
        }
        // ���������, �������� �� �������� �����
        // ���� ��, �� ����, ���� �� �������� ������
        if(thr.isAlive()){
            System.out.println("���� ���������� ��������� ������");
            thr.join();
        }
        System.out.println("��� �������� ���������");
    }  
}
