/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecourseweb.model;

/**
 *
 * @author Admin
 */
public class Payment extends Course{
    private StudentTeacherLesson studentTeacherLesson;
    private Float amount;

    public StudentTeacherLesson getStudentTeacherLesson() {
        return studentTeacherLesson;
    }

    public void setStudentTeacherLesson(StudentTeacherLesson studentTeacherLesson) {
        this.studentTeacherLesson = studentTeacherLesson;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }
    
    
}
