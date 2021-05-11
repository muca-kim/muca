package com.project.controller;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.entity.ProductEntity;
import com.project.entity.UserEntity;
import com.project.service.ProductService;
import com.project.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminController {

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    @RequestMapping("/getAdminArea")
    public String viewAdminArea() throws JsonProcessingException {

        return "adminPage";

    }

    /**
     * 유저관리
     * 
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping
    public String getUserList() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<UserEntity> userList = userService.findAll();
        return mapper.writeValueAsString(userList);
    }

    /**
     * 상품관리
     * 
     * @throws JsonProcessingException
     */
    @ResponseBody
    @GetMapping
    public String getProductList() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<ProductEntity> pList = productService.findAll();
        return mapper.writeValueAsString(pList);
    }

}