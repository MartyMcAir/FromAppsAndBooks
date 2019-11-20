// импортируем необходимые классы
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.ImageIcon;

public class myJFrame extends javax.swing.JFrame {
    // определяем поля класса
    private final ImageIcon icon; 
    private final SimpleAttributeSet mySet;

    public myJFrame() {
        // присваиваем ссылку на объект атрибутов текста
        this.mySet = new SimpleAttributeSet();
        // присваиваем ссылку на ресурс изображения
        this.icon = new ImageIcon(myJFrame.class.getResource("images/star.png"));
        // инициализируем оконную форму
        initComponents();
        // размещаем окно по центру экрана
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        myPane = new javax.swing.JTextPane();
        boldButton = new javax.swing.JButton();
        italicButton = new javax.swing.JButton();
        underlineButton = new javax.swing.JButton();
        plainButton = new javax.swing.JButton();
        iconButton = new javax.swing.JButton();
        separatorButton = new javax.swing.JButton();
        checkboxButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(myPane);

        boldButton.setText("Bold");
        boldButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boldButtonActionPerformed(evt);
            }
        });

        italicButton.setFont(new java.awt.Font("Dialog", 2, 12)); // NOI18N
        italicButton.setText("Italic");
        italicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                italicButtonActionPerformed(evt);
            }
        });

        underlineButton.setText("Underline");
        underlineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                underlineButtonActionPerformed(evt);
            }
        });

        plainButton.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        plainButton.setText("Plain");
        plainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plainButtonActionPerformed(evt);
            }
        });

        iconButton.setText("Icon");
        iconButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconButtonActionPerformed(evt);
            }
        });

        separatorButton.setText("Separator");
        separatorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                separatorButtonActionPerformed(evt);
            }
        });

        checkboxButton.setText("Checkbox");
        checkboxButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkboxButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(separatorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(checkboxButton, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(iconButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(boldButton)
                            .addGap(9, 9, 9)
                            .addComponent(italicButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(underlineButton)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(plainButton))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {boldButton, italicButton, plainButton, underlineButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boldButton)
                    .addComponent(italicButton)
                    .addComponent(underlineButton)
                    .addComponent(plainButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(separatorButton)
                    .addComponent(checkboxButton)
                    .addComponent(iconButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void boldButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boldButtonActionPerformed
        StyleConstants.setBold(mySet, true);
        myPane.setCharacterAttributes(mySet, true);
        myPane.requestFocus();
    }//GEN-LAST:event_boldButtonActionPerformed

    private void italicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_italicButtonActionPerformed
        StyleConstants.setItalic(mySet, true);
        myPane.setCharacterAttributes(mySet, true);
        myPane.requestFocus();
    }//GEN-LAST:event_italicButtonActionPerformed

    private void underlineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_underlineButtonActionPerformed
        StyleConstants.setUnderline(mySet, true);
        myPane.setCharacterAttributes(mySet, true);
        myPane.requestFocus();
    }//GEN-LAST:event_underlineButtonActionPerformed

    private void plainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plainButtonActionPerformed
        StyleConstants.setBold(mySet, false);
        StyleConstants.setItalic(mySet, false);
        StyleConstants.setUnderline(mySet, false);
        myPane.setCharacterAttributes(mySet, true);
        myPane.requestFocus();
    }//GEN-LAST:event_plainButtonActionPerformed

    private void iconButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconButtonActionPerformed
        myPane.insertIcon(icon);
        myPane.requestFocus();
    }//GEN-LAST:event_iconButtonActionPerformed

    private void separatorButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_separatorButtonActionPerformed
        myPane.insertComponent(new javax.swing.JSeparator());
        myPane.requestFocus();
    }//GEN-LAST:event_separatorButtonActionPerformed

    private void checkboxButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkboxButtonActionPerformed
        myPane.insertComponent(new javax.swing.JCheckBox());
        myPane.requestFocus();
    }//GEN-LAST:event_checkboxButtonActionPerformed

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
    private javax.swing.JButton boldButton;
    private javax.swing.JButton checkboxButton;
    private javax.swing.JButton iconButton;
    private javax.swing.JButton italicButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane myPane;
    private javax.swing.JButton plainButton;
    private javax.swing.JButton separatorButton;
    private javax.swing.JButton underlineButton;
    // End of variables declaration//GEN-END:variables
}
