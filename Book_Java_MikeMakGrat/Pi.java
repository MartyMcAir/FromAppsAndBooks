class Pi
{
	public static void main( String[] args )
	{
		float radius = Float.parseFloat( args[0] );
		
		float shortPi = (float) Math.PI;

		float circ = shortPi * ( radius + radius );

		float area = shortPi * (radius * radius); 

		System.out.print("���� ����� �� ���������� � ��������� �� " + Math.PI );
		System.out.println(" �� " + shortPi + "...");
		System.out.println("���������� � �������� " + radius + " ��" );
		System.out.println("����� ����� " + circ + " ��");
		System.out.println("� ������� " + area + " ��.��");
	}
}
