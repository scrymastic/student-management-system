/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.authen;


/**
 *
 * @author author's_name_goes_here
 */
public class UserSession {
    public static UserSession userSession;
    String username;
    String password;
    Boolean isAdmin = false;
    
    public UserSession(String username, String password) {
        this.username = username;
        this.password = password;
    }



}
