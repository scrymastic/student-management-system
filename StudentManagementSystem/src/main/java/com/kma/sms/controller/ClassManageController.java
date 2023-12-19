/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.controller;

import com.kma.sms.dao.ClassDAO;

import com.kma.sms.model.ClassRequestObject;
import com.kma.sms.model.Class;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author lxsgo
 */
public class ClassManageController {

    public static List<List<String>> getClassListString(String classId, String majorId, String teacher) {
        if (classId.isEmpty()) classId = null;
        else classId = classId.toUpperCase();
        if (majorId.isEmpty()) majorId = null;
        else majorId = majorId.toUpperCase();
        if (teacher.isEmpty()) teacher = null;

        List<Class> classList = sendSearchRequestAndReceiveClassList(classId, majorId, teacher);
        List<List<String>> classListString = new ArrayList<>();
        for (Class classObject : classList) {
            List<String> classObjectString = new ArrayList<>();
            classObjectString.add(classObject.getClassId());
            classObjectString.add(classObject.getMajorId());
            classObjectString.add(String.valueOf(classObject.getNumberOfStudents()));
            classObjectString.add(classObject.getTeacher());
            classListString.add(classObjectString);

            // System.out.println(classObject.getClassId() + " " + classObject.getMajorId() + " " + classObject.getTeacher() + " " + classObject.getNumberOfStudents());
        }
        return classListString;
    }

    private static List<Class> sendSearchRequestAndReceiveClassList(String classId, String majorId, String teacher) {
        ClassRequestObject classRequestObject = new ClassRequestObject(classId, majorId, teacher);
        List<Class> classList = ClassDAO.search(classRequestObject);
        return classList;
    }

    // update class
    public static String getClassUpdateMessage(String classId, String majorId, String teacher) {
        int errorCode = sendUpdateRequestAndReceiveResponse(classId, majorId, teacher);
        String message = "";
        switch (errorCode) {
            case 1:
                message = "Cập nhật thành công";
                break;
            default:
                message = "Cập nhật thất bại";
                break;
        }

        return message;
    }

    private static int sendUpdateRequestAndReceiveResponse(String classId, String majorId, String teacher) {
        Class classObject = new Class(classId, majorId, teacher, 0);
        int response = ClassDAO.updateClass(classObject);
        return response;
    }

    // add class
    public static String getClassAddMessage(String classId, String majorId, String teacher) {
        if (classId.isEmpty()) return "Mã lớp không được để trống";
        else classId = classId.toUpperCase();
        if (majorId.isEmpty()) return "Mã ngành không được để trống";
        else majorId = majorId.toUpperCase();
        int errorCode = sendAddRequestAndReceiveResponse(classId, majorId, teacher);
        String message = "";
        switch (errorCode) {
            case 1:
                message = "Thêm thành công";
                break;
            default:
                message = "Thêm thất bại";
                break;
        }

        return message;
    }

    private static int sendAddRequestAndReceiveResponse(String classId, String majorId, String teacher) {
        Class classObject = new Class(classId, majorId, teacher, 0);
        int response = ClassDAO.addClass(classObject);
        System.err.println(response);
        return response;
    }

    // delete class
    public static String getClassDeleteMessage(String classId) {
        int errorCode = sendDeleteRequestAndReceiveResponse(classId);
        String message = "";
        switch (errorCode) {
            case 1:
                message = "Xóa thành công";
                break;
            default:
                message = "Xóa thất bại";
                break;
        }
        return message;
    }

    private static int sendDeleteRequestAndReceiveResponse(String classId) {
        int response = ClassDAO.deleteClass(classId);
        return response;
    }

}
