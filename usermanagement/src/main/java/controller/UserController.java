package com.example.usermanagement.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.usermanagement.entity.User;
import com.example.usermanagement.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService service;


    @PostMapping
    public User create(@Valid @RequestBody User user) {
        return service.createUser(user);
    }


    @GetMapping
    public List<User> getAll() {
        return service.getAllUsers();
    }


    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return service.getUserById(id);
    }


    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @Valid @RequestBody User user) {
        return service.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteUser(id);
        return "User deleted successfully";
    }
}