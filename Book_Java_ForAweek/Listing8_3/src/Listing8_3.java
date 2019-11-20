// ���������� ����������
interface MyInterface{
    // ���������� ������ ����������
    void show();
}
// �������� ������, ������������ ���������
class MyClass implements MyInterface{
    int number;
    // ����������� ������
    MyClass(int n){
        number=n;
    }
    // ���������� ������ ����������
    @Override
    public void show(){
        System.out.println(number);
    }
    // �������������� ����� ������
    void showDouble(){
        System.out.println(number*2);
    }
}
public class Listing8_3 {

    public static void main(String[] args) {
        // ��������� ������������ ���������� ref
        MyInterface ref;
        
        // ������� ������ ������ MyClass
        // � ��������� ������ � ���������� ����������
        ref=new MyClass(5);
        // �������� ����� ����������
        ref.show();
        
        // ������� ������ ������ ������ MyClass
        MyClass obj=new MyClass(6);
        // ����������� ������ ������������ ����������
        ref=obj;
        // �������� ����� ����������
        ref.show();
        // �������� �������������� ����� ������
        obj.showDouble();
    }   
}
