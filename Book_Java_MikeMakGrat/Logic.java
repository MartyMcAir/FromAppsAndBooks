class Logic
{
	public static void main( String[] args )
	{
		boolean yes = true ;
		
boolean no = false ;		

		System.out.println( "��������� ��������� yes � yes: " + ( yes && yes ) );
		
System.out.println( "��������� ��������� yes � no: " + ( yes && no ) );

		System.out.println( "��������� ��������� yes ��� yes: " + ( yes || yes ) );
		
System.out.println( "��������� ��������� yes ��� no: " + ( yes || no ) );
		
System.out.println( "��������� ��������� no ��� no: " + ( no || no ) );

		System.out.println( "�������������� �������� ���������� yes: " + yes );
		
System.out.println( "��������������� ���������� yes: " + !yes );
	}
}

