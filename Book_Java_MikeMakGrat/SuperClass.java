class SuperClass
{
	public static void hello()
	{
		System.out.println( "������ �� �����������" );
	}

	public static void echo(String arg )
	{
		try
		{
		
			System.out.println( "�� �����: " + arg );
		}
		catch(Exception e)
		{
			System.out.println( "��������� ��������" );
		}
	}
}

