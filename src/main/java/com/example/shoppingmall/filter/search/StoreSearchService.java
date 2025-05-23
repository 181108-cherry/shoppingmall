package com.example.shoppingmall.filter.search;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.shoppingmall.entity.StoreEntity;
import com.example.shoppingmall.filter.commond.exception.BaseException;
import com.example.shoppingmall.filter.commond.exception.ErrorCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreSearchService {

	private final StoreSearchRepositoryCustom storeSearchRepositoryCustom;

	public List<StoreSearchResponseDto> searchResponseDtos(StoreSearchCursorRequest request){

		List<StoreEntity> entities = storeSearchRepositoryCustom.searchWithCursor(
			request.getCondition().getField(),
			request.getCondition().getKeyword(),
			request.getLastId(),
			request.getSize()
		);

		if(entities.isEmpty()) {
			throw new BaseException(ErrorCode.STORE_NOT_FOUND);
		}

		return entities.stream()
			.map(StoreSearchResponseDto::from)
			.collect(Collectors.toList());
	}
}
