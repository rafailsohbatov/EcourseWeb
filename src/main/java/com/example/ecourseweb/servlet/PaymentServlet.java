package com.example.ecourseweb.servlet;

import com.example.ecourseweb.dao.*;
import com.example.ecourseweb.model.*;
import com.example.ecourseweb.service.*;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "PaymentServlet", value = "/ps")
public class PaymentServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        try {
            String action = null;
            String pageAddress = null;
            PaymentDao paymentDao = new PaymentDaoImpl();
            PaymentService paymentService = new PaymentServiceImpl(paymentDao);
            StudentDao studentDao = new StudentDaoImpl();
            StudentService studentService = new StudentServiceImpl(studentDao);
            LessonDao lessonDao = new LessonDaoImpl();
            LessonService lessonService = new LessonServiceImpl(lessonDao);
            TeacherDao teacherDao = new TeacherDaoImpl();
            TeacherService teacherService = new TeacherServiceImpl(teacherDao);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            action = request.getParameter("action");
            if (action.equalsIgnoreCase("getPaymentList")) {
                List<Payment> paymentList = paymentService.getPaymentList();
                request.setAttribute("paymentList", paymentList);
                pageAddress = "WEB-INF/pages/paymentList.jsp";

            } else if (action.equalsIgnoreCase("newPayment")) {
                List<Student> studentList = studentService.getStudentList();
                List<Lesson> lessonList = lessonService.getLessonList();
                List<Teacher> teacherList = teacherService.getTeacherList();
                request.setAttribute("studentList", studentList);
                request.setAttribute("teacherList", teacherList);
                request.setAttribute("lessonList", lessonList);
                pageAddress = "views/newPayment.jsp";
            } else if (action.equalsIgnoreCase("addPayment")) {
                Long studentId = Long.parseLong(request.getParameter("studentId"));
                Long teacherId = Long.parseLong(request.getParameter("teacherId"));
                Long lessonId = Long.parseLong(request.getParameter("lessonId"));
                Student student = studentService.getStudentById(studentId);
                TeacherLesson teacherLesson = teacherService.getTeacherLessonByTeacherAndLessonId(teacherId, lessonId);
                StudentTeacherLesson studentTeacherLesson = studentService.getStudentTeacherLessonById(studentId, teacherLesson.getId());
                Payment payment = new Payment();
                payment.setStudentTeacherLesson(studentTeacherLesson);
                payment.setAmount(Float.valueOf(request.getParameter("amount")));
                paymentService.addPayment(payment);
                out.write("success");
            } else if (action.equalsIgnoreCase("getPaymentData")){
                List<Payment> paymentList = paymentService.getPaymentList();
                request.setAttribute("paymentList", paymentList);
                pageAddress = "WEB-INF/pages/paymentData.jsp";
                System.out.println("x?");
            }
            if (pageAddress != null) {
                request.getRequestDispatcher(pageAddress).forward(request, response);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
