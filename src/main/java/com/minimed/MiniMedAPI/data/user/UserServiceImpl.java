package com.minimed.MiniMedAPI.data.user;

import com.minimed.MiniMedAPI.entity.user.User;
import com.minimed.MiniMedAPI.service.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public String getName(String patientUuid) {
        Optional<User> user = userRepository.findByUuid(patientUuid);

        if (user.isPresent()) {
            return user.get().getParentUuid();
        }

        return "Бүртгэл олдсонгүй.";
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
