// �������� �����������
class MyParentClass{
    // ���� ������������� ������
    String text;
    int number;
    // ����������� ������������� ������
    MyParentClass(String text, int number){
        // ����������� ����� �������� ����������
        this.text=text;
        this.number=number;
        // ������� �������� ����� �� ������
        System.out.println("�������� ����������� �����������!");
    }
}
// �������� ���������
class MyChildClass extends MyParentClass{
    char letter;
    int digit;
    // ����������� ���������
    MyChildClass(String text, int number, char letter, int digit){
        // �������� ����������� �����������
        super(text, number);
        this.letter=letter;
        this.digit=digit;
        System.out.println("�������� ����������� ���������!");
    }
    // �������� ������ ���������
    void show(){
        // ������� �� ������ �������� ���� ����� �������
        // ����������� ������������� ���������
        System.out.println("text="+this.text);
        System.out.println("number="+this.number);
        System.out.println("letter="+this.letter);
        System.out.println("digit="+this.digit);
    }
}
public class Listing7_2 {
    public static void main(String[] args) {
        // ������� ������ ���������
        // � �������� ��������� � ����������� ���������
        MyChildClass obj=new MyChildClass("Hello",200,'S',5);
        obj.show();
    }
}
