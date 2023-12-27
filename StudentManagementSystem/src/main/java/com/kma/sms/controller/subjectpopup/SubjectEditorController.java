/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.kma.sms.controller.subjectpopup;

import com.kma.sms.dao.SubjectDAO;
import com.kma.sms.model.Subject;
/**
 *
 * @author Admin
 */
public class SubjectEditorController {
    public static String getSubjectEditMessage(String subjectId,String majorId,String subjectName,String credits,String subjectIdOld){
        // Check if UserSession.isAdmin is true
        if (!com.kma.sms.authen.UserSession.getIsAdmin()) {
            return "Bạn không có quyền sửa học phần";
        }
        if(subjectName.isEmpty()){
            return "Tên học phần không được để trống.";
        }
        int errorCode = sendStudentEditRequestAndReceiveResponse(subjectId,majorId,subjectName,credits, subjectIdOld);
        String message="";
        switch(errorCode){
            case 1:
                message = "Sửa thông tin học phần thành công";
                break;
            default:
                message = "Sửa thông tin học phần thất bại";
                break;
        }

        return message;
    }
    
    private static int sendStudentEditRequestAndReceiveResponse(String subjectId,String majorId,String subjectName,String credits,String subjectIdOld) {
        Subject subject = new Subject(subjectId,majorId,subjectName,credits);
        int response = SubjectDAO.editSubjectInfo(subject,subjectIdOld);
        
        return response;
    }
}