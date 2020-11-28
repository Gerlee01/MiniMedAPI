package com.minimed.MiniMedAPI.data.patient;

import com.minimed.MiniMedAPI.data.address.AddressService;
import com.minimed.MiniMedAPI.data.user.UserService;
import com.minimed.MiniMedAPI.entity.address.Address;
import com.minimed.MiniMedAPI.entity.patient.Patient;
import com.minimed.MiniMedAPI.entity.user.User;
import com.minimed.MiniMedAPI.model.PatientModel;
import com.minimed.MiniMedAPI.service.security.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("api/patient")
public class PatientController {
    private final PatientService patientService;
    private final UserService userService;
    private final AddressService addressService;

    @Autowired
    public PatientController(PatientService patientService, UserService userService, AddressService addressService) {
        this.patientService = patientService;
        this.userService = userService;
        this.addressService = addressService;
    }

    @GetMapping("/getPatient")
    public PatientModel getPatient(@CurrentUser UserDetails currentUser) {
        Optional<User> user = userService.findByUsername(currentUser.getUsername());
        if (user.isEmpty()) return null;

        Patient patient = patientService.getPatient(user.get().getParentUuid());
        if (patient == null) return null;

        Address address = addressService.findByUuid(patient.getAddressUuid());
        if (address == null) return null;

        return PatientModel.builder()
                .id(patient.getId())
                .firstName(patient.getFirstName())
                .lastName(patient.getLastName())
                .regNum(patient.getRegNum())
                .cardNo(patient.getCardNo())
                .mail(patient.getMail())
                .phone(patient.getPhone())
                .created(patient.getCreated())
                .city(address.getCity().getValue())
                .district(address.getDistrict().getValue())
                .khoroo(address.getKhoroo().getValue())
                .block(address.getBlock())
                .house(address.getHouse())
                .number(address.getNumber())
                .build();
    }
}
