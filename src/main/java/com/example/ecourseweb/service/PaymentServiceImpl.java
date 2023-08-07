/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecourseweb.service;

import com.example.ecourseweb.dao.PaymentDao;
import com.example.ecourseweb.model.Payment;

import java.util.List;

/**
 *
 * @author Admin
 */
public class PaymentServiceImpl implements PaymentService {

    private PaymentDao paymentDao;

    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public List<Payment> getPaymentList() throws Exception {
        return paymentDao.getPaymentList();
    }

    @Override
    public void addPayment(Payment payment) throws Exception {
        paymentDao.addPayment(payment);
    }

}
