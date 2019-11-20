// ����������� ����������
abstract class Animals{
    String name;
    String sound;
    int weight;
    // ����������� ������
    Animals(String nm, String snd, int wt){
        name=nm;
        sound=snd;
        weight=wt;
    }
    // ����������� �����
    abstract void doAnimal();
}
// �������� (�����)
class Cat extends Animals{
    // �����������
    Cat(String nm, String snd, int wt){
        super(nm,snd,wt);
    }
    // �������� ������, �������������� �� �����������
    @Override
    void doAnimal(){
        System.out.println("�������� "+name+" ����� �������� "+weight+"��, ������ ���� "+sound);
        System.out.println("��� �������� ��������� ��������:");
        System.out.println("����� �����.");
    }
}
// �������� (������)
class Dog extends Animals{
    // �����������
    Dog(String nm, String snd, int wt){
        super(nm,snd,wt);
    }
    // �������� ������, �������������� �� �����������
    @Override
    void doAnimal(){
        System.out.println("�������� "+name+" ����� �������� "+weight+"��, ������ ���� "+sound);
        System.out.println("��� �������� ��������� ��������:");
        System.out.println("�������� ��� � �������.");
    }
}
public class Listing8_1 {

    public static void main(String[] args) {
        /*
		for(i=0; i<5; i++; ){
		Cat objCat[i] = new Cat("����","��-��-��",3);
		objCat[i].doAnimal();
	} */
        // ������ ����� ������ ��������� Cat
        Cat objCat=new Cat("������","���-���-���",3);
        // ������ ��� ����� ��������� Dog
        Dog objDog1=new Dog("�����","���-���-���",9);
        // ������ ��� ������ ��������� Dog
        Dog objDog2=new Dog("������","�-�-�-�-�",15);
        // ����� ������� ��������� Cat
        objCat.doAnimal();
        // ����� ������� ������� ��������� Dog
        objDog1.doAnimal();
        // ����� ������� ������� ��������� Dog
        objDog2.doAnimal();
    }
}
