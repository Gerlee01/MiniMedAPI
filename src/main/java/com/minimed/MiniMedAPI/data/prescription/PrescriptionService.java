package com.minimed.MiniMedAPI.data.prescription;

import com.minimed.MiniMedAPI.entity.prescription.Prescription;

import java.util.List;

public interface PrescriptionService {
    List<Prescription> findAllByPatientId(Long patientId);
}
