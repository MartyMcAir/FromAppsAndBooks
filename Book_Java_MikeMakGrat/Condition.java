class Condition
{
	public static void main ( String [] args )
	{
		int num1 = 1357;
		int num2 = 2468;

		String result;

		result = ( num1 % 2 != 0 ) ? "Нечетное" : "Четное" ;
		System.out.println( num1 + " - " +  result );

		result = ( num2 % 2 != 0 ) ? "Нечетное" : "Четное" ;
		System.out.println( num2 + " - " +  result );
	}
}
