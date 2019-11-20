// импортируем необходимые классы
import java.awt.Color;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class myJFrame extends javax.swing.JFrame {
    // определяем переменную набора аттрибутов текста
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

        popupMenu = new javax.swing.JPopupMenu();
        textStyle = new javax.swing.JMenu();
        Bold = new javax.swing.JMenuItem();
        Italic = new javax.swing.JMenuItem();
        Plain = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        textColour = new javax.swing.JMenu();
        Red = new javax.swing.JMenuItem();
        Green = new javax.swing.JMenuItem();
        Blue = new javax.swing.JMenuItem();
        Black = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        paperColour = new javax.swing.JMenu();
        Red1 = new javax.swing.JMenuItem();
        Green1 = new javax.swing.JMenuItem();
        Blue1 = new javax.swing.JMenuItem();
        White = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        textPane = new javax.swing.JTextPane();

        textStyle.setText("Text Style");
        textStyle.setToolTipText("Стиль текста");

        Bold.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Bold.setText("Bold");
        Bold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BoldActionPerformed(evt);
            }
        });
        textStyle.add(Bold);

        Italic.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        Italic.setText("Italic");
        Italic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItalicActionPerformed(evt);
            }
        });
        textStyle.add(Italic);

        Plain.setText("Plain");
        Plain.setAutoscrolls(true);
        Plain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlainActionPerformed(evt);
            }
        });
        textStyle.add(Plain);

        popupMenu.add(textStyle);
        popupMenu.add(jSeparator1);

        textColour.setText("Text Colour");
        textColour.setToolTipText("Цвет текста");

        Red.setBackground(java.awt.Color.white);
        Red.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        Red.setForeground(java.awt.Color.red);
        Red.setText("Red");
        Red.setOpaque(true);
        Red.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RedActionPerformed(evt);
            }
        });
        textColour.add(Red);

        Green.setBackground(java.awt.Color.white);
        Green.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        Green.setForeground(java.awt.Color.green);
        Green.setText("Green");
        Green.setOpaque(true);
        Green.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GreenActionPerformed(evt);
            }
        });
        textColour.add(Green);

        Blue.setBackground(java.awt.Color.white);
        Blue.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        Blue.setForeground(java.awt.Color.blue);
        Blue.setText("Blue");
        Blue.setOpaque(true);
        Blue.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BlueActionPerformed(evt);
            }
        });
        textColour.add(Blue);

        Black.setBackground(java.awt.Color.white);
        Black.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        Black.setForeground(java.awt.Color.black);
        Black.setText("Black");
        Black.setOpaque(true);
        Black.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BlackActionPerformed(evt);
            }
        });
        textColour.add(Black);

        popupMenu.add(textColour);
        popupMenu.add(jSeparator2);

        paperColour.setText("Paper Colour");
        paperColour.setToolTipText("Цвет фона текста");

        Red1.setBackground(java.awt.Color.red);
        Red1.setForeground(java.awt.Color.white);
        Red1.setText("Red");
        Red1.setOpaque(true);
        Red1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Red1ActionPerformed(evt);
            }
        });
        paperColour.add(Red1);

        Green1.setBackground(java.awt.Color.green);
        Green1.setText("Green");
        Green1.setOpaque(true);
        Green1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Green1ActionPerformed(evt);
            }
        });
        paperColour.add(Green1);

        Blue1.setBackground(java.awt.Color.blue);
        Blue1.setForeground(java.awt.Color.white);
        Blue1.setText("Blue");
        Blue1.setOpaque(true);
        Blue1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Blue1ActionPerformed(evt);
            }
        });
        paperColour.add(Blue1);

        White.setBackground(java.awt.Color.white);
        White.setText("White");
        White.setOpaque(true);
        White.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WhiteActionPerformed(evt);
            }
        });
        paperColour.add(White);

        popupMenu.add(paperColour);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textPane.setComponentPopupMenu(popupMenu);
        jScrollPane1.setViewportView(textPane);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ItalicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItalicActionPerformed
        StyleConstants.setItalic(mySet, true);
        textPane.setCharacterAttributes(mySet, true);
    }//GEN-LAST:event_ItalicActionPerformed

    private void PlainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlainActionPerformed
        StyleConstants.setBold(mySet, false);
        StyleConstants.setItalic(mySet, false);
        textPane.setCharacterAttributes(mySet, true);
    }//GEN-LAST:event_PlainActionPerformed

    private void RedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RedActionPerformed
        textPane.setSelectedTextColor(Color.RED);
        StyleConstants.setForeground(mySet, Color.RED);
        textPane.setCharacterAttributes(mySet, true);
    }//GEN-LAST:event_RedActionPerformed

    private void GreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GreenActionPerformed
        textPane.setSelectedTextColor(Color.GREEN);
        StyleConstants.setForeground(mySet, Color.GREEN);
        textPane.setCharacterAttributes(mySet, true);
    }//GEN-LAST:event_GreenActionPerformed

    private void BlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BlueActionPerformed
        textPane.setSelectedTextColor(Color.BLUE);
        StyleConstants.setForeground(mySet, Color.BLUE);
        textPane.setCharacterAttributes(mySet, true);
    }//GEN-LAST:event_BlueActionPerformed

    private void BlackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BlackActionPerformed
        textPane.setSelectedTextColor(Color.BLACK);
        StyleConstants.setForeground(mySet, Color.BLACK);
        textPane.setCharacterAttributes(mySet, true);
    }//GEN-LAST:event_BlackActionPerformed

    private void Red1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Red1ActionPerformed
        StyleConstants.setBackground(mySet, Color.RED);
        textPane.setCharacterAttributes(mySet, true);
    }//GEN-LAST:event_Red1ActionPerformed

    private void Green1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Green1ActionPerformed
        StyleConstants.setBackground(mySet, Color.GREEN);
        textPane.setCharacterAttributes(mySet, true);
    }//GEN-LAST:event_Green1ActionPerformed

    private void Blue1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Blue1ActionPerformed
        StyleConstants.setBackground(mySet, Color.BLUE);
        textPane.setCharacterAttributes(mySet, true);
    }//GEN-LAST:event_Blue1ActionPerformed

    private void WhiteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WhiteActionPerformed
        StyleConstants.setBackground(mySet, Color.WHITE);
        textPane.setCharacterAttributes(mySet, true);
    }//GEN-LAST:event_WhiteActionPerformed

    private void BoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BoldActionPerformed
        StyleConstants.setBold(mySet, true);
        textPane.setCharacterAttributes(mySet, true);
    }//GEN-LAST:event_BoldActionPerformed

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
    private javax.swing.JMenuItem Black;
    private javax.swing.JMenuItem Blue;
    private javax.swing.JMenuItem Blue1;
    private javax.swing.JMenuItem Bold;
    private javax.swing.JMenuItem Green;
    private javax.swing.JMenuItem Green1;
    private javax.swing.JMenuItem Italic;
    private javax.swing.JMenuItem Plain;
    private javax.swing.JMenuItem Red;
    private javax.swing.JMenuItem Red1;
    private javax.swing.JMenuItem White;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JMenu paperColour;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JMenu textColour;
    private javax.swing.JTextPane textPane;
    private javax.swing.JMenu textStyle;
    // End of variables declaration//GEN-END:variables
}
