// �������������� ���������
interface myInterface{
    int calc(int n);
}
// �����
class MyClass{
    // ������� �� ���
    static int div2(int n){
        return n/2;
    }
    // ������ ���������� ��������
    static int none(int n){
        return n;
    }
}
public class Listing11_5 {
    public static void main(String[] args) {
        // ������� ������ ������
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
            System.out.println(tmp.calc(i));
        }
    }
}
