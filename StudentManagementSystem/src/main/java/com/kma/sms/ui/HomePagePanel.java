/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package com.kma.sms.ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RadialGradientPaint;
import java.awt.RenderingHints;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.swing.ImageIcon;

/**
 *
 * @author lxsgo
 */
public class HomePagePanel extends javax.swing.JPanel {

    private ImageIcon imageIcon;

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2d = (Graphics2D) grphcs;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Load the properties file
        Properties prop = new Properties();
        try (InputStream input = new FileInputStream("src/main/resources/background.properties")) {
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        // Extract and parse the color values
        Color[] colors = new Color[3];
        String[] colorStrings = prop.getProperty("colors_set_5").split(", "); // Change this to use different color sets
        for (int i = 0; i < colorStrings.length; i++) {
            colors[i] = Color.decode(colorStrings[i]);
        }

        int diameter = Math.max(getWidth(), getHeight());
        float radius = diameter * 1.0f; // Increase the radius
        float[] dist = { 0.0f, 0.5f, 1.0f };
        RadialGradientPaint rgp = new RadialGradientPaint(getWidth() - 50, getHeight() - 50, radius, dist, colors);

        g2d.setPaint(rgp);
        g2d.fillRect(0, 0, getWidth(), getHeight());

        // Draw the image
        Image image = imageIcon.getImage();
        // Show at center
        int x = (getWidth() - image.getWidth(null)) / 2;
        int y = (getHeight() - image.getHeight(null)) / 2;
        g2d.drawImage(image, 11, 11, getHeight() / 2, getHeight() / 2, null);
    }

    /**
     * Creates new form HomePage
     */
    public HomePagePanel() {
        initComponents();
        imageIcon = new ImageIcon("src/main/resources/images/yelling-cat.png");
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(500, 540));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Tác giả:");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("LÊ XUÂN SƠN - TRẦN VĂN LONG - NGUYỄN DUY VƯỢNG");
        jLabel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(300, 300, 300)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(178, 178, 178))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(80, 80, 80)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addContainerGap(416, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
