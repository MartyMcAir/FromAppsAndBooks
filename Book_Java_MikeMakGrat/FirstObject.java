class Car
{
	public final static String color = "�������" ;
	public final static String bodyType = "����" ;

	public static String accelerate()
	{
		String motion = "����������..." ;
		return motion;
	}
}

class FirstObject
{
	public static void main( String[] args )
	{
		System.out.println( "���� " + Car.color ) ;
		System.out.println( "��� ������ " + Car.bodyType ) ;
		System.out.println( Car.accelerate() ) ;
	}
}
