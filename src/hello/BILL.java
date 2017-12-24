package hello;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BILL extends JFrame {
 
    public BILL(String value)
  {
      initComponents();
      jTextField4.setText(value);
      jTextField4.setEditable(false);
       Date now = new Date(); 
       SimpleDateFormat formatter = new SimpleDateFormat( "dd/MM/yyyy" ); 
       jTextField5.setText(formatter.format(now));
       jTextField5.setEditable(false);
       SimpleDateFormat formatter1 = new SimpleDateFormat("HH:mm:ss"); 
       jTextField6.setText(formatter1.format(now));
       jTextField6.setEditable(false);
  }
    /**
     * Creates new form BILL
     */
    public BILL() {
        initComponents();
        groupButton();
        
     /*  Date now = new Date(); 
       SimpleDateFormat formatter = new SimpleDateFormat( "dd/MM/yyyy" ); 
       jTextField5.setText(formatter.format(now));
       SimpleDateFormat formatter1 = new SimpleDateFormat("HH:mm:ss"); 
       jTextField6.setText(formatter1.format(now));*/
         
    }
    
    
 private void groupButton()
 {
     ButtonGroup bg = new ButtonGroup();
     bg.add(jRadioButton1);
     bg.add(jRadioButton2);
 }
 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

  
    	
        jLabel6 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jTextField4 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        
       // l1=new javax.swing.JLabel("Your order is placed. It will be delivered by  "+LocalDate.now().plusDays(5));

        jLabel6.setText("jLabel6");

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setText("DATE");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 230, 47, 30);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setText("TIME");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(380, 230, 48, 30);

        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setText("PAY");
        jButton2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        
        //l1.setBounds(100, 600, 300, 30);
        getContentPane().add(jButton2);
        jButton2.setBounds(210, 520, 124, 51);
        getContentPane().add(jTextField4);
        jTextField4.setBounds(260, 330, 100, 31);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jRadioButton1.setText("CASH ON DELIVERY");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1);
        jRadioButton1.setBounds(220, 400, 200, 41);

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jRadioButton2.setText("NETBANKING");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton2);
        jRadioButton2.setBounds(440, 400, 129, 41);

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField5);
        jTextField5.setBounds(100, 230, 100, 30);

        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField6);
        jTextField6.setBounds(450, 230, 100, 30);

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setText("<html>\n<center>THANKYOU FOR SHOPPING AT</center><br>\n TECH SHOP\n<html>");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(130, 70, 322, 51);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setText("<html>\n1F/34,NIT NO.1,FARIDABAD<br><br>\n<center>0129-5498342</center>\n</html>");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(200, 140, 184, 51);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("TOTAL AMOUNT");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(100, 330, 125, 31);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("MODE OF PAYMENT");
        getContentPane().add(jLabel4);
       // getContentPane().add(l1);
        jLabel4.setBounds(30, 410, 139, 17);

   //     jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/login/IMAGES/OnlinePayment.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 570, 850);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
    	if(!(jRadioButton1.isSelected() || jRadioButton2.isSelected())){
    		 JOptionPane.showMessageDialog(rootPane,"Please select a mode of payment.");
    	}
    	else{
    		 if(jRadioButton1.isSelected())
    	      {
    	        JOptionPane.showMessageDialog(rootPane,"PAYMENT OF  Rs. '"+jTextField4.getText()+"' IS MADE THROUGH CASH\n"
    	        		+ "Your order is placed. It will be delivered by  "+LocalDate.now().plusDays(5));
    	         
    	      }
    	       if(jRadioButton2.isSelected())
    	      {
    	        JOptionPane.showMessageDialog(rootPane,"PAYMENT OF  Rs. '"+jTextField4.getText()+"' IS MADE THROUGH NETBANKING\n"
    	        		+ "Your order is placed. It will be delivered by  "+LocalDate.now().plusDays(5));
    	         
    	      }
    	       this.setVisible(false);
    	       new thnx();
    	}
     
 //     THANKYOU_PAGE t = new THANKYOU_PAGE();
  //    t.setVisible(true);
      
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BILL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BILL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BILL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BILL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new BILL().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel l1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables

  
}
