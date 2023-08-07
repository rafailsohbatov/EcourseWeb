/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecourseweb.dao;


import com.example.ecourseweb.model.Student;
import com.example.ecourseweb.model.StudentTeacherLesson;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface StudentDao {

    List<Student> getStudentList() throws Exception;

    void addStudent(Student student) throws Exception;

    Student getStudentById(Long studentId) throws Exception;

    void updateStudent(Student student) throws Exception;

    void deleteStudent(Long studentId) throws Exception;

    List<Student> searchStudentData(String keyword) throws Exception;

    StudentTeacherLesson getStudentTeacherLessonById(Long studentId, Long teacherLessonId) throws Exception;
}
