/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.kma.sms.ui;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import com.kma.sms.controller.StudentManagePanelController;

/**
 *
 * @author lxsgo
 */
public class StudentManagePanel extends javax.swing.JPanel {

    /**
     * Creates new form StudentManagePanel
     */
    public StudentManagePanel() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        studentIdInput = new javax.swing.JTextField();
        classIdInput = new javax.swing.JTextField();
        studentNameInput = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentTable = new javax.swing.JTable();
        studentIdlabel = new javax.swing.JLabel();
        classIdLabel = new javax.swing.JLabel();
        studentNameLabel = new javax.swing.JLabel();
        searchStudentButton = new javax.swing.JButton();

        classIdInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classIdInputActionPerformed(evt);
            }
        });

        studentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã sv", "Mã lớp", "Họ tên", "Ngày sinh", "Giới tính", "Địa chỉ", "SĐT"
            }
        ));
        jScrollPane1.setViewportView(studentTable);

        studentIdlabel.setText("Mã sv:");

        classIdLabel.setText("Mã lớp:");

        studentNameLabel.setText("Họ tên:");

        searchStudentButton.setText("Search");
        searchStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchStudentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(classIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(studentIdlabel, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(studentNameLabel, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(studentIdInput)
                            .addComponent(classIdInput)
                            .addComponent(studentNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(searchStudentButton)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchStudentButton)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentIdInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentIdlabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classIdInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classIdLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentNameInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studentNameLabel))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 246, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void searchStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_searchStudentButtonActionPerformed

        // Get input
        String studentId = studentIdInput.getText();
        String classId = classIdInput.getText();
        String studentName = studentNameInput.getText();


        // Get result
        List<List<String>> result = StudentManagePanelController.getStudentListString(studentId, classId, studentName,
                "", "", "", "", "");
        // Set table row count
        DefaultTableModel model = (DefaultTableModel) studentTable.getModel();
        model.setRowCount(result.size());

        // Display result
        for (int i = 0; i < result.size(); i++) {
            List<String> studentString = result.get(i);
            // Display order number
            studentString.add(0, Integer.toString(i + 1));
            for (int j = 0; j < studentString.size(); j++) {
                studentTable.setValueAt(studentString.get(j), i, j);
            }
        }

    }// GEN-LAST:event_searchStudentButtonActionPerformed

    private void classIdInputActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_classIdInputActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_classIdInputActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField classIdInput;
    private javax.swing.JLabel classIdLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton searchStudentButton;
    private javax.swing.JTextField studentIdInput;
    private javax.swing.JLabel studentIdlabel;
    private javax.swing.JTextField studentNameInput;
    private javax.swing.JLabel studentNameLabel;
    private javax.swing.JTable studentTable;
    // End of variables declaration//GEN-END:variables
}
