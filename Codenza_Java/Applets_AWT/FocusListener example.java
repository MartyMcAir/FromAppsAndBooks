FocusListener example

import java.awt.*;
import java.awt.event.*;

public class FocusListenertest extends Frame implements FocusListener
    {
     Button b1,b2;
    
     public FocusListenertest()
         {
         add(b1=new Button ("First"),"South");
         add(b2=new Button ("Second"),"North");
         b1.addFocusListener(this);
         b2.addFocusListener(this);
         setSize(200,200);
         //pack(); //Takes minimum size for the window
     }
     public void focusGained(FocusEvent fe) //method of focuslistener
         {
         if(fe.getSource()==b1)
         System.out.println(b1.getLabel()+"gained");
         if(fe.getSource()==b2)
         System.out.println(b2.getLabel()+"gained");
         if(fe.isTemporary())
         System.out.println("Temporary Focus");
     }
     public void focusLost(FocusEvent fe) //in focusevent "getID()"is a method
         {
         if(fe.getSource()==b1)
         System.out.println(b1.getLabel()+"lost");
         if(fe.getSource()==b2)
         System.out.println(b2.getLabel()+"lost");
     }
     public static void main(String a[])
         {
         new FocusListenertest().setVisible(true);
     }
}
