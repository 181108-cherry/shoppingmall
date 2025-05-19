package com.example.shoppingmall.repository;

import com.example.shoppingmall.entity.StoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<StoreEntity, Long> {

}
