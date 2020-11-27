package com.minimed.MiniMedAPI.data.payment;

import com.minimed.MiniMedAPI.data.patient.PatientService;
import com.minimed.MiniMedAPI.data.user.UserService;
import com.minimed.MiniMedAPI.entity.patient.Patient;
import com.minimed.MiniMedAPI.entity.payment.Payment;
import com.minimed.MiniMedAPI.entity.user.User;
import com.minimed.MiniMedAPI.service.security.CurrentUser;
import com.minimed.MiniMedAPI.service.security.UserPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/payment")
public class PaymentController {
    final PaymentService paymentService;
    final PatientService patientService;
    final UserService userService;

    public PaymentController(PaymentService paymentService, PatientService patientService, UserService userService) {
        this.paymentService = paymentService;
        this.patientService = patientService;
        this.userService = userService;
    }

    @GetMapping("/all")
    public List<Payment> findAll(@CurrentUser UserPrincipal currentUser) {
        Optional<User> user = userService.findByUsername(currentUser.getUsername());
        if(user.isEmpty()) return null;
        Patient patient = patientService.getPatient(user.get().getParentUuid());
        if(patient== null) return null;
        return paymentService.findAll(patient.getId());
    }
}
