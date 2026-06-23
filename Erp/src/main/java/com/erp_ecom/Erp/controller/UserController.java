package com.erp_ecom.Erp.controller;

import com.erp_ecom.Erp.entity.User;
import com.erp_ecom.Erp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAlluser(){
        return userService.getAll();

    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        userService.savedEntry(user);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

}