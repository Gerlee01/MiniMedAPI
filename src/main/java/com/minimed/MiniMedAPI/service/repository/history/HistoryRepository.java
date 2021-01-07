package com.minimed.MiniMedAPI.service.repository.history;

import com.minimed.MiniMedAPI.entity.history.History;
import com.minimed.MiniMedAPI.service.repository.BaseRepository;

import java.time.LocalDate;
import java.util.List;

public interface HistoryRepository extends BaseRepository<History> {
    List<History> findAllByPatientID(Long patientID);
    List<History> findAllByPatientIDAndTargetDateBetweenAndTypeInAndStatusIn(Long patientID, LocalDate startDate,
                                                                              LocalDate endDate, List<History.Type> types,
                                                                              List<History.Status> statuses);
    List<History> findAllByPatientIDAndType(Long patientID, History.Type type);
}
