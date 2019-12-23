Using JTree

import javax.swing.tree.*;
import javax.swing.*;
import java.awt.*;

public class TreeConstruct1 extends JFrame
    {
     public static void main(String[] args)
         {
         TreeConstruct obj=new TreeConstruct();
         obj.setSize(350,500);
         obj.setVisible(true);
     }
     public TreeConstruct1()
         {
         try
             {
             UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
         }
         catch(Exception exception)
             {
             exception.printStackTrace();
         }
         JPanel panel =new JPanel();
         panel.setLayout(new FlowLayout(FlowLayout.LEFT));
         DefaultMutableTreeNode top=new DefaultMutableTreeNode("Library");
        
         DefaultMutableTreeNode branch1=new DefaultMutableTreeNode("Comics");
         DefaultMutableTreeNode branch2=new DefaultMutableTreeNode("History");
         DefaultMutableTreeNode branch3=new DefaultMutableTreeNode("Scientific");
        
        //adding to the topmost node
         top.add(branch1);
         top.add(branch2);
         top.add(branch3);
        
        //adding to the First branch
         DefaultMutableTreeNode node1_b1=new DefaultMutableTreeNode("Tom and Jerry");
        
         DefaultMutableTreeNode node2_b1=new DefaultMutableTreeNode("Simpsons");
         branch1.add(node1_b1);
         branch1.add(node2_b1);
        
        //adding to the Second branch
         DefaultMutableTreeNode node1_b2=new DefaultMutableTreeNode("The Great History of Aruna Kumar Reddy");
         DefaultMutableTreeNode node2_b2=new DefaultMutableTreeNode("Chanakya");
         DefaultMutableTreeNode node3_b2=new DefaultMutableTreeNode("Changhiz Khan");
         branch2.add(node1_b2);
         branch2.add(node2_b2);
         branch2.add(node3_b2);
        
        //adding to the Third branch
         DefaultMutableTreeNode node1_b3=new DefaultMutableTreeNode("Physical");
         DefaultMutableTreeNode node2_b3=new DefaultMutableTreeNode("Biological");
        
         DefaultMutableTreeNode n1_node2_b3=new DefaultMutableTreeNode("Animal Science");
         DefaultMutableTreeNode n2_node2_b3=new DefaultMutableTreeNode("Plant Science");
         node2_b3.add(n1_node2_b3);
         node2_b3.add(n2_node2_b3);
        
         DefaultMutableTreeNode node3_b3=new DefaultMutableTreeNode("Chemical");
         branch3.add(node1_b3);
         branch3.add(node2_b3);
         branch3.add(node3_b3);
        
         ImageIcon icon=new ImageIcon("abook.gif");
         JTree tree=new JTree(top,true);
         tree.setToolTipText(" and ");
         panel.add(tree);
         getContentPane().add(panel);
     }
}
