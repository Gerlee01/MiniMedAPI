package com.minimed.MiniMedAPI.service.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minimed.MiniMedAPI.entity.user.User;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

@Data
@Slf4j
public class UserPrincipal implements UserDetails {
    private String uuid;

    private String username;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(String uuid, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.uuid = uuid;
        this.username = username;
        this.password = password;
        Set<GrantedAuthority> as = new HashSet<>();
        for (GrantedAuthority a : authorities) {
            as.add(new SimpleGrantedAuthority("ROLE_" + a.getAuthority()));
        }
        this.authorities = as;
    }

    public static UserPrincipal create(User user) {
        List<GrantedAuthority> authorities = user.getRoles().stream().map(SimpleGrantedAuthority::new
        ).collect(Collectors.toList());

        return new UserPrincipal(
                user.getUuid(),
                user.getUsername(),
                user.getPassword(),
                authorities
        );
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(uuid, that.uuid);
    }

    @Override
    public int hashCode() {

        return Objects.hash(uuid);
    }
}
