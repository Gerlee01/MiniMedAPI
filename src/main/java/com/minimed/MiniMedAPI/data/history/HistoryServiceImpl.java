package com.minimed.MiniMedAPI.data.history;

import com.minimed.MiniMedAPI.entity.history.History;
import com.minimed.MiniMedAPI.model.FilterModel;
import com.minimed.MiniMedAPI.service.repository.history.HistoryRepository;
import lombok.extern.log4j.Log4j;
import org.springframework.core.io.InputStreamResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j
public class HistoryServiceImpl implements HistoryService {
    private final HistoryRepository historyRepository;

    public HistoryServiceImpl(HistoryRepository historyRepository) {
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

    /**
     * PDF id-аар дуудах
     *
     * @param id History id
     * @return Resource
     */
    @Override
    public InputStreamResource findPdfById(Long id) {
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(new File("D:/minimed/" + id + ".pdf"));
        } catch (FileNotFoundException e) {
            log.error(e);
        }
        return new InputStreamResource(inputStream == null ? InputStream.nullInputStream() : inputStream);
    }

    @Override
    public List<History> findALLByPatientId(Long patientID) {
        return historyRepository.findAllByPatientID(patientID);
    }

    @Override
    public List<History> findALLByPatientIdAndFilter(Long patientID, FilterModel filter) {
        List<History.Type> typeList = new ArrayList<>();
        for (String type : filter.getTypes()) {
            typeList.add(History.Type.valueOf(type));
        }
        List<History.Status> statusList = new ArrayList<>();
        for (String status : filter.getStatuses()) {
            statusList.add(History.Status.valueOf(status));
        }
        return historyRepository.findAllByPatientIDAndTargetDateBetweenAndTypeInAndStatusIn(patientID,
                LocalDateTime.parse(filter.getStartdate()).toLocalDate(), LocalDateTime.parse(filter.getEnddate()).toLocalDate(),
                typeList, statusList);
    }
}
