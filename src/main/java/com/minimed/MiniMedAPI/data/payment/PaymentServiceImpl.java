package com.minimed.MiniMedAPI.data.payment;

import com.minimed.MiniMedAPI.data.history.HistoryService;
import com.minimed.MiniMedAPI.entity.payment.Payment;
import com.minimed.MiniMedAPI.service.repository.payment.PaymentRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Log4j
public class PaymentServiceImpl implements PaymentService{
    final PaymentRepository paymentRepository;
    final HistoryService historyService;


    public PaymentServiceImpl(PaymentRepository paymentRepository, HistoryService historyService) {
        this.paymentRepository = paymentRepository;
        this.historyService = historyService;
    }

    @Override
    public List<Payment> findAll(Long patientId){
        log.info(patientId);
        List<String> uuids = historyService.findMainUuidByPatientId(patientId);
        log.info(uuids.size());
        log.info(paymentRepository.findAllByMainUuidIn(uuids));
        return uuids == null || uuids.isEmpty() ? null : paymentRepository.findAllByMainUuidIn(uuids);
    }

}
