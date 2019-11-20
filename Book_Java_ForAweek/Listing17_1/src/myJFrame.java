import java.awt.*;

public class myJFrame extends javax.swing.JFrame {
    private final Graphics gp;    

    public myJFrame() {
        initComponents();
        gp = panel.getGraphics();
        setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        button = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 291, Short.MAX_VALUE)
        );

        button.setText("Рисовать");
        button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(222, 222, 222)
                .addComponent(button)
                .addContainerGap(243, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(button)
                .addGap(0, 13, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonActionPerformed
        // Прямоугольник синего цвета
        gp.setColor(Color.BLUE);
        gp.drawRect(10, 10, 70, 50);
        gp.fillRect(90, 10, 70, 50);
        
        // Прямоугольник со скругленными углами
        gp.drawRoundRect(170, 10, 70, 50, 15, 15);
        gp.fillRoundRect(250, 10, 70, 50, 15, 15);
        
        // Линия зеленого цвета
        gp.setColor(Color.GREEN);
        gp.drawLine(10, 70, 160, 70);
        
        // Овал серого цвета 
        gp.setColor(Color.GRAY);
        gp.drawOval(330, 10, 70, 50);
        gp.fillOval(410, 10, 70, 50);
        
        // Дуга и сектор малинового цвета, альфа = FF
        gp.setColor(new Color(0xFF8F48AF, true));
        gp.drawArc(10, 90, 80, 80, 0, 110);
        gp.fillArc(100, 90, 80, 80, 0, 110);
        
        // Сектор синего цвета, альфа = 5F
        gp.setColor(new Color(0x5F0000FF, true));
        gp.fillArc(130, 90, 80, 80, 0, 110);
        
        // Текст черного цвета, разные шрифты
        gp.setColor(Color.BLACK);
        gp.setFont(new Font("Arial", Font.BOLD|Font.ITALIC, 28));
        gp.drawString("Arial Bold Italic", 10, 180);
        gp.setFont(new Font("Times New Roman", Font.PLAIN, 28));
        gp.drawString("Times New Roman", 250, 180);
        
        // Получаем метрику текущего шрифта
        FontMetrics fm;
        fm = gp.getFontMetrics();
        // Выводим в терминал максимальную высоту шрифта
        System.out.println("Высота шрифта: " + fm.getHeight());
        
        // Многоугольник пурпурного цвета, без заливки и с заливкой
        gp.setColor(Color.MAGENTA);
        gp.drawPolygon(new int[]{25,145,25,145,25}, new int[]{205,205,265,265,205}, 5);
        gp.fillPolygon(new int[]{155,275,155,275,155}, new int[]{205,205,265,265,205}, 5);
    }//GEN-LAST:event_buttonActionPerformed

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
    private javax.swing.JButton button;
    private javax.swing.JPanel panel;
    // End of variables declaration//GEN-END:variables
}
