import java.io.* ;

class WriteFile
{
	public static void main( String[] args )
	{
		try
		{	
			FileWriter file = new FileWriter( "tam.txt" );

			BufferedWriter buffer = new BufferedWriter( file );

			buffer.write("��� ����� �� ��������� ���,");
				buffer.newLine();
			buffer.write("� ���� �������, � ������ ���,");
				buffer.newLine();
			buffer.write("� ������� ������ ���� �������,");
				buffer.newLine();
			buffer.write("� ���� ����� ���������...");
				buffer.newLine();
			buffer.write("� ����� ����, ��� ��� ����,");
				buffer.newLine();
			buffer.write("��� ������ �������� �� �����.");

			buffer.close();
		}
		catch( IOException e )
		{
			System.out.println( "��������� ������ ������." );
		}
	}
}
