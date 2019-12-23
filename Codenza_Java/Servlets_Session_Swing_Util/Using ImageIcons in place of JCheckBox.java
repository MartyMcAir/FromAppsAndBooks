Using ImageIcons in place of JCheckBox

public class test extends JFrame implements ActionListener
    {
     JCheckBox check;
     public test()
         {
         check = new JCheckBox("Test");
         check.setIcon(new ImageIcon("one.gif")); //unselected
         check.setSelectedIcon(new ImageIcon("two.gif")); //selected
         check.addActionListener(new ActionListener()
             {
             public void actionPerformed(ActionEvent ae)
                 {
                 System.out.println("check box state"+check.getState());
             }
         });
        
         getContentPane().add(check);
     }
     public static void main(String args[])
         {
         test tes = new test();
         tes.setSize(200,200);
         tes.setVisible(true);
         tes.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
     }
}
