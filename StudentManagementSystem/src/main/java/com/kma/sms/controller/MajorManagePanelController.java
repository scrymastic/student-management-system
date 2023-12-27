/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.controller;

import java.util.List;

import com.kma.sms.authen.UserSession;
import com.kma.sms.dao.MajorDAO;
import com.kma.sms.model.Major;

/**
 *
 * @author lxsgo
 */
public class MajorManagePanelController {

    public static List<List<String>> getMajorListString() {
        // Check if UserSession.isAdmin is true
        if (!UserSession.getIsAdmin()) {
            return null;
        }
        List<Major> majorList = MajorDAO.getAllMajors();
        List<List<String>> majorListString = new java.util.ArrayList<List<String>>();
        for (Major major : majorList) {
            List<String> majorString = new java.util.ArrayList<String>();
            majorString.add(major.getMajorId());
            majorString.add(major.getMajorName());
            majorString.add(major.getAddress());
            majorString.add(major.getTelephone());
            majorString.add(major.getHeadOfMajor());
            majorListString.add(majorString);
        }
        return majorListString;
    }

    // get number of males by majorId
    public static int getNumberOfMalesByMajorId(String majorId) {
        return MajorDAO.getNumberOfMales(majorId); 
    }

    // get number of females by majorId
    public static int getNumberOfFemalesByMajorId(String majorId) {
        return MajorDAO.getNumberOfFemales(majorId);
    }

    // get number of students by majorId
    public static int getNumberOfStudentsByMajorId(String majorId) {
        return MajorDAO.getNumberOfStudents(majorId);
    }

    // get average score by majorId
    public static double getAverageScoreByMajorId(String majorId) {
        return MajorDAO.getAverageScore(majorId);
    }

    // get number of excellent students by majorId
    public static int getNumberOfExcellentStudentsByMajorId(String majorId) {
        return MajorDAO.getNumberOfStudentsWithScoreRange(majorId, 8.5, 10);
    }

    // get number of good students by majorId
    public static int getNumberOfGoodStudentsByMajorId(String majorId) {
        return MajorDAO.getNumberOfStudentsWithScoreRange(majorId, 7.5, 8.5);
    }

    // get number of average students by majorId
    public static int getNumberOfAverageStudentsByMajorId(String majorId) {
        return MajorDAO.getNumberOfStudentsWithScoreRange(majorId, 6, 7.5);
    }

    
}
