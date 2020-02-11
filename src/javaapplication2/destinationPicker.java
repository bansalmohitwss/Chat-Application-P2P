package javaapplication2;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.*;


public class destinationPicker extends JPanel
   implements ActionListener {
   JButton go;

   JFileChooser chooser;
   String choosertitle;
   String path;

   public String getpath(){
       return path;
   }
  public destinationPicker() {
    go = new JButton("Choose Destination");
    go.addActionListener(this);
    add(go);
   }

  public void start(){    
      JFrame frame = new JFrame("");
    destinationPicker panel = new destinationPicker();
    frame.addWindowListener(
      new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
          System.exit(0);
          }
        }
      );
    frame.getContentPane().add(panel,"Center");
    frame.setSize(panel.getPreferredSize());
    frame.setVisible(true);
    
  }
  
  public void actionPerformed(ActionEvent e) {    
    chooser = new JFileChooser(); 
    chooser.setCurrentDirectory(new java.io.File("."));
    chooser.setDialogTitle(choosertitle);
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
    //
    // disable the "All files" option.
    //
    chooser.setAcceptAllFileFilterUsed(false);
    //    
    if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) { 
      path = ""+chooser.getCurrentDirectory();
      }
    else {
        path=client.Dir;
      }
    
    
     }

   @Override
  public Dimension getPreferredSize(){
    return new Dimension(200, 200);
    }

}
