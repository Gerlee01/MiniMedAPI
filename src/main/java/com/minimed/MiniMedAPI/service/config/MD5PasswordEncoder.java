package com.minimed.MiniMedAPI.service.config;

import com.minimed.MiniMedAPI.service.util.MD5;
import lombok.extern.log4j.Log4j;
import org.springframework.security.crypto.password.PasswordEncoder;

@Log4j
public class MD5PasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return MD5.encode(charSequence.toString());
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(MD5.encode(charSequence.toString()));
    }

}
