class Arithmetic
{
	public static void main( String[] args )
	{
		int num = 100; 
		int factor = 20; 
		int sum = 0;

		sum = num + factor;	// 100 + 20
		System.out.println("Результат сложения: " + sum );
		sum = num - factor;	// 100 - 20
		System.out.println("Результат вычитания: " + sum );

		sum = num * factor;	// 100 x 20
		System.out.println("Результат умножения: " + sum );
		sum = num / factor;	// 100 ч 20
		System.out.println("Результат деления: " + sum );
	}
}
