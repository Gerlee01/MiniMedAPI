package com.minimed.MiniMedAPI.data.patient;

import com.minimed.MiniMedAPI.entity.patient.Patient;
import com.minimed.MiniMedAPI.service.repository.patient.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient getPatient(String patientUuid) {
        Optional<Patient> patient = patientRepository.findByUuid(patientUuid);
        return patient.orElse(null);

    }
}
