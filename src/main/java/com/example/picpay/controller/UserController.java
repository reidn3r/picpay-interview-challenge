package com.example.picpay.controller;

import com.example.picpay.DTO.UserDTO;
import com.example.picpay.model.User.UserModel;
import com.example.picpay.service.UserService;
import jakarta.validation.Valid;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping
    public ResponseEntity<UserModel> createUser(@Valid @RequestBody UserDTO data) throws Exception{
            return this.userService.createUser(data);
    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.getAllUsers());
    }
}
