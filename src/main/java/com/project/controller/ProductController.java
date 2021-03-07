package com.project.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.entity.ProductEntity;
import com.project.entity.ProductRequest;
import com.project.entity.ProductResponse;
import com.project.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @ResponseBody
    @RequestMapping(value = "/getProduct", method = RequestMethod.POST)
    public String getProduct(@RequestBody String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ProductResponse response = new ProductResponse();
        // json = URLDecoder.decode(json, "UTF-8");
        try {
            ProductRequest request = mapper.readValue(json, ProductRequest.class);
            int unit = request.getUnit();
            int page = request.getPage() * unit;
            List<Integer> pageList = new ArrayList<>();
            int allProduct = productService.countAllProduct();
            int idx = 0;
            do {
                pageList.add(++idx);
            } while (allProduct / unit > idx);
            List<ProductEntity> productList = productService.getProductByPage(page, unit);
            response.setPage(pageList);
            response.setProductList(productList);
            return mapper.writeValueAsString(response);
        } catch (IOException e) {
            throw new IOException();
        }
    }
}