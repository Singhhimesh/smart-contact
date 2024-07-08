package com.scm.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.scm.repositories.UserRepository;
import com.scm.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class SecurityCustomUserDetailsService implements UserDetailsService {
    private static final Logger logger = LoggerFactory.getLogger(SecurityCustomUserDetailsService.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        logger.info("Loading user by email: {}", email);
        User user = userRepository.findByEmail(email);
        if (user == null) {
            logger.error("User not found with email: {}", email);
            throw new UsernameNotFoundException("User not found");
        }
        logger.info("User found: {}", user);
        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                true, true, true, true,
                user.getAuthorities());
    }
}
