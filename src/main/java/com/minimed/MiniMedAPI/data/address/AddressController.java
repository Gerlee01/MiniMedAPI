package com.minimed.MiniMedAPI.data.address;

import com.minimed.MiniMedAPI.service.repository.address.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/address")
public class AddressController {
    private final AddressRepository addressRepository;

    @Autowired
    public AddressController(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @GetMapping(path = "/haha/{block}")
    private String get(@PathVariable("block") String block) {
        return String.valueOf(addressRepository.findFirstByBlock(block).getId());
    }
}
