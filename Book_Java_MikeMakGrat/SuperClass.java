class SuperClass
{
	public static void hello()
	{
		System.out.println( "Привет из Суперкласса" );
	}

	public static void echo(String arg )
	{
		try
		{
		
			System.out.println( "Вы ввели: " + arg );
		}
		catch(Exception e)
		{
			System.out.println( "Требуется аргумент" );
		}
	}
}

