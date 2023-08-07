/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecourseweb.dao;


import com.example.ecourseweb.model.Teacher;
import com.example.ecourseweb.model.TeacherLesson;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class TeacherDaoImpl implements TeacherDao {

    @Override
    public List<Teacher> getTeacherList() throws Exception {
        List<Teacher> list = new ArrayList<>();
        String sql = "SELECT * FROM Teacher WHERE ACTIVE = 1";
        try ( Connection c = DBHelper.getConnection();  PreparedStatement ps = c.prepareStatement(sql);  ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getLong("Id"));
                teacher.setName(rs.getString("Name"));
                teacher.setSurname(rs.getString("Surname"));
                teacher.setDob(rs.getDate("Dob"));
                teacher.setAddress(rs.getString("Address"));
                teacher.setPhone(rs.getString("Phone"));
                teacher.setWork_experience(rs.getInt("Work_experience"));
                list.add(teacher);
            }
        }
        return list;
    }

    @Override
    public List<Teacher> getTeacherListByLessonId(Long lessonId) throws Exception {
        List<Teacher> list = new ArrayList<>();
        String sql = "select t.id,t.name ,t.surname from teacher_lesson tl inner join teacher t on t.id = TL.TEACHER_ID \n" +
                "                     inner join lesson l on l.id = tl.LESSON_ID WHERE TL.ACTIVE = 1 AND l.id = ? ";
        try ( Connection c = DBHelper.getConnection();  PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setLong(1, lessonId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getLong("Id"));
                teacher.setName(rs.getString("Name"));
                teacher.setSurname(rs.getString("Surname"));
                list.add(teacher);
            }
        }
        return list;
    }

    @Override
    public TeacherLesson getTeacherLessonByTeacherAndLessonId(Long teacherId, Long LessonId) throws Exception {
        String sql = "SELECT * FROM TEACHER_LESSON TL INNER JOIN TEACHER T ON T.ID = TL.TEACHER_ID "
                + "INNER JOIN LESSON L ON L.ID = TL.LESSON_ID WHERE TL.ACTIVE = 1 AND T.ID = ? AND L.ID = ? ";
        TeacherLesson teacherLesson = new TeacherLesson();
        try ( Connection c = DBHelper.getConnection();  PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, teacherId);
            ps.setLong(2, LessonId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                teacherLesson.setId(rs.getLong("Id"));
            }
        }
        return teacherLesson;
    }

}
