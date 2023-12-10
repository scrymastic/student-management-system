/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.model;

/**
 *
 * @author lxsgo
 */
public class StudentRequestObject {
    private String studentId;
    private String classId;
    private String studentName;
    private String lowerBoundOfDateOfBirth;
    private String upperBoundOfDateOfBirth;
    private Boolean gender;
    private String address;
    private String telephone;

    // Constructor
    public StudentRequestObject(String studentId, String classId, String studentName, 
                                String lowerBoundOfDateOfBirth, String upperBoundOfDateOfBirth, 
                                Boolean gender, String address, String telephone) {
        this.studentId = studentId;
        this.classId = classId;
        this.studentName = studentName;
        this.lowerBoundOfDateOfBirth = lowerBoundOfDateOfBirth;
        this.upperBoundOfDateOfBirth = upperBoundOfDateOfBirth;
        this.gender = gender;
        this.address = address;
        this.telephone = telephone;
    }

    // Getters
    public String getStudentId() {
        return studentId;
    }

    public String getClassId() {
        return classId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getLowerBoundOfDateOfBirth() {
        return lowerBoundOfDateOfBirth;
    }

    public String getUpperBoundOfDateOfBirth() {
        return upperBoundOfDateOfBirth;
    }

    public Boolean getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }
}

