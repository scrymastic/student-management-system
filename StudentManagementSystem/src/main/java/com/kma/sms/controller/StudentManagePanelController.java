/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.controller;

import java.util.ArrayList;
import java.util.List;

import com.kma.sms.model.Student;
import com.kma.sms.model.StudentRequestObject;


import com.kma.sms.dao.StudentDAO;

/**
 *
 * @author lxsgo
 */
public class StudentManagePanelController {

    public static List<List<String>> getStudentListString(String studentId, String classId,
                                                String studentName, String lowerBoundOfDateOfBirth, 
                                                String upperBoundOfDateOfBirth, String gender, 
                                                String address, String telephone) {
        List<Student> studentList = sendSearchRequestAndReceiveStudentList(studentId, classId,
                                                                    studentName, lowerBoundOfDateOfBirth,
                                                                    upperBoundOfDateOfBirth, gender,
                                                                    address, telephone);
        List<List<String>> studentListString = new ArrayList<List<String>>();
        for (Student student : studentList) {
            List<String> studentString = new ArrayList<String>();
            studentString.add(student.getStudentId());
            studentString.add(student.getClassId());
            studentString.add(student.getStudentName());
            studentString.add(student.getDateOfBirth());
            studentString.add(student.getGender() ? "Nam" : "Nữ");
            studentString.add(student.getAddress());
            studentString.add(student.getTelephone());
            studentListString.add(studentString);
        }
        return studentListString;
    }

    private static List<Student> sendSearchRequestAndReceiveStudentList(String studentId, String classId, 
                                                        String studentName, String lowerBoundOfDateOfBirth, 
                                                        String upperBoundOfDateOfBirth, String gender, 
                                                        String address, String telephone) {
        // If a field is empty, I will set it to null
        if (studentId.isEmpty()) studentId = null;
        if (classId.isEmpty()) classId = null;
        if (studentName.isEmpty()) studentName = null;
        if (lowerBoundOfDateOfBirth.isEmpty()) lowerBoundOfDateOfBirth = null;
        if (upperBoundOfDateOfBirth.isEmpty()) upperBoundOfDateOfBirth = null;
        Boolean genderBoolean = null;
        if (gender.isEmpty() || gender.equalsIgnoreCase("all")) genderBoolean = null;
        else genderBoolean = gender.equalsIgnoreCase("nam") ? true : false;
        if (address.isEmpty()) address = null;
        if (telephone.isEmpty()) telephone = null;

        // Construct the student object
        StudentRequestObject studentRequestObject = new StudentRequestObject(studentId, classId, studentName, lowerBoundOfDateOfBirth, upperBoundOfDateOfBirth, genderBoolean, address, telephone);

        // Send the request to the DAO
        List<Student> studentList = StudentDAO.searchStudent(studentRequestObject);
        return studentList;
    }
}
