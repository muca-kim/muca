package com.project.controller;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.entity.ProductEntity;
import com.project.entity.ProductResponse;
import com.project.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * 상품 페이지에 표시할 상품 목록을 가져옴
     * 
     * @param page
     * @param unit
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/getProduct", method = RequestMethod.GET)
    public String getProduct(@RequestParam(value = "page") String page, @RequestParam(value = "unit") String unit)
            throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ProductResponse response = new ProductResponse();
        try {
            int intUnit = Integer.parseInt(unit);
            int intPage = Integer.parseInt(page) * intUnit;
            int allPage = 0;
            // 등록된 모든 상품의 개수를 가져옴
            int allProduct = productService.countAllProduct();
            // 페이지 수 계산
            if (allProduct % intUnit == 0) {
                allPage = allProduct / intUnit;
            } else {
                allPage = allProduct / intUnit + 1;
            }
            // DB에서 상품 목록을 가져옴
            List<ProductEntity> productList = productService.getProductByPage(intPage, intUnit);
            response.setPage(allPage);
            response.setProductList(productList);
            return mapper.writeValueAsString(response);
        } catch (IOException e) {
            throw new IOException();
        }
    }
}