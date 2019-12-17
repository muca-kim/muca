package com.project.controller;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.common.Constants;
import com.project.entity.UserEntity;
import com.project.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;

    public String find(List<UserEntity> user) {
        List<UserEntity> userEntity = userRepository.findAll();
        userEntity.forEach(System.out::println);
        return "";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public void addUser(@RequestBody String json) {
        ObjectMapper mappaer = new ObjectMapper();
        try {
            UserEntity user = mappaer.readValue(json, UserEntity.class);
            System.out.println("userId = " + user.getId());
            user.setRole(Constants.Role.PERSONAL.getValue());
            userRepository.save(user);

        } catch (JsonParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (JsonMappingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void login(@RequestBody String json) {
        ObjectMapper mapper = new ObjectMapper();

    }
}