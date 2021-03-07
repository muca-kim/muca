package com.project.service;

import java.util.List;

import com.project.entity.ProductEntity;
import com.project.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public List<ProductEntity> getProductByPage(int page, int unit) {
        return repository.findByPage(page, unit);
    }

    public int countAllProduct() {
        return repository.countAllProduct();
    }
}