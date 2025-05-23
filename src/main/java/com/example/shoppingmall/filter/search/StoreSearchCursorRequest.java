package com.example.shoppingmall.filter.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StoreSearchCursorRequest {
	// 커서 기반
	private StoreSearchCondition condition;
	private Long lastId; // null 이면 첫 페이지
	private int size = 20; // 20페이지 고정

}
