class Scope
{
	//final static String txt = "��� ���������� ���������� ������ Scope";

	public static void main ( String[] args )
	{
		String txt = "��� ��������� ���������� ������ main";
		System.out.println( txt );
		sub();

		//System.out.println( Scope.txt );
	}

	public static void sub( )

	{	
		String txt = "��� ��������� ���������� ������ sub";	
		System.out.println( txt );
	}
}
