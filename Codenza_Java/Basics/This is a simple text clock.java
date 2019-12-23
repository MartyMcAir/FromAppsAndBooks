This is a simple text clock. See

javax.swing.Timer for an explanation of how use this simple timer class. 




import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Calendar;      // only need this one class

/// TextClock
public class TextClock {
    
main
    public static void main(String[] args) {
        JFrame clock = new TextClockWindow();
        clock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        clock.setVisible(true);
    }//end main
}//endclass TextClock


////// TextClockWindow
class TextClockWindow extends JFrame {
    
instance variables
    private JTextField timeField;  // set by timer listener

    
constructor
    public TextClockWindow() {
        // Build the GUI - only one panel
        timeField = new JTextField(6);
        timeField.setFont(new Font("sansserif", Font.PLAIN, 48));

        Container content = this.getContentPane();
        content.setLayout(new FlowLayout());
        content.add(timeField); 
        
        this.setTitle("Text Clock");
        this.pack();

        // Create a 1-second timer and action listener for it.
        // Specify package because there are two Timer classes
        javax.swing.Timer t = new javax.swing.Timer(1000,
              new ActionListener() {
                  public void actionPerformed(ActionEvent e) {
                      Calendar now = Calendar.getInstance();
                      int h = now.get(Calendar.HOUR_OF_DAY);
                      int m = now.get(Calendar.MINUTE);
                      int s = now.get(Calendar.SECOND);
                      timeField.setText("" + h + ":" + m + ":" + s);
                  }
              });
        t.start();  // Start the timer
    }//end constructor
}//endclass TextClock
