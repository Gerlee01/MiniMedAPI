package com.minimed.MiniMedAPI.data.history;

import com.minimed.MiniMedAPI.data.patient.PatientService;
import com.minimed.MiniMedAPI.data.user.UserService;
import com.minimed.MiniMedAPI.entity.history.History;
import com.minimed.MiniMedAPI.entity.patient.Patient;
import com.minimed.MiniMedAPI.entity.user.User;
import com.minimed.MiniMedAPI.model.ChartHistoryModel;
import com.minimed.MiniMedAPI.model.HistoryModel;
import com.minimed.MiniMedAPI.service.security.CurrentUser;
import com.minimed.MiniMedAPI.service.security.UserPrincipal;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j
@RestController
@RequestMapping("api/history")
public class HistoryController {
    final HistoryService historyService;
    final PatientService patientService;
    final UserService userService;


    public HistoryController(HistoryService historyService, PatientService patientService, UserService userService) {
        this.historyService = historyService;
        this.patientService = patientService;
        this.userService = userService;
    }

    @GetMapping("/all/{type}")
    public List<HistoryModel> findAll(@PathVariable("type") String type, @CurrentUser UserPrincipal currentUser) {
        Optional<User> user = userService.findByUsername(currentUser.getUsername());
        if (user.isEmpty()) return new ArrayList<>();
        Patient patient = patientService.getPatient(user.get().getParentUuid());
        if (patient == null) return new ArrayList<>();
        List<History> histories = historyService.findAllByPatientIdAndType(patient.getId(), History.Type.valueOf(type));
        if (histories == null || histories.isEmpty()) return new ArrayList<>();

        List<HistoryModel> results = new ArrayList<>();
        histories.forEach(f -> {
            HistoryModel model = new HistoryModel();
            model.setId(f.getId());
            model.setTargetDate(LocalDateTime.of(f.getTargetDate(), LocalTime.MAX));
            model.setTargetTime(f.getTargetTime() == null ? LocalDateTime.now() : LocalDateTime.of(LocalDate.now(), f.getTargetTime()));
            model.setTargetNumber(f.getTargetNumber());
            model.setType(f.getTypeIndex());
            model.setStatus(f.getStatusIndex());
            model.setPdf(f.getPdf());
            model.setCreated(f.getCreated());
            results.add(model);
        });

        return results;
    }

    @GetMapping("/chart/{type}")
    public ChartHistoryModel findChartValue(@PathVariable("type") String type, @CurrentUser UserPrincipal currentUser){
        Optional<User> user = userService.findByUsername(currentUser.getUsername());
        if (user.isEmpty()) return null;
        Patient patient = patientService.getPatient(user.get().getParentUuid());
        if (patient == null) return null;
        List<History> histories = historyService.findAllByPatientIdAndType(patient.getId(), History.Type.valueOf(type));
        if (histories == null || histories.isEmpty()) return null;
        int irsen = 0;
        int ireegvi = 0;
        for (History f : histories) {
            if(f.getStatus().equals(History.Status.active)) irsen++;
            else ireegvi++;
        }
        double size = histories.size();
        double onepre = 100 / size;
        return ChartHistoryModel.builder().irsen(irsen*onepre).ireegvi(ireegvi*onepre).build();
    }
}