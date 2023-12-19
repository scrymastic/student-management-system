/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.dao;

import com.kma.sms.model.Score;
import com.kma.sms.util.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lenovo
 */
public class ScoreDAO {
    public static List<Score> getScoreById(Score scr) {
        try (Connection connection = DatabaseConnection.connect()) {
            Statement statement = connection.createStatement();
            String query = "SELECT subjects.subject_id, subjects.subject_name, scores.score FROM subjects JOIN scores ON subjects.subject_id = scores.subject_id WHERE scores.student_id = '"
                    + scr.getStudenId() + "'";
            ResultSet rs = statement.executeQuery(query);
            List<Score> scoresString = new ArrayList<>();
            while (rs.next()) {

                String subject_id = rs.getString("subject_id");
                String subject_name = rs.getString("subject_name");
                String score = rs.getString("score");

                Score sc = new Score(subject_id, subject_name, score);

                scoresString.add(sc);
            }
            return scoresString;
        } catch (SQLException e) {
            // Handle any SQL exceptions.
            e.printStackTrace();
            return null;
        }
    }

    private static List<Float> to4PointScale(String StudentId) {
        try (Connection connection = DatabaseConnection.connect()) {
            Statement statement = connection.createStatement();
            String query = "SELECT score FROM scores WHERE student_id = '" + StudentId
                    + "'and subject_id !='ATQGTC1' and subject_id !='ATQGTC2' and subject_id !='ATQGTC3'";
            ResultSet rs = statement.executeQuery(query);
            List<Float> scoresString = new ArrayList<>();
            while (rs.next()) {
                Float score = rs.getFloat("score");

                if (score >= 8.5f & score <= 10f) {
                    score = 4f;
                } else if (score >= 8f & score <= 8.4f) {
                    score = 3.5f;
                } else if (score >= 7f & score <= 7.9f) {
                    score = 3f;
                } else if (score >= 6.5f & score <= 6.9f) {
                    score = 2.5f;
                } else if (score >= 5.5f & score <= 6.4f) {
                    score = 2f;
                } else if (score >= 5f & score <= 5.4f) {
                    score = 1.5f;
                } else if (score >= 4f & score <= 4.9f) {
                    score = 1f;
                } else {
                    score = 0f;
                }
                scoresString.add(score);

            }
            return scoresString;
        } catch (SQLException e) {
            // Handle any SQL exceptions.
            e.printStackTrace();
            return null;
        }
    }

    public static Float getGPA(String studentID) {
        try (Connection connection = DatabaseConnection.connect()) {
            Statement statement = connection.createStatement();
            String query = "SELECT number_of_credits FROM subjects JOIN scores ON subjects.subject_id = scores.subject_id WHERE scores.student_id = '"
                    + studentID
                    + "'and scores.subject_id !='ATQGTC1' and scores.subject_id !='ATQGTC2' and scores.subject_id !='ATQGTC3'";
            ResultSet rs = statement.executeQuery(query);
            Float GPA = 0f;
            List<Float> scoresString = ScoreDAO.to4PointScale(studentID);
            int i = 0;
            Float sumcredit = 0f;
            Float sumscorescredit = 0f;
            while (rs.next()) {
                int credit = rs.getInt("number_of_credits");
                sumcredit += credit;
                sumscorescredit += credit * scoresString.get(i);
                i++;
            }
            GPA = sumscorescredit / sumcredit;

            return GPA;
        } catch (SQLException e) {
            // Handle any SQL exceptions.
            e.printStackTrace();
            return null;
        }
    }

    public static String getName(String studentID) {
        try (Connection connection = DatabaseConnection.connect()) {
            Statement statement = connection.createStatement();
            String query = "SELECT student_name FROM students WHERE student_id = '" + studentID + "'";
            ResultSet rs = statement.executeQuery(query);
            String name = null;
            while (rs.next()) {
                name = rs.getString("student_name");
            }
            return name;
        } catch (SQLException e) {
            // Handle any SQL exceptions.
            e.printStackTrace();
            return null;
        }

    }

