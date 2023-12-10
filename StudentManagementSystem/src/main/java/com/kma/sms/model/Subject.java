/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.model;

/**
 *
 * @author lxsgo
 */
public class Subject {
//     CREATE TABLE subjects (
//     subject_id VARCHAR(40) PRIMARY KEY,
//     major_id VARCHAR(20),
//     subject_name VARCHAR(100) CHARACTER SET utf8mb4,
//     number_of_credits INT CHECK (number_of_credits > 0),
//     FOREIGN KEY (major_id) REFERENCES majors(major_id)
// );

    // Basic info
    private String subjectId;
    private String majorId;
    private String subjectName;
    private int numberOfCredits;

    // Constructor
    public Subject(String subjectId, String majorId, String subjectName, int numberOfCredits) {
        this.subjectId = subjectId;
        this.majorId = majorId;
        this.subjectName = subjectName;
        this.numberOfCredits = numberOfCredits;
    }
    
}