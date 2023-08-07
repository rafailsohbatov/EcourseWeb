/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecourseweb.model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Teacher extends Course {

    private String name;
    private String surname;
    private Date dob;
    private String address;
    private String phone;
    private Integer work_experience;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getWork_experience() {
        return work_experience;
    }

    public void setWork_experience(Integer work_experience) {
        this.work_experience = work_experience;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}
