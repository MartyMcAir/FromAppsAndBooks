import java.awt.image.*;
import java.awt.*;

public class myJFrame extends javax.swing.JFrame {
    private final Graphics gp;
    private final Graphics big;
    private final BufferedImage bi;
    private final int panelWidth;
    private final int panelHeight;
    
    public myJFrame() {
        initComponents();
        // получаем графический контекст панели
        this.gp = panel.getGraphics();
        // Получаем ширину и высоту панели окна
        this.panelWidth = panel.getWidth();
        this.panelHeight = panel.getHeight();
        // Создаем буферный рисунок по размерам панели, формат цвета ARGB, alpha==null
        this.bi = new BufferedImage(panelWidth, panelHeight, BufferedImage.TYPE_INT_ARGB);
        // Получаем графический контекст рисунка
        this.big = bi.getGraphics();
               
        setLocationRelativeTo(null);
    }
    
    @Override
    public void paint(Graphics g)
    {
      super.paint(g);
      gp.drawImage(bi, 0, 0, panel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        button = new javax.swing.JButton();
        panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        button.setText("Рисовать");
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        panel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 216, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(211, 211, 211)
                .addComponent(button)
                .addContainerGap(236, Short.MAX_VALUE))
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
       // Прямоугольник синего цвета
       big.setColor(Color.BLUE);
       big.drawRect(10, 10, 70, 50);
       big.fillRect(90, 10, 70, 50);
              
       // Прямоугольник со скругленными углами
       big.drawRoundRect(170, 10, 70, 50, 15, 15);
       big.fillRoundRect(250, 10, 70, 50, 15, 15);
        
       // Линия зеленого цвета
       big.setColor(Color.GREEN);
       big.drawLine(10, 70, 160, 70);
        
       // Овал серого цвета 
       big.setColor(Color.GRAY);
       big.drawOval(330, 10, 70, 50);
       big.fillOval(410, 10, 70, 50);
        
       // Дуга и сектор малинового цвета, альфа = FF
       big.setColor(new Color(0xFF8F48AF, true));
       big.drawArc(10, 90, 80, 80, 0, 110);
       big.fillArc(100, 90, 80, 80, 0, 110);
        
       // Сектор синего цвета, альфа = 5F
       big.setColor(new Color(0x5F0000FF, true));
       big.fillArc(130, 90, 80, 80, 0, 110);
       
       // Выводим рисунок в графический контекст панели
       gp.drawImage(bi, 0, 0, panel);
    }//GEN-LAST:event_buttonActionPerformed


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
    private javax.swing.JButton button;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables

}
