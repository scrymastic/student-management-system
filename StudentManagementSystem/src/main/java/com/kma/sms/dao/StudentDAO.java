/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.dao;

import com.kma.sms.util.DatabaseConnection;
import com.kma.sms.model.Student;
import com.kma.sms.model.StudentRequestObject;

import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author author's_name_goes_here
 */
public class StudentDAO {

    // Search student by student model request
    public static List<Student> searchStudent(StudentRequestObject studentRequest) {
        try (Connection connection = DatabaseConnection.connect()) {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM students WHERE ";
            if (studentRequest.getStudentId() != null) {
                query += "student_id LIKE '%" + studentRequest.getStudentId() + "%'";
                query += " AND ";
            }
            if (studentRequest.getClassId() != null) {
                query += "class_id LIKE '%" + studentRequest.getClassId() + "%'";
                query += " AND ";
            }
            if (studentRequest.getStudentName() != null) {
                query += "student_name LIKE '%" + studentRequest.getStudentName() + "%'";
                query += " AND ";
            }
            if ((studentRequest.getLowerBoundOfDateOfBirth() != null) && (studentRequest.getUpperBoundOfDateOfBirth() != null)) {
                query += "date_of_birth BETWEEN '" + studentRequest.getLowerBoundOfDateOfBirth() + "' AND '"
                        + studentRequest.getUpperBoundOfDateOfBirth() + "'";
                query += " AND ";
            } else if (studentRequest.getLowerBoundOfDateOfBirth() != null) {
                query += "date_of_birth >= '" + studentRequest.getLowerBoundOfDateOfBirth() + "'";
                query += " AND ";
            } else if (studentRequest.getUpperBoundOfDateOfBirth() != null) {
                query += "date_of_birth <= '" + studentRequest.getUpperBoundOfDateOfBirth() + "'";
                query += " AND ";
            }

            if (studentRequest.getGender() != null) {
                query += "gender = " + studentRequest.getGender();
                query += " AND ";
            }
            if (studentRequest.getAddress() != null) {
                query += "address LIKE '%" + studentRequest.getAddress() + "%'";
                query += " AND ";
            }
            if (studentRequest.getTelephone() != null) {
                query += "telephone LIKE '%" + studentRequest.getTelephone() + "%'";
                query += " AND ";
            }

            query += "1 = 1";

            System.out.println(query);

            ResultSet resultSet = statement.executeQuery(query);

            List<Student> ResultStudents = new ArrayList<>();

            while (resultSet.next()) {
                String studentId = resultSet.getString("student_id");
                String classId = resultSet.getString("class_id");
                String studentName = resultSet.getString("student_name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                Boolean gender = resultSet.getBoolean("gender");
                String address = resultSet.getString("address");
                String telephone = resultSet.getString("telephone");

                // Construct the student object
                Student student = new Student(studentId, classId, studentName, dateOfBirth, gender, address, telephone);

                // Append the student object to the List
                ResultStudents.add(student);

            }

            return ResultStudents;
        }
        catch (SQLException e) {
            // Handle any SQL exceptions.
            e.printStackTrace();
            return null;
        }

    }
}
