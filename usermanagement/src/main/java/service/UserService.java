package com.example.usermanagement.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.usermanagement.entity.User;
import com.example.usermanagement.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repo;

    public User createUser(User user) {
        return repo.save(user);
    }


    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User getUserById(Long id) {
        return repo.findById(id).orElse(null);
    }

        public User updateUser(Long id, User user) {
        User existingUser = repo.findById(id).orElse(null);

        if (existingUser != null) {
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());

            return repo.save(existingUser);
        }

        return null;
    }


    public void deleteUser(Long id) {
        repo.deleteById(id);
    }
}