import javax.swing.JOptionPane;

public class Listing9_3 {

    public static void main(String[] args) {
        // ������� ������ ���������� � ��������� ������
        Exception myExcept=new Exception("even");
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
                    throw myExcept;
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
            // ��������� ����� ������ ����������
            catch(Exception e){
                // ���������, ��� ��������������� ����������?
                if(e.toString().contains("even")){
                    // ���� ��, ������� ���� � ����������
                    JOptionPane.showMessageDialog(null, "����� �� ����� ������ �����!");
                }
                else{
                    // ���� ���, ������� �������� ������ � ��������
                    System.out.println(e);
                }
            }
        }  
    }
}
