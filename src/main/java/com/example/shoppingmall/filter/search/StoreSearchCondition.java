package com.example.shoppingmall.filter.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StoreSearchCondition {

	// 검색 조건
	private String field; // 상호명, 쇼핑몰명, 도메인
	private String keyword;
}
