package com.neilson.entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

import java.util.List;


public interface ShoppingInfoRepo extends JpaRepository<ShoppingDetails,String> {


    @Query(value = "SELECT * from shoppingdetails where shopperid=:shopperid",nativeQuery = true)
    public List<ShoppingDetails> fetchShoppers(String shopperid);
}
