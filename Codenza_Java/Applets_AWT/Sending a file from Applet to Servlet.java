Sending a file from Applet to Servlet

import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.io.*;
import javax.swing.*;


public class TestApplet extends JApplet implements ActionListener
    {
    
     JButton jbutton = null;
     public void init()
         {
         jbutton = new JButton("Send file");
         jbutton.addActionListener(this);
         this.getContentPane().add(jbutton);
     }
    
     public void actionPerformed(ActionEvent ae)
         {
         if(ae.getSource() == jbutton)
             {
             try
                 {
                 File file = new File("C:\uma.txt");
                
                 FileInputStream in = new FileInputStream(file);
                 byte[] buf=new byte[in.available()];
                 int bytesread = 0;
                
                
                 String toservlet = "http://localhost:8080/servlet/MyServlet";
                
                 URL servleturl = new URL(toservlet);
                 URLConnection servletconnection = servleturl.openConnection();
                 servletconnection.setDoInput(true);
                 servletconnection.setDoOutput(true);
                 servletconnection.setUseCaches(false);
                 servletconnection.setDefaultUseCaches(false);
                
                 DataOutputStream out=new DataOutputStream(servletconnection.getOutputStream());
                
                 while( (bytesread = in.read( buf )) > -1 )
                     {
                     out.write( buf, 0, bytesread );
                 }
                
                 out.flush();
                 out.close();
                 in.close();
                
                 DataInputStream inputFromClient = new DataInputStream(servletconnection.getInputStream());
                 //get what you want from servlet
                 //.......
                 inputFromClient.close();
             }
             catch(Exception e)
                 {
                 e.printStackTrace();
             }
            
            
         }
     }
    
}


import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class MyServlet extends HttpServlet
    {
     public void doPost(HttpServletRequest req,HttpServletResponse res)
         {
        
         ServletContext sc = this.getServletContext();
         try
             {
             String fileName = "uma.txt";
             String path = sc.getRealPath(File.separator)+fileName;
            
             File yourFile = new File(path);
             FileOutputStream toFile = new FileOutputStream( yourFile );
             DataInputStream fromClient = new DataInputStream( req.getInputStream() );
            
             byte[] buff = new byte[1024];
             int cnt = 0;
                 while( (cnt = fromClient.read( buff )) > -1 ) {
                 toFile.write( buff, 0, cnt );
             }
             toFile.flush();
             toFile.close();
             fromClient.close();
            
         }
         catch(Exception e)
             {
             e.printStackTrace();
         }
     }
}
