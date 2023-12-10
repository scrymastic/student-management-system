/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.dao;

import com.kma.sms.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author author's_name_goes_here
 */
public class StudentDAO {
    
        public void someMethod() {
        try (Connection connection = DatabaseConnection.connect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students WHERE student_id = 'AT170123'");
            
            while (resultSet.next()) {
                String studentId = resultSet.getString("student_id");
                String studentName = resultSet.getString("student_name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                // ... Fetch other fields

                System.out.println("Student ID: " + studentId + ", Name: " + studentName + ", Date of Birth: " + dateOfBirth);
                
            }
        } catch (SQLException e) {
            // Handle any SQL exceptions.
            e.printStackTrace();
        }
    }
}
