/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.controller;

import com.kma.sms.dao.ScoreDAO;
import com.kma.sms.model.Score;
import java.util.ArrayList;
import java.util.List;

public class ScoreManagePanelController {
    public static List<List<String>> getScoreListString(String studentId) {
        List<Score> scoreList = sendSearchRequestAndReceiveScoreList(studentId);
        List<List<String>> scoreListString = new ArrayList<List<String>>();
        for (Score sc : scoreList) {
            List<String> scoreString = new ArrayList<String>();
            scoreString.add(sc.getSubjectId());
            scoreString.add(sc.getSubjectName());
            scoreString.add(sc.getScore());
            scoreListString.add(scoreString);
        }
        return scoreListString;
    }

    public static List<Score> sendSearchRequestAndReceiveScoreList(String studentId) {
        // If a field is empty, I will set it to null
        if (studentId.isEmpty())
            studentId = null;

        Score sc = new Score(studentId);
        List<Score> scoreList = ScoreDAO.getScoreById(sc);
        return scoreList;
    }

    public static String getname(String studentId) {

        String name = ScoreDAO.getName(studentId);
        return name;
    }

    public static Float getgpa(String studentId) {
        Float gpa = ScoreDAO.getGPA(studentId);
        return gpa;
    }

    public static String getStudentEditMessage(String subjectId, String subjectName, String score) {

        if (score.isEmpty() || subjectId.isEmpty() || subjectName.isEmpty())
            return "Điểm không được để trống";
        float checkscore = Float.parseFloat(score);
        if (checkscore < 0 || checkscore > 10)
            return "Điểm nhập vào không đúng";
        int checksjid = ScoreDAO.checkSubjectId(subjectId);
        if (checksjid == 0)
            return "Không tồn tại mã môn học này";
        int checksjname = ScoreDAO.checkSubjectName(subjectName);
        if (checksjname == 0)
            return "Không tồn tại môn học này";
        int checksjidname = ScoreDAO.checkSubjectIdName(subjectId, subjectName);
        if (checksjidname != 0)
            return "Mã môn học và môn học không tương ứng";
        int errorCode = sendScoreEditRequestAndReceiveResponse(subjectId, subjectName, score);

        // Generate message
        String message = "";

        switch (errorCode) {
            case 0:
                message = "Sửa thông tin thất bại";
                break;
            default:
                message = "Sửa thông tin thành công";
                break;
        }

        return message;

    }

    private static int sendScoreEditRequestAndReceiveResponse(String subjectId, String subjectName, String score) {
        // Construct a student object
        Score scoreObj = new Score(subjectId, subjectName, score);
        // Send the request
        // Receive the response
        int response = ScoreDAO.updateScoreDB(scoreObj);

        return response;
    }

    public static String getStudentInsertMessage(String studentid, String subjectId, String subjectName, String score) {

        if (score.isEmpty() || subjectId.isEmpty() || subjectName.isEmpty())
            return "Còn ô để trống";
        float checkscore = Float.parseFloat(score);
        if (checkscore < 0 || checkscore > 10)
            return "Điểm nhập vào không đúng";
        int checksjid = ScoreDAO.checkSubjectId(subjectId);
        if (checksjid == 0)
            return "Không tồn tại mã môn học này";
        int checksjname = ScoreDAO.checkSubjectName(subjectName);
        if (checksjname == 0)
            return "Không tồn tại môn học này";
        int checksjidscore = ScoreDAO.checkSubjectIdScore(studentid, subjectId);
        if (checksjidscore != 0)
            return "Môn học này đã có trong bảng";
        int checksjidname = ScoreDAO.checkSubjectIdName(subjectId, subjectName);
        if (checksjidname != 0)
            return "Mã môn học và môn học không tương ứng";
        int errorCode = sendScoreInsertRequestAndReceiveResponse(studentid, subjectId, subjectName, score);

        // Generate message
        String message = "";

        switch (errorCode) {
            case 0:
                message = "Thêm thông tin thất bại";
                break;
            default:
                message = "Thêm thông tin thành công";
                break;
        }

        return message;

    }

    private static int sendScoreInsertRequestAndReceiveResponse(String studentid, String subjectId, String subjectName,
            String score) {
        // Construct a student object
        Score sco = new Score(studentid, subjectId, subjectName, score);
        // Send the request
        // Receive the response
        int response = ScoreDAO.insertScore(sco);

        return response;
    }

    public static String getStudentDeleteMessage(String studentid, String subjectId, String subjectName, String score) {

        if (subjectId.isEmpty() || subjectName.isEmpty())
            return "Mã sinh viên và môn học không được để trống";

        int checksjid = ScoreDAO.checkSubjectId(subjectId);
        if (checksjid == 0)
            return "Không tồn tại mã môn học này";
        int checksjname = ScoreDAO.checkSubjectName(subjectName);
        if (checksjname == 0)
            return "Không tồn tại môn học này";
        int checksjidscore = ScoreDAO.checkSubjectIdScore(studentid, subjectId);
        if (checksjidscore == 0)
            return "Môn học này không có trong bảng";
        int checksjidname = ScoreDAO.checkSubjectIdName(subjectId, subjectName);
        if (checksjidname != 0)
            return "Mã môn học và môn học không tương ứng";
        int errorCode = sendScoreDeleteRequestAndReceiveResponse(studentid, subjectId);

        // Generate message
        String message = "";

        switch (errorCode) {
            case 0:
                message = "Xóa thông tin thất bại";
                break;
            default:
                message = "Xóa thông tin thành công";
                break;
        }

        return message;

    }

    private static int sendScoreDeleteRequestAndReceiveResponse(String studentid, String subjectId) {
        // Construct a student object
        Score scoreObj = new Score(studentid, subjectId, null, null);
        // Send the request
        // Receive the response
        int response = ScoreDAO.deleteScore(scoreObj);

        return response;
    }
}
