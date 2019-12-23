    import java.net.InetAddress;
    public class Main {
    	public static void main(String[] argv) throws Exception {
    		InetAddress addr = InetAddress.getByName("23.229.203.68");
    		System.out.println("Host name is: "+addr.getHostName());
    		System.out.println("Ip address is: "+ addr.getHostAddress());
    	}
    }
