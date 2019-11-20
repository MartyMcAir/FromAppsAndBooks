import javax.swing.JOptionPane;
import java.util.Random;
public class Listing9_1{

    public static void main(String[] args) {
        Random rnd = new Random(System.currentTimeMillis());
        int secret = 1 + rnd.nextInt(10);
        int userData;
        String userInput;
        while(true){
            // ������� ���� �������
            userInput = JOptionPane.showInputDialog("�������� ����� �� 1 �� 10");
            // �������� �������� ������� ����
            try{
                // ����������� ������ � ����� � ����� ����
                userData = Integer.parseInt(userInput);
                // ��������� ��������� ����� �� ���������� � ���������
                if(userData == secret){
                    JOptionPane.showMessageDialog(null, "�� ������� �����!");
                    break;
                }
            }
            // ���������� ����������
            catch(NumberFormatException e){
                // ���� ������������ ����� ������ "Cancel"
                if(e.toString().contains("null")){
                    // ���������� ������ ���������
                    System.exit(0);
                }
                // ���� ������������ ���� ������������ ��������
                System.out.println(e);
                JOptionPane.showMessageDialog(null,"������������ ��������!","������",JOptionPane.ERROR_MESSAGE);   
            }
			finally (){
			
			}
        }
    }
}
