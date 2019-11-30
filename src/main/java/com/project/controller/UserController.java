package com.project.controller;

import java.util.List;

import com.project.entity.UserEntity;
import com.project.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController{
    @Autowired
    UserRepository userRepository;

    public String find(List<UserEntity> user){
        List<UserEntity> userEntity = userRepository.findAll();
        userEntity.forEach(System.out::println);
        return "";
    }
}