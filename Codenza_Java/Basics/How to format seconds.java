    import java.text.SimpleDateFormat;
    import java.util.Date;
    public class Main {
    	public static void main(String[] args) {
    		Date date = new Date();
    		SimpleDateFormat sdf = new SimpleDateFormat("ss");
    		System.out.println("seconds in ss format : "+ sdf.format(date));
    	}
    }
