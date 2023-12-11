/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.model;

/**
 *
 * @author Admin
 */
public class SubjectRequestObject {
    private String subjectId;
    private String majorId;
    private String subjectName;
    private String numberOfCredits;

    // Constructor
    public SubjectRequestObject(String subjectId, String majorId, String subjectName, String numberOfCredits) {
        this.subjectId = subjectId;
        this.majorId = majorId;
        this.subjectName = subjectName;
        this.numberOfCredits = numberOfCredits;
    }
    
    public String getSubjectId(){
        return subjectId;
    }
    
    public String getMajorId(){
        return majorId;
    }
    
    public String getSubjectName(){
        return subjectName;
    }
    
    public String getNumberOfCredits(){
        return numberOfCredits;
    }
    
}
