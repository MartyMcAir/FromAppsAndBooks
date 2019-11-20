import java.io.*; 

class ReadString 
{ 
	public static void main (String[] args) 
	{ 
      		System.out.print( "Введите название данной книги: " );

      		InputStreamReader isr = new InputStreamReader( System.in );
      		BufferedReader buffer = new BufferedReader( isr ); 
      		String input = "";

      		try
		{ 
         		input = buffer.readLine();
			buffer.close() ; 
      		} 
		catch (IOException e ) 
		{ 
         		System.out.println(e);  
      		} 

      		System.out.println("\nСпасибо, вы читаете " + input ); 
	} 
} 


