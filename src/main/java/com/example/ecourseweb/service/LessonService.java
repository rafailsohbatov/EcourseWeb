/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecourseweb.service;

import com.example.ecourseweb.model.Lesson;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface LessonService {
     List<Lesson> getLessonList() throws Exception;
     
     List<Lesson> getLessonByStudentId(Long studentId) throws Exception;

     void addLesson(Lesson lesson) throws Exception;
}
