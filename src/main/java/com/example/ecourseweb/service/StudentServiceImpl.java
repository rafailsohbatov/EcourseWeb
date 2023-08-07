/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecourseweb.service;


import com.example.ecourseweb.dao.StudentDao;
import com.example.ecourseweb.model.Student;
import com.example.ecourseweb.model.StudentTeacherLesson;

import java.util.List;

/**
 *
 * @author Admin
 */
public class StudentServiceImpl implements StudentService{
    
    private StudentDao studentDao;

    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
    @Override
    public List<Student> getStudentList() throws Exception{
        return studentDao.getStudentList();
    }

    @Override
    public void addStudent(Student student) throws Exception {
        studentDao.addStudent(student);
    }

    @Override
    public Student getStudentById(Long studentId) throws Exception {
        return studentDao.getStudentById(studentId);
    }

    @Override
    public void updateStudent(Student student) throws Exception {
        studentDao.updateStudent(student);
    }

    @Override
    public void deleteStudent(Long studentId) throws Exception {
        studentDao.deleteStudent(studentId);
    }

    @Override
    public List<Student> searchStudentData(String keyword) throws Exception {
        return studentDao.searchStudentData(keyword);
    }

    @Override
    public StudentTeacherLesson getStudentTeacherLessonById(Long studentId, Long teacherLessonId) throws Exception {
        return studentDao.getStudentTeacherLessonById(studentId, teacherLessonId);
    }
}
