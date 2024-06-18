package com.neilson.entity;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface Retrievedetails extends JpaRepository<ShelfEntity, String> {

    @Query(value = "SELECT * from shelf where shelfid=:shelfid", nativeQuery = true)
    public List<Map<String,Object>> findRecommendations(String shelfid);

    @Query(value = "SELECT * from shelf",nativeQuery = true)
    public List<ShelfEntity> getAllShelfRecords();



    @Query(value = "SELECT * from shelf where shelfid=:shelfid",nativeQuery = true)
    public List<ShelfEntity> fetchShelves(String shelfid);

}