package com.erp_ecom.Erp.service;


import com.erp_ecom.Erp.entity.User;
import com.erp_ecom.Erp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;


    public void  savedEntry(User user){
        userRepo.save(user);
    }

    public List<User> getAll(){ return userRepo.findAll(); }


    public User findByUserName(String userName){
        return userRepo.findByUserName(userName);
    }
}