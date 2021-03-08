package com.project.entity;

import java.util.List;

import lombok.Data;

@Data
public class ProductResponse {

    /** 페이지 */
    private int page;
    /** 상품리스트 */
    private List<ProductEntity> productList;
}