// импортируем необходимые классы
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class myJFrame extends javax.swing.JFrame {
    // определяем переменную набора атрибутов текста
    private final SimpleAttributeSet mySet;

    public myJFrame() {
        // присваиваем ссылку на объект атрибутов текста
        mySet = new SimpleAttributeSet();
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPane = new javax.swing.JTextPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        familyMenu = new javax.swing.JMenu();
        defaultFamily = new javax.swing.JRadioButtonMenuItem();
        serifFamily = new javax.swing.JRadioButtonMenuItem();
        monoFamily = new javax.swing.JRadioButtonMenuItem();
        effectMenu = new javax.swing.JMenu();
        bold = new javax.swing.JCheckBoxMenuItem();
        italic = new javax.swing.JCheckBoxMenuItem();
        underline = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textPane.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jScrollPane1.setViewportView(textPane);

        familyMenu.setText("Family");

        buttonGroup.add(defaultFamily);
        defaultFamily.setSelected(true);
        defaultFamily.setText("Default");
        defaultFamily.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                defaultFamilyActionPerformed(evt);
            }
        });
        familyMenu.add(defaultFamily);

        buttonGroup.add(serifFamily);
        serifFamily.setText("Serif");
        serifFamily.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                serifFamilyActionPerformed(evt);
            }
        });
        familyMenu.add(serifFamily);

        buttonGroup.add(monoFamily);
        monoFamily.setText("Monospaced");
        monoFamily.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monoFamilyActionPerformed(evt);
            }
        });
        familyMenu.add(monoFamily);

        jMenuBar1.add(familyMenu);

        effectMenu.setText("Effect");

        bold.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        bold.setText("Bold");
        bold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boldActionPerformed(evt);
            }
        });
        effectMenu.add(bold);

        italic.setFont(new java.awt.Font("sansserif", 2, 12)); // NOI18N
        italic.setText("Italic");
        italic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                italicActionPerformed(evt);
            }
        });
        effectMenu.add(italic);

        underline.setText("Underline");
        underline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                underlineActionPerformed(evt);
            }
        });
        effectMenu.add(underline);

        jMenuBar1.add(effectMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boldActionPerformed
        StyleConstants.setBold(mySet, bold.isSelected());
        textPane.setCharacterAttributes(mySet, true);
    }//GEN-LAST:event_boldActionPerformed

    private void italicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_italicActionPerformed
        StyleConstants.setItalic(mySet, italic.isSelected());
        textPane.setCharacterAttributes(mySet, true);
    }//GEN-LAST:event_italicActionPerformed

    private void underlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_underlineActionPerformed
        StyleConstants.setUnderline(mySet, underline.isSelected());
        textPane.setCharacterAttributes(mySet, true);
    }//GEN-LAST:event_underlineActionPerformed

    private void defaultFamilyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_defaultFamilyActionPerformed
        StyleConstants.setFontFamily(mySet, "plain");
        textPane.setCharacterAttributes(mySet, true);
    }//GEN-LAST:event_defaultFamilyActionPerformed

    private void serifFamilyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_serifFamilyActionPerformed
        StyleConstants.setFontFamily(mySet, "serif");
        textPane.setCharacterAttributes(mySet, true);
    }//GEN-LAST:event_serifFamilyActionPerformed

    private void monoFamilyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monoFamilyActionPerformed
        StyleConstants.setFontFamily(mySet, "monospaced");
        textPane.setCharacterAttributes(mySet, true);
    }//GEN-LAST:event_monoFamilyActionPerformed

    /**
     * @param args the command line arguments
     */
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
    private javax.swing.JCheckBoxMenuItem bold;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JRadioButtonMenuItem defaultFamily;
    private javax.swing.JMenu effectMenu;
    private javax.swing.JMenu familyMenu;
    private javax.swing.JCheckBoxMenuItem italic;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButtonMenuItem monoFamily;
    private javax.swing.JRadioButtonMenuItem serifFamily;
    private javax.swing.JTextPane textPane;
    private javax.swing.JCheckBoxMenuItem underline;
    // End of variables declaration//GEN-END:variables
}
