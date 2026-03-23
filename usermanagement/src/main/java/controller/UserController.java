package com.example.usermanagement.controller;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.example.usermanagement.entity.User;
import com.example.usermanagement.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public User create(@Valid@RequestBody User user){
        return service.createUser(user);
    }

    @GetMapping
    public List<User> getAll(){
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return service.getUserById(id);
    }
    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User user){
        return service.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        service.deleteUser(id);
        return "Deleted Successfully";
    }
}