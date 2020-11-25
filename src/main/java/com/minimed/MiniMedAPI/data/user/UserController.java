package com.minimed.MiniMedAPI.data.user;

import com.minimed.MiniMedAPI.entity.user.User;
import com.minimed.MiniMedAPI.service.exception.ResourceNotFoundException;
import com.minimed.MiniMedAPI.service.security.CurrentUser;
import com.minimed.MiniMedAPI.service.security.UserPrincipal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/name")
    public String getName(@RequestBody String patientUuid) {
        return service.getName(patientUuid);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAll() {
        return Optional.ofNullable(service.findAll()).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/me")
    public User getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        Optional<User> user = service.findByUsername(currentUser.getUsername());
        return user.orElseThrow(() -> new ResourceNotFoundException("User", "username", currentUser.getUsername()));
    }
}
