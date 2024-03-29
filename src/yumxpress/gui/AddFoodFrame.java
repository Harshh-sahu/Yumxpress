/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package yumxpress.gui;

import java.awt.Image;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import yumxpress.dao.ProductDAO;
import yumxpress.pojo.ProductPojo;
import yumxpress.util.OwnerProfile;
import yumxpress.util.SpoonacularAPI;

/**
 *
 * @author harsh
 */
public class AddFoodFrame extends javax.swing.JFrame {

    private List<ProductPojo> foodList;
    private int foodIndex = 0;
    private ProductPojo product;

    /**
     * Creates new form AddFoodFrame
     */
    public AddFoodFrame() {

        initComponents();
        this.lblOwneProfile.setText("Hello " + OwnerProfile.getOwnerame());
        setLocationRelativeTo(null);
        clearAll();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnAddStaff = new javax.swing.JButton();
        txtViewFood = new javax.swing.JButton();
        btnViewStaff = new javax.swing.JButton();
        SellerOptionFramebtn = new javax.swing.JButton();
        btnorderlist = new javax.swing.JButton();
        lblOwneProfile = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        btnSearchFood = new javax.swing.JButton();
        btnAddItem = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSearchFood = new javax.swing.JTextField();
        txtFoodName = new javax.swing.JTextField();
        lblBack = new javax.swing.JLabel();
        lblNext = new javax.swing.JLabel();
        lblFoodImage = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtFoodPrice = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Add Food Frame");

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("______________");
        jLabel1.setToolTipText("");
        jLabel1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yumxpress/icons/user.png"))); // NOI18N

        btnAddStaff.setBackground(new java.awt.Color(102, 255, 102));
        btnAddStaff.setFont(new java.awt.Font("Stencil", 1, 16)); // NOI18N
        btnAddStaff.setForeground(new java.awt.Color(51, 51, 51));
        btnAddStaff.setText("ADD Staff");
        btnAddStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStaffActionPerformed(evt);
            }
        });

        txtViewFood.setBackground(new java.awt.Color(102, 255, 102));
        txtViewFood.setFont(new java.awt.Font("Stencil", 1, 16)); // NOI18N
        txtViewFood.setForeground(new java.awt.Color(51, 51, 51));
        txtViewFood.setText("view food");
        txtViewFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtViewFoodActionPerformed(evt);
            }
        });

        btnViewStaff.setBackground(new java.awt.Color(102, 255, 102));
        btnViewStaff.setFont(new java.awt.Font("Stencil", 1, 16)); // NOI18N
        btnViewStaff.setForeground(new java.awt.Color(51, 51, 51));
        btnViewStaff.setText("view staff");
        btnViewStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewStaffActionPerformed(evt);
            }
        });

        SellerOptionFramebtn.setBackground(new java.awt.Color(255, 0, 51));
        SellerOptionFramebtn.setFont(new java.awt.Font("Stencil", 1, 13)); // NOI18N
        SellerOptionFramebtn.setForeground(new java.awt.Color(51, 51, 51));
        SellerOptionFramebtn.setText("Back");
        SellerOptionFramebtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SellerOptionFramebtnActionPerformed(evt);
            }
        });

        btnorderlist.setBackground(new java.awt.Color(102, 255, 102));
        btnorderlist.setFont(new java.awt.Font("Stencil", 1, 16)); // NOI18N
        btnorderlist.setForeground(new java.awt.Color(51, 51, 51));
        btnorderlist.setText("order list");
        btnorderlist.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnorderlistActionPerformed(evt);
            }
        });

        lblOwneProfile.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblOwneProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(58, 58, 58)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(76, 76, 76)
                                .addComponent(SellerOptionFramebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lblOwneProfile, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAddStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtViewFood, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnorderlist, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                        .addComponent(btnViewStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(40, 40, 40)
                .addComponent(lblOwneProfile, javax.swing.GroupLayout.DEFAULT_SIZE, 51, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnAddStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(txtViewFood, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btnViewStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(btnorderlist, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(SellerOptionFramebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 255));
        jLabel4.setText("Add Food Item");

        btnSearchFood.setBackground(new java.awt.Color(102, 255, 102));
        btnSearchFood.setFont(new java.awt.Font("Stencil", 0, 14)); // NOI18N
        btnSearchFood.setText("Search");
        btnSearchFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchFoodActionPerformed(evt);
            }
        });

        btnAddItem.setBackground(new java.awt.Color(102, 255, 102));
        btnAddItem.setFont(new java.awt.Font("Perpetua Titling MT", 1, 14)); // NOI18N
        btnAddItem.setText("Add Item");
        btnAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddItemActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 255));
        jLabel5.setText("Search Food :");

        jLabel6.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 255));
        jLabel6.setText("Food Name :");

        jLabel7.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 255));
        jLabel7.setText("Food Image :");

        txtSearchFood.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtSearchFood.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchFoodActionPerformed(evt);
            }
        });

        txtFoodName.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N

        lblBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yumxpress/icons/icons8-left-arrow-64.png"))); // NOI18N
        lblBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblBackMouseClicked(evt);
            }
        });

        lblNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yumxpress/icons/icons8-right-arrow-64 (1).png"))); // NOI18N
        lblNext.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNextMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 255));
        jLabel11.setText("Enter Price :");

        txtFoodPrice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFoodPriceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(62, 62, 62)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtSearchFood, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSearchFood, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(lblBack)
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(txtFoodPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(155, 155, 155))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(lblFoodImage, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblNext)
                        .addGap(30, 30, 30))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(289, 289, 289)
                        .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel4)
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtSearchFood)
                        .addGap(11, 11, 11)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFoodName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(btnSearchFood, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(lblBack))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(lblNext))
                    .addComponent(lblFoodImage, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtFoodPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(39, 39, 39)
                .addComponent(btnAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStaffActionPerformed
        // TODO add your handling code here:

        AddDeliveryStaffFrame AddFood = new AddDeliveryStaffFrame();
        AddFood.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_btnAddStaffActionPerformed

    private void btnAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddItemActionPerformed
        // TODO add your handling code here:

        if (!validateInputs()) {
            JOptionPane.showMessageDialog(null, "Please fill all the data");
            return;
        }
        try {
            double price = Double.parseDouble(txtFoodPrice.getText().trim());
            product.setCompnayId(OwnerProfile.getCompnayId());

            product.setProductName(txtFoodName.getText().trim());
            product.setProductPrice(price);
            boolean result = ProductDAO.addProduct(product);
            if (result == false) {
                JOptionPane.showMessageDialog(null, "Cannot add the product");
                return;
            }
            JOptionPane.showMessageDialog(null, "Product successfully added");
            foodList.remove(foodIndex);
            if (foodList.isEmpty()) {
                JOptionPane.showMessageDialog(null, "All varities of " + txtSearchFood.getText().trim() + " added");
                clearAll();
                return;
            }
            foodIndex = 0;
            showFoodDetailsByIndex(foodIndex);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Exception in DB in AddFoodFrame");
            ex.printStackTrace();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please input numeric value for price");
            ex.printStackTrace();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Exception in DAO Image Processing in AddFoodFrame");
            ex.printStackTrace();
        }
    }//GEN-LAST:event_btnAddItemActionPerformed

    private void txtSearchFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchFoodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchFoodActionPerformed

    private void txtFoodPriceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFoodPriceActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFoodPriceActionPerformed

    private void btnSearchFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchFoodActionPerformed
        // TODO add your ha  ndling code here:
        String searchFood = txtSearchFood.getText().trim();
        if (searchFood.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please type a food name");
            return;
        }
        try {
            searchFood = searchFood.replaceAll(" ", "-");
            foodList = SpoonacularAPI.getAllItemDetailsByName(searchFood);
            if (foodList.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No food details for " + searchFood + " found");
                return;
            }

            lblNext.setEnabled(true);
            lblBack.setEnabled(true);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Exception while using API");
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnSearchFoodActionPerformed

    private void lblNextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNextMouseClicked
        // TODO add your handling code here:
        foodIndex++;
        if (foodIndex >= foodList.size()) {
            foodIndex = 0;
        }
        showFoodDetailsByIndex(foodIndex);


    }//GEN-LAST:event_lblNextMouseClicked

    private void lblBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblBackMouseClicked
        // TODO add your handling code here:
        foodIndex--;
        if (foodIndex < 0) {
            foodIndex = foodList.size() - 1;
        }
        showFoodDetailsByIndex(foodIndex);


    }//GEN-LAST:event_lblBackMouseClicked

    private void txtViewFoodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtViewFoodActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        ViewFoodFrame foodFrame = new ViewFoodFrame();
        foodFrame.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_txtViewFoodActionPerformed

    private void btnViewStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewStaffActionPerformed
        // TODO add your handling code here:

        ViewDeliveryStaffFrame viewFood = new ViewDeliveryStaffFrame();
        viewFood.setVisible(true);
        this.dispose();


    }//GEN-LAST:event_btnViewStaffActionPerformed

    private void SellerOptionFramebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SellerOptionFramebtnActionPerformed
        // TODO add your handling code here:

        SellerOptionFrame SellerOption = new SellerOptionFrame();
        SellerOption.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_SellerOptionFramebtnActionPerformed

    private void btnorderlistActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnorderlistActionPerformed
        // TODO add your handling code here:

        OrderListFrame orde = new OrderListFrame();
        orde.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnorderlistActionPerformed

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
            java.util.logging.Logger.getLogger(AddFoodFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFoodFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFoodFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFoodFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFoodFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SellerOptionFramebtn;
    private javax.swing.JButton btnAddItem;
    private javax.swing.JButton btnAddStaff;
    private javax.swing.JButton btnSearchFood;
    private javax.swing.JButton btnViewStaff;
    private javax.swing.JButton btnorderlist;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblBack;
    private javax.swing.JLabel lblFoodImage;
    private javax.swing.JLabel lblNext;
    private javax.swing.JLabel lblOwneProfile;
    private javax.swing.JTextField txtFoodName;
    private javax.swing.JTextField txtFoodPrice;
    private javax.swing.JTextField txtSearchFood;
    private javax.swing.JButton txtViewFood;
    // End of variables declaration//GEN-END:variables

    private void showFoodDetailsByIndex(int foodIndex) {
        product = foodList.get(foodIndex);
        String foodName = product.getProductName();
        if (foodName.length() >= 50) {
            foodName = foodName.substring(0, 45) + "...";
        }
        txtFoodName.setText(foodName);
        Image img = product.getProductImage();
        img = img.getScaledInstance(lblFoodImage.getWidth(), lblFoodImage.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon icon = new ImageIcon(img);
        lblFoodImage.setIcon(icon);

    }

    private boolean validateInputs() {
        if (txtFoodName.getText().trim().isEmpty() || txtFoodPrice.getText().trim().isEmpty() || lblFoodImage.getIcon() == null) {
            return false;
        }
        return true;

    }

    private void clearAll() {

        txtFoodName.setText("");
        txtFoodPrice.setText("");
        txtSearchFood.setText("");
        lblFoodImage.setIcon(null);
        lblNext.setEnabled(false);
        lblBack.setEnabled(false);
        txtSearchFood.requestFocus();
    }
}
