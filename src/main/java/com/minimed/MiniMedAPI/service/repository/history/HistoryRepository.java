package com.minimed.MiniMedAPI.service.repository.history;

import com.minimed.MiniMedAPI.entity.history.History;
import com.minimed.MiniMedAPI.service.repository.BaseRepository;

import java.util.List;

public interface HistoryRepository extends BaseRepository {
    List<History> findAllByPatientID(Long patientID);
}
