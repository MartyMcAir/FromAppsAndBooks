import javax.swing.JDialog;

public class myJFrame extends javax.swing.JFrame {

    public myJFrame() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        optionPane = new javax.swing.JOptionPane();
        panelParams = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        messageTypeList = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        optionTypeList = new javax.swing.JComboBox<>();
        messageText = new javax.swing.JTextField();
        setInput = new javax.swing.JCheckBox();
        createButton = new javax.swing.JButton();
        headerText = new javax.swing.JTextField();
        panelDialog = new javax.swing.JPanel();

        optionPane.setMessageType(1);
        optionPane.setOptionType(0);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelParams.setBorder(javax.swing.BorderFactory.createTitledBorder("Настройка параметров окна"));

        jLabel1.setText("Тип сообщения");

        messageTypeList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PLAIN_MESSAGE", "ERROR_MESSAGE", "INFORMATION_MESSAGE", "WARNING_MESSAGE", "QUESTION_MESSAGE" }));

        jLabel2.setText("Стандартные опции");

        optionTypeList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DEFAULT_OPTION", "YES_NO_OPTION", "YES_NO_CANCEL_OPTION", "OK_CANCEL_OPTION" }));

        messageText.setText("Сообщение в окне диалога");

        setInput.setText("Добавить поле ввода");

        createButton.setText("Создать диалог");
        createButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createButtonActionPerformed(evt);
            }
        });

        headerText.setText("Заголовок диалога");

        javax.swing.GroupLayout panelParamsLayout = new javax.swing.GroupLayout(panelParams);
        panelParams.setLayout(panelParamsLayout);
        panelParamsLayout.setHorizontalGroup(
            panelParamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelParamsLayout.createSequentialGroup()
                .addGroup(panelParamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelParamsLayout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addGroup(panelParamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(setInput)
                            .addComponent(createButton)))
                    .addGroup(panelParamsLayout.createSequentialGroup()
                        .addGroup(panelParamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelParamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(headerText)
                                .addComponent(messageTypeList, 0, 188, Short.MAX_VALUE))
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(panelParamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2)
                            .addComponent(optionTypeList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(messageText))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelParamsLayout.setVerticalGroup(
            panelParamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelParamsLayout.createSequentialGroup()
                .addGroup(panelParamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelParamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageTypeList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(optionTypeList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelParamsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(messageText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(headerText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(setInput)
                .addGap(12, 12, 12)
                .addComponent(createButton)
                .addContainerGap())
        );

        javax.swing.GroupLayout panelDialogLayout = new javax.swing.GroupLayout(panelDialog);
        panelDialog.setLayout(panelDialogLayout);
        panelDialogLayout.setHorizontalGroup(
            panelDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelDialogLayout.setVerticalGroup(
            panelDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 154, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDialog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelParams, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(panelDialog, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelParams, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createButtonActionPerformed
        // Задаем тип сообщения
        optionPane.setMessageType(messageTypeList.getSelectedIndex()-1);
        // Задаем тип ответа пользователя
        optionPane.setOptionType(optionTypeList.getSelectedIndex()-1);
        // Задаем текст сообщения в диалоге
        optionPane.setMessage(messageText.getText());
        // Добавляем поле ввода, если оно задано
        optionPane.setWantsInput(setInput.isSelected());
        // Создаем объект диалога с заданным заголовком
        JDialog myDialog = optionPane.createDialog(panelDialog, headerText.getText());
        // Делаем диалог видимым
        myDialog.setVisible(true);
        // После закрытия диалога выводим содержимое поля ввода
        System.out.println(optionPane.getInputValue());
        // Выводим индекс кнопки, которую выбрал пользователь
        // Или null если окно принудительно закрыто
        System.out.println(optionPane.getValue()); 
    }//GEN-LAST:event_createButtonActionPerformed

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
    private javax.swing.JButton createButton;
    private javax.swing.JTextField headerText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField messageText;
    private javax.swing.JComboBox<String> messageTypeList;
    private javax.swing.JOptionPane optionPane;
    private javax.swing.JComboBox<String> optionTypeList;
    private javax.swing.JPanel panelDialog;
    private javax.swing.JPanel panelParams;
    private javax.swing.JCheckBox setInput;
    // End of variables declaration//GEN-END:variables
}
