/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.kma.sms.ui;

import java.util.List;

import javax.swing.DefaultBoundedRangeModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import com.kma.sms.controller.ClassManageController;


/**
 *
 * @author lxsgo
 */
public class ClassManagePanel extends javax.swing.JPanel {

    /**
     * Creates new form ClassManagePanel
     */
    public ClassManagePanel() {
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

        popupMenu = new javax.swing.JPopupMenu();
        deleteItem = new javax.swing.JMenuItem();
        classScrollPane = new javax.swing.JScrollPane();
        classTable = new javax.swing.JTable();
        footerLabel = new javax.swing.JLabel();
        classIdInput = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        majorInput = new javax.swing.JTextField();
        teacherInput = new javax.swing.JTextField();
        classIdLabel = new javax.swing.JLabel();
        majorIdLabel = new javax.swing.JLabel();
        teacherLabel = new javax.swing.JLabel();
        majorUpdate = new javax.swing.JTextField();
        classIdUpdate = new javax.swing.JTextField();
        teacherUpdate = new javax.swing.JTextField();
        updateButton = new javax.swing.JButton();
        insertButton = new javax.swing.JButton();

        deleteItem.setText("delete");
        deleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItemActionPerformed(evt);
            }
        });
        popupMenu.add(deleteItem);

        setPreferredSize(new java.awt.Dimension(500, 540));

        classTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Lớp", "Khoa", "Sĩ số", "GVCN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        classTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                classTableMouseReleased(evt);
            }
        });
        classTable.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                classTableComponentResized(evt);
            }
        });
        classScrollPane.setViewportView(classTable);

        footerLabel.setText("                        ");
        footerLabel.setEnabled(false);
        footerLabel.setFocusable(false);

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        majorInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                majorInputActionPerformed(evt);
            }
        });

        teacherInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherInputActionPerformed(evt);
            }
        });

        classIdLabel.setText("Lớp:");

        majorIdLabel.setText("Khoa:");

        teacherLabel.setText("GVCN:");

        majorUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                majorUpdateActionPerformed(evt);
            }
        });

        teacherUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherUpdateActionPerformed(evt);
            }
        });

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        insertButton.setText("Insert");
        insertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                insertButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(classScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
            .addComponent(footerLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(teacherLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
                    .addComponent(majorIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(classIdLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(majorInput)
                    .addComponent(teacherInput, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(classIdInput))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(majorUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classIdUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacherUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(insertButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(updateButton))
                .addGap(36, 36, 36))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(searchButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(searchButton)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(classIdInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(classIdLabel)
                    .addComponent(classIdUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(majorInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(majorIdLabel)
                    .addComponent(majorUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(insertButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teacherInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(teacherLabel)
                    .addComponent(teacherUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(classScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(footerLabel))
        );

        Dimension preferredSize = footerLabel.getPreferredSize();
        preferredSize.height = 30;
        footerLabel.setPreferredSize(preferredSize);
    }// </editor-fold>//GEN-END:initComponents

    private void majorInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_majorInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_majorInputActionPerformed

    private void teacherInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherInputActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teacherInputActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        updateTable();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void deleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemActionPerformed
        // Get input
        String classId = (String) classTable.getValueAt(classTable.getSelectedRow(), 1);

        // Show confirm dialog
        String warning = "<html><div style='text-align: center;'>"
                + "Bạn có chắc chắn muốn xóa lớp"
                + classId + " không?<br>"
                + "Lưu ý: Tất cả sinh viên trong lớp này sẽ bị xóa<br>"
                + "và không thể hoàn tác."
                + "</div></html>";
        int confirm = javax.swing.JOptionPane.showConfirmDialog(this, warning, "Xác nhận xóa", javax.swing.JOptionPane.YES_NO_OPTION);
        if (confirm == javax.swing.JOptionPane.NO_OPTION) {
            return;
        }

        // Get result
        String message = ClassManageController.getClassDeleteMessage(classId);

        // Show message
        javax.swing.JOptionPane.showMessageDialog(this, message);

        // Update table
        updateTable();

    }//GEN-LAST:event_deleteItemActionPerformed

    private void classTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_classTableMouseReleased
        // Show popup menu
        if (evt.isPopupTrigger()) {
            // Get coordinates of the mouse click
            int row = classTable.rowAtPoint(evt.getPoint());
            int column = classTable.columnAtPoint(evt.getPoint());

            // Select the row
            if (!classTable.isRowSelected(row)) {
                classTable.changeSelection(row, column, false, false);
            }

            // Show popup menu at the mouse click position
            popupMenu.show(classTable, evt.getX(), evt.getY());
        }
        // Update update text field
        int selectedRow = classTable.getSelectedRow();
        classIdUpdate.setText((String) classTable.getValueAt(selectedRow, 1));
        majorUpdate.setText((String) classTable.getValueAt(selectedRow, 2));
        teacherUpdate.setText((String) classTable.getValueAt(selectedRow, 4));

    }//GEN-LAST:event_classTableMouseReleased

    private void majorUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_majorUpdateActionPerformed

    }//GEN-LAST:event_majorUpdateActionPerformed

    private void teacherUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherUpdateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_teacherUpdateActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // Get input
        String classId = classIdUpdate.getText();
        // Get classId from table
        String classIdFromTable = (String) classTable.getValueAt(classTable.getSelectedRow(), 1);
        if (!classId.equals(classIdFromTable)) {
            javax.swing.JOptionPane.showMessageDialog(this, "Không thể thay đổi mã lớp");
            return;
        }
        String majorId = majorUpdate.getText();
        String teacher = teacherUpdate.getText();

        // Get result
        String message = ClassManageController.getClassUpdateMessage(classId, majorId, teacher);

        // Show message
        javax.swing.JOptionPane.showMessageDialog(this, message);

        // Update table
        updateTable();

    }//GEN-LAST:event_updateButtonActionPerformed

    private void insertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_insertButtonActionPerformed
        // Get input
        String classId = classIdUpdate.getText();
        String majorId = majorUpdate.getText();
        String teacher = teacherUpdate.getText();

        // Get result
        String message = ClassManageController.getClassAddMessage(classId, majorId, teacher);

        // Show message
        javax.swing.JOptionPane.showMessageDialog(this, message);

        // Update table
        updateTable();

    }//GEN-LAST:event_insertButtonActionPerformed

    private void classTableComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_classTableComponentResized
        // resize column width
        int width = classTable.getWidth();
        javax.swing.table.TableColumn column = null;
        // percent of width
        int colWidthPercent[] = {5, 20, 20, 20, 35};
        for (int i = 0; i < 5; i++) {
            column = classTable.getColumnModel().getColumn(i);
            column.setPreferredWidth(width * colWidthPercent[i] / 100);
        }

    }//GEN-LAST:event_classTableComponentResized

    private void updateTable() {
        // Get input
        String classId = classIdInput.getText();
        String majorId = majorInput.getText();
        String teacher = teacherInput.getText();

        // Get result
        List<List<String>> classListString = ClassManageController.getClassListString(classId, majorId, teacher);

        // Set table row count
        DefaultTableModel model = (DefaultTableModel) classTable.getModel();
        model.setRowCount(classListString.size());

        // Display result
        for (int i = 0; i < classListString.size(); i++) {
            List<String> classString = classListString.get(i);
            // for order
            classString.add(0, Integer.toString(i + 1));
            for (int j = 0; j < classString.size(); j++) {
                String classObjectStringElement = classString.get(j);
                classTable.setValueAt(classObjectStringElement, i, j);
            }
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField classIdInput;
    private javax.swing.JLabel classIdLabel;
    private javax.swing.JTextField classIdUpdate;
    private javax.swing.JScrollPane classScrollPane;
    private javax.swing.JTable classTable;
    private javax.swing.JMenuItem deleteItem;
    private javax.swing.JLabel footerLabel;
    private javax.swing.JButton insertButton;
    private javax.swing.JLabel majorIdLabel;
    private javax.swing.JTextField majorInput;
    private javax.swing.JTextField majorUpdate;
    private javax.swing.JPopupMenu popupMenu;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField teacherInput;
    private javax.swing.JLabel teacherLabel;
    private javax.swing.JTextField teacherUpdate;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
