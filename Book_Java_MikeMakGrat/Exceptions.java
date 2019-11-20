class Exceptions
{
	public static void main( String[] args )
	{
		try
		{
			int num = Integer.parseInt(args[0]);
			System.out.println( "Вы ввели: "+num );		
		}
		catch(ArrayIndexOutOfBoundsException e) 
		{
			System.out.println( "Требуется целочисленный аргумент.");	
		}
		catch( NumberFormatException e ) 
		{
			System.out.println( "Неверный формат аргумента.");
		}
		finally
		{
			System.out.println( "Программа завершила работу." );
		}
	}
}
