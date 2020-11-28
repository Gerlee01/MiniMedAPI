package com.minimed.MiniMedAPI.service.security.service;

import lombok.extern.log4j.Log4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Log4j
public class PasswordEncoderServiceImpl implements PasswordEncoderService {

    /**
     * Нууц үг encode хийх
     *
     * @param value нууц үг
     * @return encode хийсэн нууц үг
     */
    @Override
    public String encodeBCrypto(String value) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.encode(value);
    }
}
