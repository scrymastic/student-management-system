/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.controller;

import com.kma.sms.dao.SubjectDAO;
import com.kma.sms.model.Subject;
import com.kma.sms.model.SubjectRequestObject;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lxsgo
 */
public class SubjectManagePanelController {
    public static List<List<String>> getSubjectListString(String subjectId, String majorId, String subjectName,
            String credits) {
        List<Subject> subjectList = sendSearchRequestAndReceiveSubjectList(subjectId, majorId, subjectName, credits);
        List<List<String>> subjectListString = new ArrayList<List<String>>();
        for (Subject subject : subjectList) {
            List<String> subjectString = new ArrayList<String>();
            subjectString.add(subject.getSubjectId());
            subjectString.add(subject.getMajorId());
            subjectString.add(subject.getSubjectName());
            subjectString.add(subject.getNumberOfCredits() + "");
            subjectListString.add(subjectString);
        }
        return subjectListString;
    }

    public static List<Subject> sendSearchRequestAndReceiveSubjectList(String subjectId, String majorId,
            String subjectName, String credits) {
        if (subjectId.isEmpty())
            subjectId = null;
        // majorId = ignorecase 'all' -> null
        if (majorId.isEmpty() || majorId.equalsIgnoreCase("all"))
            majorId = null;
        else
            majorId = majorId.toUpperCase();
        if (subjectName.isEmpty())
            subjectName = null;
        if (credits.isEmpty())
            credits = null;
        SubjectRequestObject subjectRequestObject = new SubjectRequestObject(subjectId, majorId, subjectName, credits);
        List<Subject> subjectList = SubjectDAO.searchSubject(subjectRequestObject);
        return subjectList;
    }
}
