// ����������� ����� JOptionPane �� ���������� Swing
import javax.swing.JOptionPane;
public class Listing4_1{

    public static void main(String[] args) {
        int userData;
        String userInput;
        // ������� ���� ������� ������� ����
        userInput = JOptionPane.showInputDialog("������� ����� �� 1 �� 3");
        // ����������� ������ � ����� � ����� ����
        userData = Integer.parseInt(userInput);
        
        switch(userData) {
            case 1:
                JOptionPane.showMessageDialog(null, "�� ����� ����� 1");
                break;
            case 2:
                JOptionPane.showMessageDialog(null, "�� ����� ����� 2");
                break;
            case 3:
                JOptionPane.showMessageDialog(null, "�� ����� ����� 3");
                break;
            default:
                JOptionPane.showMessageDialog(null, "�� ����� ������������ �����!");
        }
    }  
}


