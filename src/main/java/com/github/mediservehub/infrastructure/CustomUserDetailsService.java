package com.github.mediservehub.infrastructure;

import com.github.mediservehub.domain.user.User;
import com.github.mediservehub.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new CustomUserDetails(userRepository.findUserByUsername(username).orElseThrow
                (() -> new AuthenticationServiceException("Invalid username")));
    }

    public static class CustomUserDetails implements UserDetails {

        private final SimpleGrantedAuthority USER_DOCTOR = new SimpleGrantedAuthority("ROLE_DOCTOR");

        private final SimpleGrantedAuthority USER_MANAGER = new SimpleGrantedAuthority("ROLE_MANAGER");

        private final Collection<? extends GrantedAuthority> ROLES_USER =
                Arrays.asList(USER_DOCTOR, USER_MANAGER);

        private final Long id;

        private final String username;

        private final String password;

        private final Collection<? extends GrantedAuthority> roles;

        public CustomUserDetails(final User user) {
            this.id = user.getId();
            this.username = user.getUsername();
            this.password = user.getPassword();
            roles = ROLES_USER;
        }

        public Long getId() {
            return id;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return roles;
        }

        @Override
        public String getPassword() {
            return password;
        }

        @Override
        public String getUsername() {
            return username;
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

    }
}
