package com.example.shoppingmall.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.shoppingmall.entity.StoreEntity;

public interface StoreRepository extends JpaRepository<StoreEntity, Long> {

	List<StoreEntity> findTop10ByRatingAndStatus(int rating, String status);

	Page<StoreEntity> findByRatingAndStatus(int rating, String status, Pageable pageable);

	// status로 필터링하고 모니터링 날짜 내림차순 정렬
	List<StoreEntity> findByStatusOrderByMonitoringDateDesc(String status);

	// 전체 평가 점수
	List<StoreEntity> findByRating(Integer rating, Pageable pageable);

	// 가게 등록되어있는지 중복 체크
	boolean existsByCompanyName(String companyName);

}
