package com.minimed.MiniMedAPI.data.prescription;

import com.minimed.MiniMedAPI.data.patient.PatientService;
import com.minimed.MiniMedAPI.data.user.UserService;
import com.minimed.MiniMedAPI.entity.patient.Patient;
import com.minimed.MiniMedAPI.entity.prescription.Prescription;
import com.minimed.MiniMedAPI.entity.user.User;
import com.minimed.MiniMedAPI.model.PrescriptionModel;
import com.minimed.MiniMedAPI.service.security.CurrentUser;
import com.minimed.MiniMedAPI.service.security.UserPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/prescription")
public class PrescriptionController {
    final PrescriptionService service;
    final PatientService patientService;
    final UserService userService;

    public PrescriptionController(PrescriptionService service, PatientService patientService, UserService userService) {
        this.service = service;
        this.patientService = patientService;
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<PrescriptionModel> findAll(@CurrentUser UserPrincipal currentUser) {
        Optional<User> user = userService.findByUsername(currentUser.getUsername());
        if (user.isEmpty()) return new ArrayList<>();
        Patient patient = patientService.getPatient(user.get().getParentUuid());
        if (patient == null) return new ArrayList<>();
        List<Prescription> pres = service.findAllByPatientId(patient.getId());
        if (pres == null || pres.isEmpty()) return new ArrayList<>();

        List<PrescriptionModel> models = new ArrayList<>();
        pres.forEach(f -> {
            PrescriptionModel model = new PrescriptionModel();
            model.setId(f.getId());
            model.setPillName(f.getPillName()); //Эмийн нэр
            model.setDiagnosis(f.getDiagnosis()); //Онош

            model.setRp(f.getRp()); // тайлбар
            model.setNote(f.getNote()); // тайлбар
            model.setParmokokinetik(f.getParmokokinetik()); // Фармакокинетик үйлдэл
            model.setParmakodinamik(f.getParmakodinamik()); // Фармакодинамик үйлдэл
            model.setArga(f.getArga()); // Хэрэглэх арга
            model.setUsedtun(f.getUsedtun());
            model.setUsedtunMax(f.getUsedtunMax()); //Тун хэтэрсэн үед илрэх шинж, авах арга хэмжээ
            model.setNuloo(f.getNuloo()); // Гаж нөлөө
            model.setTseerlelt(f.getTseerlelt()); // Цээрлэлт
            model.setNemelt(f.getNemelt()); // Нэмэлт мэдлэг
            model.setUilchlel(f.getUilchlel()); // Үйлчлэл  Харилцан үйлчилгээ
            model.setZaalt(f.getZaalt()); // Хэрэглэх заалт
            model.setPregnantZaalt(f.getPregnantZaalt()); //Жирэмсэн ба хөхүүл үеийн хэрэглээ
            model.setOlgoh(f.getOlgoh()); // Олгох нөхцөл
            model.setHadgalah(f.getHadgalah()); // Хадгалах нөхцөл

            model.setDoctorFullName(f.getDoctorFullName()); //Жор бичсэн эмчийн бүтэн нэр
            model.setDoctorWorkPlace(f.getDoctorWorkPlace()); //Жор бичсэн эмчийн ажлын байрны нэршил
            model.setDoctorRegNum(f.getDoctorRegNum()); //Жор бичсэн эмчийн регистрийн дугаар
            model.setType(f.getTypeIndex()); //Эмийн төрөл
            model.setCreated(f.getCreated()); //Жор бичсэн өдөр
            models.add(model);
        });
        return models;
    }
}
