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
public class SubjectAdderController {
    public static String getSubjectSAddMessage(String subjectId,String majorId,String subjectName,String credits){
        // Check if UserSession.isAdmin is true
        if (!com.kma.sms.authen.UserSession.getIsAdmin()) {
            return "Bạn không có quyền thêm học phần";
        }
        String message="";
        if(subjectId.isEmpty()||subjectName.isEmpty()){
            message="Mã học phần và tên học phần không được để trống.";
            return message;
        }
        if(majorId.isEmpty()) majorId=null;
        if(credits.isEmpty()) credits=null;
        int errorCode = sendAddRequestAndReceiveResponse(subjectId,majorId,subjectName,credits);
        switch (errorCode) {
            case 1:
                message = "Thêm học phần thành công";
                break;
            case 2:
                message = "Mã học phần đã tồn tại";
                break;
            default:
                message = "Thêm học phần thất bại";
                break;
        }

        return message;
    }
    
    private static int sendAddRequestAndReceiveResponse(String subjectId, String majorId, String subjectName, String credits) {
        Subject student = new Subject(subjectId,majorId,subjectName,credits);
        int response = SubjectDAO.addSubject(student);

        return response;
    }

}
