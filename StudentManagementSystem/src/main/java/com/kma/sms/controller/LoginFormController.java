/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.controller;

import com.kma.sms.authen.UserSessionRequest;

import com.kma.sms.dao.UserDAO;

/**
 *
 * @author lxsgo
 */
public class LoginFormController {

    public static String getLoginMessage(String username, String password) {
        // Check if username and password is empty
        if (username.isEmpty() || password.isEmpty()) {
            // Return error message, align center
            return "Vui lòng nhập tên đăng nhập và mật khẩu";
        }
        
        int result = sendLoginRequestAndReceiveResponse(username, password);
        String message = "";
        switch (result) {
            case 1:
                message = "Đăng nhập thành công";
                break;
            default:
                message = "Đăng nhập thất bại";
                break;
        }
        return message;
    }

    private static int sendLoginRequestAndReceiveResponse(String username, String password) {
        UserSessionRequest userSessionRequest = new UserSessionRequest(username, password);
        int result = UserDAO.login(userSessionRequest);
        return result;
    }
}
