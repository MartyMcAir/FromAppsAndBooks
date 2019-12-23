Testing a code

import javax.swing.*;
public class abc extends JFrame implements ActionListener
    {
    JPanel p;
    JButton b;
    JTextField t;
    JLabel l,i;
    
    public abc()
        {
        p=new JPanel();
        b=new JButton("click");
        t=new JTextField(15);
        l=new JLabel("enter ur id");
        
        
        p.add(l);
        p.add(t);
        p.add(b);
        getContentPane().add(p);
        setSize(400,400);
        setVisible(true);
        b.addActionListener(this);
    }
    
    public static void main(String []aa)
        {
        abc a= new abc();
    }
    
    public void actionPerformed(ActionEvent e)
        {
        Object o= e.getSource();
        if(o==b)
            {
            i=new JLabel("U Have Entered Wrong Value");
        }
    }
}
