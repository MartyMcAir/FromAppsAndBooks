class Precedence
{
	public static void main (String [] args )
	{
		int sum = 32 - 8 + 16 * 2;	// 56 ( 16x2=32 + 24 = 56) 
		System.out.println( "Порядок действий по умолчанию: " + sum );
		
		sum = (32 - 8 + 16) * 2;	// 80 ( 40x2 = 80 )
		System.out.println( "Указанный порядок действий: " + sum );

		sum = (32 - (8 + 16) ) * 2;	// 16 ( 32-24=8 x 2 = 16 )
		System.out.println( "Специфичный порядок действий: " + sum );
	}
}
