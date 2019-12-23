Count total number of live sessions in a web application

--- JSP page for testing (test.jsp) -- 

<%
Integer icount = (Integer)session.getAttribute("count");
out.println("total live sessions "+icount);
%>


--- Servlet that handles session count --

import javax.servlet.*;
import javax.servlet.http.*;

public final class CounterListener implements HttpSessionListener
    {
     private int count = 1;
     private ServletContext context = null;
    
     public synchronized void sessionCreated(HttpSessionEvent se)
         {
         count++;
         log("sessionCreated("+se.getSession().getId()+") count="+count);
         se.getSession().setAttribute("count",new Integer(count));
     }
    
     public synchronized void sessionDestroyed(HttpSessionEvent se)
         {
         count--;
         log("sessionDestroyed("+se.getSession().getId()+") count="+count);
         se.getSession().setAttribute("count",new Integer(count));
     }
    
     public int getCount()
         {
         return this.count;
     }
    
     public void addCount()
         {
         count++;
     }
    
     private void log(String message)
         {
         if (context != null)
         context.log("SessionListener: " + message);
         else
         System.out.println("SessionListener: " + message);
     }
    
}//close class CounterListener


--- web.xml file modification --

<?xml version="1.0" encoding="ISO-8859-1"?>

<!DOCTYPE web-app
PUBLIC "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
"http://java.sun.com/dtd/web-app_2_3.dtd">

<web-app>
<display-name>Welcome to Tomcat</display-name>

<!-- add this line of code -->
<listener>
<listener-class>CounterListener</listener-class>
</listener>

<description>
Welcome to Tomcat
</description>

</web-app>
