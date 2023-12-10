/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.kma.sms.ui;

import java.util.List;
import com.kma.sms.controller.SubjectManagePanelController;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author lxsgo
 */
public class SubjectManagePanel extends javax.swing.JPanel {

    /**
     * Creates new form SubjectManagePanel
     */
    public SubjectManagePanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        subjectIdInput = new javax.swing.JTextField();
        subjectNameInput = new javax.swing.JTextField();
        majorIdInput = new javax.swing.JComboBox<>();
        subjectIdLabel = new javax.swing.JLabel();
        majorIdLabel = new javax.swing.JLabel();
        subjectNameLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        subjectTable = new javax.swing.JTable();
        searchSubjectButton = new javax.swing.JButton();
        creditsLabel = new javax.swing.JLabel();
        creditsInput = new javax.swing.JTextField();

        subjectIdInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectIdInputActionPerformed(evt);
            }
        });

        subjectNameInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectNameInputActionPerformed(evt);
            }
        });

        majorIdInput.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "CB", "AT", "CT", "DT" }));
        majorIdInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                majorIdInputActionPerformed(evt);
            }
        });

        subjectIdLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        subjectIdLabel.setText("Mã học phần :");

        majorIdLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        majorIdLabel.setText("Mã ngành :");
        majorIdLabel.setToolTipText("");

        subjectNameLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        subjectNameLabel.setText("Mã học phần :");

        subjectTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã học phần", "Mã ngành", "Tên học phần", "Số tín chỉ"
            }
        ));
        jScrollPane1.setViewportView(subjectTable);

        searchSubjectButton.setBackground(new java.awt.Color(204, 255, 255));
        searchSubjectButton.setText("Search");
        searchSubjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchSubjectButtonActionPerformed(evt);
            }
        });

        creditsLabel.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        creditsLabel.setText("Số TC :");

        creditsInput.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        creditsInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                creditsInputActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(subjectIdLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subjectIdInput, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(majorIdLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(majorIdInput, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(subjectNameLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subjectNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(creditsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(creditsInput, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(searchSubjectButton)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(subjectIdLabel)
                    .addComponent(majorIdLabel)
                    .addComponent(majorIdInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subjectNameLabel)
                    .addComponent(subjectNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(subjectIdInput)
                    .addComponent(searchSubjectButton)
                    .addComponent(creditsLabel)
                    .addComponent(creditsInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 498, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void subjectNameInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectNameInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectNameInputActionPerformed

    private void majorIdInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_majorIdInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_majorIdInputActionPerformed

    private void subjectIdInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectIdInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_subjectIdInputActionPerformed

    private void searchSubjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchSubjectButtonActionPerformed
        
        String subjectId = subjectIdInput.getText();
        String majorId = majorIdInput.getSelectedItem().toString();
        String subjectName = subjectNameInput.getText();
        String credits = creditsInput.getText();
        
        System.out.println(subjectId);
        System.out.println(majorId);
        System.out.println(subjectName);
        System.out.println(credits);
        
        List<List<String>> result = SubjectManagePanelController.getSubjectListString(subjectId,majorId,subjectName,credits);
        DefaultTableModel model = (DefaultTableModel) subjectTable.getModel();
        model.setRowCount(result.size());
        for (int i = 0; i < result.size(); i++) {
            List<String> subjectString = result.get(i);
            // Display order number
            subjectString.add(0, Integer.toString(i + 1));
            for (int j = 0; j < subjectString.size(); j++) {
                subjectTable.setValueAt(subjectString.get(j), i, j);
            }
        }
    }//GEN-LAST:event_searchSubjectButtonActionPerformed

    private void creditsInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_creditsInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_creditsInputActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField creditsInput;
    private javax.swing.JLabel creditsLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> majorIdInput;
    private javax.swing.JLabel majorIdLabel;
    private javax.swing.JButton searchSubjectButton;
    private javax.swing.JTextField subjectIdInput;
    private javax.swing.JLabel subjectIdLabel;
    private javax.swing.JTextField subjectNameInput;
    private javax.swing.JLabel subjectNameLabel;
    private javax.swing.JTable subjectTable;
    // End of variables declaration//GEN-END:variables
}
