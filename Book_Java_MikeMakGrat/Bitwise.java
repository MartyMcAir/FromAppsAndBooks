class Bitwise 
{
	public static void main( String[] args ) 
	{
        	int fs = 53;	// �������� ������������� 00110101
   
        	System.out.println("���� 1: " + (((fs & 1) > 0) ? "���" : "����")  );
        	System.out.println("���� 2: " + (((fs & 2) > 0) ? "���" : "����")  );
        	System.out.println("���� 3: " + (((fs & 4) > 0) ? "���" : "����")  );
        	System.out.println("���� 4: " + (((fs & 8) > 0) ? "���" : "����")  );
        	System.out.println("���� 5: " + (((fs & 16) > 0) ? "���" : "����")  );
        	System.out.println("���� 6: " + (((fs & 32) > 0) ? "���" : "����")  );
        	System.out.println("���� 7: " + (((fs & 64) > 0) ? "���" : "����")  );
        	System.out.println("���� 8: " + (((fs & 128) > 0) ? "���" : "����") );
	}
}

