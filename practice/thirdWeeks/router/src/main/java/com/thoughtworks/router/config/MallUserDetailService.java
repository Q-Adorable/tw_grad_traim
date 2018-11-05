package com.thoughtworks.router.config;

import com.thoughtworks.router.entity.User;
import com.thoughtworks.router.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MallUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username).orElseThrow(null);
        if (user == null) {
            throw new UsernameNotFoundException(String.format("%s dosen't exist!", username));
        } else {
            return new com.thoughtworks.router.login.JwtUser(user);
        }

    }
}
