/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.authen;

/**
 *
 * @author lxsgo
 */
public class UserSessionRequest {
    String username;
    String hashedPassword;

    public UserSessionRequest(String username, String hashedPassword) {
        this.username = username;
        this.hashedPassword = hashedPassword;
    }

    // gettter and setter
    public String getUsername() {
        return username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }
    
}
