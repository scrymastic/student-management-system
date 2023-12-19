/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.model;

/**
 *
 * @author lxsgo
 */
public class Class {
    String classId;
    String majorId;
    String teacher;
    int numberOfStudents;

    public Class(String classId, String majorId, String teacher, int numberOfStudents) {
        this.classId = classId;
        this.majorId = majorId;
        this.teacher = teacher;
        this.numberOfStudents = numberOfStudents;
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

    public int getNumberOfStudents() {
        return numberOfStudents;
    }
    
}
