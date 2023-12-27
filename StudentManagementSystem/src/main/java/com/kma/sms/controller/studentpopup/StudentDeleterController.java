package com.kma.sms.controller.studentpopup;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import com.kma.sms.authen.UserSession;
import com.kma.sms.dao.StudentDAO;

/**
 *
 * @author lxsgo
 */
public class StudentDeleterController {
    public static String getStudentDeleteMessage(String studentId){
        // Check if UserSession.isAdmin is true
        if (!UserSession.getIsAdmin()) {
            return "Bạn không có quyền xóa sinh viên";
        }
        int errorCode = sendDeleteRequestAndReceiveResponse(studentId);
        String message = "";

        switch (errorCode) {
            case 1:
                message = "Xóa thành công";
                break;
            default:
                message = "Lỗi không xác định";
                break;
        }

        return message;
    }

    private static int sendDeleteRequestAndReceiveResponse(String studentId) {
        int response = StudentDAO.deleteStudent(studentId);
        return response;
    }
}




