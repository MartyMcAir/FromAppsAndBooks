import java.util.Scanner;

public class Listing3_1{
    
    public static void main(String[] args) {
        // ������� ������ input ������ Scanner
        Scanner input = new Scanner(System.in);
        // ���������� ��� �������� ����� ������������
        String name;
        // ���������� ��� �������� �������� ������������
        String surName;
        // ���������� ��� �������� ���� �������� ������������
        int yearBorn;
        // ���������� ��� �������� �������� ����
        int yearNow;
        // ������� ������ ������
        System.out.print("���� ���: ");
        // ��������� ��� (������)
        name = input.nextLine();
        System.out.print("���� ��������: ");
        // ��������� �������� (������)
        surName = input.nextLine();
        System.out.print("����� ������ ���? ");
        // ��������� ������� ��� (����� �����)
        yearNow = input.nextInt();
        System.out.print("� ����� ���� �� ��������? ");
        // ��������� ��� �������� (����� �����)
        yearBorn = input.nextInt();
        System.out.println("������������, "+name+" "+surName+"!");
        System.out.println("��� �������: "+(yearNow-yearBorn)+".");
        
    }
}
