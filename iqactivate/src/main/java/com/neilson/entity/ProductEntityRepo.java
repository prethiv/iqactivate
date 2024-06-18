package com.neilson.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductEntityRepo  extends JpaRepository<ProductEntity,String> {


    @Query(value = "SELECT * from product where category in (:category)",nativeQuery = true)
    public List<ProductEntity> fetchProducts(String category);
    @Query(value = "SELECT * from product where brand in (:brand)",nativeQuery = true)
    public List<ProductEntity> fetchProductsByBrand(String brand);
    @Query(value = "SELECT * from product LIMIT :end OFFSET :start",nativeQuery = true)
    public List<ProductEntity> fetchProductsByLimit(int start,int end);

}
