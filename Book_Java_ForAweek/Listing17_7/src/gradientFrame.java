import java.awt.image.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class gradientFrame extends javax.swing.JFrame {
    BufferedImage bi;
    Graphics gp;
    Graphics2D bi2d;
    int panelWidth;
    int panelHeight;

    public gradientFrame() {
        initComponents();
        this.panelWidth = panel.getWidth();
        this.panelHeight = panel.getHeight();
        this.bi = new BufferedImage(panelWidth, panelHeight, BufferedImage.TYPE_INT_ARGB);
        this.bi2d = bi.createGraphics();
        this.gp = panel.getGraphics();
        
        setLocationRelativeTo(null);
    }

    @Override
    public void paint(Graphics g)
    {
        super.paint(g);
        
        // Сглаживание контуров графики
        bi2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //bi2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        // Приоритет качества над скоростью при рендеринге
        bi2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        
        // Прямоугольник с градиентной заливкой от желтого к синему
        GradientPaint grdPaint = new GradientPaint(20.0f, 20.0f, Color.YELLOW, 200.0f, 20.0f, Color.BLUE);
        bi2d.setPaint(grdPaint);
        bi2d.fill(new Rectangle2D.Float(20.0f, 20.0f, 200.0f, 100.0f));
        
        // Рисуем длинный прямоугольник с циклическим градиентом
        grdPaint = new GradientPaint(20.0f, 20.0f, Color.YELLOW, 106.0f, 20.0f, Color.BLUE, true);
        bi2d.setPaint(grdPaint);
        bi2d.fill(new Rectangle2D.Float(20.0f, 170.0f, 440.0f, 50.0f));
        
        
        // Создаем элемент текстуры в виде квадрата 20*20
        BufferedImage t = new BufferedImage(20, 20, BufferedImage.TYPE_INT_RGB);
        Graphics2D tg = t.createGraphics();
        // Создаем градиентную заливку квадрата
        GradientPaint grt = new GradientPaint(0.0f, 0.0f, Color.YELLOW, 20.0f, 20.0f, Color.BLUE);
        tg.setPaint(grt);
        // Рисуем квадрат, залитый градиентом
        tg.fill(new Rectangle2D.Float(0.0f, 0.0f, 20.0f, 20.0f));
        
        // Создаем текстуру из рисунка t
        TexturePaint tp = new TexturePaint(t, new Rectangle2D.Float(0.0f, 0.0f, 20.0f, 20.0f));
        bi2d.setPaint(tp);
        // Рисуем прямоугольник, заполненный текстурой
        bi2d.fill(new Rectangle2D.Float(260.0f, 20.0f, 200.0f, 100.0f));
        
        float[] base = {0.0f, 0.5f, 1.0f}; // Массив опорных точек
        Color[] color = {Color.YELLOW, Color.BLUE, Color.GREEN}; // Массив цветов
        // Создаем многоцветную линейную градиентную заливку        
        LinearGradientPaint lgp = new LinearGradientPaint(35.0f, 270.0f, 200.0f, 270.0f, base, color);
        bi2d.setPaint(lgp);
        bi2d.fill(new Rectangle2D.Float(20.0f, 270.0f, 200.0f, 100.0f));
        
        // Создаем многоцветную радиальную градиентную заливку
        RadialGradientPaint rgp = new RadialGradientPaint(310.0f, 320.0f, 50.0f, base, color); 
        bi2d.setPaint(rgp);
        bi2d.fill(new Ellipse2D.Float(260.0f, 270.0f, 100.0f, 100.0f));
        
        // Подписи к фигурам
        bi2d.setPaint(Color.BLACK);
        bi2d.setFont(new Font("Lucida Console", Font.PLAIN, 16));
        bi2d.drawString("Заливка градиентом", 20, 145);
        bi2d.drawString("Заливка текстурой", 260, 145);
        bi2d.drawString("Циклическая заливка градиентом", 20, 245);
        bi2d.drawString("LinearGradientPaint", 20, 395);
        bi2d.drawString("RadialGradientPaint", 260, 395);
        
        gp.drawImage(bi, 0, 0, panel);
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
            .addGap(0, 477, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(gradientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(gradientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(gradientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(gradientFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gradientFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
