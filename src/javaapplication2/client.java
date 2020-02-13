package javaapplication2;

import javax.swing.JOptionPane;
import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

// Chat Page which will be appeared atfer successful connection with other client.

public class client extends javax.swing.JFrame {
    
    public ObjectInputStream objectInputStream;
    public ObjectOutputStream objectOutputStream;
    public receiveMessage receive;
    public filePicker filepicker;
    public static String Dir = "C:\\Users\\USER\\Desktop\\XYZ\\";
    public boolean flag=false;
    
    public client() {
        initComponents();
        userName.setText(start.UserName);
        textarea.setEditable(false);
        filepicker = new filePicker();
        try{
        objectOutputStream = new ObjectOutputStream(start.socket.getOutputStream());
        objectInputStream = new ObjectInputStream(start.socket.getInputStream());
        System.out.println("Successfully Open Streams for "+ start.UserName);
        }catch(IOException e)
        {
            System.out.println("Error in initializing streams"+e);
        }
        
        receive = new receiveMessage(this);
        receive.t.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        textarea = new javax.swing.JTextArea();
        message = new javax.swing.JTextField();
        send = new javax.swing.JButton();
        sendfiles = new javax.swing.JButton();
        close = new javax.swing.JButton();
        userName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        textarea.setColumns(20);
        textarea.setRows(5);
        jScrollPane1.setViewportView(textarea);

        message.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                messageActionPerformed(evt);
            }
        });

        send.setText("Send");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        sendfiles.setText("Send files");
        sendfiles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendfilesActionPerformed(evt);
            }
        });

        close.setText("close");
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(close, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 355, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(send)
                                .addGap(31, 31, 31)
                                .addComponent(sendfiles))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(userName, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(userName, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(close)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(message, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(sendfiles, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void messageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_messageActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_messageActionPerformed

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
       
        // Send Text Message to other client
        //First read from EditText and then send through outputStream 
        String str = message.getText();
        System.out.println("Sending Message");
        try{
        objectOutputStream.writeObject("0"+start.UserName+ ": " +str);
        }catch(IOException e)
        {
            System.out.println("Error in Sending Message"+e);
        }
        print(start.UserName+ ": " +str);
        message.setText("");
    }//GEN-LAST:event_sendActionPerformed

    
    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        try {
            // Close Connection , close Socket and close streams
            flag=true;
            objectInputStream.close();
            objectOutputStream.close();
            start.socket.close();
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.dispose();
    }//GEN-LAST:event_closeActionPerformed

    private void sendfilesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendfilesActionPerformed
        
        // Send files to other client.
        // First file to send , must be picked by sender.
        String path = filepicker.getPath();
        int count=0;
        FileInputStream fileInputStream = null;
        //Open file in File Object...
        File f = new File(path);
        
        try {
             fileInputStream = new FileInputStream(f);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Specify Buffer Size to be read from file.
        byte b[] = new byte[1000];
        byte[] c;
        
        try {
            /* 
            First Send Type of Message ( Here we are giving 0 for Text message and 1 for files to be recognise at 
            receiver end ).
            Then we are reading bytes from file and then sending to receiver.
            And at the end EOF Message must be send.
            */
            objectOutputStream.writeObject("1"+f.getName());
            while((count=fileInputStream.read(b))!=-1){
               c = Arrays.copyOf(b, count);
            objectOutputStream.writeObject(c);
            }
            objectOutputStream.writeObject("EOF".getBytes());
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            fileInputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_sendfilesActionPerformed

    public void receiveFile(String fileName)
    {   
        // First open file to be receive from sender.
        File f = new File(Dir+fileName);
        FileOutputStream fileOutputStream = null;
        
        try {
            fileOutputStream = new FileOutputStream(f);
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Specify Buffer size to be read from file.
        byte b[] = new byte[1005];
        String s;
        while(true)
        {
            /*
            Reading bytes from InputStream and then If EOF not occured, writing to file.
            IF occured , break while loop.
            */
            
            try {
                b = (byte[])objectInputStream.readObject();
                s = new String(b);
                if(s.compareTo("EOF")==0){
                   System.out.println("End of zfile");
                    break;
                }
                else
                fileOutputStream.write(b);
               
            } catch (IOException ex) {
                Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
            } 
            
        }
        // Closing fileOutputStream.
        
        try {
            fileOutputStream.close();
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    }
    
    synchronized public void print(String s)
    {
        String pre = textarea.getText();
        pre = pre+ s + "\n";
        textarea.setText(pre);
    }
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
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(client.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new client().setVisible(true);
            }
        });
    }
    
    /*
    Create class to receive message from sender , implements Runnable to create thread which will 
    run infinitely to get message from sender.
    */
    
    class receiveMessage implements Runnable
    {
        Thread t;
        client c;
        String s;
        public receiveMessage(client ch)
        {
            this.c = ch;
            this.t = new Thread(this);
        }
        public void run()
        {
            while(true)
            {
                try{
                s = (String)c.objectInputStream.readObject();
                if(s.charAt(0)=='1'){
                    System.out.println("Receiving File");
                   c.receiveFile(s.substring(1,s.length()));
                   continue;
                }
                System.out.println("Message Received");
                c.print(s.substring(1,s.length()));
                }catch(IOException e)
                {
                    System.out.println("Socket Error");
                    if(!flag)
                    {
                        JOptionPane.showMessageDialog(c, "Your Friend is offline Now\nRedirecting to starting Page");
                         try {
                               Thread.sleep(500);
                           } catch (InterruptedException ex) {
                              Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
                         }
                           new start().setVisible(true);
                         c.dispose();
                          break;
                    }
                    else
                        break;
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton close;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField message;
    private javax.swing.JButton send;
    private javax.swing.JButton sendfiles;
    private javax.swing.JTextArea textarea;
    private javax.swing.JLabel userName;
    // End of variables declaration//GEN-END:variables
}
