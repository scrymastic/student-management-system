/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.kma.sms.controller.subjectpopup;
import com.kma.sms.dao.SubjectDAO;

/**
 *
 * @author Admin
 */
public class SubjectDeleterController {
    public static String getSubjectDeleteMessage(String subjectId){
        int errorCode = sendDeleteRequestAndReceiveResponse(subjectId);
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
    
    private static int sendDeleteRequestAndReceiveResponse(String subjectId) {
        int response = SubjectDAO.deleteSubject(subjectId);
        return response;
    }
}
