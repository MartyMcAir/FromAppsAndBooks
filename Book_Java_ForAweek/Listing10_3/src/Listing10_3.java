public class Listing10_3 {

    public static void main(String[] args) {
        // ��������� ��������� ����������
        Thread thr;
        // ����������� ���������� ������ 
        // �� ������ �������� ������
        thr=Thread.currentThread();
        // ������� �� ������ ���������� � ������
        System.out.println(thr);
        // ��������� ����� ��� ������
        thr.setName("������� �����");
        // ��������� ����� ��������� ������
        thr.setPriority(8);
        // ������� ����������� ���������� � ������
        System.out.println(thr);
    } 
}
