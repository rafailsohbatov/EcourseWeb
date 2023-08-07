package com.example.ecourseweb.servlet;

import com.example.ecourseweb.dao.StudentDao;
import com.example.ecourseweb.dao.StudentDaoImpl;
import com.example.ecourseweb.model.Student;
import com.example.ecourseweb.service.StudentService;
import com.example.ecourseweb.service.StudentServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "StudentServlet", value = "/ss")
public class StudentServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            StudentDao studentDao = new StudentDaoImpl();
            StudentService studentService = new StudentServiceImpl(studentDao);
            String action = null;
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            action = request.getParameter("action");
            if (action.equalsIgnoreCase("getStudentList")) {
                List<Student> studentList = studentService.getStudentList();
                request.setAttribute("studentList",studentList);
                request.getRequestDispatcher("WEB-INF/pages/studentList.jsp").forward(request,response);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}