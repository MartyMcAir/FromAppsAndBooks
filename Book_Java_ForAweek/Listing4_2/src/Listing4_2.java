// ����������� ����� JOptionPane �� ���������� Swing
import javax.swing.JOptionPane;
public class Listing4_2{

    public static void main(String[] args) {
        int userData;
        String userInput;
        // ������� ���� ������� ������� ����
        userInput = JOptionPane.showInputDialog("������� ����� �� 1 �� 3");
        // ����������� ������ � ����� � ����� ����
        userData = Integer.parseInt(userInput);
        
        if((userData>=1)&(userData<=3)){
            JOptionPane.showMessageDialog(null, "�� ����� ����� " + userData);
        }
        else {
            JOptionPane.showMessageDialog(null, "�� ����� ������������ �����!");
        }
    }
}

