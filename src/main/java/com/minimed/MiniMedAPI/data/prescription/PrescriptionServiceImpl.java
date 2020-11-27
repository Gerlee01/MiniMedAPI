package com.minimed.MiniMedAPI.data.prescription;

import com.minimed.MiniMedAPI.entity.prescription.Prescription;
import com.minimed.MiniMedAPI.service.repository.prescription.PrescriptionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
    final PrescriptionRepository repository;

    public PrescriptionServiceImpl(PrescriptionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Prescription> findAllByPatientId(Long patientId){
        return repository.findAllByPatientID(patientId);
    }
}
