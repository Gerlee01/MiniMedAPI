package com.minimed.MiniMedAPI.data.history;

import com.minimed.MiniMedAPI.entity.history.History;
import com.minimed.MiniMedAPI.service.repository.history.HistoryRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j
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
    public InputStreamResource findPdfById(Long id) {
        File file = new File("D:/minimed/" + id + ".pdf");
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            log.error(e);
        }
        return new InputStreamResource(inputStream == null ? InputStream.nullInputStream() : inputStream);
    }

    @Override
    public List<History> findALLByPatientId(Long patientID) {
        return historyRepository.findAllByPatientID(patientID);
    }
}
