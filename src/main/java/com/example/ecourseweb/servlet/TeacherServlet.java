package com.example.ecourseweb.servlet;

import com.example.ecourseweb.dao.TeacherDao;
import com.example.ecourseweb.dao.TeacherDaoImpl;
import com.example.ecourseweb.model.Teacher;
import com.example.ecourseweb.service.TeacherService;
import com.example.ecourseweb.service.TeacherServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "TeacherServlet", value = "/ts")
public class TeacherServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
            String action = null;
            TeacherDao teacherDao = new TeacherDaoImpl();
            TeacherService teacherService = new TeacherServiceImpl(teacherDao);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            action = request.getParameter("action");
            if (action.equalsIgnoreCase("getTeacherList")) {
                List<Teacher> teacherList = teacherService.getTeacherList();
                request.setAttribute("teacherList", teacherList);
                request.getRequestDispatcher("WEB-INF/pages/teacherList.jsp").forward(request, response);
            } else if (action.equalsIgnoreCase("addTeacher")) {
                Teacher teacher = new Teacher();
                teacher.setName(request.getParameter("name"));
                teacher.setSurname(request.getParameter("surname"));
                teacher.setDob(df.parse(request.getParameter("dob")));
                teacher.setAddress(request.getParameter("address"));
                teacher.setPhone(request.getParameter("phone"));
                teacher.setWork_experience(Integer.valueOf(request.getParameter("workExperience")));
                teacherService.addTeacher(teacher);
                out.write("success");
            } else if (action.equalsIgnoreCase("getTeacherListByLessonIdAndStudentId")){
                Long lessonId = Long.parseLong(request.getParameter("lessonId"));
                Long studentId = Long.parseLong(request.getParameter("studentId"));
                List<Teacher> teacherList = teacherService.getTeacherListByLessonIdAndStudentId(lessonId,studentId);
                request.setAttribute("teacherList",teacherList);
                request.getRequestDispatcher("WEB-INF/pages/teacherCombo.jsp").forward(request,response);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
