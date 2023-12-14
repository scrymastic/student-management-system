/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.controller.studentpopup;

import com.kma.sms.model.Student;
import com.kma.sms.dao.StudentDAO;

/**
 *
 * @author lxsgo
 */
public class StudentEditorController {

    // Generate message for response code
    public static String getStudentEditMessage(String studentId, String classId, String studentName,
                                                String dateOfBirth, String gender, String address, String telephone) {
        // Validate input
        // Check if studentName is empty
        if (studentName.isEmpty()) return "Tên sinh viên không được để trống";
        // Check if dateOfBirth is valid
        if (!dateOfBirth.matches("\\d{4}-\\d{2}-\\d{2}")) return "Ngày sinh không hợp lệ";
        // gender to boolean
        Boolean genderBoolean = gender.equalsIgnoreCase("nam") ? true : false;

        int errorCode = sendStudentEditRequestAndReceiveResponse(studentId, classId, studentName, dateOfBirth, genderBoolean, address, telephone);

        // Generate message
        String message = "";

        switch (errorCode) {
            case 1:
                message = "Sửa thông tin sinh viên thành công";
                break;
            default:
                message = "Sửa thông tin sinh viên thất bại";
                break;
        }

        return message;

    }

    // Create StudentRequest
    private static int sendStudentEditRequestAndReceiveResponse(String studentId, String classId, String studentName,
                                                            String dateOfBirth, Boolean gender, String address, String telephone) {
        // Construct a student object
        Student student = new Student(studentId, classId, studentName, dateOfBirth, gender, address, telephone);
        // Send the request
        // Receive the response
        int response = StudentDAO.EditStudentInfo(student);

        return response;
    }
}
