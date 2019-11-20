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
			System.out.println( "Требуется аргумент" );
		} 
*/
	}

	public static void hello()
	{
		System.out.println( "Привет из Подкласса" );
	}
}
