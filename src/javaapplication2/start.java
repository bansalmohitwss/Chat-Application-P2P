package javaapplication2;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

// Start class, Initial Page to connect two client, First Page to be run.

public class start extends javax.swing.JFrame {

    public static Socket socket;
    public static String UserName;
    public ServerSocket serverSocket;
    private String ipAddress;
    private InetAddress localhost;
    
    public start() {
        initComponents();
         
        try {
            localhost = InetAddress.getLocalHost();
            String IPaddr= (localhost.getHostAddress()).trim();
            System.out.println("System IP Address : " + IPaddr);
            yourIPAddress.setText(IPaddr);            
   
        } catch (UnknownHostException ex) {
            Logger.getLogger(start.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        userName = new javax.swing.JTextField();
        ip = new javax.swing.JTextField();
        connect = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        wait = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        yourIPAddress = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        userName.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        userName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameActionPerformed(evt);
            }
        });

        ip.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        ip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ipActionPerformed(evt);
            }
        });

        connect.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        connect.setText("Connect");
        connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("P2P File Transfer");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("IP Address of friend:");

        wait.setFont(new java.awt.Font("Dialog", 1, 16)); // NOI18N
        wait.setText("Wait ");
        wait.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waitActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Your IP:");

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel4.setText("UserName:");

        yourIPAddress.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userName, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ip, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(wait)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(connect))
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(yourIPAddress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yourIPAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addGap(43, 43, 43)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ip, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(wait)
                    .addComponent(connect))
                .addGap(44, 44, 44))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameActionPerformed

    private void ipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ipActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ipActionPerformed

    private void waitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waitActionPerformed

        // This is for client whether he want to connect to someone or wait for someone
        // to be connected. after clicking button server is started at client side.
        
        UserName = userName.getText();
        try
        {
            serverSocket = new ServerSocket(5000);
            System.out.println("Server Started");
        }catch(IOException e)
        {
            System.out.println("Error in starting server"+e);
        }
        
        try{
            socket = serverSocket.accept();
            System.out.println("A new Friend is connected");
        }catch(IOException e)
        {
            System.out.println(e);
        }
        
        // If connection is established, go to chat page and close current page.
        new client().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_waitActionPerformed

    private void connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectActionPerformed
        
        //This is for client when he want to connect with someone . After clicking button, if at the specified 
        //ip address server is started, client will be connected to that otherwise IOEXception occur.
        
        UserName = userName.getText();
        ipAddress = ip.getText();
        try{
            socket = new Socket(ipAddress,5000);
        }catch(IOException e)
        {
            System.out.println(e);
        }
        
        // If connection is established, go to chat page and close current page.
        new client().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_connectActionPerformed

 
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
            java.util.logging.Logger.getLogger(start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(start.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new start().setVisible(true);        
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connect;
    private javax.swing.JTextField ip;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField userName;
    private javax.swing.JButton wait;
    private javax.swing.JLabel yourIPAddress;
    // End of variables declaration//GEN-END:variables
}
