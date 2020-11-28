package com.example.ProjectTogether.controller;

import com.example.ProjectTogether.common.utils.AuthenticationBean;
import com.example.ProjectTogether.persistance.model.UserModel;
import com.example.ProjectTogether.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping(path = "/basicauth")
    public AuthenticationBean basicauth() {
        return new AuthenticationBean("You are authenticated");
    }

    @PostMapping("/register")
    public void addUser(@RequestBody UserModel userModel) {
        userRepository.save(userModel);
    }

    @GetMapping("/getUsers")
    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/getUserById/{id}")
    public UserModel getById(@PathVariable(name = "id") Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping("/getUserByUsername/{username}")
    public UserModel getByUsername(@PathVariable(name = "username") String username) {
        return userRepository.getUserModelByUsername(username).orElse(null);
    }

    @PutMapping("/updateUser")
    public void updateUser(@RequestBody UserModel userModel) {
        UserModel updatedUser = userRepository.findById(userModel.getId()).orElse(null);
        updatedUser.setUsername(userModel.getUsername());
        if(userModel.getNewPassword()!=null&&userModel.getNewPassword()!=""){
            updatedUser.setPassword(userModel.getNewPassword());
        }

        updatedUser.setUserRole(userModel.getUserRole());
        userRepository.save(updatedUser);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteById(@PathVariable(name = "id") Long id) {
        userRepository.deleteById(id);
    }
}


