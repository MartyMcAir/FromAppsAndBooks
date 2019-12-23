Horoscope 

import javax.swing.*;
import java.awt.event.*; 
import java.awt.*;

public class Factorial extends JFrame
     {
     private JTextField txtNum;
     private JLabel lblNum, lblRes;
     private JButton btnCompute;
    
     public static int ComputeFactorial(int number)
         {
         int n = number-1;
         do
             {
             number = number*n;
             n--;
         }while(n>=1);
         return number;
     } 
    
     public Factorial()
         {
         super("GUI Factorial"); 
         Container c = getContentPane(); 
         c.setLayout(new FlowLayout()); 
         lblNum = new JLabel("Enter an integer: ");
         txtNum = new JTextField(10);
         lblRes = new JLabel();
         btnCompute = new JButton("Compute");
        
         btnCompute.addActionListener
         ( 
         new ActionListener()
             {
             public void actionPerformed(ActionEvent e)
                 {
                 String str = txtNum.getText();
                 int tmp = Integer.parseInt(str);
                 tmp = ComputeFactorial(tmp);
                 lblRes.setText("The factorial of "+str+" is "+tmp);
             }
         }
         );
         
         c.add(lblNum);
         c.add(txtNum);
         c.add(btnCompute); 
         c.add(lblRes);
         setSize(200,150);
         show();
     }
    
     public static void main(String args[])
         {
         Factorial app = new Factorial();
         app.setResizable(false);
         app.setLocation(400,200);
         app.addWindowListener
         (
         new WindowAdapter()
             {
             public void windowClosing(WindowEvent e)
                 {
                 System.exit(0);
             }
         }
         );
     }
    
}
