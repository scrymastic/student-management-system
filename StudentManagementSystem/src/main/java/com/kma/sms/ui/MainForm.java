/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package com.kma.sms.ui;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 *
 * @author lxsgo
 */
public class MainForm extends javax.swing.JFrame {

    /* Card layout */
    private void initCardLayout() {
        CardLayout cardLayout = new CardLayout();
        contentPanel.setLayout(cardLayout);
        // contentPanel.add(new HomePagePanel(), "homePagePanel");
        // contentPanel.add(new DepartmentDirPanel(), "departmentDirPanel");
        contentPanel.add(new ClassManagePanel(), "classManagePanel");
        contentPanel.add(new SubjectManagePanel(), "subjectManagePanel");
        contentPanel.add(new StudentManagePanel(), "studentManagePanel");
        contentPanel.add(new ScoreManagePanel(), "scoreManagePanel");
        // cardLayout.show(contentPanel, "homePagePanel");

        // always fit the content panel to the parent panel
        this.pack();
        contentPanel.revalidate();
    }


    /** Creates new form MainForm */
    public MainForm() {
        initComponents();
        initCardLayout();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        headerPanel = new javax.swing.JPanel();
        naviPanel = new javax.swing.JPanel();
        homePageNaviButton = new javax.swing.JButton();
        departmentDirNaviButton = new javax.swing.JButton();
        classDirNaviButton = new javax.swing.JButton();
        subjectManageNaviButton = new javax.swing.JButton();
        studentManageNaviButton = new javax.swing.JButton();
        scoreMangeNaviButton = new javax.swing.JButton();
        contentPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout headerPanelLayout = new javax.swing.GroupLayout(headerPanel);
        headerPanel.setLayout(headerPanelLayout);
        headerPanelLayout.setHorizontalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        headerPanelLayout.setVerticalGroup(
            headerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 125, Short.MAX_VALUE)
        );

        homePageNaviButton.setBackground(new java.awt.Color(51, 153, 255));
        homePageNaviButton.setText("Trang chủ");

        departmentDirNaviButton.setBackground(new java.awt.Color(51, 153, 255));
        departmentDirNaviButton.setText("Danh mục khoa");
        departmentDirNaviButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentDirNaviButtonActionPerformed(evt);
            }
        });

        classDirNaviButton.setBackground(new java.awt.Color(51, 153, 255));
        classDirNaviButton.setText("Danh mục lớp");
        classDirNaviButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                classDirNaviButtonActionPerformed(evt);
            }
        });

        subjectManageNaviButton.setBackground(new java.awt.Color(51, 153, 255));
        subjectManageNaviButton.setText("Quản lý môn");
        subjectManageNaviButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectManageNaviButtonActionPerformed(evt);
            }
        });

        studentManageNaviButton.setBackground(new java.awt.Color(51, 153, 255));
        studentManageNaviButton.setText("Quản lý sv");
        studentManageNaviButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentManageNaviButtonActionPerformed(evt);
            }
        });

        scoreMangeNaviButton.setBackground(new java.awt.Color(51, 153, 255));
        scoreMangeNaviButton.setText("Quản lý điểm");
        scoreMangeNaviButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreMangeNaviButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout naviPanelLayout = new javax.swing.GroupLayout(naviPanel);
        naviPanel.setLayout(naviPanelLayout);
        naviPanelLayout.setHorizontalGroup(
            naviPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(homePageNaviButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(departmentDirNaviButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(classDirNaviButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(subjectManageNaviButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(studentManageNaviButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scoreMangeNaviButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        naviPanelLayout.setVerticalGroup(
            naviPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(naviPanelLayout.createSequentialGroup()
                .addComponent(homePageNaviButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(departmentDirNaviButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(classDirNaviButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(subjectManageNaviButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(studentManageNaviButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(scoreMangeNaviButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        contentPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                contentPanelComponentResized(evt);
            }
        });

        javax.swing.GroupLayout contentPanelLayout = new javax.swing.GroupLayout(contentPanel);
        contentPanel.setLayout(contentPanelLayout);
        contentPanelLayout.setHorizontalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        contentPanelLayout.setVerticalGroup(
            contentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 283, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(headerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(naviPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(headerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(naviPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void departmentDirNaviButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentDirNaviButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departmentDirNaviButtonActionPerformed

    private void classDirNaviButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_classDirNaviButtonActionPerformed
        // Show class manage panel and hide other panels
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
        cardLayout.show(contentPanel, "classManagePanel");

        
    }//GEN-LAST:event_classDirNaviButtonActionPerformed

    private void subjectManageNaviButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectManageNaviButtonActionPerformed
        // Show subject manage panel and hide other panels
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
        cardLayout.show(contentPanel, "subjectManagePanel");

    }//GEN-LAST:event_subjectManageNaviButtonActionPerformed

    private void studentManageNaviButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentManageNaviButtonActionPerformed
        // show student manage panel and hide other panels
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
        cardLayout.show(contentPanel, "studentManagePanel");

    }//GEN-LAST:event_studentManageNaviButtonActionPerformed

    private void scoreMangeNaviButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoreMangeNaviButtonActionPerformed
        // show score manage panel and hide other panels
        CardLayout cardLayout = (CardLayout) contentPanel.getLayout();
        cardLayout.show(contentPanel, "scoreManagePanel");
        
    }//GEN-LAST:event_scoreMangeNaviButtonActionPerformed

    private void contentPanelComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_contentPanelComponentResized


    }//GEN-LAST:event_contentPanelComponentResized

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
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                    
                MainForm mainForm = new MainForm();
                mainForm.setLocationRelativeTo(null);

                mainForm.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton classDirNaviButton;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JButton departmentDirNaviButton;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JButton homePageNaviButton;
    private javax.swing.JPanel naviPanel;
    private javax.swing.JButton scoreMangeNaviButton;
    private javax.swing.JButton studentManageNaviButton;
    private javax.swing.JButton subjectManageNaviButton;
    // End of variables declaration//GEN-END:variables

}
