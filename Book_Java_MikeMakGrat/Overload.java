class Overload
{
	public static void main ( String[] args )
	{
		System.out.println( write(12) );
		System.out.println( write("����������") );
		System.out.println( write(4,16) );
	}

	public static String write( int num )

	{	return ( "���������� ����� " + num ) ;	}



	public static String write( String num )
	
{	return ( "���������� ��������� " + num ) ;	}



	public static String write( int num1, int num2 )

	{	return ( "����� ����� ����� " + (num1 * num2) ) ;	}
}
