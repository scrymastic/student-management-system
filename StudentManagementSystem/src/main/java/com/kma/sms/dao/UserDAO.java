/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.kma.sms.authen.UserSession;
import com.kma.sms.authen.UserSessionRequest;
import com.kma.sms.util.DatabaseConnection;
/**
 *
 * @author lxsgo
 */
public class UserDAO {

    public static int login(UserSessionRequest userSessionRequest) {
        try (Connection connection = DatabaseConnection.connect()){
            // String query = "SELECT * FROM accounts WHERE username = '" + userSessionRequest.getUsername() + "' AND password = '" + userSessionRequest.getPassword() + "'";
            // System.out.println(query);
            // java.sql.Statement statement = connection.createStatement();

            // // check if user exists
            // java.sql.ResultSet resultSet = statement.executeQuery(query);
            // if (resultSet.next()) {
            //     Boolean isAdmin = resultSet.getBoolean("is_admin");
            //     // create user session
            //     UserSession.setIsAdmin(isAdmin);
            //     return 1;
            // }
            // else {
            //     return 0;
            // }
            // SQL injection prevention
            String query = "SELECT * FROM accounts WHERE username = ? AND hashed_password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, userSessionRequest.getUsername());
            preparedStatement.setString(2, userSessionRequest.getHashedPassword());

            System.out.println(preparedStatement);

            java.sql.ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Boolean isAdmin = resultSet.getBoolean("is_admin");
                // create user session
                UserSession.setIsAdmin(isAdmin);
                return 1;
            }
            else {
                return 0;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
         
        }
        return 0;
    }
    
}
