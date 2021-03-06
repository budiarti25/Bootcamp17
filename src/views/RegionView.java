/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;
import controller.RegionController;
import entities.Region;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tools.MyConnection;

/**
 *
 * @author budiarti
 */
public class RegionView extends javax.swing.JInternalFrame {

    private RegionController regionController;
    /**
     * Creates new form RegionView
     */
    public RegionView() {
        initComponents();
        this.regionController=new RegionController(new MyConnection().getConnection());
        bindingTable();
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableRegion = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        regionId = new javax.swing.JTextField();
        regionName = new javax.swing.JTextField();
        btndrop = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btnsave = new javax.swing.JButton();
        cmbCategory = new javax.swing.JComboBox();
        data = new javax.swing.JTextField();
        btnfind = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Regions");

        tableRegion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tableRegion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableRegionMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableRegion);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Region Details"));

        jLabel1.setText("Region Id");

        jLabel2.setText("Region Name");

        regionName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regionNameActionPerformed(evt);
            }
        });

        btndrop.setText("Drop");
        btndrop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndropActionPerformed(evt);
            }
        });

        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });

        btnsave.setText("Save");
        btnsave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(regionId)
                            .addComponent(regionName, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(btndrop)
                        .addGap(18, 18, 18)
                        .addComponent(btnedit)
                        .addGap(18, 18, 18)
                        .addComponent(btnsave)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(regionId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(regionName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndrop)
                    .addComponent(btnedit)
                    .addComponent(btnsave))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        cmbCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "region_id", "region_name" }));

        btnfind.setText("Find");
        btnfind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnfindActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnfind)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(data, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnfind))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void regionNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regionNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_regionNameActionPerformed

    private void btnsaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveActionPerformed
         boolean flag=this.regionController.save(regionId.getText(), regionName.getText());
         String message="Failed to save data...";
         if(flag){
             message="Success to save data...";
         }
         JOptionPane.showMessageDialog(this, message, "Notifications", JOptionPane.INFORMATION_MESSAGE);
        bindingTable();
        reset();
    }//GEN-LAST:event_btnsaveActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        boolean flag = this.regionController.edit(regionId.getText(), regionName.getText());
        String message="Failed to update data...";
         if(flag){
             message="Success to update data...";
         }
         JOptionPane.showMessageDialog(this, message, "Notifications", JOptionPane.INFORMATION_MESSAGE);
         bindingTable();
         reset();
    }//GEN-LAST:event_btneditActionPerformed

    private void btndropActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndropActionPerformed
        String message="Failed to delete data...";
        int flag=JOptionPane.showConfirmDialog(this, "Rellay", "Are You Sure", JOptionPane.YES_NO_OPTION);
        if(flag==0){
            if(this.regionController.drop(Integer.parseInt(regionId.getText()))){
             message="Success to delete data...";
         }
         JOptionPane.showMessageDialog(this, message, "Notifications", JOptionPane.INFORMATION_MESSAGE);
        }
         
         bindingTable();
         reset();
    }//GEN-LAST:event_btndropActionPerformed

    private void tableRegionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableRegionMouseClicked
        int row = tableRegion.getSelectedRow();
        regionId.setText(tableRegion.getValueAt(row, 0).toString());
        regionName.setText(tableRegion.getValueAt(row, 1).toString());
        bindingTable();
    }//GEN-LAST:event_tableRegionMouseClicked

    private void btnfindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnfindActionPerformed
        String category= cmbCategory.getSelectedItem().toString();
        String data1=data.getText();
        search(category, data1);
    }//GEN-LAST:event_btnfindActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btndrop;
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btnfind;
    private javax.swing.JButton btnsave;
    private javax.swing.JComboBox cmbCategory;
    private javax.swing.JTextField data;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField regionId;
    private javax.swing.JTextField regionName;
    private javax.swing.JTable tableRegion;
    // End of variables declaration//GEN-END:variables

   public void bindingTable(){
       String[] header={"Region Id","Region Name"};
       DefaultTableModel defaultTableModel = new DefaultTableModel(header, 0);
      for (Region region : regionController.binding()) {
//       for (Region binding : regionController.binding("region_id","asc")) {
           Object[] region1 ={
                   region.getRegionId(),region.getRegionName()
                   };
           defaultTableModel.addRow(region1);
       }
      tableRegion.setModel(defaultTableModel);
   }
   public void search(String category, String data){
       String[] header={"Region Id","Region Name"};
       DefaultTableModel defaultTableModel = new DefaultTableModel(header, 0);
      for (Region region : regionController.find(category,data)) {
           Object[] region1 ={
                   region.getRegionId(),region.getRegionName()
                   };
           defaultTableModel.addRow(region1);
       }
      tableRegion.setModel(defaultTableModel);
   }
   
   public void reset(){
       regionId.setText("");
       regionName.setText("");
       data.setText("");
   }
}
