    import java.util.*;
    public class Main {
    	public static void main(String[] args) throws Exception {
    		Date d1 = new Date();
    		Calendar cl = Calendar. getInstance();
    		cl.setTime(d1);
    		System.out.println("today is "+ cl.WEEK_OF_YEAR+ " week of the year");
    		System.out.println("today is a "+cl.DAY_OF_MONTH + "month of the year");
    		System.out.println("today is a "+cl.WEEK_OF_MONTH +"week of the month");
    	}
    }
