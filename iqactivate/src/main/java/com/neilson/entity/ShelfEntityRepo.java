package com.neilson.entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ShelfEntityRepo extends JpaRepository<ShelfEntity,String> {

    @Query(value = "delete from shelf", nativeQuery = true)
    public String deleteShelf();


}
