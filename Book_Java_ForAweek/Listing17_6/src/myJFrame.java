import java.awt.image.*;
import java.awt.*;
import java.awt.font.TextAttribute;
import java.awt.geom.*;
import java.util.HashMap;

public class myJFrame extends javax.swing.JFrame {
    BufferedImage bi;
    Graphics gp;
    Graphics2D bi2d;
    int panelWidth;
    int panelHeight;
    
    BasicStroke penCap1 = new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
    BasicStroke penCap2 = new BasicStroke(5, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER);

    public myJFrame() {
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
               
        // Цвет чернил
        bi2d.setColor(Color.BLACK);
        
        // Создаем таблицу атрибутов шрифта
        HashMap fm = new HashMap();
        // Добавляем в таблицу атрибуты
        fm.put(TextAttribute.SIZE, 24.0f);
        fm.put(TextAttribute.WEIGHT, TextAttribute.WEIGHT_BOLD);
        fm.put(TextAttribute.WIDTH, TextAttribute.WIDTH_EXTENDED);
        // Создаем новый объект шрифта на основе таблицы атрибутов
        Font f1 = new Font(fm);
        bi2d.setFont(f1);
        
        bi2d.drawString("Без сглаживания 123456789", 25, 35);
        
        bi2d.setStroke(penCap1); // Пользовательское перо 1
        // Прямоугольник со скруглением стыков за счет пера
        bi2d.draw(new Rectangle2D.Double(30, 50, 50, 50));
        // Прямоугольник со скруглением углов
        bi2d.draw(new RoundRectangle2D.Double(110, 50, 50, 50, 10, 10));
        // Прямоугольник с заливкой
        bi2d.fill(new RoundRectangle2D.Double(190, 50, 50, 50, 10, 10));
        
        bi2d.setStroke(penCap2); // Пользовательское перо 2
        // Сегмент
        bi2d.draw(new Arc2D.Double(240, 55, 90, 90, 0, 120, Arc2D.PIE));
        // Дуга, замкнутая хордой (отрезок между конечными точками
        bi2d.draw(new Arc2D.Double(320, 55, 90, 90, 0, 120, Arc2D.CHORD));
        // Открытая дуга
        bi2d.draw(new Arc2D.Double(400, 55, 90, 90, 0, 120, Arc2D.OPEN));
        
        // Сглаживание контуров текста
        bi2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        // Сглаживание контуров графики
        bi2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        // Приоритет качества над скоростью при рендеринге
        bi2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);  
        
        bi2d.drawString("Сглаживание        123456789", 25, 155);
        
        bi2d.setStroke(penCap1); // Пользовательское перо 1
        // Прямоугольник со скруглением стыков за счет пера
        bi2d.draw(new Rectangle2D.Double(30, 170, 50, 50));
        // Прямоугольник со скруглением углов
        bi2d.draw(new RoundRectangle2D.Double(110, 170, 50, 50, 10, 10));
        // Прямоугольник с заливкой
        bi2d.fill(new RoundRectangle2D.Double(190, 170, 50, 50, 10, 10));
        
        bi2d.setStroke(penCap2); // Пользовательское перо 2
        bi2d.draw(new Arc2D.Double(240, 175, 90, 90, 0, 120, Arc2D.PIE));
        bi2d.draw(new Arc2D.Double(320, 175, 90, 90, 0, 120, Arc2D.CHORD));
        bi2d.draw(new Arc2D.Double(400, 175, 90, 90, 0, 120, Arc2D.OPEN));
        
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
            .addGap(0, 541, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 268, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
