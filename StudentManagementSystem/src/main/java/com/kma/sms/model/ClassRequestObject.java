/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.model;

/**
 *
 * @author lxsgo
 */
public class ClassRequestObject {
    private String classId;
    private String majorId;
    private String teacher;

    public ClassRequestObject(String classId, String majorId, String teacher) {
        this.classId = classId;
        this.majorId = majorId;
        this.teacher = teacher;
    }

    public String getClassId() {
        return classId;
    }

    public String getMajorId() {
        return majorId;
    }

    public String getTeacher() {
        return teacher;
    }
    
}
