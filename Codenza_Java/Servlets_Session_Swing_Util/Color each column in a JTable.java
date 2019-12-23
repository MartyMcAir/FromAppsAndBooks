Color each column in a JTable

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.*;

public class TableColumnColor extends JFrame
    {
     String[] columnNames = {"Column1", "Column2","Column3"};
         Object[][] data = {
         {"copy.gif", "Image1","dd" },
         {"save.gif", "Image2" ,"dd"},
         {"script.gif", "Image3","dd" },
         {"task.gif", "Image4" ,"dd"},
     };
    
     public TableColumnColor()
         {
         DefaultTableModel dtm = new DefaultTableModel(data,columnNames);
         JTable table=new JTable(dtm)
             {
             public Component prepareRenderer(TableCellRenderer renderer, int row, int column)
                 {
                 Component component = super.prepareRenderer(renderer,row,column);
                
                 if(column == 0)
                     {
                     component.setBackground(Color.yellow);
                 }
                 if(column == 1)
                     {
                     component.setBackground(Color.red);
                 }
                 if(column == 2)
                     {
                     component.setBackground(Color.pink);
                 }
                 return component;
             }
         };
        
         JScrollPane scroll=new JScrollPane(table);
         this.setContentPane(scroll);
         this.setBounds(100,50,300,150);
     }
     public static void main (String arg[])
         {
         TableColumnColor tes = new TableColumnColor();
         tes.setVisible(true);
         tes.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     }
}