    public static int updateScoreDB(Score scr) {
        try (Connection connection = DatabaseConnection.connect()) {
            Statement statement = connection.createStatement();
            String query = "UPDATE scores SET ";
            query += "score = '" + scr.getScore() + "' ";
            query += "WHERE subject_id = '" + scr.getSubjectId() + "' ";
            int result = statement.executeUpdate(query);

            return result;

        } catch (SQLException e) {
            // Handle any SQL exceptions.
            e.printStackTrace();
            return 0;
        }
    }

    public static int checkSubjectId(String subjectid) {
        try (Connection connection = DatabaseConnection.connect()) {
            Statement statement = connection.createStatement();
            String query = "SELECT count(subject_id) FROM subjects WHERE subject_id='" + subjectid + "'";
            ResultSet result = statement.executeQuery(query);
            int check = 10;
            while (result.next()) {
                check = result.getInt(1);
            }
            return check;

        } catch (SQLException e) {
            // Handle any SQL exceptions.
            e.printStackTrace();
            return 2;
        }
    }

    public static int checkSubjectIdScore(String studentid, String subjectid) {
        try (Connection connection = DatabaseConnection.connect()) {
            Statement statement = connection.createStatement();
            String query = "SELECT count(subject_id) FROM scores WHERE student_id='" + studentid + "' and subject_id ='"
                    + subjectid + "'";
            ResultSet result = statement.executeQuery(query);
            int check = 10;
            while (result.next()) {
                check = result.getInt(1);
            }
            return check;

        } catch (SQLException e) {
            // Handle any SQL exceptions.
            e.printStackTrace();
            return 2;
        }
    }

    public static int checkSubjectName(String subjectname) {
        try (Connection connection = DatabaseConnection.connect()) {
            Statement statement = connection.createStatement();
            String query = "SELECT count(subject_name) FROM subjects WHERE subject_name='" + subjectname + "'";
            ResultSet result = statement.executeQuery(query);
            int check = 10;
            while (result.next()) {
                check = result.getInt(1);
            }
            return check;

        } catch (SQLException e) {
            // Handle any SQL exceptions.
            e.printStackTrace();
            return 2;
        }
    }

    public static int checkSubjectIdName(String subjectid, String subjectname) {
        try (Connection connection = DatabaseConnection.connect()) {
            Statement statement = connection.createStatement();
            String query = "SELECT subject_id FROM subjects WHERE subject_name='" + subjectname + "'";
            ResultSet result = statement.executeQuery(query);

            int check = 10;
            while (result.next()) {
                if (subjectid.equals(result.getString("subject_id")))
                    check = 0;
            }
            return check;

        } catch (SQLException e) {
            // Handle any SQL exceptions.
            e.printStackTrace();
            return 2;
        }
    }

    public static int deleteScore(Score scr) {
        try (Connection connection = DatabaseConnection.connect()) {
            Statement statement = connection.createStatement();
            String query = "delete from scores where student_id = '" + scr.getStudenId() + "'and subject_id = '"
                    + scr.getSubjectId() + "'";
            int result = statement.executeUpdate(query);

            return result;

        } catch (SQLException e) {
            // Handle any SQL exceptions.
            e.printStackTrace();
            return 0;
        }
    }

    public static int insertScore(Score scr) {
        try (Connection connection = DatabaseConnection.connect()) {
            Statement statement = connection.createStatement();
            String query = "Insert into scores(student_id,subject_id,score) value (";
            query += "'" + scr.getStudenId() + "',";
            query += "'" + scr.getSubjectId() + "',";
            query += "'" + scr.getScore() + "')";
            int result = statement.executeUpdate(query);

            return result;

        } catch (SQLException e) {
            // Handle any SQL exceptions.
            e.printStackTrace();
            return 0;
        }
    }
}