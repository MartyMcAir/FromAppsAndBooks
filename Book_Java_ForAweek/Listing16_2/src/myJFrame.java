import java.awt.event.*;
import javax.swing.*;
import javax.swing.colorchooser.AbstractColorChooserPanel;

public class myJFrame extends javax.swing.JFrame {

    public myJFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        colorTextPreview = new javax.swing.JLabel();
        colorChooser = new javax.swing.JColorChooser();
        coloredText = new javax.swing.JLabel();
        chooseColor = new javax.swing.JButton();

        colorTextPreview.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        colorTextPreview.setText("Пример текста");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        coloredText.setFont(new java.awt.Font("sansserif", 1, 36)); // NOI18N
        coloredText.setText("Цветной текст");

        chooseColor.setText("Выбрать цвет");
        chooseColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseColorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(coloredText)
                .addGap(17, 17, 17))
            .addGroup(layout.createSequentialGroup()
                .addGap(88, 88, 88)
                .addComponent(chooseColor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(coloredText, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(chooseColor)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chooseColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseColorActionPerformed
        // Назначаем компонент на панель предпросмотра цвета
        colorChooser.setPreviewPanel(colorTextPreview);

        /*
        AbstractColorChooserPanel defaultPanels[] = colorChooser.getChooserPanels();
        defaultPanels = new AbstractColorChooserPanel[]{defaultPanels[3]};
        colorChooser.setChooserPanels(defaultPanels);
        */
        
        // Создаем окно диалога
        JDialog d = JColorChooser.createDialog(new JFrame(), "Цвет текста", true, colorChooser, new OkColor(), new CancelColor());
        // Делаем видимым окно диалога
        d.setVisible(true);
    }//GEN-LAST:event_chooseColorActionPerformed

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
    
    class OkColor implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            coloredText.setForeground(colorChooser.getColor());
        }
    }
    
    class CancelColor implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            JOptionPane.showMessageDialog(null, "Цвет не изменился!", "Предупреждение", JOptionPane.WARNING_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton chooseColor;
    private javax.swing.JColorChooser colorChooser;
    private javax.swing.JLabel colorTextPreview;
    private javax.swing.JLabel coloredText;
    // End of variables declaration//GEN-END:variables
}
