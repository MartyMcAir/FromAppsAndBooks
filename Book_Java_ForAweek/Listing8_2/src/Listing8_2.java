// �������� ����������
interface MyInterface{
    // ����������� ���������
    int DISTANCE=25;
    int now=888;    
// ���������� �������
    int mult(int a);
    double div(double b);
}
// �����, ����������� ���������
class MyClass implements MyInterface{
    // ���������� ������ mult()
    @Override
    public int mult(int a){
        return(a*2);
    }
    // ���������� ������ div()
    @Override
    public double div(double b){
        return(b/3);
    }
}
public class Listing8_2 {

    public static void main(String[] args) {
        // ������ ������
        MyClass obj=new MyClass();
        // ����� �� ������ ����������� ������
        // ������������� ������� � ���������
        System.out.println(obj.mult(5));
        System.out.println(obj.div(7));
        System.out.println(obj.DISTANCE);
        System.out.println(obj.now);
    }
}
