class Random
{
	public static void main( String[] args )
	{
		float random = (float) Math.random()  ;
		System.out.println("��������� �����: " + random );
		
		float multiplied = random * 10;
		System.out.println("���������� �� 10: " + multiplied );
		
		int randomInt = (int) Math.ceil( multiplied );
		System.out.println("��������� �����: " + randomInt );
	}
}
