class Exceptions
{
	public static void main( String[] args )
	{
		try
		{
			int num = Integer.parseInt(args[0]);
			System.out.println( "�� �����: "+num );		
		}
		catch(ArrayIndexOutOfBoundsException e) 
		{
			System.out.println( "��������� ������������� ��������.");	
		}
		catch( NumberFormatException e ) 
		{
			System.out.println( "�������� ������ ���������.");
		}
		finally
		{
			System.out.println( "��������� ��������� ������." );
		}
	}
}
