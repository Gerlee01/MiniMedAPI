package com.minimed.MiniMedAPI.data.user;

import com.minimed.MiniMedAPI.entity.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    String getName(String patientUuid);

    Optional<User> findByUsername(String username);

    List<User> findAll();
}
