package com.minimed.MiniMedAPI.data.history;

import com.minimed.MiniMedAPI.entity.history.History;
import com.minimed.MiniMedAPI.model.FilterModel;
import org.springframework.core.io.InputStreamResource;

import java.util.List;

public interface HistoryService {
    List<String> findMainUuidByPatientId(Long patientID);

    List<History> findALLByPatientId(Long patientID);

    List<History> findAllByPatientIdAndType(Long patientID, History.Type type);

    InputStreamResource findPdfById(Long id);

    List<History> findALLByPatientIdAndFilter(Long patientID, FilterModel filter);
}
