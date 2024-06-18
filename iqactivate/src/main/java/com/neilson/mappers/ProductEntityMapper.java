package com.neilson.mappers;


import com.neilson.entity.ProductEntity;
import com.neilson.entity.ProductModel;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityMapper {

    public ProductEntity getProductEntity(ProductModel productModel){
        ProductEntity productEntity = new ProductEntity();
        productEntity.setAdditionalInfo("{}");
        productEntity.setBrand(productModel.getBrand());
        productEntity.setId(productModel.getProductId());
        productEntity.setCategory(productModel.getCategory());
        productEntity.setTime_created((int) System.currentTimeMillis());
        productEntity.setTime_updated((int) System.currentTimeMillis());
        return productEntity;
    }


}
