package com.example.shoppingmall.filter.search;

import com.example.shoppingmall.entity.StoreEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class StoreSearchResponseDto {
	private Long id;
	private String companyName;
	private String shoppingmallName;
	private String domain;

	public static StoreSearchResponseDto from(StoreEntity entity) {
		return new StoreSearchResponseDto(
			entity.getId(),
			entity.getCompanyName(),
			entity.getShoppingmallName(),
			entity.getDomain()
		);
	}
}
