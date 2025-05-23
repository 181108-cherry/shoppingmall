package com.example.shoppingmall.filter.query;

import com.example.shoppingmall.entity.StoreEntity;

import lombok.Getter;

@Getter
public class StoreQueryDto {

	private final Long id;
	private final String companyName;
	private final String shoppingmallName;
	private final String domain;
	private final String status;
	private final Integer rating;

	public StoreQueryDto(StoreEntity entity) {
		this.id = entity.getId();
		this.companyName = entity.getCompanyName();
		this.shoppingmallName = entity.getShoppingmallName();
		this.domain = entity.getDomain();
		this.status = entity.getStatus();
		this.rating = entity.getRating();
	}

}
