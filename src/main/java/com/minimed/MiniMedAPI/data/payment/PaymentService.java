package com.minimed.MiniMedAPI.data.payment;

import com.minimed.MiniMedAPI.entity.payment.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> findAll(Long patientId);
}
