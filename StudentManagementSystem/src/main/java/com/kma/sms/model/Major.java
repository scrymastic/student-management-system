/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kma.sms.model;

/**
 *
 * @author lxsgo
 */
public class Major {

    private String majorId;
    private String majorName;
    private String address;
    private String telephone;
    private String headOfMajor;

    // Constructor
    public Major(String majorId, String majorName, String address, String telephone, String headOfMajor) {
        this.majorId = majorId;
        this.majorName = majorName;
        this.address = address;
        this.telephone = telephone;
        this.headOfMajor = headOfMajor;
    }

    public String getMajorId() {
        return majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getHeadOfMajor() {
        return headOfMajor;
    }
    
}
