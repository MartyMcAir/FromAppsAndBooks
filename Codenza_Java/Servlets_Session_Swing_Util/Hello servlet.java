Hello servlet

//J2SE Libraries;
import java.io.IOException;
import java.io.PrintWriter;

//J2EE Libraries;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
*
*A very basic servlet which prints Hello world!
*For addtional documentation refer-> http://java.sun.com/servlets
*For addtional documentation refer-> http://java.sun.com/jsp
*/
    public final class HelloServlet extends HttpServlet {
         public void init(ServletConfig config) throws ServletException {
         super.init(config);
     };
    
         protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         doPost(request, response);
     };
    
         protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         PrintWriter out= response.getWriter();
         out.println("<HTML><BODY>");
         out.println("Hello world!");
         out.println("</BODY></HTML>");
     }
    
     //optional method;
         public void destroy() {
         System.gc();
     }
}
