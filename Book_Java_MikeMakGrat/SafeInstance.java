class Car
{
	private String maker ;
	private String color ;
	private String bodyType ;

	private String accelerate()
	{
		String motion = "����������..." ;
		return motion;
	}

	public void setCar( String brand, String paint, String style )
	{
		maker = brand ;
		color = paint;
		bodyType = style;
	}

	public void getCar()
	{
		System.out.println( maker +" ���� " + color );
		System.out.println( maker + " ��� ������ " + bodyType );
		System.out.println( maker + "   " + accelerate() +"\n" );
	}
}

class SafeInstance
{
	public static void main( String[] args )
	{
		Car Porsche = new Car();
		Porsche.setCar( "Porsche", "�������", "����" );
		Porsche.getCar();

		Car Bentley = new Car();
		Bentley.setCar( "Bentley", "�������", "�����" );
		Bentley.getCar();
	}
}



