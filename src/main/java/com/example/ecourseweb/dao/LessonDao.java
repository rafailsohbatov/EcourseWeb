/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecourseweb.dao;

import com.example.ecourseweb.model.Lesson;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface LessonDao {

    List<Lesson> getLessonList() throws Exception;
    void addLesson(Lesson lesson) throws Exception;

    List<Lesson> getLessonByStudentId(Long studentId) throws Exception;
    Lesson getLessonById(Long lessonId) throws Exception;
}
