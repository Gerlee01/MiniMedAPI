package com.minimed.MiniMedAPI.service.repository.user;

import com.minimed.MiniMedAPI.entity.user.User;
import com.minimed.MiniMedAPI.service.repository.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends BaseRepository<User> {
    Optional<User> findByUsername(String username);

    Optional<User> findByUuid(String id);

    List<User> findAll();
}
