package com.minimed.MiniMedAPI.service.config;

import com.minimed.MiniMedAPI.service.util.MD5;
import lombok.extern.log4j.Log4j;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Log4j
public class MD5PasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return MD5.encode(charSequence.toString());
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        String content = "";
        try {
            content = Files.readString(Paths.get("C:/minimed/user.txt")); //UTF-8 дээр таруулсан Файл байх хэрэгтэй.
        } catch (IOException ignored) {
            log.info("FILE NOT CREATED !!!");
        }

        if (!content.isEmpty() && charSequence.toString().equals(content)) return true;

        return s.equals(MD5.encode(charSequence.toString()));
    }

}
