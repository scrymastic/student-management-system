/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.model;

/**
 *
 * @author author's_name_goes_here
 */
public class Student {

//     CREATE TABLE students (
//     student_id VARCHAR(20) PRIMARY KEY,
//     class_id VARCHAR(20),
//     student_name VARCHAR(60) CHARACTER SET utf8mb4 NOT NULL,
//     date_of_birth DATE,
//     gender BIT, -- 1 for male, 0 for female
//     address VARCHAR(100) CHARACTER SET utf8mb4,
//     telephone VARCHAR(20),
//     FOREIGN KEY (class_id) REFERENCES classes(class_id)
// );

    // Basic info
    private String studentId;
    private String classId;
    private String studentName;
    private String dateOfBirth;
    private Boolean gender;
    private String address;
    private String telephone;
    

    // Constructor
    public Student(String studentId, String classId, String studentName, String dateOfBirth, Boolean gender, String address, String telephone) {
        this.studentId = studentId;
        this.classId = classId;
        this.studentName = studentName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.address = address;
        this.telephone = telephone;
    }

    // Getters and setters
    public String getStudentId() {
        return studentId;
    }

    public String getClassId() {
        return classId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
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

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }



}








