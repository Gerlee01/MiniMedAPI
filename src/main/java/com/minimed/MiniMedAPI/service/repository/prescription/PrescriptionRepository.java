package com.minimed.MiniMedAPI.service.repository.prescription;

import com.minimed.MiniMedAPI.entity.prescription.Prescription;
import com.minimed.MiniMedAPI.service.repository.BaseRepository;

import java.util.List;

public interface PrescriptionRepository extends BaseRepository<Prescription> {
    List<Prescription> findAllByPatientID(Long id);
}
