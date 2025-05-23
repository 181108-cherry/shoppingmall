package com.example.shoppingmall.service;

import com.example.shoppingmall.dto.StoreDto;
import com.example.shoppingmall.dto.StorePageableResponseDto;
import com.example.shoppingmall.dto.StoreSummaryResponseDto;
import com.example.shoppingmall.entity.StoreEntity;
import com.example.shoppingmall.filter.commond.exception.BaseException;
import com.example.shoppingmall.filter.commond.exception.ErrorCode;
import com.example.shoppingmall.repository.StoreRepository;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StoreService {

    private final StoreRepository storeRepository;

    public StoreService(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    // Create
    public StoreDto createStore(StoreDto dto) {
		if (dto == null || dto.getCompanyName () == null || dto.getCompanyName().isBlank()) {
			throw new BaseException(ErrorCode.INVALID_STORE_REQUEST);
		}

		if (storeRepository.existsByStoreNameOrAddress(dto.getCompanyName())) {
			throw new BaseException(ErrorCode.DUPLICATE_STORE);
		}

		StoreEntity entity = new StoreEntity();
		entity.updateEntityFromDto(dto);
        StoreEntity savedEntity = storeRepository.save(entity);
		return savedEntity.updateDtofromEntity();
	}

    // Update
    public StoreDto updateStore(Long id, StoreDto dto) {
        StoreEntity existing = storeRepository.findById(id)
                .orElseThrow(() -> new BaseException(ErrorCode.STORE_NOT_FOUND));

		existing.updateEntityFromDto(dto);
		StoreEntity savedEntity = storeRepository.save(existing);
		return savedEntity.updateDtofromEntity();
    }

    // Delete
    public void deleteStore(Long id) {
        if (!storeRepository.existsById(id)) {
			throw new BaseException(ErrorCode.STORE_DELETE_NOT_FOUND);
        }
        storeRepository.deleteById(id);
    }

	public List<StoreSummaryResponseDto> findTop10ByRatingAndStatus(int rating, String status) {
		List<StoreEntity> entities = storeRepository.findTop10ByRatingAndStatus(rating, status);

		List<StoreSummaryResponseDto> result = new ArrayList<>();

		for (int i = 0; i < entities.size(); i++) {
			StoreEntity entity = entities.get(i);
			StoreSummaryResponseDto dto = StoreSummaryResponseDto.from(entity);
			result.add(dto);
		}

		return result;
	}

	public StorePageableResponseDto findStoresPaging(int rating, String status, int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		Page<StoreEntity> entityPage = storeRepository.findByRatingAndStatus(rating, status, pageable);

		List<StoreSummaryResponseDto> dtoList = new ArrayList<>();
		List<StoreEntity> content = entityPage.getContent();

		for (int i = 0; i < content.size(); i++) {
			StoreEntity entity = content.get(i);
			StoreSummaryResponseDto dto = StoreSummaryResponseDto.from(entity);
			dtoList.add(dto);
		}

		return new StorePageableResponseDto(dtoList, entityPage.getNumber(), entityPage.getSize());
	}

	// status로 필터링된 업체 리스트 반환
	public List<StoreSummaryResponseDto> findStoresByStatus(String status) {
		List<StoreEntity> entities = storeRepository.findByStatusOrderByMonitoringDateDesc(status);

		List<StoreSummaryResponseDto> result = new ArrayList<>();
		for (StoreEntity entity : entities) {
			result.add(StoreSummaryResponseDto.from(entity));
		}

		return result;
	}



	public List<StoreEntity> rating(int rating) {
		return storeRepository.findByRating(rating, PageRequest.of(0, 10));
	}

}
