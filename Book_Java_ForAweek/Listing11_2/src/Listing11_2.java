// �������������� ���������
interface myFunction{
    boolean isTrue(int n);
}

public class Listing11_2 {
    public static void main(String[] args) {
        // ���������� ������� ��������
        myFunction term = (n)-> n%2==0;
        // ��������� ������ �����
        int[] nums = {1,2,3,4,5,6,7,8,9};
        // �������� ����� sum(), �������� ��������
        // ������-��������� term � �������� ���������
        System.out.println(sum(nums, term));
    }
    // ��������� ����� ��� ���������� �����
    private static int sum (int[] numbers, myFunction func)
    {
        int result = 0;
        // ���������� �������� �������
        for(int i : numbers)
        {
            if (func.isTrue(i)) {result += i;}
        }
        return result;
    }    
}
