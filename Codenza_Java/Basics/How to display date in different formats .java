    import java.text.*;
    import java.util.*;
    public class Main {
    	public static void main(String[] args) {
    		Date dt = new Date(1000000000000L);
    		DateFormat[] dtformat = new DateFormat[6];
    		dtformat[0] = DateFormat.getInstance();
    		dtformat[1] = DateFormat.getDateInstance();
    		dtformat[2] = DateFormat.getDateInstance(DateFormat.MEDIUM);
    		dtformat[3] = DateFormat.getDateInstance(DateFormat.FULL);
    		dtformat[4] = DateFormat.getDateInstance(DateFormat.LONG);
    		dtformat[5] = DateFormat.getDateInstance(DateFormat.SHORT);
    		for (DateFormat dateform : dtformat)
    		         System.out.println(dateform.format(dt));
    	}
    }
