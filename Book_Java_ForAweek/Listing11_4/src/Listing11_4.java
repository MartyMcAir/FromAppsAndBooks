// �������������� ���������
interface myInterface{
    int calc(MyClass obj, int n);
}
// �����
class MyClass{
    // ������� �� ���
    int div2(int n){
        return n/2;
    }
    // ������ ���������� ��������
    int none(int n){
        return n;
    }
}
public class Listing11_4 {
    public static void main(String[] args) {
        // ������� ������ ������
        MyClass obj=new MyClass();
        // ��������� ������������ ����������
        myInterface tmp;
        // ��������� ������ �������� ��������
        int[] nums = {1,2,3,4,5,6,7,8,9,10};
        for(int i : nums)
        {
            if (i%2==0){ // ���� ������� �� ���
                // �� ���������� ����� ������� �� ���
                tmp=MyClass::div2;
            }
            else { // ��� ���� ���������
                // ������� �������� �����
                tmp=MyClass::none;
            }
            System.out.println(tmp.calc(obj,i));
        }
    }
}
