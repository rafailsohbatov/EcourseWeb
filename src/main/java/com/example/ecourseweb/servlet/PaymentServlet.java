package com.example.ecourseweb.servlet;

import com.example.ecourseweb.dao.*;
import com.example.ecourseweb.model.Lesson;
import com.example.ecourseweb.model.Payment;
import com.example.ecourseweb.model.Student;
import com.example.ecourseweb.model.Teacher;
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

            } else if (action.equalsIgnoreCase("addPayment")) {
                List<Student> studentList = studentService.getStudentList();
                List<Lesson> lessonList = lessonService.getLessonList();
                List<Teacher> teacherList = teacherService.getTeacherList();
                request.setAttribute("studentList", studentList);
                request.setAttribute("teacherList", teacherList);
                request.setAttribute("lessonList", lessonList);
                pageAddress = "views/newPayment.jsp";
            }

            if (pageAddress != null) {
                request.getRequestDispatcher(pageAddress).forward(request, response);
                System.out.println(pageAddress);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
