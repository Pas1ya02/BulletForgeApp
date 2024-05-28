/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import model.MySQL;

/**
 *
 * @author Admin
 */
public class adminInvoice extends javax.swing.JPanel {
 private adminHome Home;
    /**
     * Creates new form employee
     */
    public adminInvoice(adminHome home) {
        initComponents();
        loadInvoice("");
        this.Home = home;
    }

    private void loadInvoice(String search) {
        try {

            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setRowCount(0);

            ResultSet resultSet = MySQL.execute("SELECT * FROM `invoice` "
                + "INNER JOIN `invoice_item` ON `invoice`.`invoice_item_id` = `invoice_item`.`id`"
                + "INNER JOIN `product_stock` ON `invoice_item`.`product_stock_id` = `product_stock`.`id`"
                + "INNER JOIN `customer` ON `invoice`.`customer_email` = `customer`.`email`"
                + "INNER JOIN `user` ON `invoice`.`user_email` = `user`.`email`WHERE `invoice_number` LIKE '" + search + "%'");

            while (resultSet.next()) {
                Vector v = new Vector();
                v.add(resultSet.getString("invoice_number"));
                v.add(resultSet.getString("customer.email"));
                v.add(resultSet.getString("user.email"));
                v.add(resultSet.getString("product_stock.name"));
                v.add(resultSet.getString("invoice_item.qty"));
                v.add(resultSet.getString("datetime"));
                v.add(resultSet.getString("paid_amount"));
         
                model.addRow(v);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     private void search() {

        String invoice = jTextField2.getText();
        loadInvoice(invoice);
 }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(835, 584));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(11, 9, 22));

        jTable1.setForeground(new java.awt.Color(255, 255, 255));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Invoice Number", "Customer Email", "Manager Email", "Product Name", "Qty", "Date And Time", "Paid Amount"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 122, 820, 290));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 420, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Search :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, -1, -1));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 830, 540));

        jButton6.setText("X");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        this.Home.removeinvoice();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
search();        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
