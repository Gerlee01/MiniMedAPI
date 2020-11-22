package com.minimed.MiniMedAPI.service.repository.patient;

import com.minimed.MiniMedAPI.entity.patient.Patient;
import com.minimed.MiniMedAPI.service.repository.BaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PatientRepository extends BaseRepository<Patient> {
    Optional<Patient> findByUuid(String id);
}
