// ����������� ����� JOptionPane �� ���������� Swing
import javax.swing.JOptionPane;
public class Listing3_2{

    public static void main(String[] args) {
        // ���������� �������� ����������
        int yearNow, yearBorn, userAge;
        // ���������� ��������� ����������
        String userData;
        // ������� ���� ������� ������� ����
        userData = JOptionPane.showInputDialog("����� ������ ���?");
        // ����������� ������ � ����� � ����� ����
        yearNow = Integer.parseInt(userData);
        // ������� ���� ������� ���� ��������
        userData = JOptionPane.showInputDialog("� ����� ���� �� ��������?");
        // ����������� ������ � ����� � ����� ����
        yearBorn = Integer.parseInt(userData);
        // ��������� �������
        userAge = yearNow - yearBorn;
        // ������� ���� ��������� � �����������
        JOptionPane.showMessageDialog(null, "��� �������: " + userAge);
    }    
}
