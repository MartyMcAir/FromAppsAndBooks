class Lottery
{
	public static void main( String[] args )
	{
		int[] nums = new int[50];
			

		// Заполните элементы с 1 по 49 целыми числами от 1 до 49.
		for( int i = 1; i < 50; i++ ) { nums[i] = i; }
		
		// Перемешайте значения в элементах от 1 до 49.
		for( int i = 1; i < 50; i++ )
		{
			int r = (int) Math.ceil( Math.random() * 49 ) ;
			int temp=nums[i]; nums[i]=nums[r]; nums[r]=temp;
		}

		// Выведите значения, которые содержатся в элементах от 1 до 6.
		for ( int i = 1; i < 7; i++ )
		{
			System.out.print(Integer.toString(nums[ i ]) + "  ");
		}
	}
}
