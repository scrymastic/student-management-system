/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.controller.studentpopup;

import com.kma.sms.dao.StudentDAO;
import com.kma.sms.model.Student;

/**
 *
 * @author lxsgo
 */
public class StudentAdderController {

    public static String getStudentSAddMessage(String studentId, String classId, String studentName, String dateOfBirth, String gender, String address, String telephone) {
        // check if studentId or studentName is empty
        String message = "";
        if (studentId.isEmpty() || studentName.isEmpty()) {
            message = "Mã sinh viên và tên sinh viên không được để trống";
            return message;
        }
        else {
            // uppercase all characters in studentId
            studentId = studentId.toUpperCase();
        }
        if (classId.isEmpty()) {
            classId = null;
        }
        else {
            // uppercase all characters in classId
            classId = classId.toUpperCase();
        }
        // check if dateOfBirth is valid
        if (dateOfBirth.isEmpty()) {
            dateOfBirth = null;
        }
        else {
            if (!dateOfBirth.matches("\\d{4}-\\d{2}-\\d{2}")) {
                message = "Ngày sinh không hợp lệ";
                return message;
            }
        }

        Boolean genderBoolean = gender.equalsIgnoreCase("nam") ? true : false;

        if (address.isEmpty()) {
            address = null;
        }

        if (telephone.isEmpty()) {
            telephone = null;
        }

        int errorCode = sendAddRequestAndReceiveResponse(studentId, classId, studentName, dateOfBirth, genderBoolean, address, telephone);
        
        switch (errorCode) {
            case 1:
                message = "Thêm sinh viên thành công";
                break;
            case 2:
                message = "Mã sinh viên đã tồn tại";
                break;
            default:
                message = "Thêm sinh viên thất bại";
                break;
        }

        return message;
    }

    private static int sendAddRequestAndReceiveResponse(String studentId, String classId, String studentName, String dateOfBirth, Boolean gender, String address, String telephone) {
        Student student = new Student(studentId, classId, studentName, dateOfBirth, gender, address, telephone);
        int response = StudentDAO.addStudent(student);

        return response;
    }
    
}
