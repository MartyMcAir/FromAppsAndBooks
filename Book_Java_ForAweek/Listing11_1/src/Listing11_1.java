// ��������� �������������� ���������
interface MyFunction{
    // ����� �� ���������
    default void doit(int n){
        System.out.println("���������: "+calc(n));
    }
    // ����������� �����
    double calc(int n);
}
public class Listing11_1 {

    public static void main(String[] args) {
        // ����������� ������-���������
        // (���������� � ���)
        MyFunction Cube=(int n)->{
            return Math.pow(n,3);
        };
        // (���������� � �������)
        MyFunction Square=(int n)->{
            return Math.pow(n,2);
        };
        // (��������� �� 5)
        MyFunction Mult=(int n)->{
            return n*5;
        };
        // ���������� ��� ��������� Cube
        Cube.doit(3);
        // ���������� ��� ��������� Square
        Square.doit(12);
        // ���������� ��� ��������� Mult
        Mult.doit(5);
        // �������������� ��� ��������� Mult
        Mult=n->n*10;
        // �������� ���������� ��� ��������� Mult
        Mult.doit(5);
               
    } 
}
