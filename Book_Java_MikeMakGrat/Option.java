class Option
{
	public static void main( String[] args )
	{
		if( args[0].equals("-en") ) 
		{
			System.out.println( "����� ��� ����������� �����" );
		}
		else if( args[0].equals( "-es" ) ) 
		{
			System.out.println( "����� ��� ���������� �����" );
		}
		else System.out.println( "����������� �����" );
	}
}
