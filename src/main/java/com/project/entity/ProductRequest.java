package com.project.entity;

import lombok.Getter;

public class ProductRequest {

    /** 페이지 */
    @Getter
    private int page;
    /** 단위 */
    @Getter
    private int unit;
}