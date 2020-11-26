package com.minimed.MiniMedAPI.data.address;

import com.minimed.MiniMedAPI.entity.address.Address;
import com.minimed.MiniMedAPI.service.repository.address.AddressRepository;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address findByUuid(String uuid){
        return addressRepository.findByUuid(uuid);
    }
}
