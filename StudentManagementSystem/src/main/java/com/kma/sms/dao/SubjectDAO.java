/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.kma.sms.dao;

import com.kma.sms.model.Subject;
import com.kma.sms.model.SubjectRequestObject;
import com.kma.sms.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class SubjectDAO {
    public static List<Subject> searchSubject(SubjectRequestObject subjectRequest) {
        try (Connection connection = DatabaseConnection.connect()) {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM subjects WHERE ";
            if (subjectRequest.getSubjectId() != null)
                query += "subject_id LIKE '%" + subjectRequest.getSubjectId() + "%' AND ";
            if (subjectRequest.getMajorId() != null && subjectRequest.getMajorId() != " ")
                query += "major_id LIKE '%" + subjectRequest.getMajorId() + "%' AND ";
            if (subjectRequest.getSubjectName() != null)
                query += "subject_name LIKE '%" + subjectRequest.getSubjectName() + "%' AND ";
            if (subjectRequest.getNumberOfCredits() != null)
                query += "number_of_credits = " + subjectRequest.getNumberOfCredits() + " AND ";
            query += "1=1";
            System.out.println(query);
            ResultSet resultSet = statement.executeQuery(query);
            List<Subject> subjectResults = new ArrayList<>();
            while (resultSet.next()) {
                String subjectId = resultSet.getString("subject_id");
                String majorId = resultSet.getString("major_id");
                String subjectName = resultSet.getString("subject_name");
                String credits = resultSet.getString("number_of_credits");
                Subject subject = new Subject(subjectId, majorId, subjectName, credits);
                subjectResults.add(subject);
            }
            return subjectResults;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
