import java.awt.image.*;
import java.awt.*;

public class MyJFrame extends javax.swing.JFrame {
    BufferedImage bi;
    Graphics gp;
    Graphics2D bi2d;
    int panelWidth;
    int panelHeight;
    
    // Объявляем набор перьев с разными параметрами
    BasicStroke penCapRound = new BasicStroke(20, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
    BasicStroke penCapSquare = new BasicStroke(20, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL);
    BasicStroke penCapButtMiter = new BasicStroke(20, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);
    BasicStroke penCapButtBevel = new BasicStroke(20, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL);
    BasicStroke penCapButtRound = new BasicStroke(20, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND);
    // Массив для описания пунктирной линии
    float[] dash1 = {5, 20};
    // Массив для описания штрих-пунктирной линии
    float[] dash2 = {10, 5, 5, 5};
    // Перо для рисования пунктирной линии
    BasicStroke penDash1 = new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 10, dash1, 0);
    // Перо для рисования штрих-пунктирной линии
    BasicStroke penDash2 = new BasicStroke(10, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 10, dash2, 0);
    
    public MyJFrame() {     
        initComponents();
        this.panelWidth = panel.getWidth();
        this.panelHeight = panel.getHeight();
        this.bi = new BufferedImage(panelWidth, panelHeight, BufferedImage.TYPE_INT_ARGB);
        this.bi2d = bi.createGraphics();
        this.gp = panel.getGraphics();
        
        //Один из способов задать цвет фона
        bi2d.setBackground(new Color(0x90FF90));
        bi2d.clearRect(0, 0, bi.getWidth(), bi.getHeight());
        
        setLocationRelativeTo(null);
    }
    
    @Override
    public void paint(Graphics g)
    {
      super.paint(g);
      bi2d.setFont(new Font("Serif", Font.PLAIN, 15));
      bi2d.setColor(Color.BLACK);
      
      // Линия 20px со скругленными краями
      bi2d.setStroke(penCapRound);
      bi2d.drawLine(30, 20, 80, 20);
      bi2d.drawString("CAP_ROUND", 10, 50);
      
      // Линия 20px с прямоугольными краями
      bi2d.setStroke(penCapSquare);
      bi2d.drawLine(30, 90, 80, 90);
      bi2d.drawString("CAP_SQUARE", 10, 120);
      
      // Линия 20px с краями без эффектов (по умолчанию)
      bi2d.setStroke(penCapButtMiter);
      bi2d.drawLine(30, 160, 80, 160);
      bi2d.drawString("CAP_BUTT", 10, 190);
      
      // прямоугольник с простой стыковкой линий
      bi2d.setStroke(penCapButtMiter);
      bi2d.drawRect(150, 20, 90, 40);
      bi2d.drawString("JOIN_MITER", 260, 45);
      
      // Прямоугольник со скруглением углов
      bi2d.setStroke(penCapButtRound);
      bi2d.drawRect(150, 100, 90, 40);
      bi2d.drawString("JOIN_ROUND", 260, 125);
      
      // Прямоугольник с усечением углов
      bi2d.setStroke(penCapButtBevel);
      bi2d.drawRect(150, 180, 90, 40);
      bi2d.drawString("JOIN_BEVEL", 260, 205);
      
      bi2d.setStroke(penDash1);
      bi2d.drawLine(30, 260, 200, 260);
      bi2d.drawString("Dash 10px {5, 20}", 210, 265);
      
      bi2d.setStroke(penDash2);
      bi2d.drawLine(25, 290, 195, 290);
      bi2d.drawString("Dash 10px {10, 5, 5, 5}", 210, 295);
      
      gp.drawImage(bi, 0, 0, panel);
    }
       
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                panelComponentResized(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 325, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void panelComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_panelComponentResized
        
    }//GEN-LAST:event_panelComponentResized

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
            java.util.logging.Logger.getLogger(MyJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MyJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MyJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MyJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
