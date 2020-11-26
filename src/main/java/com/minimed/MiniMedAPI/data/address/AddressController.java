package com.minimed.MiniMedAPI.data.address;

import com.minimed.MiniMedAPI.entity.address.Address;
import com.minimed.MiniMedAPI.service.repository.address.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping(path = "/{uuid}")
    private Address findByUuid(@PathVariable("uuid") String uuid) {
        return addressService.findByUuid(uuid);
    }
}
