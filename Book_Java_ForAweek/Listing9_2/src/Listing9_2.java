import javax.swing.JOptionPane;

public class Listing9_2 {

    public static void main(String[] args) {
        // ��������� ������ � ����� ����������� �������� ��� ���������
        int[] arr=new int[] {1,2,3,4,5,6,7,8,9,10};
        String userInput;
        int userData;
        // ��������� "������" ����
        while(true){
            // ������� ���� �������
            userInput = JOptionPane.showInputDialog("������� ������ �� 0 �� 9");
            // ������� ���� try-catch
            try{
                // ��������� ���� try-catch
                try{
                    // ����������� ������ � ����� � ����� ����
                    userData = Integer.parseInt(userInput);
                    // ������� � �������� �������� �������� �������
                    System.out.println(arr[userData]);
                }
                // �������� �������� ������ �����
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
                finally{
                    System.out.println("�������� ��������� ���� finally");
                }
            }
            // ���� ������ ������� �� ������� ��������� 0-10
            catch(ArrayIndexOutOfBoundsException e){
                JOptionPane.showMessageDialog(null, "��e����� � ����� �������� ���!");
            }
            finally{
                System.out.println("�������� ������� ���� finally");
            }
        }
    }
}
    
