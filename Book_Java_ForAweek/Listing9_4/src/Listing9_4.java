import javax.swing.JOptionPane;
// �������� ����������������� ������ ����������
class MyException extends Exception{
    // �������� �������� ����
    private int code;
    // ����������� ������� ����������
    MyException(int n){
        // ����� ������������ �����������
        super();
        code=n;
    }
    // �������������� ����� toString
    @Override
    public String toString(){
        String message="���������������� ����������. ��� ������: "+code;
        return message;
    }
}

public class Listing9_4 {

    public static void main(String[] args) {
        String userInput;
        int userData;
        // ��������� "������" ����
        while(true){
            // ������� ���� �������
            userInput = JOptionPane.showInputDialog("������� ������������ ����� �����");
            // ����������� ���� try
            try{
                // ����������� ������ � ����� � ����� ����
                userData = Integer.parseInt(userInput);
                // ��������� ��������� ����� �� ��������
                if((userData%2)==0){
                    // ���� ����� ������, ���������� ����������
                    throw new MyException(1);
                }
                else if(userData>100){
                    throw new MyException(2);
                }
            }
            catch(NumberFormatException e){
                // ���� ������������ ����� ������ "Cancel"
                if(e.toString().contains("null")){
                    // ���������� ������ ���������
                    System.exit(0);
                }
                // ���� ������ �������������� ���� int
                else{
                    JOptionPane.showMessageDialog(null, "������� ������������ ��������");
                }
            }
            // ��������� ���������������� ����������
            catch(MyException e){        
                System.out.println(e);
            }
        }  
    }
}
