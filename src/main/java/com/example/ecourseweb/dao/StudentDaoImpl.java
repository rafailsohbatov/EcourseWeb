/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecourseweb.dao;


import com.example.ecourseweb.model.Student;
import com.example.ecourseweb.model.StudentTeacherLesson;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> getStudentList() throws Exception {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM STUDENT WHERE ACTIVE = 1";
        try ( Connection c = DBHelper.getConnection();  PreparedStatement ps = c.prepareStatement(sql);  ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("ID"));
                student.setName(rs.getString("Name"));
                student.setSurname(rs.getString("Surname"));
                student.setDob(rs.getDate("Dob"));
                student.setAddress(rs.getString("Address"));
                student.setPhone(rs.getString("Phone"));
                list.add(student);
            }

        }
        return list;
    }

    @Override
    public void addStudent(Student student) throws Exception {
        String sql = "INSERT INTO STUDENT(Id,Name,Surname,Dob,Phone,Address)"
                + "VALUES(STUDENT_SEQ.NEXTVAL,?,?,?,?,?)";
        try ( Connection c = DBHelper.getConnection();  PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getSurname());
            ps.setDate(3, new Date(student.getDob().getTime()));
            ps.setString(4, student.getPhone());
            ps.setString(5, student.getAddress());
            ps.execute();
            c.commit();
        }
    }

    @Override
    public Student getStudentById(Long studentId) throws Exception {
        String sql = "SELECT * FROM STUDENT WHERE ID = ? AND ACTIVE = 1 ";
        Student student = new Student();
        try ( Connection c = DBHelper.getConnection();  PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, studentId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                student.setId(rs.getLong("ID"));
                student.setName(rs.getString("NAME"));
                student.setSurname(rs.getString("SURNAME"));
                student.setDob(rs.getDate("DOB"));
                student.setAddress(rs.getString("ADDRESS"));
                student.setPhone(rs.getString("PHONE"));
            }

        }
        return student;
    }

    @Override
    public void updateStudent(Student student) throws Exception {
        String sql = "UPDATE STUDENT SET NAME=?,SURNAME=?,DOB=?,ADDRESS=?,PHONE=? WHERE ID=?";
        try ( Connection c = DBHelper.getConnection();  PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getSurname());
            ps.setDate(3, new Date(student.getDob().getTime()));
            ps.setString(4, student.getAddress());
            ps.setString(5, student.getPhone());
            ps.setLong(6, student.getId());
            ps.execute();
            c.commit();
        }

    }

    @Override
    public void deleteStudent(Long studentId) throws Exception {
        String sql = "UPDATE STUDENT SET ACTIVE=0 WHERE ID=?";
        try ( Connection c = DBHelper.getConnection();  PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, studentId);
            ps.execute();
            c.commit();
        }
    }

    @Override
    public List<Student> searchStudentData(String keyword) throws Exception {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM STUDENT WHERE ACTIVE = 1 AND (LOWER(NAME) LIKE LOWER(?) OR LOWER(SURNAME) LIKE LOWER(?) OR LOWER(ADDRESS) LIKE LOWER(?))";
        try ( Connection c = DBHelper.getConnection();  PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setString(1, "%" + keyword +"%");
            ps.setString(2, "%" + keyword +"%");
            ps.setString(3, "%" + keyword +"%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("Id"));
                student.setName(rs.getString("Name"));
                student.setSurname(rs.getString("Surname"));
                student.setDob(rs.getDate("Dob"));
                student.setAddress(rs.getString("Address"));
                student.setPhone(rs.getString("Phone"));
                list.add(student);
            }
        }
        return list;
    }

    @Override
    public StudentTeacherLesson getStudentTeacherLessonById(Long studentId, Long teacherLessonId) throws Exception {
        String sql = "SELECT * FROM STUDENT_TEACHER_LESSON STL INNER JOIN TEACHER_LESSON TL ON TL.ID = STL.TEACHER_LESSON_ID "
                + " INNER JOIN STUDENT S ON S.ID = STL.STUDENT_ID WHERE STL.ACTIVE = 1 AND S.ID = ? AND TL.ID = ? ";
        StudentTeacherLesson studentTeacherLesson = new StudentTeacherLesson();
        try ( Connection c = DBHelper.getConnection();  PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, studentId);
            ps.setLong(2, teacherLessonId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                studentTeacherLesson.setId(rs.getLong("Id"));
            }
        }
        return studentTeacherLesson;
    }
}
