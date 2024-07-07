package com.scm.services.servicesImplementation;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm.entities.User;
import com.scm.helpers.ResourceNotFoundException;
import com.scm.repositories.UserRepository;
import com.scm.services.UserService;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUSer(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return this.userRepository.findById(id);
    }

    @Override
    public Optional<User> updateUser(User user, Long id) {
        User user2 = this.userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found exception"));

        user2.setName(user.getName());
        user2.setEmail(user.getEmail());
        user2.setPassword(user.getPassword());
        user2.setAbout(user.getAbout());
        user2.setPhone(user.getPhone());
        user2.setProfile(user.getProfile());
        user2.setEmailVerified(user.isEmailVerified());
        user2.setPhoneVerified(user.isPhoneVerified());
        user2.setEnabled(user.isEnabled());
        user2.setProvider(user.getProvider());
        user2.setProviderUserId(user.getProviderUserId());

        User save = this.userRepository.save(user2);

        return Optional.ofNullable(save);
    }

    @Override
    public void deleteUser(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public boolean isUserExist(Long id) {
        return this.userRepository.findById(id).orElse(null) != null;
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        return this.userRepository.findByEmail(email).orElse(null) != null;
    }

    @Override
    public Optional<List<User>> getAllUser() {
        List<User> users = this.userRepository.findAll();
        
        return users.isEmpty() ? Optional.empty() : Optional.of(users);
    }
}
