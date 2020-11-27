package com.minimed.MiniMedAPI.data.history;

import com.minimed.MiniMedAPI.entity.history.History;
import com.minimed.MiniMedAPI.service.repository.history.HistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HIstoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;

    public HIstoryServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    @Override
    public List<String> findMainUuidByPatientId(Long patientID) {
        return historyRepository.findAllByPatientID(patientID).stream()
                .filter(f -> f.getPatientID().equals(patientID)).map(History::getTimeTableUuid)
                .collect(Collectors.toList());
    }

    @Override
    public List<History> findAllByPatientIdAndType(Long patientID, History.Type type) {
        return historyRepository.findAllByPatientIDAndType(patientID, type);
    }

    @Override
    public List<History> findALLByPatientId(Long patientID){
        return historyRepository.findAllByPatientID(patientID);
    }
}
