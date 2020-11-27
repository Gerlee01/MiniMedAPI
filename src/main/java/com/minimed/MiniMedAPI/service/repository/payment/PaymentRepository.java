package com.minimed.MiniMedAPI.service.repository.payment;

import com.minimed.MiniMedAPI.entity.payment.Payment;
import com.minimed.MiniMedAPI.service.repository.BaseRepository;

import java.util.List;

public interface PaymentRepository extends BaseRepository<Payment> {
    List<Payment> findAllByMainUuidIn(List<String> uuids);
}
