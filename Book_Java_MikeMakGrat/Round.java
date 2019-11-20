class Round
{
	public static void main( String[] args )
	{
		float num = 7.25f;

		System.out.println( num + " округленное равно " + Math.round(num) );
		System.out.println( num + " округленное вниз равно " + Math.floor(num) );
		System.out.println( num + " округленное вверх равно " + Math.ceil(num) );
	}
}
