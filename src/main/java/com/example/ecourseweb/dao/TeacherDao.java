/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecourseweb.dao;

import com.example.ecourseweb.model.Teacher;
import com.example.ecourseweb.model.TeacherLesson;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface TeacherDao {
      List<Teacher> getTeacherList() throws Exception;
      
      List<Teacher> getTeacherListByLessonId(Long lessonId) throws Exception;
      
      TeacherLesson getTeacherLessonByTeacherAndLessonId(Long teacherId, Long lessonId) throws Exception;
}
