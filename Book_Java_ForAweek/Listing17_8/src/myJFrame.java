import java.awt.image.*;
import java.awt.*;
import java.awt.geom.*;

public class myJFrame extends javax.swing.JFrame {
    Graphics gp;
    int panelWidth;    

    public myJFrame() {
        initComponents();
        this.panelWidth = panel.getWidth();
        this.gp = panel.getGraphics();
        setLocationRelativeTo(null);
    }
    
    @Override
    public void paint(Graphics g) {
        super.paint(g);

        BufferedImage shearImage = 
                new BufferedImage(panelWidth, 120, BufferedImage.TYPE_INT_ARGB);
        Graphics2D sh2d = shearImage.createGraphics();
        Rectangle rectSh = new Rectangle(20, 20, 100, 100);
        sh2d.setPaint(Color.BLUE);
        for (int i=0; i<5; i++) { 
            sh2d.fill(rectSh);
            // Каждый новый сдвиг больше на 20%
            sh2d.shear(0.2, 0.0);
            sh2d.translate(120, 0);
        }
        
        // Вращение квадратов
        BufferedImage rotateImage = 
                new BufferedImage(panelWidth, 155, BufferedImage.TYPE_INT_ARGB);
        Graphics2D rt2d = rotateImage.createGraphics();
        Shape rectRt = new Rectangle2D.Double(30, 30, 100, 100);
        rt2d.setPaint(Color.RED);
        // Рисуем красный квадрат в исходных координатах
        rt2d.fill(rectRt);
        // Сдвигаем плоскость координат вправо на 130 точек
        rt2d.translate(130, 0.0);
        // Поворачиваем плоскость координат
        rt2d.rotate(-Math.PI/8.0, 80, 80);
        // Рисуем зеленый квадрат
        rt2d.setPaint(Color.GREEN);
        rt2d.fill(rectRt);
        // Поворачиваем плоскость координат обратно
        rt2d.rotate(Math.PI/8.0,80,80);
        // Сдвигаем координаты вправо на 150 точек
        rt2d.translate(150, 0.0);
        // Поворачиваем плоскость координат
        rt2d.rotate(Math.PI/4.0,80,80);
        // Рисуем синий квадрат
        rt2d.setPaint(Color.BLUE);
        rt2d.fill(rectRt);
        
        // Масштабирование квадратов
        BufferedImage scaleImage = 
                new BufferedImage(panelWidth, 120, BufferedImage.TYPE_INT_ARGB);
        Graphics2D sc2d = scaleImage.createGraphics();
        Rectangle rectSc = new Rectangle(20, 10, 100, 100);
        sc2d.setPaint(Color.BLACK);
        sc2d.fill(rectSc);
        sc2d.translate(130, 0.0);
        // Сжимаем до 50% по горизонтали
        sc2d.scale(0.5, 1.0);
        sc2d.fill(rectSc);
        // Растягиваем обратно по горизонтали
        // и сжимаем до 50% по вертикали
        sc2d.scale(2.0, 0.5);
        sc2d.translate(60, 10.0);
        sc2d.fill(rectSc);
        // Сжимаем до 50% по горизонтали
        // и оставляем сжатие по вертикали
        sc2d.scale(0.5, 1.0);
        sc2d.translate(260, 0.0);
        sc2d.fill(rectSc);
        
        gp.drawString("Сдвиг (Shear)", 30, 20);
        gp.drawImage(shearImage, 0, 20, rootPane);
        gp.drawString("Вращение (Rotate)", 30, 170);
        gp.drawImage(rotateImage, 0, 175, rootPane);
        gp.drawString("Масштабирование (Scale)", 30, 340);
        gp.drawImage(scaleImage, 0, 345, rootPane);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 716, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 486, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
