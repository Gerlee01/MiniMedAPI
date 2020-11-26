package com.minimed.MiniMedAPI.data.patient;


import com.minimed.MiniMedAPI.entity.patient.Patient;

public interface PatientService {
    Patient getPatient(String patientUuid);
}
