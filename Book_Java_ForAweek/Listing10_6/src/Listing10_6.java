// ����� ��� �������� ������� ������ �������
class CommonResClass{
    int x=0;
}
// ����� ��� �������� �������
class CountClass implements Runnable{
    CommonResClass res;
    // ����������� ������
    CountClass(CommonResClass res){
        this.res=res;
    }
    // ���������� ������ run()
    @Override
    public void run(){
        // ��������� ������ res ��� ������������������
        synchronized(res){
            // ����������� ���� ������� ��������� ��������
            res.x=1;
            for (int i = 1; i <= 5; i++){
                System.out.printf("%s %d \n", Thread.currentThread().getName(), res.x);
                res.x++;
                try{
                    Thread.sleep(100);
                }
                catch(InterruptedException e){}
            }
        }
    }
}

public class Listing10_6 {
    public static void main(String[] args) {
        // ������� ������ ������ CommonResClass
        CommonResClass myRes= new CommonResClass();
        // � ����� ������� ������ ������ � ��������� ��
        for (int i = 1; i < 5; i++){
            Thread thr = new Thread(new CountClass(myRes));
            thr.setName("����� "+ i);
            thr.start();
        }
    }
}
