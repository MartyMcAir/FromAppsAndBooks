import javax.swing.JOptionPane;
// �����, ����������� ��������� Runnable
class MyThreadClass implements Runnable{
    // �������� ������ run()
    @Override
    public void run(){
        int i=0;
        while(true){
            System.out.println(i);
            i++;
            try{
                Thread.sleep(500);
            }
            catch(InterruptedException e){
                System.out.println("���������� ��������� ������");
            }
        }        
    }
}
public class Listing10_5 {

    public static void main(String[] args) {
        // ������� ������ ������
        Thread thr=new Thread(new MyThreadClass());
        // ��������� ������ ������ ������
        thr.setDaemon(true);
        // ��������� �����
        thr.start();
        // ������� ���� ������� 
        JOptionPane.showConfirmDialog(null,"���������� ���������?","������ ������-������",JOptionPane.DEFAULT_OPTION);
        // ����������� ����������� ���������� ���������
        System.exit(0);
    }    
}
