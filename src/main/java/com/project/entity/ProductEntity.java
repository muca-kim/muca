package com.project.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "product_def")
public class ProductEntity {

    /** 상품등록번호 */
    @Id
    @Getter
    private Integer productNo;
    /** 상품 이름 */
    @Getter
    private String productName;
    /** 설명 */
    @Getter
    private String description;
    /** 추천수 */
    @Getter
    private Integer recommend;
    /** 이미지주소 */
    @Getter
    private String productImg;

    @Builder
    public ProductEntity(Integer productNo, String productName, String description, Integer recommend) {
        this.productNo = productNo;
        this.productName = productName;
        this.description = description;
        this.recommend = recommend;
    }

}