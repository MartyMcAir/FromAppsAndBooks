class Random
{
	public static void main( String[] args )
	{
		float random = (float) Math.random()  ;
		System.out.println("Случайное число: " + random );
		
		float multiplied = random * 10;
		System.out.println("Умноженное на 10: " + multiplied );
		
		int randomInt = (int) Math.ceil( multiplied );
		System.out.println("Случайное целое: " + randomInt );
	}
}
