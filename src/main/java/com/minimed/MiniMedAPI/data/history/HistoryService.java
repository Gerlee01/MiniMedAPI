package com.minimed.MiniMedAPI.data.history;

import java.util.List;

public interface HistoryService {
    List<String> findMainUuidByPatientId(Long patientID);
}
