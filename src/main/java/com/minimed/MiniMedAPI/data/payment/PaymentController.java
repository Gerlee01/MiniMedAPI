package com.minimed.MiniMedAPI.data.payment;

import com.minimed.MiniMedAPI.data.patient.PatientService;
import com.minimed.MiniMedAPI.data.user.UserService;
import com.minimed.MiniMedAPI.entity.patient.Patient;
import com.minimed.MiniMedAPI.entity.payment.Payment;
import com.minimed.MiniMedAPI.entity.user.User;
import com.minimed.MiniMedAPI.model.ChartPaymentModel;
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
        if (user.isEmpty()) return null;
        Patient patient = patientService.getPatient(user.get().getParentUuid());
        if (patient == null) return null;
        return paymentService.findAll(patient.getId());
    }

    @GetMapping("/chart")
    public ChartPaymentModel findChartValue(@CurrentUser UserPrincipal currentUser) {
        Optional<User> user = userService.findByUsername(currentUser.getUsername());
        if (user.isEmpty()) return null;
        Patient patient = patientService.getPatient(user.get().getParentUuid());
        if (patient == null) return null;
        List<Payment> payments = paymentService.findAll(patient.getId());
        if (payments == null || payments.isEmpty()) return null;

        double price = 0;
        double discountPack = 0;
        double discountVip = 0;
        double discountEmergency = 0;
        double discountOutPatient = 0;
        double discountDiagnosis = 0;
        double discountInsurance = 0;
        double discountRepeat = 0;
        double discountFamily = 0;
        double discountPercent = 0;
        double mainPrice = 0;

        for (Payment payment : payments) {
            price += payment.getPrice();
            discountPack += payment.getDiscountPack();
            discountVip += payment.getDiscountVip();
            discountEmergency += payment.getDiscountEmergency();
            discountOutPatient += payment.getDiscountOutPatient();
            discountDiagnosis += payment.getDiscountDiagnosis();
            discountInsurance += payment.getDiscountInsurance();
            discountRepeat += payment.getDiscountRepeat();
            discountFamily += payment.getDiscountFamily();
            discountPercent += payment.getDiscountPercent();
            mainPrice += payment.getMainPrice();
        }

        double mainDis = discountPack +
                discountVip +
                discountEmergency +
                discountOutPatient +
                discountDiagnosis +
                discountInsurance +
                discountRepeat +
                discountFamily +
                discountPercent;

        ChartPaymentModel model = new ChartPaymentModel();
        model.setPrice(price * 100 / mainPrice);
        model.setMainPriceDis(mainDis * 100 / mainPrice);
        model.setDiscountPack(discountPack * 100 / mainDis);
        model.setDiscountVip(discountVip * 100 / mainDis);
        model.setDiscountEmergency(discountEmergency * 100 / mainDis);
        model.setDiscountOutPatient(discountOutPatient * 100 / mainDis);
        model.setDiscountDiagnosis(discountDiagnosis * 100 / mainDis);
        model.setDiscountInsurance(discountInsurance * 100 / mainDis);
        model.setDiscountRepeat(discountRepeat * 100 / mainDis);
        model.setDiscountFamily(discountFamily * 100 / mainDis);
        model.setDiscountPercent(discountPercent * 100 / mainDis);

        return model;
    }
}
