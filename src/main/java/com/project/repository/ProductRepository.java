package com.project.repository;

import java.util.List;

import com.project.entity.ProductEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

    @Query(value = "select * from product_def orders limit :unit offset :page", nativeQuery = true)
    List<ProductEntity> findByPage(@Param(value = "page") int page, @Param(value = "unit") int unit);

    @Query(value = "select count(*) from product_def", nativeQuery = true)
    int countAllProduct();

    ProductEntity findByProductNo();
}