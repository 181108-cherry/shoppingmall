package com.example.shoppingmall.filter.csv;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.shoppingmall.entity.StoreEntity;
import com.example.shoppingmall.repository.StoreRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StorePersistenceService {
	private final StoreRepository storeRepository;

	public void saveAllCsvStores(List<StoreEntity> stores) {
		storeRepository.deleteAll(); // 배포 전 수정 예정
		storeRepository.saveAll(stores);
	}
}
