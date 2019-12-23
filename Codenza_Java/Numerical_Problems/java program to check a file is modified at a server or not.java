    import java.net.URL;
    import java.net.URLConnection;
    public class Main {
    	public static void main(String[] argv) 
    	   throws Exception {
    		URL u = new URL("http://127.0.0.1/java.bmp");
    		URLConnection uc = u.openConnection();
    		uc.setUseCaches(false);
    		long timestamp = uc.getLastModified();
    		System.out.println("The last modification time of java.bmp is :"+timestamp);
    	}
    }
