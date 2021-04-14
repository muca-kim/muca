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

    /**
     * 페이지와 한 페이지당 표시할 단위의 상품 목록을 가져옴
     * 
     * @param page 해당 페이지
     * @param unit 페이지별 상품 개수
     * @return
     */
    public List<ProductEntity> getProductByPage(int page, int unit) {
        return repository.findByPage(page, unit);
    }

    /**
     * 등록되어 있는 모든 상품의 개수를 가져옴
     * 
     * @return
     */
    public int countAllProduct() {
        return repository.countAllProduct();
    }

    public int addProduct(ProductEntity product) {
        try {
            repository.save(product);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }

    public int deleteProduct(Integer productNo) {
        try {
            ProductEntity product = repository.findByProductNo();
            repository.delete(product);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return 1;
    }
}