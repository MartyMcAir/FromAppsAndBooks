public class myJFrame extends javax.swing.JFrame {
    // создаем экземпляры объектов фреймов и присваиваем
    //ссылки на эти объекты полям класса
    TextAreaFrame areaFrame = new TextAreaFrame();
    TextPanelFrame panelFrame = new TextPanelFrame();
        
    public myJFrame() {     
        initComponents();
        setLocationRelativeTo(null);
        //добавляем фреймы на панель виртуального рабочего стола
        desktopPane.add(areaFrame);
        desktopPane.add(panelFrame);
        //сдвигаем один из фреймов на 50 точек влево и вниз
        panelFrame.setLocation(50, 50);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        Menu1 = new javax.swing.JMenu();
        Menu2 = new javax.swing.JMenu();
        textArea = new javax.swing.JMenuItem();
        textPanel = new javax.swing.JMenuItem();
        hideAll = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout desktopPaneLayout = new javax.swing.GroupLayout(desktopPane);
        desktopPane.setLayout(desktopPaneLayout);
        desktopPaneLayout.setHorizontalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 888, Short.MAX_VALUE)
        );
        desktopPaneLayout.setVerticalGroup(
            desktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 418, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        getContentPane().add(panel, java.awt.BorderLayout.CENTER);

        Menu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Frames.png"))); // NOI18N
        Menu1.setText("Frame");

        Menu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Add.png"))); // NOI18N
        Menu2.setText("Open Frame");
        Menu2.setToolTipText("Показать фрейм");

        textArea.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        textArea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Frame1.png"))); // NOI18N
        textArea.setText("Text Area");
        textArea.setToolTipText("Фрейм с текстовой областью");
        textArea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textAreaActionPerformed(evt);
            }
        });
        Menu2.add(textArea);

        textPanel.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        textPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Frame2.png"))); // NOI18N
        textPanel.setText("Text Panel");
        textPanel.setToolTipText("Фрейм с текстовой панелью");
        textPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPanelActionPerformed(evt);
            }
        });
        Menu2.add(textPanel);

        Menu1.add(Menu2);

        hideAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        hideAll.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Close.png"))); // NOI18N
        hideAll.setText("Hide All");
        hideAll.setToolTipText("Скрыть все фреймы");
        hideAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hideAllActionPerformed(evt);
            }
        });
        Menu1.add(hideAll);

        menuBar.add(Menu1);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textAreaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textAreaActionPerformed
        areaFrame.show();
    }//GEN-LAST:event_textAreaActionPerformed

    private void textPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPanelActionPerformed
        panelFrame.show();
    }//GEN-LAST:event_textPanelActionPerformed

    private void hideAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hideAllActionPerformed
        areaFrame.hide();
        panelFrame.hide();
    }//GEN-LAST:event_hideAllActionPerformed

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
    private javax.swing.JMenu Menu1;
    private javax.swing.JMenu Menu2;
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem hideAll;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel panel;
    private javax.swing.JMenuItem textArea;
    private javax.swing.JMenuItem textPanel;
    // End of variables declaration//GEN-END:variables
}
