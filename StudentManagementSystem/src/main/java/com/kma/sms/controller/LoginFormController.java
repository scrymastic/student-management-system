/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.controller;

import com.kma.sms.authen.UserSessionRequest;
import com.kma.sms.authen.UserSession;
import com.kma.sms.dao.UserDAO;

/**
 *
 * @author lxsgo
 */
public class LoginFormController {

    public static int loginRequest(String username, String password) {
        UserSessionRequest userSessionRequest = new UserSessionRequest(username, password);
        return 0;
    }
    
}
