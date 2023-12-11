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
    String password;

    public UserSessionRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // gettter and setter
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
    
}
