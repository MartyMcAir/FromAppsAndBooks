Information Servlet

// Import standard networking I/O packages
import java.net.*;
import java.io.*;

// Enumeration from util
import java.util.Enumeration;

// Import servlet packages
import javax.servlet.*;
import javax.servlet.http.*;

//
//
// InfoServlet
//
//
public class InfoServlet extends HttpServlet
{

	// Get method of servlet
	public void doGet (HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		// Define content type
		response.setContentType("text/html");

		// Get information about client and server
		String clientBrowser = request.getHeader("User-Agent");
		String clientReferer = request.getHeader("Referer");
		String clientIP = request.getRemoteAddr();
		String serverOS = System.getProperty("os.name");
		String serverOSVersion = System.getProperty("os.version");
		String serverOSArch = System.getProperty("os.arch");
		
		// Get a servlet output stream for the response
		ServletOutputStream sout = response.getOutputStream();

		// Print header information
		sout.println ("<HTML><HEAD><TITLE>InfoServlet Response</TITLE></HEAD>");

		// Print body information
		sout.println ("<BODY BGCOLOR='white' COLOR='black'>");
		sout.println ("<H2>InfoServlet</H2><HR>");

		// Print information about client
		sout.println ("<H3>Client :-</H3>");

		// Check for presence of user-agent header field
		if (clientBrowser != null)
			sout.println ("User-Agent : " + clientBrowser + "<BR>");

		// Print IP address
		sout.println ("IP Address : " + clientIP + "<BR>");

		// Check for presence of referer header field
		if (clientReferer != null)
			sout.println ("Last page : " + clientReferer + "<BR>");

		// Print information about server
		sout.println ("<H3>Server</H3>");

		// Check to see if each property is valid, and if so, output it
		if ( (serverOS != null) & (serverOSVersion != null) )
			sout.println ("Server O/S : " + serverOS + " v" + serverOSVersion + "<BR>");
		
		if ( serverOSArch != null)
			sout.println ("Server CPU : " + serverOSArch + "<BR>");

		// Obtain a reference to the server context
		ServletContext context = getServletContext();

		if (context != null)
		{
			// Display information about servlets
			sout.println ("<h3> Servlet information </h3>");

			// Table for servlet info
			sout.println ("<table border='1' width=70%>");
			sout.println ("<tr><td><b>Servlet Name</b></td></tr>");
			for (Enumeration e = context.getServletNames(); e.hasMoreElements();)
			{
				// Get name of servlet
				String name = (String) e.nextElement();

				sout.println ("<tr> <td>");
				sout.println (name);
				sout.println ("</td> </tr>");
			}

			sout.println ("</table>");
		}
		else
			sout.println ("Could not determine servlet context");
		// Write footer information
		sout.println ("</BODY></HTML>");

		// Flush
		sout.flush();
	}

	// Post method of servlet
	public void doPost (HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		// Perform same action as get method
		doGet(request, response);
	}

	public String getServletInfo()
	{
		return new String (
			"InfoServlet - reports information on client connection and server state"
		);
	}
}
