class FirstInstance
{
	public static void main( String[] args )
	{
		System.out.println( "���� ���������� " + Car.color ) ;
		System.out.println( "��� ������ " + Car.bodyType ) ;
		System.out.println( Car.accelerate() ) ;

		Car Porsche = new Car() ;

		System.out.println( "���� Porsche " + Porsche.color ) ;
		System.out.println( "��� ������ Porsche " + Porsche.bodyType ) ;
		System.out.println( Porsche.accelerate() ) ;
	}
}

