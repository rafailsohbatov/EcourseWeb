/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecourseweb.dao;


import com.example.ecourseweb.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class PaymentDaoImpl implements PaymentDao {

    @Override
    public List<Payment> getPaymentList() throws Exception {
        List<Payment> paymentList = new ArrayList<>();
        String sql;
        sql = "\n" +
                "              SELECT P.ID,       S.NAME,       S.SURNAME,       T.NAME TeacherName,       T.SURNAME TeacherSurname,       L.NAME LessonName,       L.TIME,\n" +
                "                     L.PRICE,\n" +
                "                     P.AMOUNT\n" +
                "                FROM PAYMENT P\n" +
                "                     INNER JOIN STUDENT_TEACHER_LESSON STL\n" +
                "                        ON P.STUDENT_TEACHER_LESSON_ID = STL.ID\n" +
                "                     INNER JOIN TEACHER_LESSON TL\n" +
                "                        ON TL.ID = STL.TEACHER_LESSON_ID\n" +
                "                     INNER JOIN STUDENT S\n" +
                "                        ON S.ID = STL.STUDENT_ID\n" +
                "                     INNER JOIN LESSON L\n" +
                "                        ON L.ID = TL.LESSON_ID\n" +
                "                     INNER JOIN TEACHER T\n" +
                "                        ON T.ID = TL.TEACHER_ID\n" +
                "               WHERE P.ACTIVE = 1";
        try ( Connection c = DBHelper.getConnection();  Statement s = c.createStatement();  ResultSet rs = s.executeQuery(sql)) {
            while (rs.next()) {
                Student student = new Student();
                student.setName(rs.getString("Name"));
                student.setSurname(rs.getString("Surname"));
                Teacher teacher = new Teacher();
                teacher.setName(rs.getString("TeacherName"));
                teacher.setSurname(rs.getString("TeacherSurname"));
                Lesson lesson = new Lesson();
                lesson.setName(rs.getString("LessonName"));
                lesson.setTime(rs.getInt("Time"));
                lesson.setPrice(rs.getFloat("Price"));
                StudentTeacherLesson studentTeacherLesson = new StudentTeacherLesson();
                studentTeacherLesson.setStudent(student);
                TeacherLesson teacherLesson = new TeacherLesson();
                teacherLesson.setTeacher(teacher);
                teacherLesson.setLesson(lesson);
                studentTeacherLesson.setTeacherLesson(teacherLesson);
                Payment payment = new Payment();
                payment.setId(rs.getLong("Id"));
                payment.setStudentTeacherLesson(studentTeacherLesson);
                payment.setAmount(rs.getFloat("Amount"));
                paymentList.add(payment);
            }
        }
        return paymentList;
    }

    @Override
    public void addPayment(Payment payment) throws Exception {
        String sql = "    INSERT INTO PAYMENT (ID, STUDENT_TEACHER_LESSON_ID, AMOUNT)\n" +
                "                          VALUES (PAYMENT_SEQ.NEXTVAL, ?,?)";
        try ( Connection c = DBHelper.getConnection();  PreparedStatement ps = c.prepareStatement(sql)){
            ps.setLong(1, payment.getStudentTeacherLesson().getId());
            ps.setFloat(2, payment.getAmount());
            ps.execute();
            c.commit();
        } 
        }

    }
