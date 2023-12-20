/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.dao;

import com.kma.sms.model.Major;

import com.kma.sms.model.ClassRequestObject;
import com.kma.sms.util.DatabaseConnection;
import com.mysql.cj.jdbc.exceptions.MySQLQueryInterruptedException;

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
public class MajorDAO {

    // get all majors

    public static List<Major> getAllMajors() {
        // connect to database
        try (Connection connection = DatabaseConnection.connect()) {
            // execute query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM majors");

            // get result
            List<Major> majorResults = new ArrayList<>();
            while (resultSet.next()) {
                String majorId = resultSet.getString("major_id");
                String majorName = resultSet.getString("major_name");
                String address = resultSet.getString("address");
                String telephone = resultSet.getString("telephone");
                String headOfMajor = resultSet.getString("head_of_major");

                // System.out.println(majorId + " " + majorName + " " + address + " " +
                // telephone + " " + headOfMajor);

                Major major = new Major(majorId, majorName, address, telephone, headOfMajor);
                majorResults.add(major);
            }
            return majorResults;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }

    // get number of males by majorId
    // SELECT
    // COUNT(students.student_id) AS total_students,
    // SUM(CASE WHEN students.gender = 1 THEN 1 ELSE 0 END) AS total_males,
    // SUM(CASE WHEN students.gender = 0 THEN 1 ELSE 0 END) AS total_females
    // FROM
    // students
    // JOIN
    // classes ON students.class_id = classes.class_id
    // JOIN
    // majors ON classes.major_id = majors.major_id
    // WHERE
    // majors.major_id = 'givenMajorId';

    public static int getNumberOfMales(String majorId) {
        // connect to database
        try (Connection connection = DatabaseConnection.connect()) {
            // execute query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT SUM(CASE WHEN students.gender = 1 THEN 1 ELSE 0 END) as total_males"
                            + " FROM students JOIN classes ON students.class_id = classes.class_id JOIN majors ON classes.major_id = majors.major_id"
                            + " WHERE majors.major_id = '" + majorId + "'");
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // get number of females by majorId
    public static int getNumberOfFemales(String majorId) {
        try (Connection connection = DatabaseConnection.connect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement
                    .executeQuery("SELECT SUM(CASE WHEN students.gender = 0 THEN 1 ELSE 0 END) as total_males"
                            + " FROM students JOIN classes ON students.class_id = classes.class_id JOIN majors ON classes.major_id = majors.major_id"
                            + " WHERE majors.major_id = '" + majorId + "'");
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // get number of students by majorId
    public static int getNumberOfStudents(String majorId) {
        try (Connection connection = DatabaseConnection.connect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(students.student_id) AS total_students"
                    + " FROM students JOIN classes ON students.class_id = classes.class_id JOIN majors ON classes.major_id = majors.major_id"
                    + " WHERE majors.major_id = '" + majorId + "'");
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    // get avg gpa by majorId
    // SELECT AVG(scores.score) AS average_score
    // FROM scores
    // JOIN students ON scores.student_id = students.student_id
    // JOIN classes ON students.class_id = classes.class_id
    // WHERE scores.score IS NOT NULL
    // AND classes.major_id = 'specificMajorId';

    public static float getAverageScore(String majorId) {
        try (Connection connection = DatabaseConnection.connect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT AVG(scores.score) AS average_score"
                    + " FROM scores JOIN students ON scores.student_id = students.student_id JOIN classes ON students.class_id = classes.class_id"
                    + " WHERE scores.score IS NOT NULL AND classes.major_id = '" + majorId + "'");
            if (resultSet.next()) {
                return resultSet.getFloat(1);
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }


    // get number of excellent students by majorId
// SELECT 
//     COUNT(*) AS number_of_excellent_students
// FROM (
//     SELECT 
//         students.student_id, 
//         AVG(scores.score) AS avg_score
//     FROM 
//         students
//     INNER JOIN 
//         scores ON students.student_id = scores.student_id
//     INNER JOIN 
//         classes ON students.class_id = classes.class_id
//     WHERE 
//         classes.major_id = 'givenMajorId'
//     GROUP BY 
//         students.student_id
// ) AS student_avg_scores
// WHERE 
//     avg_score >= 9;

    public static int getNumberOfStudentsWithScoreRange(String majorId, double d, double maxScore) {
        try (Connection connection = DatabaseConnection.connect()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) AS number_of_excellent_students"
                    + " FROM (SELECT students.student_id, AVG(scores.score) AS avg_score"
                    + " FROM students INNER JOIN scores ON students.student_id = scores.student_id"
                    + " INNER JOIN classes ON students.class_id = classes.class_id"
                    + " WHERE classes.major_id = '" + majorId + "' GROUP BY students.student_id) AS student_avg_scores"
                    + " WHERE avg_score >= " + d + " AND avg_score <= " + maxScore);
            if (resultSet.next()) {
                return resultSet.getInt(1);
            } else {
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

}
