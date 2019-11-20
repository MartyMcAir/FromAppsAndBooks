class FirstInstance
{
	public static void main( String[] args )
	{
		System.out.println( "Цвет автомобиля " + Car.color ) ;
		System.out.println( "Тип кузова " + Car.bodyType ) ;
		System.out.println( Car.accelerate() ) ;

		Car Porsche = new Car() ;

		System.out.println( "Цвет Porsche " + Porsche.color ) ;
		System.out.println( "Тип кузова Porsche " + Porsche.bodyType ) ;
		System.out.println( Porsche.accelerate() ) ;
	}
}

