import java.text.NumberFormat ;
import java.time.format.DateTimeFormatter ;


public class Formats
{
	public static void main(String[] args) 
	{		
		NumberFormat nf = NumberFormat.getNumberInstance();
		System.out.println( "\nЧисло : " + nf.format(123456789) );
		
		NumberFormat cf = NumberFormat.getCurrencyInstance();
		System.out.println( "\nВалюта : " + cf.format(1234.50f) );

		NumberFormat pf = NumberFormat.getPercentInstance();
		System.out.println( "\nПроцент : " +  pf.format(0.75f) );

		java.time.LocalDateTime now = java.time.LocalDateTime.now();

		DateTimeFormatter df = DateTimeFormatter.ofPattern("MMM d, yyy") ;
		System.out.println( "\nДата : " + now.format( df ) );

		DateTimeFormatter tf = DateTimeFormatter.ofPattern("h:m a") ;
		System.out.println( "\nВремя : " + now.format( tf ) );
	}
}