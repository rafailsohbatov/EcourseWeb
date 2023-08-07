package com.example.ecourseweb.servlet;

import com.example.ecourseweb.dao.PaymentDao;
import com.example.ecourseweb.dao.PaymentDaoImpl;
import com.example.ecourseweb.model.Payment;
import com.example.ecourseweb.service.PaymentService;
import com.example.ecourseweb.service.PaymentServiceImpl;

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
            PaymentDao paymentDao = new PaymentDaoImpl();
            PaymentService paymentService = new PaymentServiceImpl(paymentDao);
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            action = request.getParameter("action");
            if (action.equalsIgnoreCase("getPaymentList")) {
                List<Payment> paymentList = paymentService.getPaymentList();
                request.setAttribute("paymentList", paymentList);
                request.getRequestDispatcher("WEB-INF/pages/paymentList.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
