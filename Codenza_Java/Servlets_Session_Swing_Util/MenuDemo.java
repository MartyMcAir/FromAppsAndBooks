MenuDemo.java
 


// Title : MenuDemo.java - Simple demo of building menus.


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/// MenuDemo
public class MenuDemo {  
    
main
    public static void main(String[] args) {
        JFrame win = new MenuDemoGUI();
        win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        win.setVisible(true);
    }
}


///// MenuDemoGUI
class MenuDemoGUI extends JFrame {
    JTextArea m_editArea = new JTextArea(20, 50);;
    JMenu     m_fileMenu = new JMenu("File");// declare and create new menu
    JMenuItem m_openItem = new JMenuItem("Open"); // create new menu item
    JMenuItem m_quitItem = new JMenuItem("Quit"); // another menu item
    JMenu     m_editMenu = new JMenu("Edit");
    JMenuItem m_copyItem = new JMenuItem("Copy");
    JMenuItem m_pasteItem= new JMenuItem("Paste");

    
constructor
    public MenuDemoGUI() {
        //... Add listeners to menu items
        m_openItem.addActionListener(new OpenAction());
        m_quitItem.addActionListener(new QuitAction());
        // Copy and Paste don't have listeners yet, so disable them for now.
        m_copyItem.setEnabled(false);
        m_pasteItem.setEnabled(false);
        
        //... Menubar, menus, menu items.  Use indentation to show structure.
        JMenuBar menubar = new JMenuBar();  // declare and create new menu bar
            menubar.add(m_fileMenu);        // add the menu to the menubar
                m_fileMenu.add(m_openItem); // add the menu item to the menu
                m_fileMenu.addSeparator();  // add separator line to menu
                m_fileMenu.add(m_quitItem);
            menubar.add(m_editMenu);
                m_editMenu.add(m_copyItem);
                m_editMenu.add(m_pasteItem);
        
        //... Content pane: create, layout, add components
        JPanel content = new JPanel();
        content.setLayout(new BorderLayout());
        content.add(m_editArea, BorderLayout.CENTER);

        //... Set JFrame's menubar, content pane, and title.
        this.setContentPane(content);       // Set windows content pane..
        this.setJMenuBar(menubar);          // Set windows menubar.
        this.pack();
        this.setTitle("MenuDemo");
    }//endconstructor
    
//// OpenAction
    class OpenAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Sorry, can't open anything");
        }
    }
    
/// QuitAction
    class QuitAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);  // terminate this program
        }
    }
}
