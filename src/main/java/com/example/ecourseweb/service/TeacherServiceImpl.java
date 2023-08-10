/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecourseweb.service;

import com.example.ecourseweb.dao.TeacherDao;
import com.example.ecourseweb.model.Teacher;
import com.example.ecourseweb.model.TeacherLesson;

import java.util.List;

/**
 *
 * @author Admin
 */
public class TeacherServiceImpl implements TeacherService{

    private TeacherDao teacherDao;

    public TeacherServiceImpl(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }
    
    
    @Override
    public List<Teacher> getTeacherList() throws Exception {
        return teacherDao.getTeacherList();
    }

    @Override
    public void addTeacher(Teacher teacher) throws Exception {
        teacherDao.addTeacher(teacher);
    }

    @Override
    public List<Teacher> getTeacherListByLessonId(Long lessonId) throws Exception {
        return teacherDao.getTeacherListByLessonId(lessonId);
    }

    @Override
    public TeacherLesson getTeacherLessonByTeacherAndLessonId(Long teacherId, Long LessonId) throws Exception {
        return teacherDao.getTeacherLessonByTeacherAndLessonId(teacherId, LessonId);
    }

    @Override
    public List<Teacher> getTeacherListByLessonIdAndStudentId(Long lessonId, Long studentId) throws Exception {
        return teacherDao.getTeacherListByLessonIdAndStudentId(lessonId,studentId);
    }

}
