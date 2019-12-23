    import java.util.*;
    public class Main {
    	public static void main(String[] args) throws Exception {
    		Date d1 = new Date();
    		Calendar cl = Calendar. getInstance();
    		cl.setTime(d1);
    		System.out.println("today is "+ d1.toString());
    		cl. roll(Calendar.MONTH, 100);
    		System.out.println("date after a month will be " + cl.getTime().toString() );
    		cl. roll(Calendar.HOUR, 70);
    		System.out.println("date after 7 hrs will be "+ cl.getTime().toString() );
    	}
    }
