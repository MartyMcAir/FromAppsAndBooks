class StringComparison
{
	public static void main( String[] args )
	{
		String password = "bingo";

		try
		{
			if( args[0].toLowerCase().equals(password) ) 
			{
				System.out.println( "��������� ���� ������." );
			}
			else 
			{
				System.out.println( "Incorrect password." );
			}
		}
		catch(Exception e) 
		{
			System.out.println( "������ �����������." );
		}
	}
}
