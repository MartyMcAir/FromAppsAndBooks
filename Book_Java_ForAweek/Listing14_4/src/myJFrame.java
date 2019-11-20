import java.awt.Color;
import javax.swing.JPanel;

public class myJFrame extends javax.swing.JFrame {
    // Объявляем объектные переменные панелей
    JPanel myPanelRed = new JPanel();
    JPanel myPanelGreen = new JPanel();
    JPanel myPanelBlue = new JPanel();
    
    public myJFrame() {
        initComponents();
        setLocationRelativeTo(null);
        
        // Панель красного цвета размером 100x100
        // на слое номер 5
        myPanelRed.setBounds(20, 20, 100, 100);
        myPanelRed.setBackground(Color.RED);
        layPane.add(myPanelRed, new Integer(5));
        
        // Панель зеленого цвета размером 100x100
        // на слое номер 5
        myPanelGreen.setBounds(30, 30, 100, 100);
        myPanelGreen.setBackground(Color.GREEN);
        layPane.add(myPanelGreen, new Integer(5));
        
        // Панель синего цвета размером 100x100
        // на слое номер 4
        myPanelBlue.setBounds(40, 40, 100, 100);
        myPanelBlue.setBackground(Color.BLUE);
        layPane.add(myPanelBlue, new Integer(4));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layPane = new javax.swing.JLayeredPane();
        redButton = new javax.swing.JButton();
        greenButton = new javax.swing.JButton();
        blueButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layPaneLayout = new javax.swing.GroupLayout(layPane);
        layPane.setLayout(layPaneLayout);
        layPaneLayout.setHorizontalGroup(
            layPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 401, Short.MAX_VALUE)
        );
        layPaneLayout.setVerticalGroup(
            layPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 182, Short.MAX_VALUE)
        );

        redButton.setBackground(java.awt.Color.red);
        redButton.setText("Red");
        redButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redButtonActionPerformed(evt);
            }
        });

        greenButton.setBackground(java.awt.Color.green);
        greenButton.setText("Green");
        greenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                greenButtonActionPerformed(evt);
            }
        });

        blueButton.setBackground(java.awt.Color.blue);
        blueButton.setForeground(new java.awt.Color(255, 255, 255));
        blueButton.setText("Blue");
        blueButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layPane)
            .addGroup(layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(redButton)
                .addGap(18, 18, 18)
                .addComponent(greenButton)
                .addGap(18, 18, 18)
                .addComponent(blueButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(layPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(redButton)
                        .addComponent(blueButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(greenButton)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void redButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redButtonActionPerformed
        // Переносим красную панель на передний план слоя
        layPane.moveToFront(myPanelRed);
    }//GEN-LAST:event_redButtonActionPerformed

    private void greenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_greenButtonActionPerformed
        // Переносим зеленую панель на передний план слоя
        layPane.moveToFront(myPanelGreen);
    }//GEN-LAST:event_greenButtonActionPerformed

    private void blueButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueButtonActionPerformed
        // Перемещаем синюю панель на слой 5
        layPane.setLayer(myPanelBlue, 5);
        // Переносим синюю панель на передний план слоя
        layPane.moveToFront(myPanelBlue);
    }//GEN-LAST:event_blueButtonActionPerformed

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
    private javax.swing.JButton blueButton;
    private javax.swing.JButton greenButton;
    private javax.swing.JLayeredPane layPane;
    private javax.swing.JButton redButton;
    // End of variables declaration//GEN-END:variables
}
