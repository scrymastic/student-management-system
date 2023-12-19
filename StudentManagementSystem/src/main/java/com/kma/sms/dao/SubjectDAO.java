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
    public static List<Subject> searchSubject(SubjectRequestObject subjectRequest){
        try (Connection connection = DatabaseConnection.connect()){
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM subjects WHERE ";
            if(subjectRequest.getSubjectId()!=null) query += "subject_id LIKE '%"+subjectRequest.getSubjectId()+"%' AND ";
            if(subjectRequest.getMajorId()!=null && subjectRequest.getMajorId()!=" ") query += "major_id LIKE '%"+subjectRequest.getMajorId()+"%' AND ";
            if(subjectRequest.getSubjectName()!=null) query += "subject_name LIKE '%" + subjectRequest.getSubjectName()+"%' AND ";
            if(subjectRequest.getNumberOfCredits()!=null) query += "number_of_credits = " + subjectRequest.getNumberOfCredits()+" AND ";
            query += "1=1";
            System.out.println(query);
            ResultSet resultSet = statement.executeQuery(query);
            List<Subject> subjectResults = new ArrayList<>();
            while(resultSet.next()){
                String subjectId = resultSet.getString("subject_id");
                String majorId = resultSet.getString("major_id");
                String subjectName = resultSet.getString("subject_name");
                String credits = resultSet.getString("number_of_credits");
                Subject subject = new Subject(subjectId,majorId,subjectName,credits);
                subjectResults.add(subject);
            }
            return subjectResults;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    public static int addSubject(Subject subject){
        try(Connection connection = DatabaseConnection.connect()){
            Statement statement = connection.createStatement();
            String query = "INSERT INTO subjects VALUES (";
            query += "'" + subject.getSubjectId() + "', ";
            if (subject.getMajorId() != null) query += "'" + subject.getMajorId() + "', ";
            else query += "NULL, ";
            query += "'" + subject.getSubjectName() + "', ";
            if (subject.getNumberOfCredits() != null) query +=  subject.getNumberOfCredits() + " ";
            else query += "NULL, ";
            query += ")";
            
            System.out.println(query);
            int result = statement.executeUpdate(query);

            return result;
        }
        catch (SQLException e) {
            // Handle any SQL exceptions.
            e.printStackTrace();
            // Check if the student id already exists
            if (e.getErrorCode() == 1062) return 2;

            return 0;
        }
    }
    
    public static int editSubjectInfo(Subject subject,String subjectIdOld){
        try (Connection connection = DatabaseConnection.connect()) {
            Statement statement = connection.createStatement();
            String query = "UPDATE subjects SET ";
            query += "subject_id = '" + subject.getSubjectId() + "', ";
            query += "major_id = '" + subject.getMajorId() + "', ";
            query += "subject_name = '" + subject.getSubjectName() + "', ";
            query += "number_of_credits = " + subject.getNumberOfCredits();
            query += " WHERE subject_id = '" + subjectIdOld + "'";
            System.out.println(query);
            int result = statement.executeUpdate(query);

            return result;

        } catch (SQLException e) {
            // Handle any SQL exceptions.
            e.printStackTrace();
            return 0;
        }

    }
    
    public static int deleteSubject(String subjectId) {
        // Connect to database
        try (Connection connection = DatabaseConnection.connect()) {
            connection.setAutoCommit(false);

            try (Statement statement = connection.createStatement()) {
                String deleteScoresSql = "DELETE FROM scores WHERE subject_id = '" + subjectId + "'";
                statement.executeUpdate(deleteScoresSql);
                
                String deleteSubjectSql = "DELETE FROM subjects WHERE subject_id = '" + subjectId + "'";
                statement.executeUpdate(deleteSubjectSql);
                System.out.println(deleteSubjectSql);
                connection.commit(); 
                return 1;
            } catch (SQLException e) {
                connection.rollback(); 
                throw e; 
            }
        }catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
