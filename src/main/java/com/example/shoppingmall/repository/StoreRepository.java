package com.example.shoppingmall.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shoppingmall.entity.StoreEntity;

public interface StoreRepository extends JpaRepository<StoreEntity, Long> {
	List<StoreEntity> findTop10ByRatingAndStatus(int rating, String status);
}
