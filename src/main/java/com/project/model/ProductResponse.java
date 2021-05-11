package com.project.model;

import java.util.List;

import com.project.entity.ProductEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ProductResponse extends Page {

    /** 상품리스트 */
    private List<ProductEntity> productList;
}