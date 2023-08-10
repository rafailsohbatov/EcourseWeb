package com.example.ecourseweb.servlet;

import com.example.ecourseweb.dao.LessonDao;
import com.example.ecourseweb.dao.LessonDaoImpl;
import com.example.ecourseweb.model.Lesson;
import com.example.ecourseweb.service.LessonService;
import com.example.ecourseweb.service.LessonServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "LessonServlet", value = "/ls")
public class LessonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try{
            LessonDao lessonDao = new LessonDaoImpl();
            LessonService lessonService = new LessonServiceImpl(lessonDao);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            String action = request.getParameter("action");
            if (action.equalsIgnoreCase("getLessonListByStudentId")) {
                Long studenId = Long.valueOf(request.getParameter("studentId"));
                List<Lesson> lessonList = lessonService.getLessonByStudentId(studenId);
                request.setAttribute("lessonList",lessonList);
                request.getRequestDispatcher("WEB-INF/pages/lessonCombo.jsp").forward(request,response);
            } else if (action.equalsIgnoreCase("getLessonList")){
                List<Lesson> lessonList = lessonService.getLessonList();
                request.setAttribute("lessonList",lessonList);
                request.getRequestDispatcher("WEB-INF/pages/lessonList.jsp").forward(request,response);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
