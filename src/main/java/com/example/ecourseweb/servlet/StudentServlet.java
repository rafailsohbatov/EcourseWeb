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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            StudentService studentService = new StudentServiceImpl(studentDao);
            String action = null;
            String pageAddress = null;
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            action = request.getParameter("action");
            if (action.equalsIgnoreCase("getStudentList")) {
                List<Student> studentList = studentService.getStudentList();
                request.setAttribute("studentList", studentList);
                pageAddress = "WEB-INF/pages/studentList.jsp";
            } else if (action.equalsIgnoreCase("addStudent")) {
                Student student = new Student();
                student.setName(request.getParameter("name"));
                student.setSurname(request.getParameter("surname"));
                student.setDob(df.parse(request.getParameter("dob")));
                student.setAddress(request.getParameter("address"));
                student.setPhone(request.getParameter("phone"));
                studentService.addStudent(student);
                out.write("success");
            } else if (action.equalsIgnoreCase("getStudentData")){
                List<Student> studentList = studentService.getStudentList();
                request.setAttribute("studentList", studentList);
                pageAddress = "WEB-INF/pages/studentData.jsp";
            }
            if(pageAddress != null){
                request.getRequestDispatcher(pageAddress).forward(request, response);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}