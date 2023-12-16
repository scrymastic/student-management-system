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
    public static Boolean isAdmin;

    public static Boolean getIsAdmin() {
        return isAdmin;
    }

    public static void setIsAdmin(Boolean isAdmin) {
        UserSession.isAdmin = isAdmin;
    }
}
