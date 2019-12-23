Color selected cells in a JTable

public class TableColorSelection extends JFrame {
     String[] columns = { "mon","tue","wed" };
     public static Color givenColor = new Color(255,128,54);
     static JTable table;
    
         public TableColorSelection() {
             DefaultTableModel model = new DefaultTableModel(columns,0) {
                 public boolean isCellEditable(int row,int col) {
                 return false;
             }
         };
         model.addRow(new Object[]{ "1","2","3" });
         model.addRow(new Object[]{ "4","5","6" });
         model.addRow(new Object[]{ "7","8","9" });
        
         Object[] defaultOffDays = { "3","6","9" };
        
         table = new MT(model,defaultOffDays);
         table.setCellSelectionEnabled(true);
         table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
         JScrollPane scroller = new JScrollPane(table);
        
         scroller.setBounds(10,10,300,200);
        
         JPanel panel = new JPanel();
        
         panel.setLayout(null);
         panel.add(scroller);
        
         getContentPane().add(panel);
         setSize(400,400);
         setVisible(true);
     }
         public static void main(String[] arg) {
         TableColorSelection tt = new TableColorSelection();
     }
}

    class MT extends JTable {
         public MT(TableModel dm,Object[] defaultOffDays) {
         super(dm);
         setDefaultRenderer(Object.class,new MyCellRenderer(defaultOffDays));
     }
         public void changeSelection(int r,int c,boolean toggle,boolean extend) {
         super.changeSelection(r,c,toggle,extend);
        
         MyCellRenderer renderer = (MyCellRenderer) getDefaultRenderer(Object.class);
        
         Object val = getValueAt(r,c);
        
             if (renderer.isRed(val)) {
             renderer.makeBlue(val);
         }
             else {
             renderer.clearValue();
         }
     }
    
         class MyCellRenderer extends DefaultTableCellRenderer {
         java.util.ArrayList selectedValues = new java.util.ArrayList();
         Object v = null;
        
             public MyCellRenderer(Object[] defaultOffDays) {
                 for (int i = 0; i < defaultOffDays.length; i++) {
                 selectedValues.add(defaultOffDays);
             }
         }
         public Component getTableCellRendererComponent(JTable table,Object value,
             boolean isSelected,boolean hasFocus,int row,int column) {
             JLabel label = (JLabel) super.getTableCellRendererComponent(table,value,isSelected,
             hasFocus,row,column);
            
             setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
             setText(value.toString());
            
                 if (isSelected && (v != value)) {
                 setForeground(Color.RED);
                
                     if (!selectedValues.contains(value)) {
                     //value already remembered, and reselected, make FG blue
                     selectedValues.add(value);
                 }
             }
                 else {
                 //not selected
                 setForeground(selectedValues.contains(value) ? Color.RED : Color.BLUE);
             }
             return label;
         }
             public boolean isRed(Object value) {
             // System.out.println("isRed: " + selectedValues.contains(value));
             return selectedValues.contains(value);
         }
             public void makeBlue(Object value) {
             v = value;
             selectedValues.remove(value);
         }
             public void clearValue() {
             v = null;
         }
     }
}
