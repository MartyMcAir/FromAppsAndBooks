class Array
{
	public static void main( String[] args )
	{
		String[] str = { "Java ", "�������", " ����" } ;
		
		int[] num = new int[3];

		num[0] = 100;
		num[1] = 200;

		str[1] = "������";

		System.out.println("������ ���������� ������� " + str.length );
		System.out.println("������ �������������� ������� " + num.length );
		System.out.println(num[0]+","+num[1]+","+num[2]);
		System.out.println(str[0]+str[1]+str[2]);
	}
}
