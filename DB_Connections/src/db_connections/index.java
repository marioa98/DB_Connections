
package db_connections;

import javax.swing.JOptionPane;
import db_connections.DB_Connections;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import db_connections.querysPostgreSQL;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class index extends javax.swing.JFrame {
    
    DB_Connections db;
    String host,port,DB,user,pwd,url;

    public index() {
        initComponents();
        db = new DB_Connections();
    }
    
    public void testConnectionPostgreSQl(String host, String port, String DB, String user, String pwd) {
        Connection conn = null;
        url = "jdbc:postgresql://" + host + ":" + port + "/" + DB ;
        try {
            conn = DriverManager.getConnection(url, user, pwd);
            JOptionPane.showMessageDialog(null,"Test Successfully","Connection Test Success",JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException e ) {
            JOptionPane.showMessageDialog(null, "Connection Test Failed","Connection Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void testConnection(String host, String port, String DB, String user, String pwd){
        db = new DB_Connections();
        String test = db.testConnection(host, port, DB, user, pwd);
        
        if(test == null){
            JOptionPane.showMessageDialog(null,"Test Successfully","Connection Test Success",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Connection Test Failed","Connection Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void executeConnection() {
        String value = jComboBox1.getSelectedItem().toString();
        host = txtHost.getText().toLowerCase();
        port = txtPort.getText();
        String bd = txtDB.getText();
        user = txtUser.getText();
        pwd = txtPwd.getText();
        if(value.equals( "mysql")) {
            String test = db.testConnection(host, port, bd, user, pwd);
            url = "jdbc:mysql://"+host+":"+port+"/"+bd+"?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            if(test == null){
                MySQL_Command_Line form = new MySQL_Command_Line(url,pwd,user);
                form.setLocationRelativeTo(null);
                form.setResizable(false);
                form.setVisible(true);
            }
            else {
                  JOptionPane.showMessageDialog(null, "Connection Test Failed test","Connection Error",JOptionPane.ERROR_MESSAGE);
                  System.out.println(test);
                  
             }
        }
        else {
             url = "jdbc:postgresql://" + host + ":" + port + "/" + bd ;
             boolean test = db.testConnectionPostgres(host, port, bd, user, pwd);
             if(test){
                
                querysPostgreSQL form = new querysPostgreSQL(url,user,pwd);
                form.setLocationRelativeTo(null);
                form.setResizable(false);
                form.setVisible(true);
             }
             else {
                  JOptionPane.showMessageDialog(null, "Connection Test Failed","Connection Error",JOptionPane.ERROR_MESSAGE);
             }
        }
    }
   
    
    public void executeTestConnection() {
        String value = jComboBox1.getSelectedItem().toString();
        host = txtHost.getText().toLowerCase();
        port = txtPort.getText();
        String bd = txtDB.getText().toLowerCase();
        user = txtUser.getText();
        pwd = txtPwd.getText();
        if(value.equals("mysql")) {
            
            String test = db.testConnection(host, port, bd, user, pwd);
            if(test == null){
                JOptionPane.showMessageDialog(null,"Test Successfully","Connection Test Success",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Connection Test Failed","Connection Error",JOptionPane.ERROR_MESSAGE);
            }
        }
       
        else {
            boolean test = db.testConnectionPostgres(host, port, bd, user, pwd);
            if(test){
                JOptionPane.showMessageDialog(null,"Test Successfully","Connection Test Success",JOptionPane.INFORMATION_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Connection Test Failed","Connection Error",JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }
    
//    public void connectDB(String host, String port, String DB, String user, String pwd){
//        db = new DB_Connections();
//        boolean test = db.testConnection(host, port, DB, user, pwd);
//        
//        if(test){
//            JOptionPane.showMessageDialog(null,"Test Successfully","Connection Test Success",JOptionPane.INFORMATION_MESSAGE);
//            
//        }else{
//            JOptionPane.showMessageDialog(null, "Connection Test Failed","Connection Error",JOptionPane.ERROR_MESSAGE);
//        }
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtHost = new javax.swing.JTextField();
        txtPort = new javax.swing.JTextField();
        txtDB = new javax.swing.JTextField();
        txtUser = new javax.swing.JTextField();
        txtPwd = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnTestC = new javax.swing.JButton();
        btnConnect = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Host name:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Port:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Database name:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("User:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Password:");

        txtHost.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtHost.setName(""); // NOI18N

        txtPort.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPort.setName(""); // NOI18N

        txtDB.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtDB.setName(""); // NOI18N

        txtUser.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtUser.setName(""); // NOI18N

        txtPwd.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPwd.setName(""); // NOI18N

        jLabel6.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel6.setText("DataBase Connection");

        btnTestC.setText("Test Connection");
        btnTestC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTestCMouseClicked(evt);
            }
        });
        btnTestC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestCActionPerformed(evt);
            }
        });

        btnConnect.setText("Connect");
        btnConnect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConnectMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Data source:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "mysql", "postgresql" }));
        jComboBox1.setToolTipText("mysql");
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTestC, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtDB, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtPwd, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtHost, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(249, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtHost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3))
                    .addComponent(txtDB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtUser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTestC)
                    .addComponent(btnConnect))
                .addContainerGap(134, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTestCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTestCMouseClicked
       executeTestConnection();
    }//GEN-LAST:event_btnTestCMouseClicked

    private void btnConnectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConnectMouseClicked
//        if(jComboBox1.getSelectedItem().toString().equals("mysql")) {
//            String host = txtHost.getText().toLowerCase();
//            String port = txtPort.getText();
//            String db = txtDB.getText().toLowerCase();
//            String user = txtUser.getText();
//            String pwd = txtPwd.getText();
//        
//        }
    executeConnection();
    }//GEN-LAST:event_btnConnectMouseClicked

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void btnTestCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTestCActionPerformed

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
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new index().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnTestC;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField txtDB;
    private javax.swing.JTextField txtHost;
    private javax.swing.JTextField txtPort;
    private javax.swing.JTextField txtPwd;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
