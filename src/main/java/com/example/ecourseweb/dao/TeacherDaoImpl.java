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
 * @author Admin
 */
public class TeacherDaoImpl implements TeacherDao {

    @Override
    public List<Teacher> getTeacherList() throws Exception {
        List<Teacher> list = new ArrayList<>();
        String sql = "SELECT * FROM Teacher WHERE ACTIVE = 1";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql); ResultSet rs = ps.executeQuery()) {

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
    public void addTeacher(Teacher teacher) throws Exception {
        String sql = "INSERT INTO TEACHER(ID,NAME,SURNAME,DOB,ADDRESS,PHONE,WORK_EXPERIENCE)" +
                "VALUES(TEACHER_SEQ.NEXTVAL,?,?,?,?,?,?)";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, teacher.getName());
            ps.setString(2, teacher.getSurname());
            ps.setDate(3, new java.sql.Date(teacher.getDob().getTime()));
            ps.setString(4, teacher.getAddress());
            ps.setString(5, teacher.getPhone());
            ps.setInt(6, teacher.getWork_experience());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public List<Teacher> getTeacherListByLessonId(Long lessonId) throws Exception {
        List<Teacher> list = new ArrayList<>();
        String sql = "select t.id,t.name ,t.surname from teacher_lesson tl inner join teacher t on t.id = TL.TEACHER_ID \n" +
                "                     inner join lesson l on l.id = tl.LESSON_ID WHERE TL.ACTIVE = 1 AND l.id = ? ";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

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
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, teacherId);
            ps.setLong(2, LessonId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                teacherLesson.setId(rs.getLong("Id"));
            }
        }
        return teacherLesson;
    }

    @Override
    public List<Teacher> getTeacherListByLessonIdAndStudentId(Long lessonId, Long studentId) throws Exception {
        List<Teacher> list = new ArrayList<>();
        String sql =
                "              SELECT  T.ID,T.NAME,T.SURNAME" +
                        "                     FROM STUDENT_TEACHER_LESSON STL\n" +
                        "                     INNER JOIN TEACHER_LESSON TL\n" +
                        "                        ON TL.ID = STL.TEACHER_LESSON_ID\n" +
                        "                     INNER JOIN STUDENT S\n" +
                        "                        ON S.ID = STL.STUDENT_ID\n" +
                        "                     INNER JOIN LESSON L\n" +
                        "                        ON L.ID = TL.LESSON_ID\n" +
                        "                     INNER JOIN TEACHER T\n" +
                        "                        ON T.ID = TL.TEACHER_ID\n" +
                        "               WHERE STL.ACTIVE = 1 AND L.ID = ? AND S.ID = ?";
        try (Connection c = DBHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {
            ps.setLong(1, lessonId);
            ps.setLong(2, studentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getLong("ID"));
                teacher.setName(rs.getString("NAME"));
                teacher.setSurname(rs.getString("SURNAME"));
                list.add(teacher);
            }
        }
        return list;
    }

}
