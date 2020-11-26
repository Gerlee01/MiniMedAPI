package com.minimed.MiniMedAPI.data.address;

import com.minimed.MiniMedAPI.entity.address.Address;

public interface AddressService {
    Address findByUuid(String uuid);
}
