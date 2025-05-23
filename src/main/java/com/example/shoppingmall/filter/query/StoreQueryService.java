package com.example.shoppingmall.filter.query;

import org.springframework.stereotype.Service;

import com.example.shoppingmall.entity.StoreEntity;
import com.example.shoppingmall.repository.StoreRepository;
import com.example.shoppingmall.filter.commond.exception.BaseException;
import com.example.shoppingmall.filter.commond.exception.ErrorCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreQueryService {

	private final StoreRepository storeRepository;

	// id -> 특정 가게 조회
	public StoreQueryDto findStoreById(Long id) {
		StoreEntity entity = storeRepository.findById(id)
			.orElseThrow(() -> new BaseException(ErrorCode.STORE_NOT_FOUND));
		return new StoreQueryDto(entity);
	}
}
