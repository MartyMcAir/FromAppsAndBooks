class SubClass extends SuperClass
{
	public static void main(String[] args)
	{
		hello();
		SuperClass.hello();
		echo( args[0]);
/*
		try
		{
			echo( args[0]);
		}
		catch(Exception e)
		{
			System.out.println( "��������� ��������" );
		} 
*/
	}

	public static void hello()
	{
		System.out.println( "������ �� ���������" );
	}
}
