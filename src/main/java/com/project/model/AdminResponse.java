package com.project.model;

import java.util.List;

import com.project.entity.ProductEntity;
import com.project.entity.UserEntity;

import lombok.Data;

@Data
public class AdminResponse {

    List<UserEntity> userList;
    List<ProductEntity> productList;

}