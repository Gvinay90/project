/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.BorderLayout;
import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import jdk.nashorn.internal.runtime.regexp.joni.constants.CCVALTYPE;
import net.proteanit.sql.DbUtils;
/**
 *
 * @author Lenovo
 */
public class VIEWUSERDETAILS extends javax.swing.JFrame {

    /**
     * Creates new form VIEWUSERDETAILS
     */
    public VIEWUSERDETAILS() {
        initComponents();
        displaytable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
     private void displaytable()
    {
        try{
          Class.forName("com.mysql.jdbc.Driver");
          Connection conn =DriverManager.getConnection("jdbc:mysql://Localhost:3306/tapms","vinay","vinay");
          String sql="select erpno,name,lname,dept,apointer,skills,emailid,Category from studentinfo";
          PreparedStatement psmt=conn.prepareStatement(sql);
          ResultSet rs=psmt.executeQuery();
          table_studentdetails.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
           
       }
          
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table_studentdetails = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setText("STUDENT DETAILS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));

        table_studentdetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ERP No", "Name", "Dept", "skills", "Emailid"
            }
        ));
        jScrollPane1.setViewportView(table_studentdetails);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(93, 60, 1060, 588));

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 12, -1, -1));

        jButton2.setText("File");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 670, 70, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
TPOLOGIN m=new TPOLOGIN();
       m.setVisible(true);
        setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    try{
            PrintWriter pw=new PrintWriter(new File("/home/vinay/Desktop/Detail.csv"));
            StringBuilder sb=new StringBuilder();
          Class.forName("com.mysql.jdbc.Driver");
          Connection conn =DriverManager.getConnection("jdbc:mysql://Localhost:3306/tapms","vinay","vinay");
          String sql="select erpno,name,mname,lname,gender,emailid,phoneno,dob,skills,SSC,HSC,FE,SE,TE,apointer,Backlog,Category from studentinfo;";
          PreparedStatement psmt=conn.prepareStatement(sql);
          ResultSet rs=psmt.executeQuery();
          while(rs.next())
          {
              sb.append(rs.getString("erpno"));
              sb.append(",");
              sb.append(rs.getString("name"));
              sb.append(",");
              sb.append(rs.getString("mname"));
              sb.append(",");
              sb.append(rs.getString("lname"));
              sb.append(",");
              sb.append(rs.getString("gender"));
              sb.append(",");
              sb.append(rs.getString("emailid"));
              sb.append(",");
              sb.append(rs.getString("phoneno"));
              sb.append(",");
              sb.append(rs.getString("dob"));
              sb.append(",");
              sb.append(rs.getString("SSC"));
              sb.append(",");
              sb.append(rs.getString("HSC"));
              sb.append(",");
              sb.append(rs.getString("FE"));
              sb.append(",");
              sb.append(rs.getString("SE"));
              sb.append(",");
              sb.append(rs.getString("TE"));
              sb.append(",");
              sb.append(rs.getString("apointer"));
              sb.append(",");
              sb.append(rs.getString("Backlog"));
              sb.append(",");
              sb.append(rs.getString("Category"));
              sb.append("\r\n");
          }
          pw.write(sb.toString());
          pw.close();
          JOptionPane.showMessageDialog(null,"File Generated");
          
        }
        catch(Exception e){
           JOptionPane.showMessageDialog(null, e);
           
       }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(VIEWUSERDETAILS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VIEWUSERDETAILS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VIEWUSERDETAILS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VIEWUSERDETAILS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VIEWUSERDETAILS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_studentdetails;
    // End of variables declaration//GEN-END:variables
}
