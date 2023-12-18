/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.model;

/**
 *
 * @author Lenovo
 */
public class Score {
    private String studenId;
    private String subjectId;
    private String studentName;
    private String subjectName;
    private String score;

    public Score(String studenId) {
        this.studenId = studenId;
    }
    public Score(String subjectId, String subjectName, String score) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.score = score;
    }
     public Score(String studenId, String subjectId, String subjectName, String score) {
        this.studenId = studenId;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.score = score;
    }
    public Score(String studenId, String subjectId, String studentName, String subjectName, String score) {
        this.studenId = studenId;
        this.subjectId = subjectId;
        this.studentName = studentName;
        this.subjectName = subjectName;
        this.score = score;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

   

    public String getStudenId() {
        return studenId;
    }

    public void setStudenId(String studenId) {
        this.studenId = studenId;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
    
    
}
