/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecourseweb.service;

import com.example.ecourseweb.model.Payment;

import java.util.List;

/**
 *
 * @author Admin
 */
public interface PaymentService {
    List<Payment> getPaymentList() throws Exception;
    
    public void addPayment(Payment payment) throws Exception;
}
