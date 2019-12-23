    import java.io.IOException;
    import java.net.InetAddress;
    import java.net.Socket;
    import java.net.SocketException;
    import java.net.UnknownHostException;
    public class Main {
    	public static void main(String[] args) {
    		try {
    			InetAddress addr = 
    			         InetAddress.getByName("74.125.67.100");
    			Socket theSocket = new Socket(addr, 80);
    			System.out.println("Connected to " 
    			         + theSocket.getInetAddress()
    			         + " on port " + theSocket.getPort() + " from port "
    			         + theSocket.getLocalPort() + " of " 
    			         + theSocket.getLocalAddress());
    		}
    		catch (UnknownHostException e) {
    			System.err.println("I can't find " + e  );
    		}
    		catch (SocketException e) {
    			System.err.println("Could not connect to " +e );
    		}
    		catch (IOException e) {
    			System.err.println(e);
    		}
    	}
    }
