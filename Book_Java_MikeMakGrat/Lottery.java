class Lottery
{
	public static void main( String[] args )
	{
		int[] nums = new int[50];
			

		// ��������� �������� � 1 �� 49 ������ ������� �� 1 �� 49.
		for( int i = 1; i < 50; i++ ) { nums[i] = i; }
		
		// ����������� �������� � ��������� �� 1 �� 49.
		for( int i = 1; i < 50; i++ )
		{
			int r = (int) Math.ceil( Math.random() * 49 ) ;
			int temp=nums[i]; nums[i]=nums[r]; nums[r]=temp;
		}

		// �������� ��������, ������� ���������� � ��������� �� 1 �� 6.
		for ( int i = 1; i < 7; i++ )
		{
			System.out.print(Integer.toString(nums[ i ]) + "  ");
		}
	}
}
