import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileView;

public class myJFrame extends javax.swing.JFrame {

    public myJFrame() {
        initComponents();
        setLocationRelativeTo(null);
        // Добавляем фильтры по расширению в список выбора
        fileChooser.addChoosableFileFilter(new MyFilter(".txt", "Текстовые файлы (*.txt)"));
        fileChooser.addChoosableFileFilter(new MyFilter(".log", "Файлы лога приложения (*.log)"));
        // Заменяем иконку файлов с расширением .log
        fileChooser.setFileView(new MyFileView(".log", "Log.png"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fileChooser = new javax.swing.JFileChooser();
        pane = new javax.swing.JScrollPane();
        textView = new javax.swing.JTextArea();
        menu = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        Open = new javax.swing.JMenuItem();
        Save = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        Close = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textView.setColumns(20);
        textView.setRows(5);
        pane.setViewportView(textView);

        jMenu1.setText("File");

        Open.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Open.png"))); // NOI18N
        Open.setText("Open");
        Open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OpenActionPerformed(evt);
            }
        });
        jMenu1.add(Open);

        Save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Save.png"))); // NOI18N
        Save.setText("Save");
        Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveActionPerformed(evt);
            }
        });
        jMenu1.add(Save);
        jMenu1.add(jSeparator1);

        Close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Close.png"))); // NOI18N
        Close.setText("Close");
        Close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CloseActionPerformed(evt);
            }
        });
        jMenu1.add(Close);

        menu.add(jMenu1);

        jMenu2.setText("Edit");
        menu.add(jMenu2);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pane, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pane, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OpenActionPerformed
        // Создаем диалог открытия файла
        int ret = fileChooser.showOpenDialog(this);
        // Продолжаем после закрытия окна
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
            // Читаем содержимое файла в текстовую область
            textView.read(new FileReader(file.getAbsolutePath()), null);
            // Выводим имя файла в заголовок главного окна
            this.setTitle(file.getName());
            } catch (IOException ex) {
                System.out.println("Проблема доступа к файлу: "+file.getAbsolutePath());
                }
        } else {
            System.out.println("Операция отменена.");
        }
    }//GEN-LAST:event_OpenActionPerformed

    private void SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveActionPerformed
        // Создаем диалог сохранения файла
        int ret = fileChooser.showSaveDialog(this);
        // Продолжаем после закрытия окна
        if (ret == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                // Сохраняем содержимое текстовой области в файл
                textView.write(new FileWriter(file.getAbsolutePath()));
                // Выводим имя файла в заголовок главного окна
                this.setTitle(file.getName());
            } catch (IOException ex) {
                System.out.println("Проблема доступа к файлу: "+file.getAbsolutePath());
            }
        } else {
            System.out.println("Операция отменена.");
        }
    }//GEN-LAST:event_SaveActionPerformed

    private void CloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CloseActionPerformed
        System.exit(0);
    }//GEN-LAST:event_CloseActionPerformed

    // класс пользовательского фильтра по расширению
    class MyFilter extends FileFilter {
        String filetype; // расширение имени файла
        String description; // строка описания типа файла
        
        MyFilter(String f, String d) {
            this.filetype = f;
            this.description = d;
        }
        
        @Override
        public boolean accept(File file) {
            // Допускает отображение только каталогов или файлов с расширением filetype
            return file.isDirectory() || file.getAbsolutePath().endsWith(filetype);
        }
        
        @Override
        public String getDescription() {
            return description;
        }
    }    
    
    // Расширяем класс FileView
    class MyFileView extends FileView{
        String ext;
        String pict;
        Icon icon;
        
        MyFileView (String e, String p) {
            this.ext = e; // расширение имени файла
            this.pict = "src/images/"+p; // путь к файлу иконки
            this.icon = new ImageIcon(pict);
        }
        
        @Override
        public Icon getIcon(File f){
            if (f.getAbsolutePath().endsWith(ext)) return icon;
            else return null;
        }
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(myJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(myJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(myJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(myJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new myJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Close;
    private javax.swing.JMenuItem Open;
    private javax.swing.JMenuItem Save;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuBar menu;
    private javax.swing.JScrollPane pane;
    private javax.swing.JTextArea textView;
    // End of variables declaration//GEN-END:variables
}
