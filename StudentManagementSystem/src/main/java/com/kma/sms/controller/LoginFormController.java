/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.controller;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
        // hash password using SHA-256
        String hashedPassword = "";
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            hashedPassword = String.format("%064x", new BigInteger(1, hash));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        UserSessionRequest userSessionRequest = new UserSessionRequest(username, hashedPassword);
        int result = UserDAO.login(userSessionRequest);
        return result;
    }
}
