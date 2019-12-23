Using JInternalFrame

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

    public class IframeApp extends JFrame implements ActionListener,InternalFrameListener {
    
    JMenuBar bar = new JMenuBar();
    JMenu fileMenu = new JMenu("File");
    JMenuItem newItem = new JMenuItem("New");
    
    JDesktopPane desktop = new JDesktopPane();
    int iFrameCount = 0;
    
         public IframeApp() {
         super("IframeApp");
        
         fileMenu.add(newItem);
         newItem.addActionListener(this);
         bar.add(fileMenu);
         setJMenuBar(bar);
        
         getContentPane().add(desktop);
        
             this.addWindowListener (new WindowAdapter(){
                 public void windowClosing(WindowEvent e){
                 dispose();
                 System.exit(0);
             }
         });
     }
    
         public void actionPerformed(ActionEvent e) {
         Object source = e.getSource();
             if(source == newItem) {
             ++iFrameCount;
             IFrame iFrame = new IFrame("Untitled "+iFrameCount);
             iFrame.addInternalFrameListener(this);
             desktop.add(iFrame);
         }
     }
    
         public void internalFrameOpened(InternalFrameEvent e) {
     }
         public void internalFrameClosing(InternalFrameEvent e) {
     }
         public void internalFrameClosed(InternalFrameEvent e) {
     }
         public void internalFrameIconified(InternalFrameEvent e) {
     }
         public void internalFrameDeiconified(InternalFrameEvent e) {
     }
         public void internalFrameActivated(InternalFrameEvent e) {
         JInternalFrame sourceFrame =(JInternalFrame)e.getSource();
         setTitle("IframeApp ["+sourceFrame.getTitle()+"]");
     }
    
         public void internalFrameDeactivated(InternalFrameEvent e) {
     }
    
    
         public static void main(String args[]) {
         System.out.println("Starting App");
         IframeApp f = new IframeApp();
         f.setSize(400,400);
         f.show();
     }
}
