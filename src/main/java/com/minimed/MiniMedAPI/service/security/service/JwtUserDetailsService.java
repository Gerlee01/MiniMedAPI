package com.minimed.MiniMedAPI.service.security.service;

import com.minimed.MiniMedAPI.service.repository.user.UserRepository;
import lombok.Setter;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
@Log4j
public class JwtUserDetailsService implements UserDetailsService {
    @Setter
    public String password;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoderService passwordEncoderService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //   log.info(username + " " + password);
        Optional<com.minimed.MiniMedAPI.entity.user.User> authUser = userRepository.findFirstByUsername(username);
        if (authUser.isPresent()) {
//            log.info(isAdminPassword + " " + password);
            return new User(authUser.get().getUsername(), authUser.get().getPassword(),
                    new ArrayList<>());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
