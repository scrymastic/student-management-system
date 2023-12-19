/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.dao;


import com.kma.sms.model.Class;
import com.kma.sms.model.ClassRequestObject;
import com.kma.sms.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author lxsgo
 */
public class ClassDAO {

    // search class by ClassRequestObject
    public static List<Class> search(ClassRequestObject classRequestObject) {
        // connect to database
        try (Connection connection = DatabaseConnection.connect()) {
            StringBuilder queryBuilder = new StringBuilder("SELECT * FROM classes WHERE ");
            if (classRequestObject.getClassId() != null) {
                queryBuilder.append("class_id LIKE '%").append(classRequestObject.getClassId()).append("%' AND ");
            }
            if (classRequestObject.getMajorId() != null) {
                queryBuilder.append("major_id LIKE '%").append(classRequestObject.getMajorId()).append("%' AND ");
            }
            if (classRequestObject.getTeacher() != null) {
                queryBuilder.append("homeroom_teacher LIKE '%").append(classRequestObject.getTeacher()).append("%' AND ");
            }
            queryBuilder.append("1 = 1");

            // execute query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryBuilder.toString());

            // get result
            List<Class> classResults = new ArrayList<>();
            while (resultSet.next()) {
                String classId = resultSet.getString("class_id");
                String majorId = resultSet.getString("major_id");
                String teacher = resultSet.getString("homeroom_teacher");
                int numberOfStudents = getNumberOfStudents(classId);

                // System.out.println(classId + " " + majorId + " " + teacher + " " + numberOfStudents);

                Class classObject = new Class(classId, majorId, teacher, numberOfStudents);
                classResults.add(classObject);
            }
            return classResults;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    // Get number of students in a class
    public static int getNumberOfStudents(String classId) throws SQLException {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "SELECT COUNT(*) FROM students WHERE class_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, classId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
            else {
                return 0;
            }
        }
    }

    // update class
    public static int updateClass(Class classObject) {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "UPDATE classes SET major_id = ?, homeroom_teacher = ? WHERE class_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, classObject.getMajorId());
            preparedStatement.setString(2, classObject.getTeacher());
            preparedStatement.setString(3, classObject.getClassId());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // add class
    public static int addClass(Class classObject) {
        try (Connection connection = DatabaseConnection.connect()) {
            String query = "INSERT INTO classes (class_id, major_id, homeroom_teacher) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, classObject.getClassId());
            preparedStatement.setString(2, classObject.getMajorId());
            preparedStatement.setString(3, classObject.getTeacher());
            return preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }


    // delete class
    public static int deleteClass(String classId) {
        try (Connection connection = DatabaseConnection.connect()) {
            connection.setAutoCommit(false);
            try (Statement statement = connection.createStatement()) {
                String query = "DELETE FROM classes WHERE class_id = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, classId);
                preparedStatement.executeUpdate();

                query = "DELETE FROM students WHERE class_id = ?";
                preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, classId);
                preparedStatement.executeUpdate();

                connection.commit();
                return 1;
            } catch (SQLException e) {
                connection.rollback();
                e.printStackTrace();
                return 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
