package com.minimed.MiniMedAPI.service.repository.address;

import com.minimed.MiniMedAPI.entity.address.Address;
import com.minimed.MiniMedAPI.service.repository.BaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends BaseRepository<Address> {
    Address findByUuid(String uuid);
}
