package com.example.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.example.usermanagement.entity.User;
import com.example.usermanagement.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public User createUser(User user){
        return repo.save(user);
    }

    public List<User> getAllUsers(){
        return repo.findAll();
    }

    public User getUserById(Long id){
        return repo.findById(id).orElse(null);
    }

    public void deleteUser(Long id){
        repo.deleteById(id);
    }
    public User updateUser(Long id, User user){
        User existingUser = repo.findById(id).orElse(null);

        if(existingUser != null){
            existingUser.setName(user.getName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            return repo.save(existingUser);
        }
        return null;
    }
}