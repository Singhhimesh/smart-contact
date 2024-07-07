package com.scm.services;

import java.util.List;
import java.util.Optional;

import com.scm.entities.User;

public interface UserService {
    public User saveUSer(User user);

    public Optional<User> getUserById(Long id);

    public Optional<User> updateUser(User user, Long id);

    public void deleteUser(Long id);

    public boolean isUserExist(Long id);

    public boolean isUserExistByEmail(String email);

    public Optional<List<User>> getAllUser();
}
