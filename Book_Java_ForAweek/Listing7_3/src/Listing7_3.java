class MyParentClass{
    int number=5;
    // �������� ����� �����������
    void show(){
        System.out.println("����� �����������");
        System.out.println(number);
    }
}
class MyChildClass extends MyParentClass{
    // ��������������� ������ �����������
    @Override
    void show(){
        System.out.println("����� ����� ���������");
        System.out.println(number*2);
    }
}
public class Listing7_3 {

    public static void main(String[] args) {
        // ������� ������ �����������
        MyParentClass objParent=new MyParentClass();
        // ������� ������ ���������
        MyChildClass objChild=new MyChildClass();
        // �������� ����� �����������
        objParent.show();
        // �������� ���������������� ����� ���������
        objChild.show();
    }
    
}
