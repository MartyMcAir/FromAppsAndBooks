// ����� � ������������� �������
class MyClass{
    // ������ ������� ������ (��� ���������)
    void mult(){
        System.out.println("������ ������ �����.");
    }
    // ������ ������� ������ (� ����������)
    void mult(int n){
        System.out.println("������� ��������� �� ���: "+n*2);
    }
}
// ������ ���������
interface Method1{
    void doit();
}
// ������ ���������
interface Method2{
    void doit(int n);
}
public class Listing11_6 {
    public static void main(String[] args) {
        // ������� ������ ������
        MyClass obj=new MyClass();
        // ������ ������������ ����������
        Method1 A=obj::mult;
        // ������ ������������ ����������
        Method2 B=obj::mult;
        // �������� ������ ������� ������
        A.doit();
        // �������� ������ ������� ������
        B.doit(5);
    }
}
