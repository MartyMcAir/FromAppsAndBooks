class Array
{
	public static void main( String[] args )
	{
		String[] str = { "Java ", "Хороший", " Язык" } ;
		
		int[] num = new int[3];

		num[0] = 100;
		num[1] = 200;

		str[1] = "Лучший";

		System.out.println("Размер строкового массива " + str.length );
		System.out.println("Размер целочисленного массива " + num.length );
		System.out.println(num[0]+","+num[1]+","+num[2]);
		System.out.println(str[0]+str[1]+str[2]);
	}
}
