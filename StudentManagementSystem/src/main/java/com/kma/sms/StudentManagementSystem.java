/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms;
import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.ui.FlatButtonBorder;
import com.kma.sms.ui.LoginForm;


/**
 *
 * @author lxsgo
 */
public class StudentManagementSystem {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (Exception ex) {
            ex.printStackTrace(); // Print stack trace for debugging
        }
        // Show login form
        LoginForm loginForm = new LoginForm();
        // Set location of login form
        loginForm.setLocationRelativeTo(null);
        loginForm.setVisible(true);
    }
    
}

// âm thanh