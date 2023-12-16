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
            // SELECT * FROM students WHERE student_name COLLATE utf8mb4_bin LIKE '%hà%'
            if (studentRequest.getStudentId() != null) {
                query += "student_id LIKE '%" + studentRequest.getStudentId() + "%'";
                query += " AND ";
            }
            if (studentRequest.getClassId() != null) {
                query += "class_id LIKE '%" + studentRequest.getClassId() + "%'";
                query += " AND ";
            }
            if (studentRequest.getStudentName() != null) {
                query += "student_name COLLATE utf8mb4_bin LIKE '%" + studentRequest.getStudentName() + "%'";
                query += " AND ";
            }
            if ((studentRequest.getLowerBoundOfDateOfBirth() != null)
                    && (studentRequest.getUpperBoundOfDateOfBirth() != null)) {
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
                query += "address COLLATE utf8mb4_bin LIKE '%" + studentRequest.getAddress() + "%'";
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
        } catch (SQLException e) {
            // Handle any SQL exceptions.
            e.printStackTrace();
            return null;
        }

    }

    // Modify student by student class
    public static int editStudentInfo(Student student) {
        // Connect to database
        try (Connection connection = DatabaseConnection.connect()) {
            Statement statement = connection.createStatement();
            String query = "UPDATE students SET ";
            query += "class_id = '" + student.getClassId() + "', ";
            query += "student_name = '" + student.getStudentName() + "', ";
            query += "date_of_birth = '" + student.getDateOfBirth() + "', ";
            query += "gender = " + student.getGender() + ", ";
            query += "address = '" + student.getAddress() + "', ";
            query += "telephone = '" + student.getTelephone() + "' ";
            query += "WHERE student_id = '" + student.getStudentId() + "'";
            System.out.println(query);
            int result = statement.executeUpdate(query);

            return result;

        } catch (SQLException e) {
            // Handle any SQL exceptions.
            e.printStackTrace();
            return 0;
        }

    }

    // Delete student by student id
    public static int deleteStudent(String studentId) {
        // Connect to database
        try (Connection connection = DatabaseConnection.connect()) {
            connection.setAutoCommit(false); // Start transaction

            try (Statement statement = connection.createStatement()) {
                // SQL to delete student's scores
                String deleteScoresSql = "DELETE FROM scores WHERE student_id = '" + studentId + "'";
                statement.executeUpdate(deleteScoresSql);

                // SQL to delete student
                String deleteStudentSql = "DELETE FROM students WHERE student_id = '" + studentId + "'";
                statement.executeUpdate(deleteStudentSql);

                connection.commit(); // Commit transaction
                return 1; // Successful deletion
            } catch (SQLException e) {
                connection.rollback(); // Rollback transaction in case of error
                throw e; // Re-throw the exception to be caught in the outer catch block
            }

        } catch (SQLException e) {
            // Handle any SQL exceptions.
            e.printStackTrace();
            return 0;
        }
    }


    // Add student by student class
    public static int addStudent(Student student) {
        // Connect to database
        try (Connection connection = DatabaseConnection.connect()) {
            Statement statement = connection.createStatement();
            String query = "INSERT INTO students VALUES (";
            query += "'" + student.getStudentId() + "', ";
            if (student.getClassId() != null) query += "'" + student.getClassId() + "', ";
            else query += "NULL, ";
            query += "'" + student.getStudentName() + "', ";
            if (student.getDateOfBirth() != null) query += "'" + student.getDateOfBirth() + "', ";
            else query += "NULL, ";
            if (student.getGender() != null) query += student.getGender() + ", ";
            else query += "NULL, ";
            if (student.getAddress() != null) query += "'" + student.getAddress() + "', ";
            else query += "NULL, ";
            if (student.getTelephone() != null) query += "'" + student.getTelephone() + "'";
            else query += "NULL";
            query += ")";

            System.out.println(query);
            int result = statement.executeUpdate(query);

            return result;

        } catch (SQLException e) {
            // Handle any SQL exceptions.
            e.printStackTrace();
            // Check if the student id already exists
            if (e.getErrorCode() == 1062) return 2;

            return 0;
        }

    }
}
