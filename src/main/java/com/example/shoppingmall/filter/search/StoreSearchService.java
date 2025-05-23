package com.example.shoppingmall.filter.search;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.shoppingmall.entity.StoreEntity;

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

		return entities.stream()
			.map(StoreSearchResponseDto::from)
			.collect(Collectors.toList());
	}
}
