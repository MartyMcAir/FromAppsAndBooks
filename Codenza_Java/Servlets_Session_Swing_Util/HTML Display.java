HTML Display

import java.awt.*;
import java.net.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;


public class HtmlDisplay extends JFrame implements HyperlinkListener
    {
     public static void main(String[] args)
         {
         
         HtmlDisplay obj=new HtmlDisplay();
         obj.setSize(400,500);
         obj.setVisible(true);
     }
     URL url;
     JEditorPane html;
     Document doc;
     public HtmlDisplay()
         {
             try{
            
             UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
             url=new URL("http://202.71.136.142:8080");
             html=new JEditorPane();
             System.out.println("Editor created");
             html.setEditable(false);
             html.setPage(url);
             html.addHyperlinkListener(this);
            // JScrollPane scroller = new JScrollPane();
            // JViewport vp = scroller.getViewport();
            // vp.add(html);
            // vp.setBackingStoreEnabled(true);
            
             System.out.println("html created");
            // getContentPane().add(scroller);
             getContentPane().add(html);
            
         }catch(Exception e){e.printStackTrace();}
        
     }
         public void hyperlinkUpdate(HyperlinkEvent e) {
             try{
            
             if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
                 {
                
                 doc = html.getDocument();
                 System.out.println(e.getURL());
                 html.setPage(e.getURL());
                 getToolkit().beep();
                 System.out.println("Listening");
             }
            
             }catch(Exception ex){
             // html.setDocument(doc);
             ex.printStackTrace();
         }
     }
  }
